
/**
 * Driver to print deck of cards before and after shuffle and top two cards
 *
 * @author Landon Leigh
 * @version 4/23/2019
 */
public class CardDriver
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();//creates instance of Deck
        
        System.out.println("Deck before shuffling:");
        for(int i = 0; i < 52; i++)
        {
            System.out.println(deck.cards[i].toString());//prints each index of array
        }
        
        deck.shuffle();//calls shuffle method to shuffle deck
        
        System.out.println("\nDeck after shuffling:");
        for(int i = 0; i < 52; i++)
        {
            System.out.println(deck.cards[i].toString());//prints each index of array
        }
        
        System.out.println("\nTop two cards:");//prints top two cards in array
        System.out.println(deck.cards[0].toString());
        System.out.println(deck.cards[1].toString());
    }
}
