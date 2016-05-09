#include <stdio.h>
#include <dirent.h>

void printdir(char* path){
    DIR *dirp; // directory stream pointer
    struct dirent *dp; // directory entry

    dirp = opendir(path); // open directory
    if(!dirp){ // if if cannot be opened
        return;
    }
    while(dp = readdir(dirp)){ // loop through directory entries
        puts(dp->d_name); // print entry name
    }
    closedir(dirp); // close directory
}

int main(int argc, char** argv){
    int i;
    for(i = 1; i < argc; ++i){ // loop through arguments
        puts(argv[i]); // print directory name
        printdir(argv[i]); // print directory contents
        puts(""); // newline
    }
    return 0;
}
