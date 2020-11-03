void epoll_run(int port);

int init_listen_fd(int port,int epfd);
void do_accept(int lfd,int epfd);
void disconnect(int cfd,int epfd);
void http_request(int cfd,const char* file);
void send_respond_head(int cfd,int num,char* discription,char* type,int len);
void send_file(int cfd,const char* file);
const char* get_file_type(const char* name);
void send_error(int cfd,int status,char* title,char* text);
void send_dir(int cfd,char* dirname);


int get_line(int cfd,char* buf,int size);