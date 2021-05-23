
/**
 * Write a description of class Publisher here.
 * 
 * @author L. Lehmann 
 * @version v1
 */
public class Publisher
{
   String name;
   String address;
   String phone;
   int yearEst;
   
   public Publisher(String inName, String inAddress, String inPhone, int inYear)
   {
         name = inName;
         address = inAddress;
         phone = inPhone;
         yearEst = inYear;
    }
    
    public Publisher(Publisher inP)
    {
        this.name = inP.name;
        this.address = inP.address;
        this.phone = inP.phone;
        this.yearEst =  inP.yearEst;
    }

    public String toString( )
    {
        return "Publisher Info:\t" + name + "\t" + phone;
    } 
    
    

}
