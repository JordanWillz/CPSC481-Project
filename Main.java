
/**
 *This program calculates the compound interest for certain interest rates and various time periods.
 * 
 * @author Jordan Williams 
 *Date created: Oct.20/2016
 * Last Modified: Oct.19/2016 - Wrote program
 *                Oct.20/2016 - Updated the format of the program
 */
public class Main
{
    public static void main (String[] args)
    {

        double amount,interestRate, secondInterestRate, finalAmount1, finalAmount2, difference;
        int years;
        UserInteraction User= new UserInteraction();
        Calculations Calc = new Calculations();
        FinalPrintout Output = new FinalPrintout();
        System.out.println("Compound Interest Calculator");
        System.out.println("This program calculates the amount of money");
        System.out.println("in a bank account for an initial deposit");
        System.out.println("invested for n years at an interest rate r.");
        System.out.println("");
        amount = User.getDoubleValueFromUser("Enter the initial amount in the account ");
        interestRate = User.getDoubleValueFromUser ("Enter the first interest rate as a value \nabove prime(ex 2.5 for 2.5%)            "); 
        secondInterestRate = User.getDoubleValueFromUser ("Enter the second interest rate as a value \nabove prime(ex 3 for 3.0%)              ");
        years= User.getIntValueFromUser ("Enter the number of years to invest for ");
        System.out.println("");
        System.out.println("The prime rate is                        : 1");
        System.out.println("");
        finalAmount1 = Calc.Calculations(amount,interestRate, years);
        finalAmount2 = Calc.Calculations(amount,secondInterestRate, years);
        System.out.println("The final amount of money using rate1 is : " +finalAmount1);
        System.out.println("");
        System.out.println("The final amount of money using rate2 is : " +finalAmount2);
        System.out.println("");
        System.out.println("The difference between using rate1 at    : " +interestRate+"percent");
        System.out.println("                   and using rate2 at    : " +secondInterestRate+"percent");
        difference = Calc.Difference(finalAmount1, finalAmount2); 
        Output.FinalPrintout(difference);

    }
}
