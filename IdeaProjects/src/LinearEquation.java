import java.util.*;

class Equation {
    private int a,b,c,d,e,f;
    public Equation(int a,int b,int c,int d,int e,int f)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e;
        this.f=f;
    }
    public int getA()
    {
        return a;
    }
    public int getB()
    {
        return b;
    }
    public int getC()
    {
        return c;
    }
    public int getD()
    {
        return d;
    }
    public int getE()
    {
        return e;
    }
    public int getF()
    {
        return f;
    }
    public int getX() { return (e*d-b*f)/(a*d-b*c); }
    public int getY() { return (a*f-e*c)/(a*d-b*c); }
    public boolean isSolvable(int a,int b,int d,int c)
    {
        if((a*d-b*c)!=0)
            return true;
        else
            return false;
    }
}
public class LinearEquation{
    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);

        System.out.println("Please enter a, b, c, d, e, and f:");
        int a=input.nextInt();
        int b=input.nextInt();
        int c=input.nextInt();
        int d=input.nextInt();
        int e=input.nextInt();
        int f=input.nextInt();

        Equation equation=new Equation(a,b,c,d,e,f);
        boolean bool=equation.isSolvable(a,b,d,c);
        if(bool==false)
            System.out.println("The equation has no solution.");
        else
        {
            System.out.println("X:"+equation.getX()+"Y:"+equation.getY());
        }
    }
}