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
#include <errno.h>
#include <dirent.h>
#include <ctype.h>


#define MAXSIZE 2048

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
       /* char method[16],path[256],protocol[16];
        sscanf(line, "%[^ ] %[^ ] %[^ ]",method,path,protocol);

        printf("method =%s,path=%s,protocol=%s\n",method,path,protocol);


        decode_str(path,path);*/
        
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
        //if(strncasecmp(method,"get",3)==0)
        if(strncasecmp(line,"get",3)==0)
        {
           // char *file=path+1; //取出 客户端要访问的文件名
            //http_request(cfd,file);
            http_request(cfd,line);
        }
    }
}


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

void send_dir(int cfd,char* dirname)
{
    int i,ret;

    char buf[1024]={0};
    sprintf(buf,"<html><head><title>目录名: %s</title></head>",dirname);
    sprintf(buf+strlen(buf),"<body><h1>当前目录: %s</h1><table>",dirname);

    char enstr[1024]={0};
    char path[1024]={0};

    struct dirent **ptr;
    int num=scandir(dirname,&ptr,NULL,alphasort);
    for(int j=0;j<num;j++)
    {
        char* name=ptr[j]->d_name;

        sprintf(path,"%s/%s",dirname,name);
        printf("path=%s\n",path);

        struct stat st;
        stat(path,&st);

        encode_str(enstr,sizeof(enstr),name);

        if(S_ISREG(st.st_mode))
        {
            sprintf(buf+strlen(buf),
                "<tr><td><a href=\"%s\">%s</a></td><td>%ld</td></tr>",
                enstr,name,(long)st.st_size);
        }
        else if(S_ISDIR(st.st_mode))
        {
            sprintf(buf+strlen(buf),
                "<tr><td><a href=\"%s/\">%s</a></td><td>%ld</td></tr>",
                enstr,name,(long)st.st_size);
        }

        ret=send(cfd,buf,sizeof(buf),0);
        if(ret==-1)
        {
            printf("errno = %d\n",errno);
            if(errno==EAGAIN)
            {
                printf("--------EAGAIN\n");
                continue;
            }
            else if(errno==EINTR)
            {
                printf("-------EINTR\n");
                continue;
            }
            else
            {
                perror("send error");
                return ;
            }
        }
        memset(buf,0,sizeof(buf));
    }
    sprintf(buf+strlen(buf),"</table></body></html>");
    send(cfd,buf,strlen(buf),0);


    printf("dir message ok!!!\n");
}

void encode_str(char *to, int tosize, const char *from) 
{
    int tolen;
    for (tolen = 0; *from != '\0' && tolen + 4 < tosize; ++from) {
        if (isalnum(*from) || strchr("/_.-~", *from) != (char *) 0) {
            *to = *from;
            ++to;
            ++tolen;
        } else {
            sprintf(to, "%%%02x", (int) *from & 0xff);
            to += 3;
            tolen += 3;
        }
    }
    *to = '\0';
}

void decode_str(char *to, char *from) 
{
    for (; *from != '\0'; ++to, ++from) {
        if (from[0] == '%' && isxdigit(from[1]) && isxdigit(from[2])) {
            *to = hexit(from[1]) * 16 + hexit(from[2]);
            from += 2;
        } else {
            *to = *from;
        }
    }
    *to = '\0';
}

int hexit(char c) 
{
    if (c >= '0' && c <= '9')
        return c - '0';
    if (c >= 'a' && c <= 'f')
        return c - 'a' + 10;
    if (c >= 'A' && c <= 'F')
        return c - 'A' + 10;
    return 0;
}

//客户端fd，错误号，错误描述，回发文件类型，错误长度
void send_respond_head(int cfd,int num,char* discription,char* type,int len)
{
    char buf[1024]={0};
    sprintf(buf,"HTTP/1.1 %d %s\r\n",num,discription);
    //send(cfd,buf,sizeof(buf),0);

    sprintf(buf+strlen(buf),"Content-Type:%s\r\n",type);
    sprintf(buf+strlen(buf),"Content-Length:%d\r\n",len);

    send(cfd,buf,strlen(buf),0);
    send(cfd,"\r\n",2,0);
    
}

