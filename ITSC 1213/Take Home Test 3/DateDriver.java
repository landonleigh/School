
/**
 * Driver of date class to allow user to add, subtract, or get days between.
 *
 * @author Landon Leigh
 * @version 3/31/2019
 */
public class DateDriver
{
    public static void main(String[] args)
    {
       Date d = new Date();//Create date reference

       System.out.println(d.toString());//Print current date

       d.add(6);//Add days to the stored date
       System.out.println("After adding 6 days: " + d.toString());
       d.add(60);//Add days to the stored date
       System.out.println("After adding 60 days: " + d.toString());
       d.add(600);//Add days to the stored date
       System.out.println("After adding 600 days: " + d.toString());

       d.subtract(3);//Subtract days from the stored date
       System.out.println("After subtracting 3 days: " + d.toString());
       d.subtract(30);//Subtract days from the stored date
       System.out.println("After subtracting 30 days: " + d.toString());
       d.subtract(300);//Subtract days from the stored date
       System.out.println("After subtracting 300 days: " + d.toString());

       Date btw = new Date(7, 14, 2019);//Get days between current date and another date
       System.out.println("There are " + Math.abs(d.getDays() - Date.daysBetween(btw)) + " days between the current date and 7/14/2019");
       Date btw2 = new Date(1, 11, 2019);//get days between current date and another date
       System.out.println("There are " + Math.abs(d.getDays() - Date.daysBetween(btw2)) + " days between the current date and 1/11/2019");
       Date btw3 = new Date(4, 23, 2020);//get days between current date and another date
       System.out.println("There are " + Math.abs(d.getDays() - Date.daysBetween(btw3)) + " days between the current date and 4/23/2020");
               
       System.out.println("Date in word format: " + d.getDate('a'));//Show different formats from getDate method
       System.out.println("Date in number format: " + d.getDate('b'));
       
       System.out.println("Is the stored date the same as 7/14/2019? " + d.equals(btw));//Tests equals method
       
       System.out.println("Comparing stored date to 4/3/2019: " + d.compareTo(btw));//Tests equals method
       
       d.setMonth(2);//Testing set methods
       d.setDay(27);
       d.setYear(1998);
       System.out.println("After set methods date is: " + d.toString());
       
       System.out.println("getDays method shows days in stored date: " + d.getDays());//Testing getDays method
       
       System.out.println("Is stored date a leap year? " + d.isLeapYear());//Tests isLeapYear method
    }
}
