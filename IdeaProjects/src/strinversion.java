import java.util.*;
public class strinversion
{
    public static void main(String[] agrs)
    {
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();
        StringBuffer t=new StringBuffer();

        char[] a=s.toCharArray();

        /*for(int i=s.length()-1;i>=0;i--)
        {
            if(a[i]>='A' && a[i]<='Z')
            {
                t.append(String.valueOf(a[i]).toLowerCase());
            }
            else if(a[i]>='a' && a[i]<='z')
            {
                t.append(String.valueOf(a[i]).toUpperCase());
            }
        }*/
        int j=0;
        if(s!=null)
        {
            for(int i=0;i<s.length();i++)
            {
                if(a[i]>='A' && a[i]<='Z' )
                {
                    s=s.toLowerCase();
                    t.append(s.charAt(i));
                }
                else if(a[i]>='a' && a[i]<='z' )
                {
                    s=s.toUpperCase();
                    t.append(s.charAt(i));
                }
                else if(a[i]==' ')
                {
                    t.append(s.charAt(i));
                }
                else
                    t.append(s.charAt(i));
            }
        }
        t.reverse();
        System.out.println(t.toString());
    }
}
