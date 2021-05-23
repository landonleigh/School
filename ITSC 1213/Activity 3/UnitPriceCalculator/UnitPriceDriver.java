
/**
 * Write a description of class UnitPriceDriver here.
 *
 * @author Landon Leigh
 * @version 1/30/2019
 */
import java.util.*;
public class UnitPriceDriver
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        UnitPriceCalculator pc = new UnitPriceCalculator();
        
        double price = 0;
        double amountPound = 0;
        double amountOunce = 0;
        char choice ='y';
        char choiceWeight = 'p';
        
        while(choice == 'y')
        {
            System.out.println("Enter the price of your item.");
            price = input.nextDouble();
            
            System.out.println("Is your item weighed in pounds or ounces? Enter 'p' or 'o'.");
            choiceWeight = input.next().charAt(0);
            
            if(choiceWeight == 'p')
            {
                System.out.println("Enter the weight of your item in pounds.");
                amountPound = input.nextDouble();
                pc.setAmount(price, amountPound, 0);
            }
            if(choiceWeight == 'o')
            {
                System.out.println("Enter the weight of your item in ounces.");
                amountOunce = input.nextDouble();
                pc.setAmount(price, 0, amountOunce);
            }
            
            System.out.println(pc.toString(choiceWeight));
            
            System.out.println("Do you want to enter a new item? Enter 'y' or 'n'");
            choice = input.next().charAt(0);
        }
        
        System.out.println("Goodbye!");
    }
}
