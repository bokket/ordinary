import java.util.*;
public class change
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String tmp;

        while(in.hasNextLine())
        {
            tmp=in.nextLine();
            if(tmp.equals("end"))
                break;
            s=s+'\n'+tmp;
        }
        String m=in.next();
        String n=in.next();

        String r=s.replaceAll(m,n);
        System.out.println(r);
    }
}
