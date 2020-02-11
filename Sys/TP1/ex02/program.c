#include <stdio.h>
#include <sys/time.h>
#include <unistd.h>
int	main() {
	int d = 1;	
	while (d == 1) {
		printf("Bonjour!\n");
		sleep(30);	
	}
	return (0);
}
