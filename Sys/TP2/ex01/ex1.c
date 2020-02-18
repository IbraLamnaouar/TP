#include <sys/wait.h>
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char *argv[])
{
    int pipefd[2];
    int pipepd[2];
    int cpid;
    int buf;
    int s;
    char inttoprint[100];

    assert(argc >= 2);

    if (pipe(pipefd) == -1 || pipe(pipepd) == -1)
    {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    cpid = fork();
    if (cpid == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (cpid == 0)
    { /* Child reads from pipe */
        close(pipefd[1]);
        close(pipepd[0]);
        s = 0;
        while (read(pipefd[0], &buf, sizeof(buf)) > 0) {
            s += buf;
        }
        close(pipefd[0]);
        write(pipepd[1], &s, sizeof(s));
        close(pipepd[1]);
        exit(EXIT_SUCCESS);
    }

    else
    { /* Parent writes argv[1] to pipe */
        close(pipefd[0]);
        close(pipepd[1]);
        for (int i = 1; i < argc ; ++i) {
            buf = atoi(argv[i]);
            write(pipefd[1], &buf, sizeof(buf));
        }
        close(pipefd[1]); /* Reader will see EOF */
        wait(NULL); /* Wait for child */
        if (read(pipepd[0], &s, sizeof(s)) == -1) {
            printf("Erreur: y'a pas de somme\n");
            exit(EXIT_FAILURE);
        }
        close(pipepd[0]);
        sprintf(inttoprint, "%d\n", s);
        write(STDOUT_FILENO, inttoprint, strlen(inttoprint));
        exit(EXIT_SUCCESS);
    }
}