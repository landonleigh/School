import java.io.*;
import java.util.*;

/**
 * This is a driver class used to
 * test the methods of the Student class
 * in learning about equals( ) amd compareTo( )
 * 
 * @author Landon Leigh
 * @version 2/25/2019
 */
import java.util.*;
public class Driver
{
    public static void main(String[ ] args)throws IOException
    {
        Scanner input = new Scanner(System.in);
        Student st;
 
        Student s1; //reference variable will hold the address of a Student object
        Student s2; //reference variable will hold the address of a Student object
        Student s3; //reference variable will hold the address of a Student object
        //write the code to create the three Student objects using the constructor that accepts all the values
        s1 = new Student("Leigh",  "Landon", 12345, 3.5, 70);
        s2 = new Student(s1);
        s3 = new Student(s2);
        
        
        //write the code to determine if s1 and s3 should be considered equal. Be sure to test
        //scenarios where they are equal and where they are not equal. Also, print results
        //if(true)
        //{
        //   System.out.println("They are equal. ID of student 1 = " + ID1 + " ID of student 3 = " + ID3);
        //}
        //else
        //{
        //    System.out.println("They are not equal. IDof student 1 = " + ID1 + " ID of sstudent 3 = " + ID3);
        //}
        
        //Write the code to determine the "greatest" Student object using the compareTo( ) method
        //System.out.println("The greatest Student object is: " + st.compareTo(s1.firstName(), s2.firstName(), s3.firstName()));
        //Write the code to determine the "least" Student object using the compareTo( ) method
       
        
        

  }//end of main( )
}