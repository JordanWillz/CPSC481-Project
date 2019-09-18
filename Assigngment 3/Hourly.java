import java.io.*;
public class Hourly extends Employee
{
    private double hourlyRate;
    private double weeklyHours;
    public Hourly()
    {
        hourlyRate = 0.0;
        weeklyHours = 0.0;
    }

    public Hourly(double hourly, double hrsWorkWeekly)
    {
        hourlyRate = hourly;
        weeklyHours = hrsWorkWeekly;
    }

    public double getHourlyRate()
    {
        return hourlyRate;
    }

    public double getWeeklyHours()
    {
        return weeklyHours;
    }

    public void setHourlyRate(double rate)
    {
        hourlyRate = rate;
    }

    public void setWeeklyHours(double weekHour)
    {
        weeklyHours = weekHour;
    }

    public double calcWeeklyPay()
    {
        double weekPay = 0;
        double overtime;
        if(weeklyHours < 40)
        {
            weekPay = weeklyHours * hourlyRate;   
        }
        else if( weeklyHours >= 40)
        {
            weekPay = 40 * hourlyRate;
            overtime = hourlyRate - 40;
            weekPay =+ overtime * (hourlyRate * 1.5);
        }
        return weekPay;
    }

    public String toString()
    {
        return super.toString()+ "\n"+ "Hourly rate: " + hourlyRate +"\n"+ "Weekly hours: " + weeklyHours; 
    }

    public void endWeek()
    {
        weeklyHours = 0;
    }

    public String writeData()
    {
        return name+" "+empNo+" "+ department+ " "+ type+ " "+ hourlyRate+ " " + weeklyHours;
    }
}