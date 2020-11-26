import java.util.*;

public class suffix
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        String s1;
        String s2;
        s1=input.next();
        s2=input.next();

        char [] a=s1.toCharArray();
        char [] b=s2.toCharArray();

        int i=s1.length()-1;
        int j;
        int cnt=0;
        for(j=s2.length()-1;j>=0;j--)
        {
            if(b[j]==a[i])
            {
                cnt++;
                i--;
            }
            else
                break;
        }
        if(cnt==0)
            System.out.println("No common suffix.");
        else
        {
            System.out.print("The common suffix is ");
            for(j=s1.length()-cnt;j<s1.length();j++)
                System.out.print(a[j]);
            System.out.println(".");
        }
    }
}

