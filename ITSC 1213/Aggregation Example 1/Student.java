
/**
 * This class holds data and methods for a Student
 * This is an example of aggregation, the has-a relationship.
 * 
 * @author Lorrie Lehmann
 * @version v1
 */
public class Student
{
    private String lName;
    private String fName;
    private String id;
    private Advisor advisor; //a Student has-an advisor
    public static int numberOfStudents = 0;
    
    /**
     * This no-arg constructor sets the lName, fName and id fields to "unknown"
     * and sets the refrence to an Advisor to null
     */
    public Student( )
    {
        lName = fName = id  = "unknown";
        advisor = null;
        numberOfStudents++;
    }
    
    /**
     * This constructor allows the user to specify values for a newly
     * constructed Student object.
     * Note that the inAd parameter is a reference to an exisitng Advisor object
     */
    public Student(String inFirst, String inLast, String inID, Advisor inAd)
    {
       
        fName = new String(inFirst);//deep copy
        //fName = inFirst;
       
        lName = new String(inLast);//deep copy
        id = inID;
        
       
        advisor = inAd; //shallow copy
        
        advisor.incrementAdvisees( );
        numberOfStudents++;
        
    }
    
    /**
     * This methods determines if two Student objects should be
     * considered equal based on the values of their id fields.
     * @param Student inStudent- a reference to another Student object
     * @retrun boolean -true if the ids have the same value, false 
     * otherwise
     */
    public boolean equals(Student inStudent )
    {
        //since the id fields are Strings, I simply call the equals( )
        //method of the String class
        //note that id refers to the id field of the invoking object
        // inStudent.id refers to the id field of the parameter
        return id.equals(inStudent.id);
    }
    
    /**
     * This method compares two Student objects using their
     * lName and fName fields
     * If the lName fields are equal, the fNames are compared
     * @param Student inStudent - another Student object
     * @return int negative, positive or zero
     */
    public int compareTo(Student inStudent)
    {
        int result;
        //test to see if the lName fields are equal
        if(lName.equals(inStudent.lName))
        {
            //if lNames are equal, compare the fName fields
            //Since the fields are Strings, I simply call
            //the compareTo( ) method for the String class
            result =  fName.compareTo(inStudent.fName);
        }
        else
        {
            result = lName.compareTo(inStudent.lName);
        }
        return result;
    }
    
    /**
     * This method returns a String reprentation of a Student
     * object. Note that is concatenates all the fileds and then
     * also calls the toString( ) method of the advisor field.
     */
    public String toString( )
    {
        String result;
        result = "Last Name: " + lName
                 + "\nFirst Name: " + fName
                 + "\nID Number: " + id
                 + "\nAdvisor Information: " + advisor;
       return result;
    }
                 
   
    
    
       
}
