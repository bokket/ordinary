//
// Created by bokket on 2020/9/27.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <event2/event.h>
//对操作函数进行回调
void write_cb(evutil_socket_t fd,short what,void* arg)
{
    char buf[1024]={0};
    int len=read(fd,buf,sizeof(buf));
}
int main()
{

    //非阻塞能够更加方便看到效果
    int fd=open("myfifo",O_WRONLY | O_NONBLOCK);
    if(fd==-1)
    {
        perror("open error");
        exit(1);
    }

    //写管道
    struct event_base* base=NULL;
    base=event_base_new();

    //创建事件
    struct event* ev=NULL;
    //ev=event_new(base,fd,EV_WRITE|EV_PERSIST,write_cb,NULL);
	ev=event_new(base,fd,EV_WRITE,write_cb,NULL);

    //添加事件
    event_add(ev,NULL);

    //事件循环
    event_base_dispatch(base);

    //释放资源
    event_free(ev);
    event_base_free(base);
    close(fd);
}
