
/**
 * This program converts the weights from pounds to ounces and allows calculaton
 * of price per each pound/ounce.
 *
 * @author Landon Leigh
 * @version 2/17/2019
 */
public class UnitPriceConverter
{
    // instance variables
    private double priceOfItem;
    private double weightInPounds;
    private double pricePerPound;
    private double pricePerOunce;
    private final double ouncesPerPound = 16;

    /**
     * Constructor for objects of class UnitPriceConverter
     */
    public UnitPriceConverter()
    {
        // initialise instance variables
        priceOfItem = weightInPounds = pricePerPound = pricePerOunce = 0;
    }

    //overloaded constructor that get input of variables
    public UnitPriceConverter(double inPrice, double inPounds)
    {
        priceOfItem = inPrice;
        weightInPounds = inPounds;
        pricePerPound = priceOfItem / weightInPounds;
        pricePerOunce = priceOfItem / (weightInPounds * ouncesPerPound);
    }
    
    //method that gets input from driver and sets variables
    public void setAmount(double inPrice, double inPounds)
    {
        priceOfItem = inPrice;
        weightInPounds = inPounds;
        pricePerPound = priceOfItem / weightInPounds;
        pricePerOunce = priceOfItem / (weightInPounds * ouncesPerPound);
    }
    
    //gets value price 
    public double getPrice()
    {
        return priceOfItem;
    }
    
    //gets value for amount or pounds
    public double getPounds()
    {
        return weightInPounds;
    }
    
    //gets value for price per pound
    public double getPricePerPound()
    {
        return pricePerPound;
    }
    
    //gets value for price per ounce
    public double getPricePerOunce()
    {
        return pricePerOunce;
    }
}
