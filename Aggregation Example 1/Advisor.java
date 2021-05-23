
/**
 *This class holds info for a college advisor
 * 
 * @author Lorrie Lehmann 
 * @version v1
 */
public class Advisor
{
    //these are the instance variables (the fields)
    private String lName;
    private String fName;
    private String department;
    private int numberOfAdvisees;
    private String phone;
    
    /** 
     * The no-arg constructor sets the name, department and phone
     * to "unknown" and the number of advisees to 0
     */
    public Advisor( )
    {
        fName = lName= department = phone = "unknown";
        numberOfAdvisees = 0;
    }
    
    /**
     * This constructor allows the user to specify values for all the fields
     */
    public Advisor(String inLast, String inFirst, String inDept, String inPhone, int inNumber)
    {
        lName = inLast;
        fName = inFirst;
        department = inDept;
        phone = inPhone;
        numberOfAdvisees = inNumber;
    }
    
    /**
     * This version of the constructor allows the user to specify
     * values for all the fields except for the number of advisee
     * field. This constructor sets that field to 0
     */
    public Advisor(String inLast, String inFirst, String inDept, String inPhone)
    {
        lName = inLast;
        fName = inFirst;
        department = inDept;
        phone = inPhone;
        numberOfAdvisees = 0;
    }
    
    
    
    /**This is the copy constructor. It creates a new instance
     * of the Advisor class using an exitisting instance that
     * is sent in as a parameter. Remember, the pusrpose of the 
     * constructor is to initialize the fields of the new instance. 
     * I used this here to empahsize that.
     */
    
    public Advisor(Advisor inAd)
    {
        this.lName = inAd.lName;
        this.fName = inAd.fName;
        this.department = inAd.department;
        this.phone = inAd.phone;
        this.numberOfAdvisees = 0;
    }
    
    
    
    /**
     * This methods determines if two Advisor objects should
     * be considered equal using the first, last and phone number fields
     * @param inAd this is the advisor object to test agsinst
     * @return boolean - true if the two objects are equal, false otherwise
     */
    
    public boolean equals(Advisor inAd)
    {
        //since the firled being tested are Strings, I am calling the equals( ) method for the String class
        return this.lName.equals(inAd.lName) && fName.equals(inAd.fName) && phone.equals(inAd.phone);
    }
    
    /**
     * This method will compare two Advisor objects by their lName field.
     * If the lName fields are the same, it will then compare the
     * two Advisor objects using the fName field
     * @param inAd another Advisor object to be compared against
     * @return int this int is negative if the invoking
     * object is to be consided less than the parameter,
     * zero, if the two objects are to be considered equal,
     * and a positive int if the invoking object is to be considered
     * greater than the parameter
     * 
     */
    public int compareTo(Advisor inAd )
    {
        int result;
        
        //check to see if the lNames are equal
        if (this.lName.equals(inAd.lName))
        {
          //if lNames are equal, compare the fNames
          //Since fName is a String, I am calling the
          //compareTo( ) method of the String class
          result = this.fName.compareTo(inAd.fName);
        }
        else
        {
          result = this.lName.compareTo(inAd.lName);
        }
        return result;
    }
    
    /**
     * This method returns a String representation of an Advisor
     */
    
    public String toString( )
    {
        return lName + "\t" + fName + "\t" + department + "\t" + phone + "\t" + numberOfAdvisees;
    }
    
    public void incrementAdvisees( )
    {
        numberOfAdvisees++;
    }
       
       
}
