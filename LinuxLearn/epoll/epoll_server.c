#include <sys/types.h>
#include <sys/stat.h>
#include <sys/epoll.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <epoll_serv.h>
#include <arpa/inet.h>
#define MAXSIZE 2000

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
            if(! pev->events & EPOLLIN)
                continue;
            if(pev->data.fd==lfd)
            {
        
            }
            else
            {

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
   
    listen(lfd,64);


    struct epoll_event ev;
    ev.events=EPOLLIN;
    ret=epoll_ctl(epfd,EPOLL_CTL_ADD,lfd,&ev);
    if(ret==-1)
    {
        perror("epoll_ctl error");
        exit(1);
    }


   
    return lfd;
}