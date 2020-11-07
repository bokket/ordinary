import java.util.*;

public class count
{
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        String str=input.next();
        String a=input.next();
        char b=a.charAt(0);


        int cnt=count(str,b);
        System.out.println(String.format("The number of occurrences is "+cnt+"."));
    }

    public static int count(String str, char a)
    {
        int cnt=0;
        char[] ch=str.toCharArray();//变成数组
        char c=a;
        for(int i=0;i<ch.length;i++)
        {
            if(c==ch[i])
                cnt++;
        }
        return cnt;
    }
}

