//
// Created by bokket on 2020/9/28.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <event2/event.h>
#include <event2/bufferevent.h>
//链接监听器
#include <event2/listener.h>


//读回调
void read_cb(struct bufferevent* bev,void* arg)
{
    //读缓存区里面的数据
    char buf[1024]={0};
    bufferevent_read(bev,buf,sizeof(buf));
    printf("recv buf:%s\n",buf);

    char* pt="你发送的数据我已经收到了---\n";
    //发送数据
    bufferevent_write(bev,pt,strlen(pt)+1);
    printf("我发送了数据，给客户端----,send_buf:%s\n",pt);
}

void write_cb(struct bufferevent* bev,void* arg)
{
    printf("发送的数据已经被发生出去");
}


//
void event_cb(struct bufferevent *bev, short events, void *arg)
{

    if (events & BEV_EVENT_EOF)
    {
        printf("connection closed\n");  
    }
    else if(events & BEV_EVENT_ERROR)   
    {
        printf("some other error\n");
    }
    
    bufferevent_free(bev);    
    printf("buffevent 资源已经被释放...\n"); 
}



//连接完成之后，对应的通信操作被回调-----交给框架和操作系统
void listen_cb(struct evconnlistener* listener,
                evutil_socket_t sock, //用于通信的文件描述符
                struct sockaddr *addr,//客户端的IP和端口信息
                int len,
                void *ptr)//外部传进来的数据
{
    //先得到传进来的event_base
    struct event_base* base=(struct event_base*)ptr;
    //主要是接受和发送数据
    //先接受数据
    //将fd封装为bufferevent
    struct bufferevent* bev=NULL;
    bev=bufferevent_socket_new(base,sock,BEV_OPT_CLOSE_ON_FREE);
                                    //释放bufferevent时关闭底层传输端口。这将关闭底层套接字,释放底层bufferevent 等
    //给bufferevent对应的读写缓冲区设置回调函数
    bufferevent_setcb(bev,read_cb,write_cb,event_cb,NULL);

    //默认ev_write 是enable
    //ev_read是关闭的
    //设置读缓冲区的回调可用，默认写是可用的
    bufferevent_enable(bev,EV_READ);

}

int main()
{
    //创建事件处理框架
    struct event_base* base=event_base_new();

    //init server info
    struct sockaddr_in serv;
    memset(&serv,0,sizeof(serv));
    serv.sin_family=AF_INET;
    serv.sin_port=htons(8765);
    serv.sin_addr.s_addr=htonl(INADDR_ANY);
    //创建监听的套接字
    //绑定
    //监听
    //等待并接受链接
    struct evconnlistener* listen=NULL;

    //有新连接的时候，listen_cb被调用
    //listen=evconnlistener_new_bind(base,listen_cb,NULL,
    //                               LEV_OPT_CLOSE_ON_FREE | LEV_OPT_REUSEABLE,
    //                               -1,(struct sockaddr*)&serv,sizeof(serv));

    listen=evconnlistener_new_bind(base,listen_cb,base,//传参
                                   LEV_OPT_CLOSE_ON_FREE | LEV_OPT_REUSEABLE,
                                   -1,(struct sockaddr*)&serv,sizeof(serv));

    //进入到事件循环
    event_base_dispatch(base);

    //释放资源
    evconnlistener_free(listen);
    event_base_free(base);
}



