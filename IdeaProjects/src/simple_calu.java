import java.math.BigInteger;
import java.util.*;
public class simple_calu
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();



        if(s.indexOf('/')!=-1)
        {
            String [] s1=s.split("/",0);
            BigInteger b1=new BigInteger(s1[0]);
            BigInteger b2=new BigInteger(s1[1]);
            System.out.println(b1.divide(b2));
        }
        if(s.indexOf('*')!=-1)
        {
            String [] s1=s.split("\\*",0);
            BigInteger b1=new BigInteger(s1[0]);
            BigInteger b2=new BigInteger(s1[1]);
            System.out.println(b1.multiply(b2));
        }
        if(s.indexOf('-')!=-1)
        {
            String [] s1=s.split("-",0);
            BigInteger b1=new BigInteger(s1[0]);
            BigInteger b2=new BigInteger(s1[1]);
            System.out.println(b1.subtract(b2));
        }
        if(s.indexOf('+')!=-1)
        {
            String [] s1=s.split("+",0);
            BigInteger b1=new BigInteger(s1[0]);
            BigInteger b2=new BigInteger(s1[1]);
            System.out.println(b1.add(b2));
        }
    }
}
