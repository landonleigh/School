
/**
 * Sets current date and provides methods to add, subtract and get days between.
 *
 * @author Landon Leigh
 * @version 3/31/2019
 */
import java.util.*;//Import java util
public class Date
{
    static int month;//Declare variables for date
    static int day;
    static int year;
    static int userMonth;
    static int userDay;
    static int userYear;
    
    /**
     * Constructor that sets date variables to current date
     */
    public Date()
    {
        month = Calendar.getInstance().get(Calendar.MONTH) +1;//Initialize variables to current date
        day = Calendar.getInstance().get(Calendar.DATE);
        year = Calendar.getInstance().get(Calendar.YEAR);
    }
    
    /**
     * Copy constructor
     * 
     * @param other refrence to date object to copy
     */
    public Date(Date other)
    {
        month = other.month;//Initialize variables as copy
        day = other.day;
        year = other.year;
    }
    
    /**
     * Comstructor to creat object that takes in month, day, and year value
     * 
     * @param inMonth user entered month
     * @param inDay user entered day
     * @param inYear user entered year
     */
    public Date(int inMonth, int inDay, int inYear)
    {
        month = inMonth;//Initialize variables based on input
        day = inDay;
        year = inYear;
    }
    
    /**
     * Comstructor to creat object that takes in month, day, and year value
     * 
     * @param inMonth user entered month
     * @param inDay user entered day
     * @param inYear user entered year
     */
    public Date(int inMonth, int inDay, int inYear, char inUser)
    {
        userMonth = inMonth;//Initialize variables based on input
        userDay = inDay;
        userYear = inYear;
    }
    
    /**
     * Add method to add days and calculate new date
     * 
     * @param inDays how many days user wants to add to stored date
     * @return newDate reference to updated date
     */
    public Date add(int inDays)
    {
        int totalDays = getDays();//Initialize variables
        int newDays;
        int remainder;
        
        newDays = totalDays + inDays;
        year = newDays / 365;
        remainder = newDays % 365;
        if(Date.isLeapYear())//If year is leap year it calculates date with the extra day 
        {
            if(remainder > 0 && remainder <= 31)
            {
                month = 1;
                day = remainder;
            }
            else if(remainder > 31 && remainder <= 60)
            {
                month = 2;
                day = remainder - 31;
            }
            else if(remainder > 60 && remainder <= 91)
            {
                month = 3;
                day = remainder - 60;
            }
            else if(remainder > 91 && remainder <= 121)
            {
                month = 4;
                day = remainder - 91;
            }
            else if(remainder > 121 && remainder < 152)
            {
                month = 5;
                day = remainder - 121;
            }
            else if(remainder > 152 && remainder < 182)
            {
                month = 6;
                day = remainder - 152;
            }
            else if(remainder > 182 && remainder < 213)
            {
                month = 7;
                day = remainder - 182;
            }
            if(remainder > 213 && remainder < 244)
            {
                month = 8;
                day = remainder - 213;
            }
            if(remainder > 244 && remainder < 274)
            {
                month = 9;
                day = remainder - 244;
            }
            if(remainder > 274 && remainder < 305)
            {
                month = 10;
                day = remainder - 274;
            }
            if(remainder > 305 && remainder < 334)
            {
                month = 11;
                day = remainder - 305;
            }
            if(remainder > 335 && remainder < 366)
            {
                month = 12;
                day = remainder - 335;
            }
        }
        else//If year is not leap year calculated date normally
        {
            if(remainder > 0 && remainder <= 31)
            {
                month = 1;
                day = remainder;
            }
            else if(remainder > 31 && remainder <= 59)
            {
                month = 2;
                day = remainder - 31;
            }
            else if(remainder > 59 && remainder <= 90)
            {
                month = 3;
                day = remainder - 59;
            }
            else if(remainder > 90 && remainder <= 120)
            {
                month = 4;
                day = remainder - 90;
            }
            else if(remainder > 120 && remainder < 151)
            {
                month = 5;
                day = remainder - 120;
            }
            else if(remainder > 151 && remainder < 181)
            {
                month = 6;
                day = remainder - 151;
            }
            else if(remainder > 181 && remainder < 212)
            {
                month = 7;
                day = remainder - 181;
            }
            if(remainder > 212 && remainder < 243)
            {
                month = 8;
                day = remainder - 212;
            }
            if(remainder > 243 && remainder < 273)
            {
                month = 9;
                day = remainder - 243;
            }
            if(remainder > 273 && remainder < 304)
            {
                month = 10;
                day = remainder - 273;
            }
            if(remainder > 304 && remainder < 334)
            {
                month = 11;
                day = remainder - 304;
            }
            if(remainder > 334 && remainder < 365)
            {
                month = 12;
                day = remainder - 334;
            }
        }
        Date newDate = new Date(month, day, year);
        return newDate;//Return date reference
    }
     
