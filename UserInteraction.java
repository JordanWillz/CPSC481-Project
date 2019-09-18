/**
 * Methods used for basic user interaction
 * DO NOT PUT OTHER METHODS IN THIS CLASS
 * @author Jordan Kidney
 * Date created:  Oct 11, 2016
 * Last Modified: Oct 11, 2016 – created
  DO NOT PUT OTHER METHODS IN THIS CLASS or make any changes to it
 */
import java.util.*;
//DO NOT PUT OTHER METHODS IN THIS CLASS or make any changes to it
public class UserInteraction
{
    public String getStringValueFromUser(String message)
    {
        String value = "";
        Scanner input = new Scanner(System.in);
        System.out.print(message + " : ");
        value = input.nextLine();
        return value;
    }
//DO NOT PUT OTHER METHODS IN THIS CLASS or make any changes to it
    public double getDoubleValueFromUser(String message)
    {
        double value = 0;
        Scanner input = new Scanner(System.in);
        System.out.print(message + " : ");
        value = input.nextDouble();
        return value;
    }
//DO NOT PUT OTHER METHODS IN THIS CLASS or make any changes to it
    public int getIntValueFromUser(String message)
    {
        int value = 0;
        Scanner input = new Scanner(System.in);
        System.out.print(message + " : ");
        value = input.nextInt();
        return value;
    }
    
  //DO NOT PUT OTHER METHODS IN THIS CLASS or make any changes to it
}
