
/**
 * This class simulates the 60 minutes of the queue at the grocery store.
 *
 * @author Landon Leigh
 * @version 7/22/2019
 */
import java.util.*;
public class PriorityDriver
{
    public static void main(String[] args) 
{
        Random rand = new Random();//random Number generator
        int totalServiced = 0;//number of customers serviced
        int max = 0;//count the max length
        int length = 0;//length of line
        PriorityQueue store = new PriorityQueue();//declares a new queue object

        //for loop for 60 iterations to simulate 60 minutes
        for (int i = 1; i <= 60; i++)
        {
            if (rand.nextInt(4) + 1 == 1)//randomly gives a 25% probability of a customer popping up
            {
                length++;//adds one to length due to new customer
                store.addQueue(new PriorityCustomer());//adds new customer to queue 
                
                System.out.println("New customer added! Queue length is now " + store.getSize());
                System.out.println("------------------------------------------------------------");
            
                //store the max length during 60 min
                if (store.getSize() > max) 
                {
                    max++;
                }
            }
            if (store.isEmpty() != true) 
            {
                PriorityCustomer customer = store.getFirst();
                customer.decServiceTime();
                
                //if customer is served then customer is removed 
                if (customer.getServiceTime() <= 0) 
                {
                    store.removeQueue();
                    totalServiced++;
                    
                    System.out.println("Customer serviced and removed from the queue. Queue length is now: " + store.getSize());
                    System.out.println("------------------------------------------------------------");
                }
                else
                {
                    System.out.println("------------------------------------------------------------");
                }
            }
        }
        
        System.out.println("Total number of customers serviced: " + totalServiced);
        System.out.println("Max length of the line: " + max);
    }
}

