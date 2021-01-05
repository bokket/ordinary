import java.text.DecimalFormat;
import java.util.*;
import java.math.*;
public class result
{
    public static void main(String[] args)
    {
        double a, b, c;
        DecimalFormat format=new DecimalFormat("#.##");
        Scanner input = new Scanner(System.in);

        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();



        double d=b*b-4*a*c;

        double x=(-b+d)/(2*a);
        //if (Math.abs(x)<10*Math.E-6)
        if(d==0)
        {
            System.out.printf("The root is:%.2f.",(-b+Math.sqrt(d))/(2*a));
            //System.out.println("The root is:"+format.format(x)+".");
        }
        else if(d>0)
        {
            System.out.printf("The roots are %.2f and %.2f.",(-b+Math.sqrt(d))/(2*a),(-b-Math.sqrt(d))/(2*a));
        }
        else if(d<0)
        {
            System.out.printf("The equation has no real roots.");
        }
    }
}
