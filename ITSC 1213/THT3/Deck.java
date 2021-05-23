
/**
 * Creates array of cards and gets top card and shuffles deck
 *
 * @author Landon Leigh
 * @version 4/23/2019
 */
public class Deck
{
    // instance variables
    Card cards[] = new Card[52];//array of cards
    String suit[] = {"Spades", "Clubs", "Diamonds", "Hearts"};//array for suits
    int value[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};//array for values of card
    String face[] = {"Jack", "Queen", "King", "Ace"};//array for face values
    
    /**
     * Constructor for objects of class Deck to create array of cards
     */
    public Deck()
    {
        int index = 0;//variable for array index
        
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 13; j++)
            {
               if(j == 10 || j == 11 || j == 12 || j == 13)//if value is jack, queen, king, or ace
               {
                 cards[index] = new Card(value[j],suit[i],face[(j + 1) % 10]);
               }
               else//all number values
               {
                  cards[index] = new Card(value[j],suit[i],face[0]); 
               }
               index++;
            }
        }
    }
    
    /**
     * getTopCard method to retrieve a copy of the top card object
     * 
     * @return topCard object of card on top of the deck
     */
    public Card getTopCard()
    {
        Card topCard = new Card(cards[1]);//copies card to get top card
        return topCard;
    }
    
    /**
     * getTopCard method to retrieve a copy of the top card object
     * 
     */
    public void shuffle()
    {
        for(int i = 0; i < 20; i++)//loop and nested loop to shuffle over 1000 times
        {
            for(int j = 0; j < cards.length; j++) 
            {
                //Generate an index randomly
                int index = (int)(Math.random() * cards.length);
                Card temp = cards[i];
                cards[i] = cards[index];
                cards[index] = temp;
    	    }
        }
    }
}
