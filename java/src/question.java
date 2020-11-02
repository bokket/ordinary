import java.util.*;
import java.math.*;
public class question{

    public static void main(String[] args) {

        double a,b,c;
        Scanner input = new Scanner(System.in);
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