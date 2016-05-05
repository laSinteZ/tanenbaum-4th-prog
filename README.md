# Programming tasks, Tanenbaum 4th edition
[Chapter 1](#chapter-1)
[Chapter 2](#chapter-2)
[Chapter 3](#chapter-3)
[Chapter 4](#chapter-4)
[Chapter 5](#chapter-5)
[Chapter 6](#chapter-6)
[Chapter 8](#chapter-8)
[Chapter 9](#chapter-9)

##Chapter 1 (0/1)
**34** Write a shell that is similar to Fig. 1-19 but contains enough code that it actually works so you can test it. You might also add some features such as redirection of input and output, pipes, and background jobs.

##Chapter 2 (2/9)
**57** [[Solved]](https://github.com/laSinteZ/tanenbaum-4th-prog/tree/master/chapter_2/57) Write a shell script that produces a file of sequential numbers by reading the last number in the file, adding 1 to it, and then appending it to the file. Run one instance of the script in the background and one in the foreground, each accessing the same file. How long does it take before a race condition manifests itself? What is the critical region? Modify the script to prevent the race. (Hint: use `ln file file.lock` to lock the data file.)

**58** Assume that you have an operating system that provides semaphores. Implement a message system. Write the procedures for sending and receiving messages.

**59** [[Solved]](https://github.com/laSinteZ/tanenbaum-4th-prog/blob/e1862565dbdf64d3180c9ac3b8f6a2b679108a13/chapter_2/59/DinningPhilosophers.java) Solve the dining philosophers problem using monitors instead of semaphores.

**60** Suppose that a university wants to show off how politically correct it is by applying the U.S. Supreme Court’s ‘‘Separate but equal is inherently unequal’’ doctrine to gender as well as race, ending its long-standing practice of gender-segregated bathrooms on campus. However, as a concession to tradition, it decrees that when a woman is in a bathroom, other women may enter, but no men, and vice versa. A sign with a sliding marker on the door of each bathroom indicates which of three possible states it is currently in:
* Empty
* Women present
* Men present

In some programming language you like, write the following procedures: `woman_wants_to_enter`, `man_wants_to_enter`, `woman_leaves`, `man_leaves`. You may use whatever counters and synchronization techniques you like.

**61** [[Solved]](https://github.com/laSinteZ/tanenbaum-4th-prog/blob/master/chapter_2/261.c) Rewrite the program of Fig. 2-23 to handle more than two processes.

**62** [[Solved]](https://github.com/laSinteZ/tanenbaum-4th-prog/blob/master/chapter_2/62.%D1%81) Write a producer-consumer problem that uses threads and shares a common buffer. However, do not use semaphores or any other synchronization primitives to guard the shared data structures. Just let each thread access them when it wants to. Use sleep and wakeup to handle the full and empty conditions. See how long it takes for a fatal race condition to occur. For example, you might have the producer print a number once in a while. Do not print more than one number every minute because the I/O could affect the race conditions.

**63** A process can be put into a round-robin queue more than once to give it a higher priority. Running multiple instances of a program each working on a different part of a data pool can have the same effect. First write a program that tests a list of numbers for primality. Then devise a method to allow multiple instances of the program to run at once in such a way that no two instances of the program will work on the same number. Can you in fact get through the list faster by running multiple copies of the program? Note that your results will depend upon what else your computer is doing; on a personal computer running only instances of this program you would not expect an improvement, but on a system with other processes, you should be able to grab a bigger share of the CPU this way.

**64** The objective of this exercise is to implement a multithreaded solution to find if a given number is a perfect number. N is a perfect number if the sum of all its factors, excluding itself, is N; examples are 6 and 28. The input is an integer, N. The output is true if the number is a perfect number and false otherwise. The main program will read the numbers N and P from the command line. The main process will spawn a set of P threads. The numbers from 1 to N will be partitioned among these threads so that two threads do not work on the name number. For each number in this set, the thread will determine if the number is a factor of N. If it is, it adds the number to a shared buffer that stores factors of N. The parent process waits till all the threads complete. Use the appropriate synchronization primitive here. The parent will then determine if the input number is perfect, that is, if N is a sum of all its factors and then report accordingly. (Note: You can make the computation faster by restricting the numbers searched from 1 to the square root of N.)

**65** Implement a program to count the frequency of words in a text file. The text file is partitioned into N segments. Each segment is processed by a separate thread that outputs the intermediate frequency count for its segment. The main process waits until all the threads complete; then it computes the consolidated word-frequency data based on the individual threads’ output

##Chapter 3 (0/5)
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

##Chapter 4 (0/6)
**43** Write a program that reverses the bytes of a file, so that the last byte is now first and the first byte is now last. It must work with an arbitrarily long file, but try to make it reasonably efficient.

**44** Write a program that starts at a given directory and descends the file tree from that point recording the sizes of all the files it finds. When it is all done, it should print a histogram of the file sizes using a bin width specified as a parameter (e.g., with 1024, file sizes of 0 to 1023 go in one bin, 1024 to 2047 go in the next bin, etc.).

**45** Write a program that scans all directories in a UNIX file system and finds and locates all i-nodes with a hard link count of two or more. For each such file, it lists together all file names that point to the file.

**46** Write a new version of the UNIX ls program. This version takes as an argument one or more directory names and for each directory lists all the files in that directory, one line per file. Each field should be formatted in a reasonable way given its type. List only the first disk address, if any.

**47** Implement a program to measure the impact of application-level buffer sizes on read time. This involves writing to and reading from a large file (say, 2 GB). Vary the application buffer size (say, from 64 bytes to 4 KB). Use timing measurement routines (such as gettimeofday and getitimer on UNIX) to measure the time taken for different buffer sizes. Analyze the results and report your findings: does buffer size make a difference to the overall write time and per-write time?

**48** Implement a simulated file system that will be fully contained in a single regular file stored on the disk. This disk file will contain directories, i-nodes, free-block information, file data blocks, etc. Choose appropriate algorithms for maintaining free-block information and for allocating data blocks (contiguous, indexed, linked). Your program will accept system commands from the user to create/delete directories, create/ delete/open files, read/write from/to a selected file, and to list directory contents

##Chapter 5 (0/3)
**55** Write a program that simulates stable storage. Use two large fixed-length files on your disk to simulate the two disks.

**56** Write a program to implement the three disk-arm scheduling algorithms. Write a driver program that generates a sequence of cylinder numbers (0–999) at random, runs the three algorithms for this sequence and prints out the total distance (number of cylinders) the arm needs to traverse in the three algorithms.

**57** Write a program to implement multiple timers using a single clock. Input for this program consists of a sequence of four types of commands (S <int>, T, E <int>, P): S <int> sets the current time to <int>; T is a clock tick; and E <int> schedules a signal to occur at time <int>; P prints out the values of Current time, Next signal, and Clock header. Your program should also print out a statement whenever it is time to raise a signal.

##Chapter 6 (0/6)
**39** A student majoring in anthropology and minoring in computer science has embarked on a research project to see if African baboons can be taught about deadlocks. He locates a deep canyon and fastens a rope across it, so the baboons can cross hand-overhand. Several baboons can cross at the same time, provided that they are all going in the same direction. If eastward-moving and westward-moving baboons ever get onto the rope at the same time, a deadlock will result (the baboons will get stuck in the middle) because it is impossible for one baboon to climb over another one while suspended over the canyon. If a baboon wants to cross the canyon, he must check to see that no other baboon is currently crossing in the opposite direction. Write a program using semaphores that avoids deadlock. Do not worry about a series of eastward-moving baboons holding up the westward-moving baboons indefinitely.

**40** Repeat the previous problem, but now avoid starvation. When a baboon that wants to cross to the east arrives at the rope and finds baboons crossing to the west, he waits until the rope is empty, but no more westward-moving baboons are allowed to start until at least one baboon has crossed the other way.

**41** Program a simulation of the banker’s algorithm. Your program should cycle through each of the bank clients asking for a request and evaluating whether it is safe or unsafe. Output a log of requests and decisions to a file.

**42** Write a program to implement the deadlock detection algorithm with multiple resources of each type. Your program should read from a file the following inputs: the number of processes, the number of resource types, the number of resources of each type in existence (vector E), the current allocation matrix C (first row, followed by the second row, and so on), the request matrix R (first row, followed by the second row, and so on). The output of your program should indicate whether there is a deadlock in the system. In case there is, the program should print out the identities of all processes that are deadlocked.

**43** Write a program that detects if there is a deadlock in the system by using a resource allocation graph. Your program should read from a file the following inputs: the number of processes and the number of resources. For each process if should read four numbers: the number of resources it is currently holding, the IDs of resources it is holding, the number of resources it is currently requesting, the IDs of resources it is requesting. The output of program should indicate if there is a deadlock in the system. In case there is, the program should print out the identities of all processes that are deadlocked.

**44** In certain countries, when two people meet they bow to each other. The protocol is that one of them bows first and stays down until the other one bows. If they bow at the same time, they will both stay bowed forever. Write a program that does not deadlock.

##Chapter 8 (0/4)
**35** Copying buffers takes time. Write a C program to find out how much time it takes on a system to which you have access. Use the clock or times functions to determine how long it takes to copy a large array. Test with different array sizes to separate copying time from overhead time.

**36** Write C functions that could be used as client and server stubs to make an RPC call to the standard printf function, and a main program to test the functions. The client and server should communicate by means of a data structure that could be transmitted over a network. You may impose reasonable limits on the length of the format string and thenumber, types, and sizes of the variables your client stub will accept.

**37** Write a program that implements the sender-initiated and receiver-initiated load balancing algorithms described in Sec. 8.2. The algorithms should take as input a list of newly created jobs specified as (creating processor, start time, required CPU time) where the creating processor is the number of the CPU that created the job, the start time is the time at which the job was created, and the required CPU time is the amount of CPU time the job needs to complete (specified in seconds). Assume a node is overloaded when it has one job and a second job is created. Assume a node is underloaded when it has no jobs. Print the number of probe messages sent by both algorithms under heavy and light workloads. Also print the maximum and minimum number of probes sent by any host and received by any host. To create the workloads, write two workload generators. The first should simulate a heavy workload, generating, on average, N jobs every AJL seconds, where AJL is the average job length and N is the number of processors. Job lengths can be a mix of long and short jobs, but the av erage job length must be AJL. The jobs should be randomly created (placed) across all processors. The second generator should simulate a light load, randomly generating N/3 jobs every AJL seconds. Play with other parameter settings for the workload generators and see how it affects the number of probe messages. 

**38** One of the simplest ways to implement a publish/subscribe system is via a centralized broker that receives published articles and distributes them to the appropriate subscribers. Write a multithreaded application that emulates a broker-based pub/sub system. Publisher and subscriber threads may communicate with the broker via (shared) memory. Each message should start with a length field followed by that many characters. Publishers send messages to the broker where the first line of the message contains a hierarchical subject line separated by dots followed by one or more lines that comprise the published article. Subscribers send a message to the broker with a single line containing a hierarchical interest line separated by dots expressing the articles they are interested in. The interest line may contain the wildcard symbol ‘‘*’’. The broker must respond by sending all (past) articles that match the subscriber’s interest. Articles in the message are separated by the line ‘‘BEGIN NEW ARTICLE.’’ The subscriber should print each message it receives along with its subscriber identity (i.e., its interest line). The subscriber should continue to receive any new articles that are posted and match its interests. Publisher and subscriber threads can be created dynamically from the terminal by typing ‘‘P’’ or ‘‘S’’ (for publisher or subscriber) followed by the hierarchical subject/interest line. Publishers will then prompt for the article. Typing a single line containing ‘‘.’’ will signal the end of the article. (This project can also be implemented using processes communicating via TCP.)

##Chapter 9 (0/5)
**58** Write a pair of programs, in C or as shell scripts, to send and receive a message by a covert channel on a UNIX system. (Hint: A permission bit can be seen even when a file is otherwise inaccessible, and the sleep command or system call is guaranteed to delay for a fixed time, set by its argument.) Measure the data rate on an idle system. Then create an artificially heavy load by starting up numerous different background processes and measure the data rate again.

**59** Several UNIX systems use the DES algorithm for encrypting passwords. These systems typically apply DES 25 times in a row to obtain the encrypted password. Download an implementation of DES from the Internet and write a program that encrypts a password and checks if a password is valid for such a system. Generate a list of 10 encrypted passwords using the Morris-Thomson protection scheme. Use 16-bit salt for your program.

**60** Suppose a system uses ACLs to maintain its protection matrix. Write a set of management functions to manage the ACLs when (1) a new object is created; (2) an object is deleted; (3) a new domain is created; (4) a domain is deleted; (5) new access rights (a combination of r, w, x) are granted to a domain to access an object; (6) existing access rights of a domain to access an object are revoked; (7) new access rights are granted to all domains to access an object; (8) access rights to access an object are revoked from all domains.

**61** Implement the program code outlined in Sec. 9.7.1 to see what happens when there is buffer overflow. Experiment with different string sizes.

**62** Write a program that emulates overwriting viruses outlined in Sec. 9.9.2 under the heading ‘‘Executable Program Viruses’’. Choose an existing executable file that you know can be overwritten without any harm. For the virus binary, choose any harmless executable binary.
