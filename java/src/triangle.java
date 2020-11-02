import java.util.*;
import java.math.*;
public class triangle {
    double x1,y1;
    double x2,y2;
    double x3,y3;
    double side1,side2,side3;
    double s;
    double area;
    void input()
    {
        Scanner input=new Scanner(System.in);

        System.out.print("Enter three points for a triangle:");
        x1=input.nextDouble();
        y1=input.nextDouble();

        x2=input.nextDouble();
        y2=input.nextDouble();

        x3=input.nextDouble();
        y3=input.nextDouble();
    }

    void show()
    {
        side1=Math.sqrt( (x1-x2)*(x1-x2) +  (y1-y2)*(y1-y2)  );
        side2=Math.sqrt( (x1-x3)*(x1-x3) +  (y1-y3)*(y1-y3)  );
        side3=Math.sqrt( (x2-x3)*(x2-x3) +  (y2-y3)*(y2-y3)  );

        s=(side1+side2+side3)/2;

        area=Math.sqrt( s*(s-side1)*(s-side2)*(s-side3) );

        System.out.println("The area of the triangle is:"+area);
    }
    public static void main(String[] args)
    {

        triangle area=new triangle();
        area.input();
        area.show();
    }
}