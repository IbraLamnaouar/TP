#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
#include <stdlib.h>

void* fonction_thread(void* parm){
	int *tab = parm;
	printf("\nFonction de THREAD.\tMon PID:%d.\n",(int) getpid());
	for(int i = 0; i < 100; i++) printf("%d ", tab[i]);
	printf("\n");
}

int main(){
	pthread_t tid;
	
	printf("\nProgramme MAIN.\t\tMon PID:%d.",(int) getpid());
	
	int *tab = (int*)malloc(sizeof(int) * 100);
	for(int i = 0; i < 100; i++) tab[i] = i*i;

	pthread_create(&tid, NULL, &fonction_thread, tab);
	sleep(1);	
	printf("\n");
	

	free(tab);
	return 0;
}

