#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <fcntl.h>
#include <string.h>
#include <err.h>

int main(int argc, char **argv){
	int fd = -1;
	int low_border = 0;
	int high_border = 0;
	char* source;

	FILE *file = fopen(argv[1], "r"); 
	fseek(file, -1, SEEK_END);
	int file_len = ftell(file);
	fclose(file);

	if ((fd = open(argv[1],O_RDWR,0)) == -1)
		err(1,"File not opened");
	source = (char*)mmap(NULL, file_len, PROT_READ|PROT_WRITE, MAP_FILE|MAP_SHARED, fd, 0);
	high_border = file_len-1;
	char a;
	while(low_border < high_border){
		a = source[low_border];
		source[low_border] = source[high_border];
		source[high_border] = a;
		high_border--;
		low_border++;
	}

	munmap(source,file_len);
	close(fd);
	return 0;
}