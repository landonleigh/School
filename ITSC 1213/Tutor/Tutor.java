
/**
 * Provides a menu for what to do with the fractions
 *
 * @author Landon Leigh
 * @version 3/20/2019
 */
import java.util.*;
public class Tutor
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String choice = "";
        int numerator, denominator;
        Fraction f1, f2, ans, add;
        
        while(choice != "Q")
        {
                System.out.println("Pick an option: \nA. Add\nS. Subtract\nM. Multiply\nD. Divide\nQ. Quit");
                choice = input.nextLine().toUpperCase();
                
                switch(choice)
                {
                    case "A":
                    for(int i = 0; i < 5; i++)
                    {
                        f1 = Fraction.random();
                        f2 = Fraction.random();
                        System.out.println("What is " + f1.toString() + " + " + f2.toString() + "?");
                    
                        System.out.println("Enter the numerator of the answer: ");
                        numerator = input.nextInt();
                        System.out.println("Enter the denominator of the answer: ");
                        denominator = input.nextInt();
                        ans = new Fraction(numerator, denominator);
                        add = f1.add(f2);
                     
                        if(ans.equals(add))
                        {
                            System.out.println("Your answer is correct!");
                        }
                            else
                        { 
                            System.out.println("Incorrect. The correct answer is " + add.toString());    
                        }
                    }
                    break;
                    case "S":
                    for(int i = 0; i < 5; i++)
                    {
                        f1 = Fraction.random();
                        f2 = Fraction.random();
                        System.out.println("What is " + f1.toString() + " - " + f2.toString() + "?");
                        
                        System.out.println("Enter the numerator of the answer: ");
                        numerator = input.nextInt();
                        System.out.println("Enter the denominator of the answer: ");
                        denominator = input.nextInt();
                        ans = new Fraction(numerator, denominator);
                        add = f1.subtract(f2);
                     
                        if(ans.equals(add))
                        {
                            System.out.println("Your answer is correct!");
                        }
                            else
                        { 
                            System.out.println("Incorrect. The correct answer is " + add.toString());    
                        }
                    }
                    break;
                    case "M":
                    for(int i = 0; i < 5; i++)
                    {
                        f1 = Fraction.random();
                        f2 = Fraction.random();
                        System.out.println("What is " + f1.toString() + " * " + f2.toString() + "?");
                        
                        System.out.println("Enter the numerator of the answer: ");
                        numerator = input.nextInt();
                        System.out.println("Enter the denominator of the answer: ");
                        denominator = input.nextInt();
                        ans = new Fraction(numerator, denominator);
                        add = f1.multiply(f2);
                     
                        if(ans.equals(add))
                        {
                            System.out.println("Your answer is correct!");
                        }
                            else
                        { 
                            System.out.println("Incorrect. The correct answer is " + add.toString());    
                        }
                    }
                    break;
                    case "D":
                    for(int i = 0; i < 5; i++)
                    {
                        f1 = Fraction.random();
                        f2 = Fraction.random();
                        System.out.println("What is " + f1.toString() + " / " + f2.toString() + "?");
                        
                        System.out.println("Enter the numerator of the answer: ");
                        numerator = input.nextInt();
                        System.out.println("Enter the denominator of the answer: ");
                        denominator = input.nextInt();
                        ans = new Fraction(numerator, denominator);
                        add = f1.divide(f2);
                 
                    if(ans.equals(add))
                    {
                        System.out.println("Your answer is correct!");
                    }
                        else
                    { 
                        System.out.println("Incorrect. The correct answer is " + add.toString());    
                    }
                }
                break;
            }
            }
        }
}

