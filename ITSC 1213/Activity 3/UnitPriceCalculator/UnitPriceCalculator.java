
/**
 * The project will be able to print both the price per pound
 * and the price per ounce of an item. 
 *
 * @author Landon Leigh
 * @version 1/30/2019
 */
public class UnitPriceCalculator
{
    private double price;
    private double amountPound;
    private double amountOunce;
    
    public UnitPriceCalculator()
    {
        price = amountPound = amountOunce = 0;
    }
    
    public UnitPriceCalculator(double inPrice, double inPounds, double inOunces)
    {
        if(inPrice < 0 || inPounds < 0 || inOunces < 0)
        {
            price = amountPound = amountOunce = 0;
        }
        else
        {
            price = inPrice;
            amountPound = inPounds;
            amountOunce = inOunces;
        }
    }
    
    public String toString(char inChoice)
    {
        if(inChoice == 'p')
        {
            return "The item is $" + price + " and is " + amountPound + " pounds. The price per pound is $" + (price / amountPound);
        }
        if(inChoice == 'o')
        {
            return "The item is $" + price + " and is " + amountOunce + " ounces. The price per ounce is $" + (price / amountOunce);
        }
        return "Incorrect input of weight";
    }
    
    public void setAmount(double inPrice, double inPounds, double inOunces)
    {
        if(inPrice < 0 || inPounds < 0 || inOunces < 0)
        {
            price = amountPound = amountOunce = 0;
        }
        else
        {
            price = inPrice;
            amountPound = inPounds;
            amountOunce = inOunces;
        }
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public double getPounds()
    {
        return amountPound;
    }
    
    public double getOunces()
    {
        return amountOunce;
    }
}
