
/**
 * This class is the data structure  that holds the Customer objects
 *
 * @author Landon Leigh
 * @version 7/12/2019
 */
public class LinkedList
{
    private Customer front; //front of the queue
    private Customer back; //back of the queue
    private int length; //size of the queue

    //constructor
    public LinkedList()
    {
        //initializes the queue with their default values
        front = null;
        back = null;
        length = 0;
    }
    
    //to see if queue is empty
    public boolean isEmpty()
    {
        return front == null;
    }
    
    //to add customers into queue
    public void addQueue(Customer inCustomer)
    {
        length++;
        if(isEmpty())
        {
            front = inCustomer;
        }
        
        else
        {
            back.setNext(inCustomer);
        }
        back = inCustomer;
    }
    
    //to remove customers from queue
    public Customer removeQueue()
    {
        if(isEmpty())
        {   
            return null;
        }
        length--;
        Customer object = front;
        
        if(front == back)
        {
            back = null; //if there is only one customer
        }
        
        front = front.getNext(); //set first to next in queue
        return object; //return stored customer in queue
    }
    
    //get first customer object
    public Customer getFirst()
    {
        if(isEmpty( ))
        {
            return null;
        }
        else
        {
            Customer object = front;
            
            return object;
        }
    }
    
    public int getLength()
    {
        return length;
    }
}