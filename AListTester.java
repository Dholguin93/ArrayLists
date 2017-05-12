/******
 * AListTester
 * Author: Diego Holguin
 * 
 * Tests out the AList ADT
 ******/

public class AListTester 
{
	public static int NumOfAppends = 10;
	public static String growthRate = "m + 1";
   
    public static void main(String[] args) 
    {
    	// List starting size is at defualt 10
    	AList<Integer> list = new AList<Integer>(10,growthRate);   // A list of Integers (default capacity)
	
    	int i; // holder variable
    	double averageTime = 0;
    	
    	// Adds a new integer all the way up to it's SIZE
    	// Note: index 0 will always be null.... 
    	for (i = 1; i <= NumOfAppends; i++) 
    	{
    		// Start the clock
			long startTime = System.nanoTime();              

			// Append new int to AList
    		list.append(new Integer(i*i));
    		
    		// Estimate the time from by finding the difference from
    		//  the program's clock against our coded clock(startTime) 
			long estimatedTime = System.nanoTime() - startTime; // Estimated time taken
			
			// Calculate the average
			averageTime = (averageTime*NumOfAppends + estimatedTime)/(NumOfAppends+1);
    	}
    
		// Now print the contents of the array out
    	//list.printArray();
    	
		// Print out the number of elements added and the corressponding average time (in CSV format)
    	// (i-1) get the correct # of elements added, since i is incremented "ahead of time"
		System.out.println( (i-1) + "," + averageTime);
    }
}

