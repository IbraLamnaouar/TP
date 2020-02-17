#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int	main() {
	int	pid[2] = {0, 0};
	//int pid;

	printf("Current PID: %d\n", getpid());

	pid[0] = fork();
	if (pid[0] == 0) {
		printf("----------------------Proc1--------------\n");
		printf("Parent PID: %d \n", getppid());
		printf("Child PID: %d \n", getpid());
	}else{
		printf("----------------------Proc2--------------\n");
                printf("Parent PID: %d \n", pid[0]);
                printf("Child PID: %d \n", getpid());
		wait(NULL);
	}
	
	return (0);
}
