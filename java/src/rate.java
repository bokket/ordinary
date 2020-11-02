import java.util.Scanner;

public class rate {

    String employee;
    int work;
    double rate;
    double federal_tax;
    double state_tax;
    void input()
    {
        Scanner input=new Scanner(System.in);

        System.out.print("Enter employee's name:");
        employee=input.next();

        System.out.print("Enter number of hours worked in a week:");
        work=input.nextInt();

        System.out.print("Enter hourly pay rate:");
        rate=input.nextDouble();

        System.out.print("Enter federal tax withholding rate:");
        federal_tax=input.nextDouble();

        System.out.print("Enter state tax withholding rate:");
        state_tax=input.nextDouble();

    }
    void show()
    {
        System.out.println("Employee Name:"+employee);

        System.out.println("Hours Worked:"+work);

        System.out.println("Pay Rate:$"+rate);

        System.out.println("Gross Pay:$"+(rate*work));

        System.out.println("Federal withholding:$"+(federal_tax*rate*work));

        System.out.println("State withholding:$"+state_tax*rate*work);

        System.out.println("Total Deduction:$"+((state_tax*rate*work)+(federal_tax*rate*work)));

        System.out.println("Net Pay:$"+((rate*work)-((state_tax*rate*work)+(federal_tax*rate*work))));

    }
    public static void main(String[] args)
    {

        rate employee=new rate();
        employee.input();
        employee.show();
    }
}