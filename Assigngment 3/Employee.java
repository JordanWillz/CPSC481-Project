import java.text.*;
import java.io.*;
public class Employee
{
    protected String name;
    protected String empNo;
    protected String department;
    protected char type;

    public Employee()
    {
        name = "";
        empNo ="";
        department = "";

    }

    public Employee(String Name, String empNum, String dep, char typ)
    {
        name = Name;
        empNo = empNum;
        department = dep;
        type = typ;
    }

    public String getName()
    {   
        return name;
    }

    public String getEmpNo()
    {   
        return empNo;
    }

    public String getDepartment()
    {   
        return department;
    }

    public char getType()
    {
        return type;
    }

    public void setName(String Name)
    {
        name = Name;
    }

    public void setEmpNo(String num)
    {
        empNo = num;
    }

    public void setDepart(String dep)
    {
        department = dep;
    }

    public void setType(char Type)
    {
        type = Type;
    }
    
    public boolean equals (Employee e)
    {
        boolean equals = false;
        if( e.getEmpNo() == empNo)
        {
            equals = true;
        }
        return equals;
    }

    public void delEmp(String empNo)
    {
  
    } 

    public String printSalRep()
    {
        return name + "\t" + empNo+ "\t" + department+ "\t"; 
    }

    public void printTopSeller()
    {

    }

    public void endWeek()
    {

    }

    public String toString()
    {
        return "Employee name: " + name +"\n"+ "Employee number: " + empNo + "\n" + "Employee department: " + department;
    }

    public String writeData()
    {
        return name +" "+ empNo+" "+ department;
    }
}
