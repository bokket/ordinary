import java.util.*;
public class value {
    public static void main(String[] args)
    {
        double interest,rate;
        double year;
        double futer;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter investment amount:");
        interest=input.nextDouble();

        System.out.print("Enter annual interest rate:");
        rate=input.nextDouble();

        System.out.print("Enter number of years:");
        year=input.nextDouble();

        futer=interest*Math.pow((1+rate/1200),(year*12));

        System.out.println(String.format("Accumulated value is $ %f",futer));
    }
}
