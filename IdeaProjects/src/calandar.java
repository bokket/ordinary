import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class calandar
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        Calendar g=Calendar.getInstance();
        SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
        long n=in.nextLong();
       long day=in.nextInt();

       long time=24*60*60*1000*day+n;
        System.out.println(time);
        g.setTimeInMillis(n);
        System.out.println(d.format(g.getTimeInMillis()));


        g.setTimeInMillis(time);
        System.out.println(d.format(g.getTimeInMillis()));
    }
}
