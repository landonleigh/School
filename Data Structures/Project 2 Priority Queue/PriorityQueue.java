
/**
 * This class is the data structure that holds the heap for the Customer objects
 *
 * @author Landon Leigh
 * @version 7/22/2019
 */
public class PriorityQueue
{
    private PriorityCustomer[] heap;  
    private int size;
    
    //constructor
    public PriorityQueue()
    {
      heap = new PriorityCustomer[50];
      size = 0;
    }
    
    //to see if queue is empty
    public boolean isEmpty()
    {
        return heap[1] == null;
    }
    
    //gets current size of queue
    public int getSize () 
    {      
        return size;
    }
    
    //to add customers into queue
    public void addQueue(PriorityCustomer customer) 
    {      
        //make sure heap isn't full      
        if (size + 2 > heap.length) 
        {         
            System.out.println ("The heap is full");        
            return;      
        }
        
        //increase the size
        size++;
        
        //add new object to the next open position in the heap      
        heap[size] = customer;  
        
        //create a variable to keep track of where our object is in the heap    
        int index = size;
        
        //continue to compare the object to it's parents until it reaches the root   
        while (index > 1) 
        {        
            //grab parent's index        
            int parentIndex = index / 2; 
            
            //compare object to it's parent   
            if (heap[index].getPriority() > heap[parentIndex].getPriority()) //if parent value is lower
            {         
                //swap objects      
                PriorityCustomer temporary = heap[index];
                heap[index] = heap[parentIndex];              
                heap[parentIndex] = temporary;        
                //update index to parent's index      
                index = parentIndex;        
            } 
            else 
            {      
                break;       
            }     
        }     
    }
        
    //remove customers from queue
    public PriorityCustomer removeQueue()
    {
        //make sure the heap isn't empty      
        if (size == 0) 
        {         
            System.out.println ("The heap is already empty");   
            return null;     
        }   
        
        //store temporary reference to root object  
        PriorityCustomer temporary = heap[1];   
        
        //move object in the last position to the root  
        heap[1] = heap[size];    
        heap[size] = null;     
        size--; 
        
        //store the index of the object we moved to the root   
        int index = 1; 
        
        //continue to compare index to its children as long as there are children   
        while (index <= size / 2) 
        {       
            //store index and values of children   
            int leftChildIndex = index * 2;    
            int rightChildIndex = leftChildIndex + 1;  
            int leftChildValue = heap[leftChildIndex].getPriority (); 
            int rightChildValue = Integer.MIN_VALUE; 
            
            //is there a right child      
            if (rightChildIndex <= size) 
            {          
                rightChildValue = heap[rightChildIndex].getPriority ();       
            }        
            
            //determine the larger of the two children  
            int largerValue;       
            int largerIndex;   
            
            if (rightChildValue > leftChildValue) 
            {      
                largerValue = rightChildValue;   
                largerIndex = rightChildIndex;  
            }
            else 
            {       
                largerValue = leftChildValue;     
                largerIndex = leftChildIndex;  
            }  
            
            //determine if a swap should be made with the parent and the larger child  
            if (heap[index].getPriority() < largerValue) 
            {          
                //swap    
                PriorityCustomer swap = heap[index];    
                heap[index] = heap[largerIndex];    
                heap[largerIndex] = swap;     
                //update the index since we moved it to a child position     
                index = largerIndex;       
            } 
            else 
            {      
                break;        
            }     
        }
        
        //return the original root   
        return temporary;
    }
    
    //gets the first customer in line
    public PriorityCustomer getFirst() 
    {
        PriorityCustomer customer = heap[1];
        return customer;
    }
}