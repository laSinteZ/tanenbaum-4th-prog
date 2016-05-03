# Programming tasks, Tanenbaum 4th edition
[Chapter 1](#chapter-1)
[Chapter 2](#chapter-2)
[Chapter 3](#chapter-3)
[Chapter 4](#chapter-4)

##Chapter 1
**34** Write a shell that is similar to Fig. 1-19 but contains enough code that it actually works so you can test it. You might also add some features such as redirection of input and output, pipes, and background jobs.

##Chapter 2
**57** Write a shell script that produces a file of sequential numbers by reading the last number in the file, adding 1 to it, and then appending it to the file. Run one instance of the script in the background and one in the foreground, each accessing the same file. How long does it take before a race condition manifests itself? What is the critical region? Modify the script to prevent the race. (Hint: use `ln file file.lock` to lock the data file.)

**58** Assume that you have an operating system that provides semaphores. Implement a message system. Write the procedures for sending and receiving messages.

**59** Solve the dining philosophers problem using monitors instead of semaphores.

**60** Suppose that a university wants to show off how politically correct it is by applying the U.S. Supreme Court’s ‘‘Separate but equal is inherently unequal’’ doctrine to gender as well as race, ending its long-standing practice of gender-segregated bathrooms on campus. However, as a concession to tradition, it decrees that when a woman is in a bathroom, other women may enter, but no men, and vice versa. A sign with a sliding marker on the door of each bathroom indicates which of three possible states it is currently in:
* Empty
* Women present
* Men present

In some programming language you like, write the following procedures: `woman_wants_to_enter`, `man_wants_to_enter`, `woman_leaves`, `man_leaves`. You may use whatever counters and synchronization techniques you like.

**61** Rewrite the program of Fig. 2-23 to handle more than two processes.

**62** Write a producer-consumer problem that uses threads and shares a common buffer. However, do not use semaphores or any other synchronization primitives to guard the shared data structures. Just let each thread access them when it wants to. Use sleep and wakeup to handle the full and empty conditions. See how long it takes for a fatal race condition to occur. For example, you might have the producer print a number once in a while. Do not print more than one number every minute because the I/O could affect the race conditions.

**63** A process can be put into a round-robin queue more than once to give it a higher priority. Running multiple instances of a program each working on a different part of a data pool can have the same effect. First write a program that tests a list of numbers for primality. Then devise a method to allow multiple instances of the program to run at once in such a way that no two instances of the program will work on the same number. Can you in fact get through the list faster by running multiple copies of the program? Note that your results will depend upon what else your computer is doing; on a personal computer running only instances of this program you would not expect an improvement, but on a system with other processes, you should be able to grab a bigger share of the CPU this way.

**64** The objective of this exercise is to implement a multithreaded solution to find if a given number is a perfect number. N is a perfect number if the sum of all its factors, excluding itself, is N; examples are 6 and 28. The input is an integer, N. The output is true if the number is a perfect number and false otherwise. The main program will read the numbers N and P from the command line. The main process will spawn a set of P threads. The numbers from 1 to N will be partitioned among these threads so that two threads do not work on the name number. For each number in this set, the thread will determine if the number is a factor of N. If it is, it adds the number to a shared buffer that stores factors of N. The parent process waits till all the threads complete. Use the appropriate synchronization primitive here. The parent will then determine if the input number is perfect, that is, if N is a sum of all its factors and then report accordingly. (Note: You can make the computation faster by restricting the numbers searched from 1 to the square root of N.)

**65** Implement a program to count the frequency of words in a text file. The text file is partitioned into N segments. Each segment is processed by a separate thread that outputs the intermediate frequency count for its segment. The main process waits until all the threads complete; then it computes the consolidated word-frequency data based on the individual threads’ output

##Chapter 3
**51** Write a program that simulates a paging system using the aging algorithm. The number of page frames is a parameter. The sequence of page references should be read from a file. For a given input file, plot the number of page faults per 1000 memory references as a function of the number of page frames available.

**52** Write a program that simulates a toy paging system that uses the WSClock algorithm. The system is a toy in that we will assume there are no write references (not very realistic), and process termination and creation are ignored (eternal life). The inputs will be:
* The reclamation age threshhold
* The clock interrupt interval expressed as number of memory references
* A file containing the sequence of page references
  
1. Describe the basic data structures and algorithms in your implementation.
2. Show that your simulation behaves as expected for a simple (but nontrivial) input example.
3. Plot the number of page faults and working set size per 1000 memory references.
4. Explain what is needed to extend the program to handle a page reference stream that also includes writes.

**53** Write a program that demonstrates the effect of TLB misses on the effective memory access time by measuring the per-access time it takes to stride through a large array.

1. Explain the main concepts behind the program, and describe what you expect the output to show for some practical virtual memory architecture.
2. Run the program on some computer and explain how well the data fit your expectations.
3. Repeat part *2* but for an older computer with a different architecture and explain any major differences in the output.

**54** Write a program that will demonstrate the difference between using a local page replacement policy and a global one for the simple case of two processes. You will need a routine that can generate a page reference string based on a statistical model. This model has N states numbered from 0 to N − 1 representing each of the possible page references and a probability pi associated with each state i representing the chance that the next reference is to the same page. Otherwise, the next page reference will be one of the other pages with equal probability.

1. Demonstrate that the page reference string-generation routine behaves properly for some small N.
2. Compute the page fault rate for a small example in which there is one process and a fixed number of page frames. Explain why the behavior is correct.
3. Repeat part 2 with two processes with independent page reference sequences and twice as many page frames as in part 2
4. Repeat part 4 but using a global policy instead of a local one. Also, contrast the per-process page fault rate with that of the local policy approach.

**55** Write a program that can be used to compare the effectiveness of adding a tag field to TLB entries when control is toggled between two programs. The tag field is used to effectively label each entry with the process id. Note that a nontagged TLB can be simulated by requiring that all TLB entries have the same tag at any one time. The inputs will be:
* The number of TLB entries available
* The clock interrupt interval expressed as number of memory references
* A file containing a sequence of (process, page references) entries
* The cost to update one TLB entry
  
1. Describe the basic data structures and algorithms in your implementation.
2. Show that your simulation behaves as expected for a simple (but nontrivial) input
example.
3. Plot the number of TLB updates per 1000 references.

##Chapter 4
**43** Write a program that reverses the bytes of a file, so that the last byte is now first and the first byte is now last. It must work with an arbitrarily long file, but try to make it reasonably efficient.

**44** Write a program that starts at a given directory and descends the file tree from that point recording the sizes of all the files it finds. When it is all done, it should print a histogram of the file sizes using a bin width specified as a parameter (e.g., with 1024, file sizes of 0 to 1023 go in one bin, 1024 to 2047 go in the next bin, etc.).

**45** Write a program that scans all directories in a UNIX file system and finds and locates all i-nodes with a hard link count of two or more. For each such file, it lists together all file names that point to the file.

**46** Write a new version of the UNIX ls program. This version takes as an argument one or more directory names and for each directory lists all the files in that directory, one line per file. Each field should be formatted in a reasonable way given its type. List only the first disk address, if any.

**47** Implement a program to measure the impact of application-level buffer sizes on read time. This involves writing to and reading from a large file (say, 2 GB). Vary the application buffer size (say, from 64 bytes to 4 KB). Use timing measurement routines (such as gettimeofday and getitimer on UNIX) to measure the time taken for different buffer sizes. Analyze the results and report your findings: does buffer size make a difference to the overall write time and per-write time?

**48** Implement a simulated file system that will be fully contained in a single regular file stored on the disk. This disk file will contain directories, i-nodes, free-block information, file data blocks, etc. Choose appropriate algorithms for maintaining free-block information and for allocating data blocks (contiguous, indexed, linked). Your program will accept system commands from the user to create/delete directories, create/ delete/open files, read/write from/to a selected file, and to list directory contents
