import java.util.*;


public class IsNumber
{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.next();

        boolean flag=false;
        int cnt=0;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)=='.')
            {
                flag=true;
                cnt++;
            }
            if(Character.isDigit(s.charAt(i)));
            {
                flag=true;
            }
        }
        if(flag && cnt==1)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
