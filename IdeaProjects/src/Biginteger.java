import java.util.*;
import java.math.BigInteger;
public class Biginteger
{
    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        BigInteger result=new BigInteger("1");
        for(int i=1;i<=n;i++)
        {
            BigInteger t=new BigInteger(i+"");
            result=result.multiply(t);
        }
        System.out.println(result);
    }
}
