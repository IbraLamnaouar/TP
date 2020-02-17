#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int	main() {
	int	pid[2] = {0, 0};
	//int pid;

	printf("Current PID: %d\n", getpid());

	pid[0] = fork();
	if (pid[0] == 0) {
		printf("----------------------Proc1--------------\n");
		printf("Parent PID: %d \n", getppid());
		printf("Child PID: %d \n", getpid());
		pid[1] = fork();
		if (pid[1] == 0) {
                	printf("----------------------Proc2--------------\n");
                	printf("Parent PID: %d \n", getppid());
               		printf("Child PID: %d \n", getpid());
       		}else{
        	        printf("\n\nCreating second Processor\n");
	        }

	}else{
		printf("\n\nCreating First Processor\n");
	}

	//pid[1] = fork();
        //if (pid[1] == 0) {
	//	printf("----------------------Proc2--------------");
        //        printf("Parent PID: %d \n", getppid());
        //        printf("Child PID: %d \n", getpid());
        //}
	//
	return (0);
}
