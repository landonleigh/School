
/**
 * This class holds a template for a Author object
 * 
 * @author Lorrie Lehmann
 * @version v1
 */
public class Author
{
	private String lastName;
	private String firstName;
	private String address;
	private int yearOfBirth;
	
	public Author( )
	{
	    lastName = firstName = address = "unknown";
	    yearOfBirth = -999;
	}
	
	public Author(String inLast, String inFirst, String inAddress, int yearOfBirth)
	{
	    lastName = new String(inLast);
	    firstName = inFirst;
	    address = inAddress;
	    this.yearOfBirth = yearOfBirth;
   }
   
   public Author(Author inAuthor)
   {
       lastName = inAuthor.lastName;
       firstName = inAuthor.firstName;
       address = inAuthor.address;
       this.yearOfBirth = inAuthor.yearOfBirth;
    }
    
    
    
    public String toString( )
    {
        return "Name: " + lastName + "\t" + firstName;
    }
    
    
    public boolean equals(Author inAuthor)
    {
        return lastName.equals(inAuthor.lastName) && 
                    firstName.equals(inAuthor.firstName)&&
                    yearOfBirth == inAuthor.yearOfBirth;
   }
   
   public int compareTo(Author inAuthor)
   {
       int result;
       if(lastName.equals(inAuthor.lastName))
         result = firstName.compareTo(inAuthor.firstName);
       else
         result = lastName.compareTo(inAuthor.lastName);
        
       return result; 
    }                 
        
  }
    
    
    
    
       
       
	
	
	