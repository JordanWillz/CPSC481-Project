import java.util.Scanner;
import java.io.*;

public class Client
{
    public static void main(String args[]) throws IOException
    {

        //clear the screen
        System.out.print('\u000C');

        // define necessary variables here
        char choice='a';
        boolean done = false;
        Payroll PR = new Payroll();

        PR.loadData();

        // place here the code for the processing requirements
        while(!done){
            choice = showMenu();

            switch(choice){
                case 'a':
                case 'A':
                System.out.println("You pressed a");
                addEmp(PR);
                break;
                case 'i':
                case 'I':
                System.out.println("I - Print information of an individual employee");
                printEmpInfo(PR);
                break;
                case 'd':
                case 'D':
                System.out.println("D - Remove an employee from payroll");
                break;

                case 's':
                case 'S':
                System.out.println("S - calculate and print the weekly pay of an employee");
                break;
                case 'p':
                case 'P':
                System.out.println("P - prints salary report");
                PR.printSalRep();
                break;
                case 'w':
                case 'W':
                System.out.println("W - End of week processing");
                PR.endWeek(userInStr("Enter save file name: "));
                break;
                case 'q':
                case 'Q':
                System.out.println("You pressed q");
                done = true;
                break;
                default:
                System.out.println("Error, invalid command.");  

            }

        }
        System.out.println("Thank you for using the Payroll Processing System");
    }

    //   The Payroll processing menu
    public static char showMenu()
    {

        char menuInput = 'a';
        Scanner input = new Scanner(System.in);

        System.out.println("\nMENU:");
        System.out.println("A - Add a new employee");
        System.out.println("I - Print information of an individual employee");
        System.out.println("D - Remove an employee from payroll");
        System.out.println("S - calculate and print the weekly pay of an employee");
        System.out.println("P - prints salary report");
        System.out.println("W - End of week processing");
        System.out.println();
        System.out.println("Q - Quit the system");

        System.out.print("Enter your choice-->");
        menuInput = input.next().charAt(0);

        return menuInput;

    }

    public static String userInStr(String message)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        return input.next();

    }

    public static double userInDou(String message)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        return input.nextDouble();
    }

    public static void addEmp(Payroll PR)
    {
        boolean newId = false;
        String empNo;
        String name;
        String dep;
        String typeStr;
        char type;
        double yearlySalary;
        double hourlyRate;
        double commRate;
        double commBase;

        empNo = userInStr("Enter new employee number: ");
        newId = PR.validEmpNo(empNo);
        if (newId == false)
        {
            name = userInStr("Enter employee name: ");
            dep = userInStr("Enter employee department: ");
            typeStr = userInStr("Enter employee type ('S', 'H', 'C'): ");
            type = typeStr.charAt(0);
            if(type == 'S')
            {
                yearlySalary = userInDou("Enter yearly salary: ");
                PR.addEmpS(empNo, name, dep, type, yearlySalary);
            }
            else if(type == 'H')
            {
                hourlyRate = userInDou("Enter hourly rate: ");
                PR.addEmpH(empNo, name, dep, type, hourlyRate);
            }
            else if(type == 'C')
            {   
                commRate = userInDou("Enter commission rate: ");
                commBase = userInDou("Enter weekly salary base: ");
                PR.addEmpC(empNo, name, dep, type, commRate, commBase);
            }
        }
    }

    public static void printEmpInfo(Payroll PR)
    {
        String empNo;
        boolean Id = false;

        empNo = userInStr("Enter employee number: ");
        Id = PR.validEmpNo(empNo);

        if (Id == true)
        {   
            PR.printEmpInfo(empNo);
        }
        else
        {
            System.out.println("Employee number not valid");
        }
    }

}
