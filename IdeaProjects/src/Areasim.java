import java.text.DecimalFormat;
import java.util.*;
public class Areasim {
    public static void main(String[] args)
    {
        double a,b,c;
        Scanner in=new Scanner(System.in);
        DecimalFormat f=new DecimalFormat("0.000");
        a=in.nextDouble();
        b=in.nextDouble();
        c=in.nextDouble();

        double d=(a+b+c)/2;

        if(a+b<c)
        {
            System.out.println("It can not be created a triangle.");
        }
        else
            System.out.println("The area is:"+f.format(Math.sqrt(d*(d-a)*(d-b)*(d-c)))+".");
    }
}
