/******
 * AList ADT
 * Original Author: Clifford Shaffer
 * Modified by: Diego Holguin 
 * Defines the basic Array-based list implementation
 ******/

import java.lang.String;
import java.lang.Math;

class AList<E> implements List<E> 
{
    private static final int defaultSize = 10; // Default size
    public int maxSize;    // Maximum size of list 
    private static String growthRate = null;	// Type of growth rate
    private int listSize;   // Current # of list items
    private int curr;       // Position of current element
    private E[] listArray;  // Array holding list elements

    /** Constructors */
    /** Create a list with the default capacity. */
    AList() 
    { 
    	// Creates default array of no type
    	this(defaultSize, null);
    }

    /** Create a new list object.
	@param size Max # of elements list can contain. */
    @SuppressWarnings("unchecked") // Generic array allocation
	AList(int size, String typeArray) 
	{
    	growthRate = typeArray;
    	maxSize = size;
    	listSize = curr = 0;
    	listArray = (E[])new Object[size]; // Create listArray
    }

    /** Reinitialize the list */
    public void clear() {  listSize = curr = 0; }    // Simply reinitialize values

    /** Insert "it" at current position */
    public void insert(E it) 
    {
    	// Check the current capacity of the array 
    	updateArrayCapacity();
	
    	// Shift elements up
    	for (int i=listSize; i>curr; i--) 
    	{   
    		listArray[i] = listArray[i-1]; // to make room
    		listArray[curr] = it;
    		listSize++; // Increment list size
    	}
    }
    
    public int returnMaxSize()
    {
    	return maxSize;
    }

    /** Append "it" to list */
    public void append(E it) 
    {
    
    	// Check the current capacity of the array
    	updateArrayCapacity();
    	
    	listSize++;
    	
    	// Insert new object into the next array location
    	listArray[listSize] = it;
    }

    /** Remove and return the current element */
    public E remove() {
	if ((curr<0) || (curr>=listSize)) // No current element
	    return null;
	E it = listArray[curr];
	// Copy the element
	for(int i=curr; i<listSize-1; i++) // Shift them down
	    listArray[i] = listArray[i+1];
	listSize--; // Decrement size
	return it;
    }

    /** Set curr to the front */
    public void moveToStart() { curr = 0; }

    /** Set curr to the end */
    public void moveToEnd() { curr = listSize; }

    /** Back up */
    public void prev() { if (curr > 0) curr--; }

    /** Go forward */
    public void next() { if (curr < listSize) curr++; }

    /** @return List size */
    public int length() { return listSize; }

    /** @return Current position */
    public int currPos() { return curr; }

    /** Set current list position to "pos" */
    public void moveToPos(int pos) {
	assert (pos>=0) && (pos<=listSize) : "Pos out of range";
	curr = pos;
    }
    
    // Diego Designed Functions \\
    //////////////////////////////
    
    public void printArray()
    {
		/* Print out the contents of the array */
		for(int y = 0; y <= listArray.length-1; y++)
		{
			System.out.println("New List Array at Index " + y + " Has the element : " + listArray[y]);
		}
    }
    
    @SuppressWarnings("unchecked")
	public void updateArrayCapacity()
    {
    	// If listSize is greater then or equal to 3 quarters of the maximum size allowed.. 
    	if(this.listSize >= (this.maxSize/4)*3)
    	{
    		// Determine it's growth rate
    		if(growthRate == "m + 1")
    		{
       			// Increment maxSize based upon the growth rate of the function
    			this.maxSize++;
    			
    			// Create a temp variable to hold the old array
    			E[]oldArray = listArray;
    			
    			// Update pointer to point to a new array of the appropriate updated maxSize
    	    	this.listArray = (E[])new Object[maxSize]; 
    	    	    	    	
    			//Transfer contents from the old array to the new array
    			for(int x = 0; x < oldArray.length; x++)
    			{
    				// Check if the index has an actual value to transfer over
    				if((x <= oldArray.length) && (oldArray[x] != null))
    				{
    					// Transfer elemements from the old array into the new listArray
    					this.listArray[x] = oldArray[x];
    				}
    			}
    			
    			oldArray = null;

    		}
    		else if(growthRate == "m + 100")
    		{
    			// Increment maxSize based upon the growth rate of the function
    			this.maxSize += 100;
    			
    			// Create a temp variable to hold the old array
    			E[]oldArray = listArray;
    			
    			// Update pointer to point to a new array of the appropriate updated maxSize
    	    	this.listArray = (E[])new Object[maxSize]; 
    			
    			//Transfer contents from the old array to the new array
    			for(int x = 0; x < oldArray.length; x++)
    			{
    				// Check if the index has an actual value to transfer over
    				if((x <= oldArray.length) && (oldArray[x] != null))
    				{
    					// Transfer elemements from the old array into the new listArray
    					this.listArray[x] = oldArray[x];
    				}
    			}
    			
    			oldArray = null;
    		}
    		else if(growthRate == "2m")
    		{
    			// Increment maxSize based upon the growth rate of the function
    			maxSize *=2;
    			
    			// Update pointer to point to a new array of the appropriate updated maxSize
    	    	listArray = (E[])new Object[maxSize]; 
    		}
    		else if (growthRate == "m^2 + 1")
    		{
    			// Increment maxSize based upon the growth rate of the function
    			maxSize = (maxSize * maxSize) + 1;
    			
    			// Create a temp variable to hold the old array
    			E[]oldArray = listArray;
    			
    			// Update pointer to point to a new array of the appropriate updated maxSize
    	    	listArray = (E[])new Object[maxSize]; 
    			
    			//Transfer contents from the old array to the new array
    			for(int x = 0; x < oldArray.length; x++)
    			{
    				// Check if the index has an actual value to transfer over
    				if((x <= oldArray.length) && (oldArray[x] != null))
    				{
    					// Transfer elemements from the old array into the new listArray
    					listArray[x] = oldArray[x];
    				}
    			}
    		}
    		else if (growthRate == "m  + floor(squareroot(m))")
    		{
    			// Increment maxSize based upon the growth rate of the function
    			maxSize = (int) (maxSize + Math.floor((Math.sqrt((double)maxSize))));
    			
    			// Create a temp variable to hold the old array
    			E[]oldArray = listArray;
    			
    			// Update pointer to point to a new array of the appropriate updated maxSize
    	    	listArray = (E[])new Object[maxSize]; 
    			
    			//Transfer contents from the old array to the new array
    			for(int x = 0; x < oldArray.length; x++)
    			{
    				// Check if the index has an actual value to transfer over
    				if((x <= oldArray.length) && (oldArray[x] != null))
    				{
    					// Transfer elemements from the old array into the new listArray
    					listArray[x] = oldArray[x];
    				}
    			}
    		}
    	}
    }

    ////////////////////////////
	/** @return Current element */
    public E getValue() {
	assert (curr>=0) && (curr<listSize) :
	"No current element";
	return listArray[curr];
    }
}
