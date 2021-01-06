import java.util.*;
public class cntstring {
    public static int count(String str, char a)
    {
        int cnt=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==a)
                cnt++;
        }
        return cnt;
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        String a=in.next();
        char c=in.next().charAt(0);
        int n=count(a,c);
        System.out.println("The number of occurrences is "+n+".");


    }
}
