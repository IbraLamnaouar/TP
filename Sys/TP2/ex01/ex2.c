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
    int gender;
    char message[255] = "Bonjour M";
    char buf;

    assert(argc == 3);

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
        if (read(pipefd[0], &gender, sizeof(gender)) == -1){
            printf("Cannot read gender");
            exit(EXIT_FAILURE);
        }
        if (gender == 0) {
            strcat(message, "onsieur ");
        } else if (gender == 1) {
            strcat(message, "adamme ");
        } else {
            printf("Gender unknown");
            exit(EXIT_FAILURE);
        }
        while (read(pipefd[0], &buf, 1) > 0) {
            sprintf(message, "%s%c", message, buf);
        }
        close(pipefd[0]);
        write(pipepd[1], message, strlen(message));
        close(pipepd[1]);
        exit(EXIT_SUCCESS);
    }

    else
    { /* Parent writes argv[1] to pipe */
        close(pipefd[0]);
        close(pipepd[1]);

        gender = atoi(argv[2]);
        write(pipefd[1], &gender, sizeof(gender));
        write(pipefd[1], argv[1], strlen(argv[1]));
        close(pipefd[1]); /* Reader will see EOF */
        wait(NULL); /* Wait for child */
        while (read(pipepd[0], &buf, 1) > 0) {
            write(STDOUT_FILENO, &buf, 1);
        }
        write(STDOUT_FILENO, "\n", 1);
        close(pipepd[0]);
        exit(EXIT_SUCCESS);
    }
}