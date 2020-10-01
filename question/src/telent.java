import java.util.*;
public class telent {
    public static void main(String[] args) {
        double b = 0.8;//可信
        double x = 0.8;//可信上课
        double x1 = 0.2; //可信不去上课
        double y = 0.4;//不可信上课
        double y1 = 0.6;//不可信不去上课
        double b1 = 0.2;//不可信


        int cnt = 0;

        while (b >= 0.01) {
            b = (b * x1) / ((x1 * b) + (y1 * b1));
            b1 = 1 - b;
            cnt++;
        }
        System.out.println(cnt);

        int count=0;
        while(b<0.85)
        {
            b=(b*x)/((b*x)+(b1*y));
            b1=1-b;
            count++;
        }
        System.out.println(count);
    }
}
