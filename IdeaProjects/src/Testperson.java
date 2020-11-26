import java.util.*;
class Person
{
    String name;
    String addr;
    String phone;
    String email;
    Person()
    {
    }
    void setPerson(String name,String addr,String phone,String email)
    {
        this.name=name;
        this.addr=addr;
        this.phone=phone;
        this.email=email;
    }
    public String toString()
    {
        return " name: "+name+" address: "+addr+" telephone: "+phone+" email: "+email;
    }
}
class Student extends Person
{
    String classtate;
    void setClasstate(String classtate)
    {
        this.classtate=classtate;
    }
    String getClasstate()
    {
        return classtate;
    }
}
class Employee extends Person
{
    String office;
    double salary;
    Employee()
    {

    }
    void Employee(String office,double salary)
    {
        this.office=office;
        this.salary=salary;
    }
    Employee(String office,double salary)
    {
        this.office=office;
        this.salary=salary;
    }
    String getOffice()
    {
        return " office: "+office+" salary: "+salary;
    }
}
class Staff extends Employee
{
    String chenghao;
    public String toString()
    {
        return " office: "+super.office+" salary: "+super.salary+" 称号: "+chenghao;
    }
}
public class Testperson
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("student or employee? 0 or 1: ");
        if(input.nextInt()==0)
        {
            System.out.print("enter the classstate:");
            Student a=new Student();
            String classstate=input.nextLine();

            a.setClasstate(classstate);
            input.nextLine();
            System.out.print("enter the name address tel email:");
            String name=input.nextLine();
            String address=input.nextLine();
            String tel=input.nextLine();
            String email=input.nextLine();
            Person b=new Person();
            b.setPerson(name, address, tel, email);
            System.out.println("classstate: "+a.getClasstate()+b.toString());
        }
        else {
            System.out.print("enter salary: ");
            double salary=input.nextDouble();
            input.nextLine();
            System.out.print("enter office ");

            String office=input.nextLine();


            Staff c =new Staff();
            c.Employee(office, salary);
            System.out.print("enter the chenghao:");
            c.chenghao=input.nextLine();

            Person d=new Person();
            System.out.print("enter the name address tel email:");
            String name=input.nextLine();
            String address=input.nextLine();
            String tel=input.nextLine();
            String email=input.nextLine();
            d.setPerson(name, address, tel, email);
            System.out.println(d.toString());
            System.out.println(c.toString());

        }

    }
}
