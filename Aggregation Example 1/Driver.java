
/**
 * This class demonstrates the use of
 * the Student and Advisor classes.
 * Play with it- change some code
 * and add your own code to create more 
 * objects using the other constructors
 * 
 * @author Lorrie Lehmann
 * @version v1
 */
public class Driver
{
    public static void main(String[ ] args)
    {
        Student s1, s2, s3, s4; //declare four student references
        Advisor a1, a2, a3; //declare three advisor references
        
        //create three advisor objects
        a1 = new Advisor("Goodrum", "Cloyd", "Computer Science", "687-8668");
        a2 = new Advisor("Lehmann", "Lorrie", "Computer Science","687-8439");
        a3 = new Advisor("Jones", "Sue", "English Studies  ", "678-8888");
        
        //create four student objects
        s1 = new Student("Sam", "Davis", "1111", a1);
      //  System.out.println("There are " + Student.numberOfStudents + " students created\n\n");
        s2 = new Student("Teresa", "Miller", "2222", a2);
       // System.out.println("There are " + Student.numberOfStudents + " students created\n\n");
        s3 = new Student("William", "Hanly", "3333", a3);
     //   System.out.println("There are " + Student.numberOfStudents + " students created\n\n");
        s4 = new Student("Alex", "Wildman", "4444", a2);
        
        //print the data for the students using the toString()
        //method which is called automatically when an object
        //reference is used where a string is expected
        System.out.println(s1.toString( )  + "\n");
        System.out.println(s2.toString( )  + "\n");
        System.out.println(s3 + "\n");
        System.out.println(s4+ "\n");
    //    System.out.println("There are " + Student.numberOfStudents + " students created\n\n");
        
        //test the compare to method I am calling the compareTo( )
        //method to compare s1 with s3. I have wriiten the compareTo( )
        //method in the Student class to compare last names. If they are the same
        //the first names are used for the comparison.
//         if(s1.compareTo(s3) < 0) //s1 comes before s3
//         {
//             System.out.println(s1 + "is alphabetically before\n" + s3);
//         }
//         else
//         {
//             if(s1.compareTo(s3) == 0) //s1 and s3 are the same values based on the criteria
//             {
//                 System.out.println(s1 + "has the same name as\n" + s3);
//             }
//             else //only other possibility is s1 comes after s3 using the name fields
//             {
//               System.out.println(s1 + " comes after\n" + s3 + " in alphabetical order");
//             }
//         }
      }
 }
       

