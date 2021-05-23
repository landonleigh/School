
/**
 * Write a description of class TokenDriver here.
 *
 * @author Landon Leigh
 * @version 3/11/2019
 */
import java.util.*;
import java.io.*;
public class TokenDriver
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner(new File("tokenizerfile.txt"));
        StringTokenizer stok;
        String sentence;
        
        //1
        System.out.println("1.");
        System.out.println("Enter a sentence: ");
        sentence = new String(input.nextLine());
        
        stok = new StringTokenizer(sentence);
        System.out.println("Amount of tokens: " + stok.countTokens());
        
        while(stok.hasMoreTokens())
        {
            System.out.println(stok.nextToken());
        }
        
        //2
        System.out.println("2.");
        System.out.println("Enter a sentence: ");
        sentence = new String(input.nextLine());
        
        stok = new StringTokenizer(sentence, ",");
        System.out.println("Amount of tokens: " + stok.countTokens());
        
        while(stok.hasMoreTokens())
        {
            System.out.println(stok.nextToken());
        }
        
        //3
        System.out.println("3.");
        System.out.println("Enter a sentence: ");
        sentence = new String(input.nextLine());
        
        stok = new StringTokenizer(sentence, ",", true);
        System.out.println("Amount of tokens: " + stok.countTokens());
        
        while(stok.hasMoreTokens())
        {
            System.out.println(stok.nextToken());
        }
        
        //4
        System.out.println("4.");
        System.out.println("Enter a sentence: ");
        sentence = new String(input.nextLine());
        
        stok = new StringTokenizer(sentence, ", .", true);
        System.out.println("Amount of tokens: " + stok.countTokens());
        
        while(stok.hasMoreTokens())
        {
            System.out.println(stok.nextToken());
        }
        
        //5
        System.out.println("5.");
        stok = new StringTokenizer(scan.nextLine(), ",");
        
        while(stok.hasMoreTokens())
        {
            System.out.println(stok.nextToken());
        }
    }
}
