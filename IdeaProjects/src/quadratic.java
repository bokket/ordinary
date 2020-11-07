import java.util.*;

class quadraticEquation {
private double a,b,c;
    quadraticEquation(double a,double b,double c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public double getA()
    {
        return a;
    }
    public double getB()
    {
        return b;
    }
    public double getC()
    {
        return c;
    }
    public double getDiscriminant()
    {
        return b*b-4*a*c;
    }
    public double getRoot1()
    {
        double m=getDiscriminant();
        if(m>=0)
        {
            double m1;
            m1=(-b+Math.sqrt(m)) / ( 2 * a );
            return m1;
        }
        else
            return 0;
    }
    double getRoot2()
    {
        double m= getDiscriminant();
        if(m>=0){
            double m2;
            m2 = ( -b - Math.sqrt(m) ) / ( 2 * a );
            return m2;
        }
        else
            return 0;
    }
}

public class quadratic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("please input a b c : ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        quadraticEquation quadraticEquation = new quadraticEquation(a, b, c);
        double m = quadraticEquation.getDiscriminant();

        if (m > 0)
            System.out.println("Root1: "+quadraticEquation.getRoot1()+" Root2: "+quadraticEquation.getRoot2());
        else if (m == 0)
            System.out.println("Root: "+quadraticEquation.getRoot1());
        else
            System.out.println("The equation has no roots");
    }
}