void send_file(int cfd,const char* file)
{
    char buf[4096]={0};
    int n=0,ret;

    int fd=open(file,O_RDONLY);
    if(fd<0)
    {
        //404错误

        perror("open error");
        exit(1);
    }
    while( (n =read(fd,buf,sizeof(buf))) >0)
    {
        
        //printf("----------n:%d\n",n);
        ret=send(cfd,buf,n,0);
        if(ret==-1)
        {
            //perror("send error");
            //exit(1);
            printf("errno = %d\n",errno);
            if(errno==EAGAIN)
            {
                printf("--------EAGAIN\n");
                continue;
            }
            else if(errno==EINTR)
            {
                printf("-------EINTR\n");
                continue;
            }
            else
            {
                perror("send error");
                exit(1);
            }
        }
        if(ret<4096)
            printf("----------send ret:%d\n",ret);
    }

    close(fd);
}
void send_error(int cfd,int status,char* title,char* text)
{
    char buf[1024]={0};

    sprintf(buf,"%s %d %s\r\n","HTTP/1.1",status,title);
    sprintf(buf+strlen(buf),"Content-Type:%s\r\n","text/html");
    sprintf(buf+strlen(buf),"Content-Length:%d\r\n",-1);
    sprintf(buf+strlen(buf),"Content:close\r\n");

    send(cfd,buf,strlen(buf),0);
    send(cfd,"\r\n",2,0);

    memset(buf,0,sizeof(buf));
    sprintf(buf,"<html><head><title>%d %s</title></head>\n",status,title);
    sprintf(buf+strlen(buf),"<body bgcolor=\"#cc99cc\"><h2 align=\"center\"%d %s</h4>\n",status,title);
    sprintf(buf+strlen(buf),"%s\n",text);
    sprintf(buf+strlen(buf),"<hr>\n</body>\n</html>\n");
    send(cfd,buf,strlen(buf),0);
}
char* get_file_type(const char* name)
{
    char *dot;

    dot=strrchr(name,'.');

    if(dot==NULL)
        return "text/plain; charset=utf-8";
    if(strcmp(dot,".html")==0 || strcmp(dot,".htm")==0)
        return "text/html; charset=utf-8";
    
    if(strcmp(dot,".jpg")==0 || strcmp(dot,".jpeg")==0)
        return "image/jpeg";
    if(strcmp(dot,".gif")==0)
        return "image/gif";
    if(strcmp(dot,".png")==0)
        return "image/png";
    
    if(strcmp(dot,".css")==0)
        return "text/css";

    if(strcmp(dot,".au")==0)
        return "audio/basic";
    if(strcmp(dot,".wav")==0)
        return "audio/wav";

    if(strcmp(dot,".avi")==0)
        return "video/x-msvideo";
    if(strcmp(dot,".mov")==0 || strcmp(dot,".qt")==0)
        return "video/quicktime";
    if(strcmp(dot,".mpeg")==0 || strcmp(dot,".mpe")==0)
        return "video/mpeg";
    if(strcmp(dot,".vrml")==0 || strcmp(dot,".wrl")==0)
        return "model/vrml";
    
    if(strcmp(dot,".midi")==0 || strcmp(dot,".mid")==0)
        return "audio/midi";
    if(strcmp(dot,".mp3")==0)
        return "audio/mpeg";

    if(strcmp(dot,".ogg")==0)
        return "application/ogg";
    if(strcmp(dot,".pac")==0)
        return "application/x-ns-proxy-autoconfig";

    return "text/plain; charset=utf-8";
}


//判断文件是否存在
//void http_request(int cfd,const char* file)
void http_request(int cfd,char* line)
{

    char method[16],path[256],protocol[16];
    sscanf(line, "%[^ ] %[^ ] %[^ ]",method,path,protocol);

    printf("method =%s,path=%s,protocol=%s\n",method,path,protocol);


    decode_str(path,path);


    char file[256];
    if(strcmp(path,"/")==0)
        strcpy(file,"./");
    else
    {
        strcpy(file,path+1);
    }
    

    struct stat sbuf;

    int ret=stat(file,&sbuf);

    if(ret!=0)
    {
        //回发浏览器错误页面
        send_error(cfd,404,"Not Found","No such file or direntry");
        return ;
    }

    if(S_ISREG(sbuf.st_mode) ) //一个普通文件
    {
        //printf("------------It is a file : %s \n",file);
        //回发http应答
        //send_respond_head(cfd,200,"OK", "Content-Type: text/plain; charset=iso-8859-1",sbuf.st_size);
        send_respond_head(cfd,200,"OK", get_file_type(file),sbuf.st_size);
        //回发给客户端请求数据内容,
        send_file(cfd,file);
    }
    else if(S_ISDIR(sbuf.st_mode))
    {
        send_respond_head(cfd,200,"OK",get_file_type(".html"),-1);
        send_dir(cfd,file);
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