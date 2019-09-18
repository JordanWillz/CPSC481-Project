import java.util.*;
import java.io.*;
public class Payroll
{
    private ArrayList<Employee> Staff;
    public Payroll()
    {
        Staff = new ArrayList<Employee>();
    }

    public void loadData() throws IOException{

        System.out.println("Loading Data...");

        String nextEmployee;
        Employee tempEmployee;
        Hourly tempHourly;
        Salary tempSalary;
        Commission tempCommission;

        //tempEmployee vars
        String eName;
        String eEmpNo;
        String eDepartment;
        char eType;
        //temp hourly vars
        double hourlyRate;
        double weeklyHours;

        //temp salary vars
        double yearlySalary;

        //temp commsion vars
        int weeksEmployed;
        double weekSalBas;
        int weekSales;
        int totalSales;
        //double totalSales;
        double commRate;

        Scanner fileScan,lineScan;
        fileScan= new Scanner(new File("in.txt"));

        while(fileScan.hasNext()){
            //tempEmployee = new Employee();
            tempHourly = new Hourly();
            tempSalary = new Salary();
            tempCommission = new Commission();

            nextEmployee = fileScan.nextLine();

            lineScan = new Scanner(nextEmployee);
            lineScan.useDelimiter(" ");
            eName = lineScan.next();
            eEmpNo = lineScan.next();
            eDepartment = lineScan.next();
            eType = lineScan.next().charAt(0);

            //the switch finishes the field loading by creating the right type of  employee.
            // and adding the new employee to the Staff array List.
            switch(eType) {
                case 'H':
                System.out.println("hourly employee");
                hourlyRate = lineScan.nextDouble();
                weeklyHours = lineScan.nextDouble();

                tempHourly = new Hourly(hourlyRate,weeklyHours);
                tempHourly.setName(eName);
                tempHourly.setEmpNo(eEmpNo);
                tempHourly.setDepart(eDepartment);
                tempHourly.setType(eType);
                Staff.add(tempHourly);
                System.out.println(Staff.get(0));
                System.out.println("");

                break;

                case 'S':
                System.out.println("salary employee");
                yearlySalary = lineScan.nextDouble();
                tempSalary = new Salary(yearlySalary);
                tempSalary.setName(eName);
                tempSalary.setEmpNo(eEmpNo);
                tempSalary.setDepart(eDepartment);
                tempSalary.setType(eType);
                Staff.add(tempSalary);
                System.out.println(Staff.get(1));
                System.out.println("");
                break;
                case 'C':
                System.out.println("Commission employee");

                //System.out.println("&&&&&&&&&&&&&&&&&&&"+nextEmployee+"&&&&&&&&&&&&&&&&&&&");
                weeksEmployed = lineScan.nextInt();
                //System.out.println("weeksEmployed:"+weeksEmployed);
                weekSalBas = lineScan.nextDouble();
                //System.out.println("weekSalBas:"+weekSalBas);

                //next line gets rid of sales this week
                totalSales = (int)lineScan.nextDouble();
                totalSales = (int)lineScan.nextDouble();
                //System.out.println("totalSales:"+totalSales);
                //System.out.println("test:"+test);
                //totalSales = (int)test;
                commRate = (int)lineScan.nextDouble();
                //System.out.println("commRate:"+commRate);
                //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

                tempCommission = new Commission(weeksEmployed, weekSalBas,totalSales, commRate);

                tempCommission.setName(eName);
                tempCommission.setEmpNo(eEmpNo);
                tempCommission.setDepart(eDepartment);
                tempCommission.setType(eType);

                Staff.add(tempCommission);

                System.out.println(Staff.get(2));

                System.out.println("commission employee");
                System.out.println("");
                break;

                default:
                System.out.println("**** Error wrong type found");
            }
        }
    }

    public boolean validEmpNo(String id)
    {
        int index = 0;
        while (index < Staff.size())
        {
            if (id.equals(Staff.get(index).getEmpNo()))
            {
                return true;
            }
            index ++;
        }
        return false;
    }

    public int validEmpNoIndex(String id)
    {
        int index = 0;
        while (index < Staff.size())
        {
            if (id.equals(Staff.get(index).getEmpNo()))
            {
                return index;
            }
            index ++;
        }
        return -1;
    }

    public void addEmpH(String empNo, String name, String dep, char type, double hourly)
    {
        int index = Staff.size();
        Hourly tempHourly = new Hourly(hourly,0);
        tempHourly.setName(name);
        tempHourly.setEmpNo(empNo);
        tempHourly.setDepart(dep);
        tempHourly.setType(type);
        Staff.add(tempHourly);
        System.out.println("New employee added" );
        System.out.println(Staff.get(index).toString());
    }

    public void addEmpC(String empNo, String name, String dep, char type, double commRate, double commBase)
    {
        int index = Staff.size();
        Commission tempCommission = new Commission(0, commBase,0, commRate);
        tempCommission.setName(name);
        tempCommission.setEmpNo(empNo);
        tempCommission.setDepart(dep);
        tempCommission.setType(type);
        Staff.add(tempCommission);
        System.out.println("New employee added" );
        System.out.println (Staff.get(index).toString());
    }

    public void addEmpS(String empNo, String name, String dep, char type,double salary)
    {
        int index = Staff.size();
        Salary tempSalary = new Salary(salary);
        tempSalary.setName(name);
        tempSalary.setEmpNo(empNo);
        tempSalary.setDepart(dep);
        tempSalary.setType(type);
        Staff.add(tempSalary);
        System.out.println("New employee added" );
        System.out.println(Staff.get(index).toString());
    }

    public void delEmp(String empNo)
    {

    }

    public void printSalRep()
    {
        int index = 0;
        while (index < Staff.size())
        {
            System.out.println(Staff.get(index).printSalRep());
            index++;
        }
    }

    public void printTopSeller()
    {

    }

    public void printEmpInfo(String empNo)
    {
        int index = 0;
        index = validEmpNoIndex(empNo);
        if(index != -1)
        {
            System.out.println(Staff.get(index));
        }
    }

    public void endWeek(String fileName)throws IOException
    {
        int index = 0;
        String out;
        PrintWriter output= new PrintWriter(new File(fileName));
        while(index < Staff.size())
        {
            Staff.get(index).endWeek();
            output.println(Staff.get(index).writeData());
            index ++;
        }
        output.close();
    }
}
