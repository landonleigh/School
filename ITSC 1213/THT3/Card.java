
/**
 * Creates each card and gets values for each, has toString to print the card as a String
 * Has copy constructor, and compareTo and equals methods.
 *
 * @author Landon Leigh
 * @version 4/23/2019
 */
public class Card
{
    // instance variables
    public int value;
    public String suit;
    public String face;

    /**
     * Default constructor for objects of class Card
     */
    public Card()
    {
        value = 0;//sets fields to 0 or unknown
        suit = face = "unknown";
    }

    /**
     * Overloaded constructor that takes in values for value, suit, and face
     * 
     * @param inValue int of value of the card
     * @param inSuit String for suit of the card
     * @param inFace String for face of the card
     */
    public Card(int inValue, String inSuit, String inFace)
    {
        value = inValue;//sets fields to parameter values
        suit = inSuit;
        face = inFace;
    }
    
    /**
     * Copy constructor that takes in values for value, suit, and face
     * 
     * @param other object of card to copy
     */
    public Card(Card other)
    {
        value = other.value;//copies fields
        suit = other.suit;
        face = other.face;
    }
    
    /**
     * Get method to retrieve value of card
     * 
     * @return value int for value of card
     */
    public int getValue()
    {
        return value;//returns value of card
    }
    
    /**
     * Get method to retrieve suit of card
     * 
     * @return suit String for suit of card
     */
    public String getSuit()
    {
        return suit;//returns suit of card
    }
    
    /**
     * Get method to retrieve face of card
     * 
     * @return face String for face of card
     */
    public String getFace()
    {
        return face;//returns face of card
    }
    
    /**
     * toString method to print value/face and suit of card
     * 
     * @return String with face or value and suit
     */
    public String toString()
    {
        if(value > 10)//returns card based on if it is a number or face 
        {
            return face + " of " + suit;
        }
        else
        {
            return value + " of " + suit;
        }
    }
    
    /**
     * compareTo method to compare two cards based on value
     * 
     * @param other object of card value
     * 
     * @return int based of which value is higher
     */
    public int compareTo(Card other)
    {
        if(this.value < other.value)
        {
            return -1;//return int based on 
        }
        else if(this.value > other.value)
        {
            return 1;//return int based on 
        }
        else
        {
            return 0;//return int based on 
        }
    }
    
    /**
     * equals method to check if card has same suit and face
     * 
     * @param other object of card value
     * 
     * @return boolean based on if cards are equal
     */
    public boolean equals(Card other)
    {
        return this.suit == other.suit && this.face == other.face;//compares the suits and the faces
    }
}
