
/**
 * Calculations for the interest 
 * 
 *@author Jordan Williams 
 *Date created: Oct.20/2016
 * Last Modified: Oct.20/2016 - Wrote program
 */
public class Calculations
{
    public double Calculations(double amount, double rate, int years)
    {
        double PrimeRate = 1.0 + (1.0 + rate)/100.0;
        double FinalAmount = amount* Math.pow(PrimeRate, years);
        return FinalAmount;
    }  
    
    public double Difference(double finalAmount1, double finalAmount2)
    {
        double Difference = finalAmount2 - finalAmount1;
        return Difference;
    }
}
