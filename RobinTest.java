// Round Robin Scheduling Algorithm 
// By Ishrat Mowla & Sekani Millette

import java.util.*;

public class RobinTest 
{
	static ArrayList<Integer> times1 = new ArrayList<Integer>();																	//Create an array list to store the different process execution times.
	static ArrayList<Integer> times2 = new ArrayList<Integer>();																	//Create an array list to store the different process execution times.
	static ArrayList<Integer> times3 = new ArrayList<Integer>();																	//Create an array list to store the different process execution times.
	static ArrayList<Integer> times4 = new ArrayList<Integer>();																	//Create an array list to store the different process execution times.
	static ArrayList<Integer> times5 = new ArrayList<Integer>();																	//Create an array list to store the different process execution times.
	
	static int contextSwitch = 0;
	static int timeCompleted = 0;
	static int length = 0;
	static int waitingTime = 0;
	static int cpuWaitTime = 0;
	
	public static void main(String []args)
	{
		Scanner scan1 = new Scanner(System.in);
		Random rng = new Random();
		
		System.out.println("Here we will simulate the round robin scheduling");
		System.out.println("How many processes would you like to run?: ");
		int x = scan1.nextInt();
		length = x;																													//Sets the length to the amount of processes run.
		 																	
		System.out.println("These are the execution times of the " + x + " processes.");
		
		for (int i = 0; i < x; i++) 																								//Randomly generate different process times to test the time quantum.
		{
			int processLength = rng.nextInt(100) + 1;
			times1.add(processLength); 																								//Store the generated process execution times into the array different lists.
			times2.add(processLength);
			times3.add(processLength);
			times4.add(processLength);
			times5.add(processLength);
			
			
			System.out.println(times1.get(i));
		}
		
		System.out.println("We will now schedule " + x + " processes at five different time quantums.");
		System.out.println("\n");
		
		robin(5, times1);																											//Runs the scheduler with a 5 second time slice.
		robin(10, times2);																											//Runs the scheduler with a 10 second time slice.
		robin(15, times3);																											//Runs the scheduler with a 15 second time slice.
		robin(20, times4);																											//Runs the scheduler with a 20 second time slice.
		robin(25, times5);																											//Runs the scheduler with a 25 second time slice.
	}	
	
	public static void robin(int timeSlice, ArrayList<Integer> times)																//Passes the time slice value and the array list with the process execution lengths.
	{
		contextSwitch = 0;																											//Resets the values to 0 for each robin.	
		waitingTime = 0;
		timeCompleted = 0;
		
		for (int i = 0; i < times.size(); i++)																						//Gets the total time for the scheduling to complete (sum of process execution times).
		{
			timeCompleted += times.get(i);
		}
			
		while (times.size() > 0)																									//Counts the amount of context switches and calculates waiting time.
		{
			int l = pop(times);
			l = (l - timeSlice);
			
			if (l > 0)
			{
				times.add(l);
			}
			
			waitingTime += timeSlice * (times.size() - 1);
			contextSwitch++;
		}	
		System.out.println("Time Slice: " + timeSlice + " ms");
		report();
	}
	
	public static int pop(ArrayList<Integer> times)
	{
		int x = times.get(0);
		times.remove(0);
		return x;
	}
	
	public static long getAverageTurnAroundTime()
	{
		return timeCompleted/length;
	}
	
	public static float getThroughput()
	{
		return (float) length/(timeCompleted*contextSwitch-1);
	}
	
	public static long getAverageWaitTime()
	{	
		return waitingTime/length;
	}
	
	public static int getCpuUtilization()
	{
		return (int)(100 - (cpuWaitTime/timeCompleted));
	}
	
	public static void report()
	{
		System.out.println("CPU Usage: "+ getCpuUtilization() +"%");
		System.out.println("Context Switches: " + contextSwitch);
		System.out.println("Throughput: " + getThroughput() + " seconds");
		System.out.println("Average Wait Time: " + getAverageWaitTime() + " ms");
		System.out.println("Average Turnaround Time: " + getAverageTurnAroundTime() + " ms");
		System.out.println("\n");
	}
}

