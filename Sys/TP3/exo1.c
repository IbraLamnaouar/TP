#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

void* fonction_thread(void* parm){
	int c=1;
	while ( c==1)
	{
		printf("x\n");
	}
}

int main(){
	pthread_t tid;
	
	printf("\nProgramme MAIN.\t\tMon PID:%d.",(int) getpid());
	
	pthread_create(&tid, NULL, &fonction_thread, NULL);
	int c=1;
	while ( c==1)
	{ printf("o\n");
	}
	//sleep(1);	
	printf("\n");
	
	return 0;
}
