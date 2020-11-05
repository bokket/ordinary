//
// Created by bokket on 2020/11/5.
//

bool daemonize()
{
    pid_t pid=fork();

    if(pid<0)
    {
        return false;
    }
    else if(pid>0)
    {
        exit(0);
    }

    umask(0);//mode & 0777

    pid_t sid=setsid();
    if(sid<0)
    {
        return false;
    }

    if((chdir("/"))<0)
    {
        return false;
    }


    close(STDIN_FILENO);
    close(STDOUT_FILENO);
    close(STDERR_FILENO);

    //qi

    open( "/dev/null", O_RDONLY );
    open( "/dev/null", O_RDWR );
    open( "/dev/null", O_RDWR );
    return true;
}
