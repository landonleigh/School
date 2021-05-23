
/**
 * Write a description of class WarDriver here.
 *
 * @author Landon Leigh
 * @version 5/1/2019
 */
public class WarDriver
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();//creates instance of Deck
        deck.shuffle();//calls shuffle method to shuffle deck
        int p1Count = 0;//declare and initialize values for card count
        int p2Count = 0;
        int j = 26;//index for player 2's stack
        
        for(int i = 0; i < 25; i++)//loop through p1 cards
        {
            
            int compare = deck.cards[i].compareTo(deck.cards[j]);//variable to hold compareTo value
            if(compare == 1)//case of higher player 1 value
            {
                System.out.println("Player 1 value: " + deck.cards[i].toString());
                System.out.println("Player 2 value: " + deck.cards[j].toString());
                System.out.println("Player 1 wins this round.");
                p1Count += 2;
            }
            else if(compare == -1)//case of higher player 2 value
            {
                System.out.println("Player 1 value: " + deck.cards[i].toString());
                System.out.println("Player 2 value: " + deck.cards[j].toString());
                System.out.println("Player 2 wins this round.");
                p2Count += 2;
            }
            else//case of equal values WAR
            {
                System.out.println("\nPlayer 1 value: " + deck.cards[i].toString());
                System.out.println("Player 2 value: " + deck.cards[j].toString());
                System.out.println("Values are equal. WAR!");
                i += 4;//deal 4 cards
                j += 4;
                System.out.println("Player 1's 4th card value: " + deck.cards[i].toString());
                System.out.println("Player 2's 4th card value: " + deck.cards[j].toString());
                compare = deck.cards[i].compareTo(deck.cards[j]);//update compare value
                if(compare == 1)//higher p1 value
                {
                   System.out.println("Player 1 wins the war and round.");
                   p1Count += 10;
                }
                else if(compare == -1)//higher p2 value
                {
                   System.out.println("Player 2 wins the war and round."); 
                   p2Count += 10;
                }
                else//equal values double war
                {
                    System.out.println("Values are equal again. WAR!");
                    i += 4;//deal 4 cards
                    j += 4;
                    System.out.println("Player 1's 4th card value: " + deck.cards[i].toString());
                    System.out.println("Player 2's 4th card value: " + deck.cards[j].toString());
                    if(compare == 1)//higher p1 value
                    {
                       System.out.println("Player 1 wins the war and round.");
                       p1Count += 10;
                    }
                    else if(compare == -1)//higher p2 value
                    {
                       System.out.println("Player 2 wins the war and round."); 
                       p2Count += 10;
                    }
                }
            }
            
            j++;//go to next card for p2
            
            System.out.println();//create blank line to look neater
        }
       
        if(p1Count > p2Count)//statements to determine winner and print it
        {
            System.out.println("Player 1 wins the game! \nScore:\nP1: " + p1Count + "\nP2: " + p2Count);
        }
        else if(p1Count < p2Count)
        {
            System.out.println("Player 2 wins the game! \nScore:\nP1: " + p1Count + "\nP2: " + p2Count);
        }
    }
}
