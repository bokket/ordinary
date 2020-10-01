import java.util.*;
import java.math.*;
public class circle {
    public static void main(String[] args) {

        double x1, y1, r1;
        double x2, y2, r2;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter circle1s center x-,y-coordinates,and radius:");
        x1 = input.nextDouble();
        y1 = input.nextDouble();
        r1 = input.nextDouble();

        System.out.println("Enter circle2s center x-,y-coordinates,and radius:");
        x2 = input.nextDouble();
        y2 = input.nextDouble();
        r2 = input.nextDouble();

        double result=Math.abs(r1-r2);
        double cent=Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        double result1=r1+r2;

        if(result1>=cent)
        {
            if(result>=cent)
            {
                System.out.println("circle2 is inside circle1");
            }
            else
                System.out.println("circle2 overlaps circle1");
        }
        else
            System.out.println("circle2 does not overlap circle1");
    }
}
