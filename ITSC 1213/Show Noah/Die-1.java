import java.util.*;
/**
 * Information and methods for a game die (dice).
 * 
 * @author Landon Leigh
 * @version v1
 */

public class Die
{
	
    private int numberOfSides;
    private int face;
	
    private Random numberGenerator;//declare a reference 
                                    //variable for a Random 
                                    //object	
	public Die( )
	{
	    numberOfSides = 6;
	    numberGenerator = new Random( );
	    roll( );
	} 
	
	public Die( int inNumberOfSides)
	{
	    numberOfSides = inNumberOfSides;
	    numberGenerator = new Random( );
	    roll( );
	}  
	
	public void roll( )
	{
	    face = numberGenerator.nextInt(numberOfSides) + 1;
    }
   
   public String toString( )
   {
       String result;
       switch(face)
       {
           case 1:  result =    " _______\n" +
                       			"|       |\n"+
                       			"|   *   |\n"+
                       			"|       |\n"+
                       			"'-------'";
                    break;
           case 2:  result =  	" _______\n" +
        		   			  	"| *     |\n"+
        		   			  	"|       |\n"+
        		   			  	"|     * |\n"+
        		   			  	"'-------'";
                    break;
           case 3:  result = 	" _______\n" +
                   			 	"| *     |\n"+
                   			 	"|   *   |\n"+
                   			 	"|     * |\n"+
                   			 	"'-------'";
                    break;
           case 4:  result = 	" _______\n" +
                   				"| *   * |\n"+
                   				"|       |\n"+
                   				"| *   * |\n"+
                   				"'-------'";
                    break;
           case 5:  result = 	" _______\n" +
                   				"| *   * |\n"+
                   				"|   *   |\n"+
                   				"| *   * |\n"+
                   				"'-------'";
                    break;
           case 6:  result = 	" _______\n" +
                   				"| *   * |\n"+
                   				"| *   * |\n"+
                   				"| *   * |\n"+
                   				"'-------'";
                    break;
           default: result = "face is " + face;
        }
        return result;
    }
    
    public int getFace( )
    {
        return face;
    }    
   
    
    public boolean equals(Die inDie)
    {
       return (face == inDie.face) && (numberOfSides == inDie.numberOfSides);
    }
    
    public int compareTo(Die inDie)
    {
        int answer;
        
        if(face > inDie.face)
        {
           answer = 1;
        }
        else
        {
            if(face < inDie.face)
            {
                answer = -1;
            }
            else
            {
                answer = 0;
            }
        }   
        return answer;
    }
    
     
 }
	    
	    
	    
	    
	    
	    
	    
	    
	    