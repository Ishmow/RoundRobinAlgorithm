# RoundRobinAlgorithm
An assignment for my Operating Systems class

# CPU Scheduling 
Programming Assignment

# Aim 
To designate the Round Robin Scheduling Algorithm using different time quantum.

# Introduction 

Round-robin (RR) is one of the simplest scheduling algorithms for processes in an operating system. As the term is generally used, time slices are assigned to each process in equal portions and in circular order, handling all processes without priority (also known as cyclic executive). Round-robin scheduling is simple, easy to implement, and starvation-free. Round-robin scheduling can also be applied to other scheduling problems, such as data packet scheduling in computer networks.
In order to schedule processes fairly, a round-robin scheduler generally employs time-sharing, giving each job a time slot or quantum[1] (its allowance of CPU time), and interrupting the job if it is not completed by then. The job is resumed next time a time slot is assigned to that process. In the absence of time-sharing, or if the quanta were large relative to the sizes of the jobs, a process that produced large jobs would be favored over other processes.

# How It Works

To start the program, select the “run” in input Frame. The applet classes gets the programmer defined PROCESS NAME, PROCESS ARRIVAL TIME, PROCESS CPU BURST TIME .Scheduler starts creating the process and threads and then Round Robin algorithm is run. As Round Robin thread runs, it updates the anime Frame that shows each job going through round robin and time spent graphically. 
When all processes are done . The statistics are displayed in the stats frame. For example – Process name, Arrival time, Service time, Finish time, Turn Around, Waiting Time, Average Turn Around time, Average waiting time.
NOTE- To achieve 100% CPU utilization, there should be at least one process in the waiting queue. Robin.html is used to load all the java classes.

# Conclusion

Here, we have noticed that for those processes, increase in  quantum number was a wrong move as it increases the waiting time,  turnaround time for processes. The quantum =1 was the best way to implement the Round Robin algorithm for the processes that arrive at the same time. Further,  the process that arrive at different times , the increase in quantum numbers helps getting the decrease in waiting time, turnaround time. One important thing to keep in mind is that when we kept increasing the quantum numbers, the results were similar. Hence the effect of change in quantum numbers were started acting life FIFO algorithm.
