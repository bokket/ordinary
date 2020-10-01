import java.util.*;
import java.math.*;
public class result{

    public static void main(String[] args) {

        double a,b,c;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a,b,c:");
        a = input.nextDouble();

        b = input.nextDouble();

        c = input.nextDouble();

        double result = b * b - 4 * a * c;

        double x1, x2;

        x1=(-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        x2=(-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;




        if (result>0)
        {

            System.out.println(String.format("The roots are %.2f and %.2f.",x1,x2));
        }
        else if (result==0)
        {
            System.out.println(String.format("The root is:%.2f.",x1));

        }
        else
        {

            System.out.println("The equation has no real roots.");
        }
    }
}
/*import java.util.*;
import java.math.*;
public class result {
    int a,b,c;
    int result;
    double r1,r2;
    double pw;

    void input()
    {
        Scanner input=new Scanner(System.in);

        System.out.print("Enter a,b,c:");
        a=input.nextInt();
        b=input.nextInt();
        c=input.nextInt();
    }

    void show()
    {

        result=b*b-4*a*c;

        if(result>0)
        {
            pw=Math.pow(result,0.5);
            r1=( -b - pw)/(2*a);

            r2=( -b + pw)/(2*a);
            System.out.printf("The roots are %f and %f\n",r2,r1);
        }
        else if(result==0)
        {
            r1=(- b + pw)/(2*a);
            System.out.printf("The roots is %f\n",r1);
        }
        else
        {
            System.out.println("The equation has no real roots");
        }
    }
    public static void main(String[] args)
    {

        result triangle=new result();
        triangle.input();
        triangle.show();
    }
}*/