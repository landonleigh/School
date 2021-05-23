
/**
 * This program provides the interface for the user to enter their price and weight and 
 * allow it to calculate the prices per ounce/pound.
 *
 * @author Landon Leigh
 * @version 2/17/2019
 */
import java.util.*;
public class UnitPriceDriver
{
    public static void main(String[] args)
    {
        //initialize scanner 
        Scanner input = new Scanner(System.in);
        UnitPriceConverter uc = new UnitPriceConverter();
        
        //initialize variables
        char choice = 'y';
        double price;
        double weight;
        
        //loop until user quits
        while(choice == 'y')
        {
            //get price input
            System.out.println("Enter the price of your item: ");
            price = input.nextDouble();
            
            //get weight input in pounds
            System.out.println("Enter the weight of your item in pounds: ");
            weight = input.nextDouble();
            
            //pass values to set method for calculations
            uc.setAmount(price, weight);
            
            //print the price per ounce and pound
            System.out.println("The price per pound is: $" + uc.getPricePerPound());
            System.out.println("The price per ounce is: $" + uc.getPricePerOunce());
            
            //ask to go again
            System.out.println("Do you want to go again? Enter 'y' or 'n'.");
            choice = input.next().charAt(0);
        }
        //print goodbye message
        System.out.println("Goodbye!");
    }
}
