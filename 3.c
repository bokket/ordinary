import java.util.*;
public class eleven112 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in); System.out.print("student or employee?0 or 1:");
        if(input.nextInt()==0) {
            System.out.print("enter the classstate:");
            student a=new student();
            String classstate=input.nextLine();
            a.setclasstate(classstate);
            input.nextLine();
            System.out.print("enter the name address tel email:");
            String name=input.nextLine();
            String address=input.nextLine();
            String tel=input.nextLine();
            String email=input.nextLine();
            person b=new person();
            b.setall(name, address, tel, email);
            System.out.println("classstate: "+a.get()+b.toString());
        }
        else {
            System.out.print("enter salary: ");
            double salary=input.nextDouble();
            input.nextLine();
            System.out.print("enter office ");

            String office=input.nextLine();

            staff c =new staff();
            c.em(office, salary);
            System.out.print("enter the chenghao:");
            c.chenghao=input.nextLine();
            person d=new person();
            System.out.print("enter the name address tel email:");
            String name=input.nextLine();
            String address=input.nextLine();
            String tel=input.nextLine();
            String email=input.nextLine();
            d.setall(name, address, tel, email);
            System.out.println(d.toString());
            System.out.println(c.toString());

        }

    }
}

class student extends person{
    private String classstate;
    public void setclasstate(String classtate) {
        this.classstate=classtate;
    }
    public String get() {
        return classstate;
    }
}
class employee extends person{
    String office;
    double salary;
    public void em(String office,double salary) {
        this.office=office;
        this.salary=salary;
    }
    public String get() {
        return "office: "+office+"salary: "+salary;
    }

}
class staff extends employee{
    String chenghao;
    public String toString() {
        return "office:"+super.office+"salary: "+super.salary+"称号："+chenghao;
    }

}
class person{
    String name,address,tel,email;
        public void setall(String name,String address,String tel,String email) {
        this.name=name;
        this.tel=tel;
        this.address=address;
        this.email=email;

    }
    public String toString() {
        return "name: "+name+"address: "+address+"tel: "+tel+"email: "+email;
                }
}
