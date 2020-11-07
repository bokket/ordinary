import java.util.*;
import java.text.DecimalFormat;


abstract class shape {
    // 抽象类 / 抽象方法 求面积
    public abstract double getArea();
    // 抽象方法 求周长
    public abstract double getPerimeter();
}


class RPentagon extends shape
{
    RPentagon(double r)
    {
        a=r;
    }
    public double getArea()
    {
        //S=5a^2/(4tan(36度))
        return 5*Math.pow(a,2)/(4*Math.tan(36*Math.PI/180));
    }
    public double getPerimeter()
    {
        return a*5;
    }

    private double a;
}
public class regular
{
    public static void main(String[]args)
    {
        DecimalFormat format=new DecimalFormat("#.####");
        Scanner input=new Scanner(System.in);

        RPentagon r=new RPentagon(input.nextDouble());
        System.out.println(format.format(r.getArea()));
        System.out.println(format.format(r.getPerimeter()));
    }
}