    /**
     * Add method to subtract days and calculate new date
     * 
     * @param inDays how many days user wants to subtract
     * @return newDate reference to updated date
     */
    public Date subtract(int inDays)
    {
        int totalDays = getDays();//Initialize variables
        int newDays;
        int remainder;
        
        newDays = totalDays - inDays;
        year = newDays / 365;
        remainder = newDays % 365;
        if(Date.isLeapYear())//If year is leap year does calculations with extra day
        {
            if(remainder > 0 && remainder <= 31)
            {
                month = 1;
                day = remainder;
            }
            else if(remainder > 31 && remainder <= 60)
            {
                month = 2;
                day = remainder - 31;
            }
            else if(remainder > 60 && remainder <= 91)
            {
                month = 3;
                day = remainder - 60;
            }
            else if(remainder > 91 && remainder <= 121)
            {
                month = 4;
                day = remainder - 91;
            }
            else if(remainder > 121 && remainder < 152)
            {
                month = 5;
                day = remainder - 121;
            }
            else if(remainder > 152 && remainder < 182)
            {
                month = 6;
                day = remainder - 152;
            }
            else if(remainder > 182 && remainder < 213)
            {
                month = 7;
                day = remainder - 182;
            }
            if(remainder > 213 && remainder < 244)
            {
                month = 8;
                day = remainder - 213;
            }
            if(remainder > 244 && remainder < 274)
            {
                month = 9;
                day = remainder - 244;
            }
            if(remainder > 274 && remainder < 305)
            {
                month = 10;
                day = remainder - 274;
            }
            if(remainder > 305 && remainder < 334)
            {
                month = 11;
                day = remainder - 305;
            }
            if(remainder > 335 && remainder < 366)
            {
                month = 12;
                day = remainder - 335;
            }
        }
        else//If year is not leap year, does calculations normally
        {
            if(remainder > 0 && remainder <= 31)
            {
                month = 1;
                day = remainder;
            }
            else if(remainder > 31 && remainder <= 59)
            {
                month = 2;
                day = remainder - 31;
            }
            else if(remainder > 59 && remainder <= 90)
            {
                month = 3;
                day = remainder - 59;
            }
            else if(remainder > 90 && remainder <= 120)
            {
                month = 4;
                day = remainder - 90;
            }
            else if(remainder > 120 && remainder < 151)
            {
                month = 5;
                day = remainder - 120;
            }
            else if(remainder > 151 && remainder < 181)
            {
                month = 6;
                day = remainder - 151;
            }
            else if(remainder > 181 && remainder < 212)
            {
                month = 7;
                day = remainder - 181;
            }
            if(remainder > 212 && remainder < 243)
            {
                month = 8;
                day = remainder - 212;
            }
            if(remainder > 243 && remainder < 273)
            {
                month = 9;
                day = remainder - 243;
            }
            if(remainder > 273 && remainder < 304)
            {
                month = 10;
                day = remainder - 273;
            }
            if(remainder > 304 && remainder < 334)
            {
                month = 11;
                day = remainder - 304;
            }
            if(remainder > 334 && remainder < 365)
            {
                month = 12;
                day = remainder - 334;
            }
        }
        Date newDate = new Date(month, day, year);
        return newDate;//return newDate reference
    }
    
    /**
     * Returns number of days between two dates
     * 
     * @param anotherDate reference to user entered date
     * @return daysBetween how many days are between current and entered dates
     */
    public static int daysBetween(Date otherDate)
    {
        Date d = new Date();
        int daysBetween = 0;
        
        daysBetween = otherDate.getDays('y') - d.getDays();
        return Math.abs(daysBetween);//Returns number of days between
    }
    
    /**
     * Set method to set value of month
     * 
     * @param inMonth input for month
     */
    public void setMonth(int inMonth)
    {
        month = inMonth;
    }
        
    /**
     * Set method to set value of day
     * 
     * @param inDay input for day
     */
    public void setDay(int inDay)
    {
        day = inDay;
    }
        
    /**
     * Set method to set value of year
     * 
     * @param inYear input for year
     */
    public void setYear(int inYear)
    {
        year = inYear;
    }
        
