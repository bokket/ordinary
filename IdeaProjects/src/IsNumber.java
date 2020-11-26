import java.util.*;


public class IsNumber
{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.next();


        int cnt=1;
        for(int i= s.length()-1;i>=0;i--)
        {
            if(!Character.isDigit(s.charAt(i)));
            {
                cnt = 0;
            }
        }
        if(cnt==0)
            System.out.println("false");
        if(cnt==1)
            System.out.println("true");
    }
}
