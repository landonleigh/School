
/**
 * This is a template for a Book object.
 * This is written as an example of aggregation.
 * 
 * @author Lorrie Lehmann 
 * @version v1
 */
public class Book
{
	private String title;
	private String ISBN;
	private double cost;
	private int yearPublished;
	private Author writer;
	private Publisher pub;

	
	public Book( )
	{
	    title = ISBN  = null;
	    writer = null;
	    pub = null;
	    cost = 0;
	    yearPublished = -999;
   }
   
   public Book(String inTitle, String inISBN, double inCost, 
               int inYear, Author inWriter, Publisher p)
   {
       title = inTitle;
       ISBN = inISBN;
       cost = inCost;
       yearPublished = inYear;
       writer = inWriter;
       pub = p;
      
    }  
    
  public Book(Book inBook)
  {
      title = inBook.title;
      ISBN = inBook.ISBN;
      cost = inBook.cost;
      yearPublished = inBook.yearPublished;
      writer = new Author(inBook.writer);
      //pub = inBook.pub; //shallow copy
      pub = new Publisher(inBook.pub); //deep copy
  }
  
  public String toString( )
  {
      return "Title:\t" + title +
             "\nISBN:\t" + ISBN +
             "\nAuthor:\t" + writer.toString( ) +
             "\nCost:\t" + cost +
             "\nYear published:\t" + yearPublished +
             "\n"  + pub.toString( ) ;
             
     
   }           
}   
         
    