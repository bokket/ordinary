import java.util.*;
public class phone_num
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        boolean flag = true;



            for (int i = 0; i < n.length(); i++)
            {
                if (!(n.charAt(i)>='0' && n.charAt(i)<='9' ))
                {
                    flag=false;
                    break;
                }
            }



        if(flag==true && n.length()==11 && n.charAt(0)=='1')
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
