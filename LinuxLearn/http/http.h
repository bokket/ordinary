void epoll_run(int port);

int init_listen_fd(int port,int epfd);
void do_accept(int lfd,int epfd);
void disconnect(int cfd,int epfd);
void http_request(int cfd,const char* file);
void send_respond(int cfd,int num,char* discription,char* type,int len);

int get_line(int cfd,char* buf,int size);