
import java.util.Scanner;
import java.text.DecimalFormat;

interface IShape {
    public abstract double getArea();

    public abstract double getPerimeter();
}
class RTriangle1 implements IShape
{
    private double a,b;
    RTriangle1(double a,double b)
    {
        this.a=a;
        this.b=b;
    }
    public double getArea()
    {
        return a*b*0.5;
    }
    public double getPerimeter()
    {
        return Math.sqrt(a*a+b*b)+a+b;
    }
}
/*你写的代码将嵌入到这里*/
public class RTriangle {
    public static void main(String[] args) {
        DecimalFormat d = new DecimalFormat("#.####");
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        IShape r = new RTriangle1(a, b);
        System.out.println(d.format(r.getArea()));
        System.out.println(d.format(r.getPerimeter()));
        input.close();
    }
}


