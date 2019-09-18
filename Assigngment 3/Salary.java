import java.io.*;
public class Salary extends Employee
{
    private double yearlySalary;

    public Salary()
    {
        yearlySalary = 0.0;
    }

    public Salary(double YearlySalary)
    {
        yearlySalary = YearlySalary;
    }

    public double getYearlySalary()
    {
        return yearlySalary;
    }

    public void setYearlySalary(double YearlySalary)
    {
        yearlySalary = YearlySalary;
    }

    public double calcWeeklySalary()
    {
        double ManagmentPay = 0;
        ManagmentPay = ManagmentPay - (ManagmentPay * (1/52));
        return ManagmentPay;
    }

    public String toString()
    {
        return super.toString() +"\n"+ "Yearly salary: " +yearlySalary;
    }

    public String writeData()
    {
        return name+" "+empNo+" "+ department+ " "+ type+ " "+ yearlySalary;
    }
    
}
