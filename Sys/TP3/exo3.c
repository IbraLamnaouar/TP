#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
#include <stdlib.h>

#define Malloc(type) (type*)malloc(sizeof(type))


typedef struct job_s {
	struct job_s* next;
	char character;
	int count;
} job_t; 

job_t *job_queue;


void process_job(job_t* job);

void* thread_function (void* arg) {
	while (job_queue != NULL) {
		job_t* job_to_process = job_queue;
		job_queue = job_queue->next;
		process_job(job_to_process);
		free (job_to_process);
		sleep(2);
	}
	return NULL;
}


void  	enqueue_job (char chart, int count) {
	job_t* job = Malloc(job_t);
	job->character = chart;
	job->count = count;
	job->next = job_queue;
	job_queue = job;	
}

void process_job(job_t* job){
	for(int i = 0; i < job->count; i++) printf("%c", job->character);
}

int main(){
	pthread_t tid;

	job_queue = Malloc(job_t);
	
	enqueue_job('b', 1000);
	enqueue_job('m', 2000);
	enqueue_job('b', 3000);
	enqueue_job('l', 5000);

	pthread_create(&tid, NULL, &thread_function, NULL);
	pthread_join(tid, NULL);
	
	
	printf("\n");

	return 0;
}
