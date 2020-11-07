import java.math.BigInteger;
import java.util.*;
public class BigNumber
{
    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);
        BigInteger big= new BigInteger(String.valueOf(Long.MAX_VALUE));
        int n=input.nextInt();
        int cnt=0;

        while(cnt<3)
        {
            if(big.mod(BigInteger.valueOf(n)).intValue()==0)
            {
                System.out.println(big);
                //cnt++;
            }
            big=big.add(BigInteger.ONE);
        }
    }
}
