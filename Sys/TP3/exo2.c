#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

#define Malloc(type) (type*)malloc(sizeof(type))

typedef struct 
{
	char c;
	int comp;
} p_t;


void* fonction_thread(void* parm){
	p_t *t = (t_p*)parm;
	for(int i = 0; i < t->comp; i++) printf("%c", t->c);
}

int main(){
	pthread_t tid2;
	pthread_t tid1;
	
	//printf("\nProgramme MAIN.\t\tMon PID:%d.",(int) getpid());
	
	p_t t1 = {.c = 'b', .comp = 1000};
	p_t t2 = {.c = 'l', .comp = 3000};

	pthread_create(&tid1, NULL, &fonction_thread, &t1);
	pthread_join(tid1, NULL);	
	
	pthread_create(&tid2, NULL, &fonction_thread, &t2);
	pthread_join(tid2, NULL);	
	printf("\n");
	
	return 0;
}

