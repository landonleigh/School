
/**
 * Write a description of class BookDriver here.
 *
 * @author Landon Leigh
 * @version 3/27/2019
 */
import java.util.*;
public class BookDriver
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        Book[] books = new Book[5];
        String title, author;
        double price;
        
        books[0] = new Book("The Great Gatsby", "Fitzgerald", 39.99);
        books[1] = new Book("Tale of two cities", "Dickens", 29.99);
        books[2] = new Book("Hunger Games", "Collins", 34.99);
        books[3] = new Book("Hrry Potter", "Rowling", 24.99);
        books[4] = new Book("Cat in the hat", "Dr. Seuss", 19.99);
        
        int minPos;
        Book minValue;
        Book temp;
        
        for(int i = 0; i < books.length; i++)
        {
           minPos = 1;
           minValue = books[i];
           
           for(int k = 0; k < books.length; k++)
           {
               if(books[k].compareTo(minValue) <= 0)
               {
                   minValue = books[i];
                   minPos = k;
                }
           }
        
           temp = minValue;
           books[minPos] = books[i];
           books[i] = minValue;
           System.out.println(books[i].toString());
        }
    }
}
