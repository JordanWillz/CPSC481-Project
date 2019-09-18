import java.io.*;

public class Commission extends Employee
{
    private int weeksEmployed;
    private double weekSalBas;
    private int weekSales;
    private int totalSales;
    private double commRate;

    public Commission()
    {
        weeksEmployed = 0;
        weekSalBas = 0.0;
        totalSales = 0;
        commRate = 0.0;
        weekSales = 0;
    }

    public Commission(int weeksEmploy, double WeeklySalaryBase, int TotalSales, double comRate)
    {
        weeksEmployed = weeksEmploy;
        //System.out.println("weeksEmployed"+weeksEmployed);
        weekSalBas = WeeklySalaryBase;
        //System.out.println("weekSalBas"+weekSalBas);
        totalSales = TotalSales;
        //System.out.println("totalSales"+totalSales);
        commRate = comRate;
        //System.out.println("commRate"+commRate);
    }

    public int getWeeksEmployed()
    {
        return weeksEmployed;
    }

    public double getWeekSalBas()
    {
        return weekSalBas;
    }

    public int getWeekSales()
    {
        return weekSales;
    }

    public int getTotalSales()
    {
        return totalSales;
    }

    public double getCommRate()
    {
        return commRate;
    }

    public void setWeeksEmployed(int weeks)
    {
        weeksEmployed = weeks;
    }

    public void setWeekSalBas(double salary)
    {   
        weekSalBas = salary;
    }

    public void setWeekSales(int sales)
    {
        weekSales = sales;
    }

    public void setTotalSales(int total)
    {
        totalSales = total;
    }

    public void setCommRate(double comm)
    {
        commRate = comm;
    }

    public double calcWeeklySalary()
    {
        double salary = 0;
        salary = weekSalBas + (weekSales * commRate);
        return salary;
    }

    public boolean topSeller()
    {
        if( (weekSales * commRate) > 1500)
        {
            return true; 
        }
        return false;
    }

    public String toString()
    {
        String topSeller ; 
        if(topSeller())
        {
            topSeller = "Yes";
        }
        else
        {
            topSeller = "No";
        }

        return super.toString() +"\n"+ "Weeks employed: " + weeksEmployed + "\n" + "Weekly salary base: " + weekSalBas + "\n" + "Week sales: " + weekSales +"\n"+ "Total sales :" + totalSales +
        "\n" + "Commission rate: " + commRate + "\n" + "Top sellers club: " + topSeller;
    }

    public void endWeek()
    {
        weeksEmployed ++;
        weekSales = 0;
    }

    public String writeData()
    {
        return name+" "+empNo+" "+ department+ " "+ type+ " " + weeksEmployed +" "+weekSalBas +" " +weekSales+" "+totalSales+" "+commRate;
    }
}
