
/**
 * This class holds data and methods
 * for a Book.
 * 
 * @authorL. Lehmann
 * @version v1
 */
public class Book
{
    private String title;
    private String authorName;
    private double price;
   
   
    public Book( )
    {
        title = null;
        authorName = null;
        price = 0;
     }
    
    
    
    public Book(String inTitle, String inAuthorName, double inPrice)
    {
        title = inTitle;
        authorName = inAuthorName;
        price = inPrice;
    }
    
    public Book(Book other)
    {
        this.title = other.title;
        this.authorName = other.authorName;
        this.price = other.price;
    }
    
    //write the equals method based on the title and authorName fields
     public boolean equals(Book other)
    {
        return this.title == other.title && this.authorName == other.authorName;
     }
     
     //write the compareTo method basedon the activity instructions
    public int compareTo(Book other)
    {
        if(this.price < other.price)
        {
            return -1;
        }
        if(this.price > other.price)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public String toString( )
    {
        return "Title:  " + title +
               "\nAuthor: " + authorName +
               "\nPrice:  " + price;
    }
}//end of class definition
