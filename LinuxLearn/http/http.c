#include <sys/types.h>
#include <sys/stat.h>
#include <sys/epoll.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include "http.h"
#include <arpa/inet.h>
#include <sys/fcntl.h>

#define MAXSIZE 2048

void epoll_run(int port)
{
    int epfd=epoll_create(MAXSIZE);
    if(epfd==-1)
    {
        perror("epoll_create error");
        exit(1);
    }    

    int lfd=init_listen_fd(port,epfd);
    struct epoll_event all[MAXSIZE];
    

    while(1)
    {
        int ret=epoll_wait(epfd,all,MAXSIZE,-1);
        if(ret==-1)
        {
            perror("epoll_wait error");
            exit(1);
        }

        for(int i=0;i<ret;i++)
        {
            struct epoll_event *pev=&all[i];
            if(! (pev->events & EPOLLIN))
                continue;
            //接受连接请求
            if(pev->data.fd==lfd)
            {
                do_accept(lfd,epfd);
            }
            else
            {
                do_read(pev->data.fd,epfd);
            }

        }
    }

}
int init_listen_fd(int port,int epfd)
{
    int lfd=socket(AF_INET,SOCK_STREAM,0);
    
    struct sockaddr_in serv;
    memset(&serv,0,sizeof(serv));
    serv.sin_family=AF_INET;
    serv.sin_port=htons(port);
    serv.sin_addr.s_addr=htonl(INADDR_ANY);

    int flag=1;
    setsockopt(lfd,SOL_SOCKET,SO_REUSEADDR,&flag,sizeof(flag));
    int ret= bind (lfd,(struct sockaddr*)&serv,sizeof(serv));
   
    listen(lfd,128);


    struct epoll_event ev;
    ev.events=EPOLLIN;
    ev.data.fd=lfd;

    ret=epoll_ctl(epfd,EPOLL_CTL_ADD,lfd,&ev);
    if(ret==-1)
    {
        perror("epoll_ctl error");
        exit(1);
    }
    return lfd;
}
void do_accept(int lfd,int epfd)
{
    struct sockaddr_in clt;
    socklen_t clt_len=sizeof(clt);

    int cfd=accept(lfd,(struct sockaddr*)&clt,&clt_len);

    if(cfd==-1)
    {
        perror("accpet error");
        exit(1);
    }

    char client_ip[64]={0};
    printf("New Client IP : %s, Port : %d , cfd= %d \n",
            inet_ntop(AF_INET,&clt.sin_addr.s_addr,client_ip,sizeof(client_ip)),
            ntohs(clt.sin_port), cfd);

    int flag=fcntl(cfd, F_GETFL);
    flag |= O_NONBLOCK;
    fcntl(cfd,F_SETFL,flag);

    struct epoll_event ev;
    ev.data.fd=cfd;

    //边沿非阻塞模式
    ev.events = EPOLLIN | EPOLLET;
    int ret= epoll_ctl(epfd,EPOLL_CTL_ADD,cfd,&ev);

    if(ret==-1)
    {
        perror("epoll_ctl add cfd error");
        exit(1);
    }
}

void disconnect(int cfd,int epfd)
{   
    int ret=epoll_ctl(epfd,EPOLL_CTL_DEL,cfd,NULL);
    if(ret!=0)
    {
        perror("epoll error");
        exit(1);
    }
    close(cfd);
}


//客户端fd，错误号，错误描述，回发文件类型，错误长度
void send_respond(int cfd,int num,char* discription,char* type,int len)
{
    char buf[1024]={0};
    sprintf(buf,"HTTP/1.1 %d %s\r\n",num,discription);
    sprintf(buf+strlen(buf),"%s\r\n",type);
    sprintf(buf+strlen(buf),"Content-Length:%d\r\n",len);

    send(cfd,buf,strlen(buf),0);
    send(cfd,"\r\n",2,0);
    
}
//判断文件是否存在
void http_request(int cfd,const char* file)
{
    struct stat sbuf;

    int ret=stat(file,&sbuf);

    if(ret!=0)
    {
        //回发浏览器错误页面
        perror("stat error");
        exit(1);
    }

    if(S_ISREG(sbuf.st_mode) ) //一个普通文件
    {
        //printf("------------It is a file : %s \n",file);
        //回发http应答
        send_respond(cfd,200,"OK", "Content-Type: text/plain; charset=iso-8859-1",sbuf.st_size);
        //回发给客户端请求数据内容,
    }
}

void do_read(int cfd,int epfd)
{
    //读取一行http协议，拆分get文件名和协议号
    char line[1024]={0};
    int len=get_line(cfd,line,sizeof(line));
    if(len==0)
    {
        printf("服务器检查到客户端关闭\n");
        disconnect(cfd,epfd);
    }
    else
    {
        char method[16],path[256],protocol[16];
        sscanf(line, "%[^ ] %[^ ] %[^ ]",method,path,protocol);

        printf("method =%s,path=%s,protocol=%s\n",method,path,protocol);

        while(1)
        {
            char buf[1024]={0};
            len=get_line(cfd,buf,sizeof(buf));
            if(len== '\n')
                break;

            //printf("----len = %d , %s",len,buf);

            else if(len==-1)
            {
                break;
            }
        }
        if(strncasecmp(method,"get",3)==0)
        {
            char *file=path+1; //取出 客户端要访问的文件名
            http_request(cfd,file);
        }
    }
}
int get_line(int cfd,char* buf,int size)
{
    int i=0;
    char c='\0';
    int n;
    while((i<size-0) && (c!='\n') )
    {
        n=recv(cfd,&c,1,0);
        if(n>0)
        {
            if(c=='\r')
            {
                n=recv(cfd,&c,1,MSG_PEEK);
                if( (n>0) && (c=='\n') )
                    n=recv(cfd,&c,1,0);//实际读
                else
                {
                    c='\n';
                }
            }
            buf[i]=c;
            i++;
        }
        else
        {
            c='\n';
        }
    }
    buf[i]='\0';

    if(n==-1)
        i=n;
    return i;
}