    /**
     * Get method to get the date in different formats
     * 
     * @param format user entered choice
     * @return string that shows month/day/year in different formats
     */
    public String getDate(char format)
    {
        if(format == 'a')//Uses user input of format
        {
            if(month == 1)
            {
                return "January " + day + ", " + year;
            }
            if(month == 2)
            {
                return "February " + day + ", " + year;
            }
            if(month == 3)
            {
                return "March " + day + ", " + year;
            }
            if(month == 4)
            {
                return "April " + day + ", " + year;
            }
            if(month == 5)
            {
                return "May " + day + ", " + year;
            }
            if(month == 6)
            {
                return "June " + day + ", " + year;
            }
            if(month == 7)
            {
                return "July " + day + ", " + year;
            }
            if(month == 8)
            {
                return "August " + day + ", " + year;
            }
            if(month == 9)
            {
                return "September " + day + ", " + year;
            }
            if(month == 10)
            {
                return "October " + day + ", " + year;
            }
            if(month == 11)
            {
                return "November " + day + ", " + year;
            }
            if(month == 12)
            {
                return "December " + day + ", " + year;
            }
        }
        else if(format == 'b')
        {
            return month + "/" + day + "/" + year;
        }
        return "No format entered";
    }
    
    /**
     * Get method to get the total days
     * 
     * @return totalDays calculates how many days since month 0, day 0, and year 0
     */
    public int getDays()
    {
        int totalDays = 0;
        
        switch(month)//Gets total days based of which month it is
        {
            case 1:
            totalDays = (365 * year) + day;
            break;
            case 2:
            totalDays = (365 * year) + 31 + day;
            break;
            case 3:
            totalDays = (365 * year) + 59 + day;
            break;
            case 4:
            totalDays = (365 * year) + 90 + day;
            break;
            case 5:
            totalDays = (365 * year) + 120 + day;
            break;
            case 6:
            totalDays = (365 * year) + 151 + day;
            break;
            case 7:
            totalDays = (365 * year) + 181 + day;
            break;
            case 8:
            totalDays = (365 * year) + 212 + day;
            break;
            case 9:
            totalDays = (365 * year) + 243 + day;
            break;
            case 10:
            totalDays = (365 * year) + 273 + day;
            break;
            case 11:
            totalDays = (365 * year) + 304 + day;
            break;
            case 12:
            totalDays = (365 * year) + 334 + day;
            break;
        }
        return totalDays;//Returns days since day 0, month 0, year 0
    }
    
    /**
     * Get method to get the total days
     * 
     * @param inUser determines if calculating using user input
     * @return totalDays calculates how many days since month 0, day 0, and year 0
     */
    public int getDays(char inUser)
    {
        int totalDays = 0;
        
        switch(userMonth)//Gets total days based of which month it is
        {
            case 1:
            totalDays = (365 * userYear) + userDay;
            break;
            case 2:
            totalDays = (365 * userYear) + 31 + userDay;
            break;
            case 3:
            totalDays = (365 * userYear) + 59 + userDay;
            break;
            case 4:
            totalDays = (365 * userYear) + 90 + userDay;
            break;
            case 5:
            totalDays = (365 * userYear) + 120 + userDay;
            break;
            case 6:
            totalDays = (365 * userYear) + 151 + userDay;
            break;
            case 7:
            totalDays = (365 * userYear) + 181 + userDay;
            break;
            case 8:
            totalDays = (365 * userYear) + 212 + userDay;
            break;
            case 9:
            totalDays = (365 * userYear) + 243 + userDay;
            break;
            case 10:
            totalDays = (365 * userYear) + 273 + userDay;
            break;
            case 11:
            totalDays = (365 * userYear) + 304 + userDay;
            break;
            case 12:
            totalDays = (365 * userYear) + 334 + userDay;
            break;
        }
        return totalDays;//Returns days since day 0, month 0, year 0
    }
    
    /**
     * Method to check if the current year is a leap year
     * 
     * @return boolean if year is a leap year
     */
    public static boolean isLeapYear()
    {
        if((year % 4 == 0) && (year % 100 != 0))//Checks if year is leap year
        {
            return true;
        }
        if(year % 400 == 0) 
        {
            return true;
        }
        return false;
    }
    
    /**
     * Equals method check if the dates are the same using getDays method
     * 
     * @return boolean tells if date references are equal
     */
    public boolean equals(Date otherDate)
    {
        return this.getDays() == otherDate.getDays('y');
    }
    
    /**
     * compareTo method checks which date has more days
     * 
     * @return int number of days between to see which is bigger
     */
    public int compareTo(Date otherDate)
    {
        return this.getDays() - otherDate.getDays();
    }
    
    /**
     * toString method to return the date after calculations as a string
     * 
     * @return string to tell what the date is month/day/year
     */
    public String toString()
    {
        return "Date is: " + month + "/" + day + "/" + year;//Returns date as string
    }
}
