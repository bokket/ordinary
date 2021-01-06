import java.math.BigInteger;
import java.util.*;
public class Find_primer
{
    public static void main(String[] args)
    {

        Scanner in=new Scanner(System.in);
        BigInteger big2=in.nextBigInteger();

        int num=in.nextInt();
        int cnt=0;
        while(cnt<num)
        {
            if(big2.isProbablePrime(100))
            {
                System.out.println(big2);
                cnt++;
            }
            big2=big2.nextProbablePrime();
        }
    }
}
