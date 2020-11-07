import java.util.*;
import java.math.*;
public class multiplied
{
    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);

        BigInteger a=input.nextBigInteger();
        BigInteger b=input.nextBigInteger();
        BigInteger c=a.divide(b);
        System.out.println(c);
    }
}
