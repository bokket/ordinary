//
// Created by bokket on 2020/11/5.
//

#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <assert.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>

int main( int argc, char* argv[] ) {
    if (argc <= 2) {
        printf("usage: %s ip_address port_number\n", basename(argv[0]));
        return 1;
    }
    const char *ip = argv[1];
    int port = atoi(argv[2]);

    struct sockaddr_in addr;
    bzero(&addr, sizeof(addr));
    addr.sin_family = AF_INET;q2
    inet_pton(AF_INET, ip, &addr.sin_addr);
    addr.sin_port = htons(port);


    int sock = socket(AF_INET, SOCK_STREAM, 0);
    assert(sock>= 0);

    int ret = bind(sock, (struct sockaddr *) &addr, sizeof(addr));
    assert(ret != -1);
    ret = listen(sock, 5);
    assert(ret != -1);

    sleep(20);
    struct sockaddr_in cli;
    socklen_t cli_addr=sizeof(cli);
    int connfd=accept(sock,(struct sockaddr*)&cli,&cli_addr);

    if(connfd<0)
        printf( "errno is: %d\n", errno );
    else {
        char remote[INET_ADDRSTRLEN];
        printf( "connected with ip: %s and port: %d\n", inet_ntop(AF_INET,&cli.sin_addr,remote,INET_ADDRSTRLEN),ntohs(cli.sin_port));
        close(connfd);
    }
    close(sock);
}