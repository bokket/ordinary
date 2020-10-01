import java.util.*;
import java.math.*;
public class up {
    public static void main(String[] args)
    {
        double b=0.8;//可信
        double x=0.8;//可信上课
        double x1=0.2; //可信不去上课
        double y=0.4;//不可信上课
        double y1=0.6;//不可信不去上课
        double b1=0.2;//不可信

        double result;
        double ret;
        int cnt=0;

        result=(x1*b)/((x1*b)+(y1*b1));

        while(true)
        {
            System.out.println(result);
            if (result <= 0.01)
            {
                ret=result;
                System.out.println(ret);
                break;
            }
            else {
                b=result;
                b1=1-result;
                result=(x1*b)/((x1*b)+(y1*b1));
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(" ");

        System.out.println(ret);

        //double t;
        //double t1;
        int count=0;
        double ret1=ret;

       /* static double add(double d1,double d2)
        {
            BigDecimal b1=new BigDecimal(Double.toString(d1));
            BigDecimal b2=new BigDecimal(Double.toString(d2));
            return b1.add(b2).doubleValue();
        }*/
        //double d1,d2;
        while(true)
        {

            //System.out.println(ret1);
            if(ret1>=0.85)
            {
                break;
            }
            else
            {
                double t=ret1;
                //System.out.println(t);
                double t1=1-ret1;
                //System.out.println(t1);
                ret1=
                //System.out.println(ret1);
                count++;
            }
        }
        System.out.println(count);
    }
}
