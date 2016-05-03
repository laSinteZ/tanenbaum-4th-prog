# Programming tasks, Tanenbaum 4th edition
##Chapter 1
34 Write a shell that is similar to Fig. 1-19 but contains enough code that it actually works so you can test it. You might also add some features such as redirection of input and output, pipes, and background jobs.
##Chapter 2
57 Write a shell script that produces a file of sequential numbers by reading the last number in the file, adding 1 to it, and then appending it to the file. Run one instance of the script in the background and one in the foreground, each accessing the same file. How long does it take before a race condition manifests itself? What is the critical region? Modify the script to prevent the race. (Hint: use `ln file file.lock` to lock the data file.)
58 Assume that you have an operating system that provides semaphores. Implement a message system. Write the procedures for sending and receiving messages.
59 Solve the dining philosophers problem using monitors instead of semaphores.
60 Suppose that a university wants to show off how politically correct it is by applying the U.S. Supreme Court’s ‘‘Separate but equal is inherently unequal’’ doctrine to gender as well as race, ending its long-standing practice of gender-segregated bathrooms on campus. However, as a concession to tradition, it decrees that when a woman is in a bathroom, other women may enter, but no men, and vice versa. A sign with a sliding marker on the door of each bathroom indicates which of three possible states it is currently in:
* Empty
* Women present
* Men present
In some programming language you like, write the following procedures: `woman_wants_to_enter`, `man_wants_to_enter`, `woman_leaves`, `man_leaves`. You may use whatever counters and synchronization techniques you like.
61 
