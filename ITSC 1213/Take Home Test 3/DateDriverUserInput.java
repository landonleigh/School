
/**
 * Driver of date class to allow user to add, subtract, or get days between.
 *
 * @author Landon Leigh
 * @version 3/31/2019
 */
import java.util.*;//Import java util
public class DateDriverUserInput
{
    public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);//Declare/initialize scanner, object, and variables
       Date d = new Date();
       char format = 'a';
       int choice = 0;
       int days = 0;
       int month, day, year = 0;
       
       System.out.println(d.toString());//Print current date
       
       while(choice != 5)//Loop until uer chooses to quit
       {
           //Ask user for input
           System.out.println("Select an option: \n1. Add to stored date \n2. Subtract from stored date \n3. Days Between current date and your date" +
           "\n4. Get date in another format \n5. Quit");
           choice = input.nextInt();

           switch(choice)//Switch statement to do operations based off user choice
           {
               case 1://Case to add days to the stored date
               System.out.println("How many days do you want to add?");
               days = input.nextInt();
               d.add(days);
               System.out.println(d.toString());
               break;
               case 2://Case to subtract days from the stored date
               System.out.println("How many days do you want to subtract?");
               days = input.nextInt();
               d.subtract(days);
               System.out.println(d.toString());
               break;
               case 3://Case to get days between current date and entered date
               System.out.println("Enter the month of the date you want.");
               month = input.nextInt();
               System.out.println("Enter the day of the date you want.");
               day = input.nextInt();
               System.out.println("Enter the year of the date you want.");
               year = input.nextInt();
               Date btw = new Date(month, day, year);
               System.out.println("There are " + (d.getDays() - Date.daysBetween(btw)) + " days between the current date and the entered date.");
               break;
               case 4://Case to show different formats
               System.out.println("Do you want format 'a' (i.e January 5, 2019) or format 'b' (i.e 1/5/2019)? Enter 'a' or 'b'.");
               format = input.next().charAt(0);
               System.out.println(d.getDate(format));
               break;
           }
       }

       System.out.println("Goodbye!");//Goodbye statement
    }
}
