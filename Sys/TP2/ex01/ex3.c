#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <assert.h>
#include <sys/wait.h>
#include <string.h>
int	main(int argc, char **argv) {
	
	int pid, etat, n;

	assert(argc == 2);
	
	n = atoi(argv[1]);
	printf("We're creating %d processors\n", n);

	for(int i = 0; i < n; i++) {
		pid = fork();
		switch(pid) {
			case 0:
				printf("Je suis le %d-ieme fils, mon pid est %d et le pid de mon pere est %d \n", i+1, getpid(), getppid());
				printf("Child %d is going to sleep for %d seconds\n",i+1, 2*i+1);
				sleep(2*i+1);
				printf("Good Morning I am child number %d\n", i+1);
				exit(i);
				break;
			case -1:
				printf("Le fils %i n'a pas pu se creer\n", i+1);
				exit(n);
				break;
			default: {};
		}
	}

	pid = wait(&etat);
	while(pid != -1) {
		printf("Fils %d, Etat %d\n\n", pid, etat);
		pid = wait(&etat);
	}

	printf("Job is Done. All children are terminated.\n");
       	exit(EXIT_SUCCESS);


	return (0);
}
