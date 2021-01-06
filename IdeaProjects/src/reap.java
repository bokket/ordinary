import java.util.*;
public class reap
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);

        StringBuilder s1=new StringBuilder(in.next());
        StringBuilder s2=new StringBuilder(in.next());
        StringBuilder s=new StringBuilder();

        int len=0;
        int cnt=0;
        s1.reverse();
        s2.reverse();

        if(s1.length()<s2.length())
            len=s2.length();
        else
            len=s1.length();

        for(int i=0;i<len;i++)
        {
            if(s1.charAt(i)==s2.charAt(i)) {
                s.append(s1.charAt(i));
                cnt++;
            }
            else
                break;

        }

        if(s.length()!=0)
            System.out.println("The common suffix is "+s.reverse()+".");
        else
            System.out.println("No common suffix.");
    }
}
