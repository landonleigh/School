
/**
 * This is a test program for the Book class
 * 
 * @author L. Lehmann 
 * @version v1
 * This driver illustrates the use of aggregation.
 */
public class Driver
{
	public static void main(String[ ] args)
   {
         Book bA;
         Book bB;
         Publisher p1;
         
         Author a1 = new Author("King", "Steven", "2121 West Side Drive", 1948);
         Author a2=  new Author("Handey", "Jack", "331 Rodeo Drive", 1960);
         
         p1 = new Publisher("DoubleDay", "1200 Park Place London", "700-232-4345",1927 );
         
         bA = new Book("The Stand", "23232323", 24.99, 1978, a1, p1);
         bB = new Book("Deep Thoughts", "5555555", 12.95, 1999, a2, p1);

        System.out.println(bA.toString( ));
        System.out.println("==============================\n\n");
        System.out.println(bB.toString( ));
        System.out.println("\n\n\n=================\n");
//     if(a1.compareTo(a2) < 0)
//       System.out.println(a1 + "   comes before " + a2);
//     else
//        System.out.println(a1 + "  does not  come before " + a2);
   }   
}