#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
void* fonction_thread(void* parm){
	printf("\nFonction de THREAD.\tMon PID:%d.",(int) getpid());
}

int main(){
	pthread_t tid;
	
	printf("\nProgramme MAIN.\t\tMon PID:%d.",(int) getpid());
	
	pthread_create(&tid, NULL, &fonction_thread, NULL);
	sleep(1);	
	printf("\n");
	
	return 0;
}
