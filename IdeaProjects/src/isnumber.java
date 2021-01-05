import java.util.*;
public class isnumber {
    public static void main(String[] args)
    {
        String s;
        Scanner in=new Scanner(System.in);
        s=in.next();
        int cnt=0;
        boolean flag=true;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.') {
                flag=true;
                cnt++;
            }
            if(s.charAt(i)>='a' && s.charAt(i)<='z') {
                flag=false;
                break;
            }
            if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
                flag=false;
                break;
            }
            flag=true;
        }


        if(flag && cnt==1)
            System.out.println("true");
        else
            System.out.println("false");
        /*String s;
        Scanner in=new Scanner(System.in);
        s=in.next();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.')
                continue;
            if(s.charAt(i)>='a' && s.charAt(i)<='z') {
                System.out.println("false");
                break;
            }
            else
            {
                System.out.println("true");
                break;
            }
        }*/

    }
}
