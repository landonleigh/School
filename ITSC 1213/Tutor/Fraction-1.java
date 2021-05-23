
/**
 * Write a description of class Fraction here.
 *
 * @author Landon Leigh
 * @version 3/19/2019
 */
public class Fraction
{
    private int num;
    private int den;
    
    public Fraction()
    {
        num = 1;
        den = 1;
    }
    
    public Fraction(int inNum, int inDen)
    {
        num = inNum;
        den = (inDen > 0) ? den = inDen:0;
        simplify();
    }
    
    public void simplify()
    {
        boolean simplified = false;
        int factor = 1;
        
        if(num < den)
        {
            factor = num;
        }
        if(num > den)
        {
            factor = den;
        }
        
        while(num % factor != 0 || den % factor != 0)
        {
            factor--;
        }
        
        num = num / factor;
        den = den / factor;
    }
    
    public Fraction add(Fraction other)
    {
        return new Fraction(this.num*other.den + other.num*this.den, this.den*other.den);
    }
    
    public Fraction subtract(Fraction other)
    {
        return new Fraction(this.num*other.den - other.num*this.den, this.den*other.den);
    }
    
    public Fraction multiply(Fraction other)
    {
        return new Fraction(this.num * other.num , this.den * other.den);
    }
    
    public Fraction divide(Fraction other)
    {
        return new Fraction(this.num * other.den , this.den * other.num);
    }
    
    /*public int compareTo(Fraction other)
    {
        return Fraction.compareTo(other.Fraction);
    }*/
    
    public boolean equals(Fraction other)
    {
        return this.num == other.num && this.den == other.den;
    }
    
    public double decimalValue()
    {
        return (double)num / den;
    }
    
    public static Fraction random()
    {
        int num = (int)((Math.random()*9) + 1);
        int den = (int)((Math.random()*9) + 1);
        
        if(num > den)
        {
            return new Fraction(den, num);
        }
        else if(num < den)
        {
            return new Fraction(num, den);
        }
        else
        {
            return new Fraction(1, 1);
        }
    }
    
    public String toString()
    {
        return num + "/" + den;
    }
}
