
import java.util.*;
public class credit
{
    public static boolean isValid(long number)
    {
        if(getSize (number)<13)
        {
            System.out.println("输入的信用卡号"+number+"共有"+getSize (number)+"位小于13位，有误");
            return false;
        }
        else if(getSize (number)>16)
        {
            System.out.println("输入的信用卡号"+number+"共有"+getSize (number)+"位超过16位，有误");
            return false;
        }

        else
        {
            return true;
        }
    }
    public static int sumOfDoubleEvenPlace (long number)
    {
        int sum=0;
        String number1 =String.valueOf (number);
        for(int i=getSize (number)-2;i>=0;i-=2)
        {
            sum=sum+getDigit (2*(number1.charAt(i)-48));
        }
        return sum;
    }
    public static int getDigit (int number)
    {
        if(number<=9)
        {
            return number;
        }
        else
        {
            return 1+number%10;
        }
    }
    public static int sumOfOddPlace (long number)
    {
        int sum=0;
        String number1 =String.valueOf (number);
        for(int i=getSize (number)-1;i>=0;i-=2)
        {
            sum=sum+getDigit (number1.charAt(i)-48);
        }
        return sum;
    }
    public static boolean prefixMatched(long number,int d)
    {
        String number1 =String.valueOf (number);
        if(getSize (d)==1)
        {
            if (d==4||d==5||d==6)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(getSize (d)==2)
        {
            int temp=(number1.charAt(0)-48)*10+(number1.charAt(1)-48);
            if (temp==37)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    public static int getSize (long d)
    {
        String d1 =String.valueOf (d);
        return d1.length();
    }
    public static long getPrefix(long number,int k)
    {
        String number1 =String.valueOf (number);
        if(getSize (number)<k)
        {
            return number;
        }
        else
        {
            int temp=0;
            for(int i=0;i<k;i++)
            {
                temp=10*temp+number1.charAt(i)-48;
            }
            return temp;
        }
    }
    public static void main(String[] args)
    {
        System.out.println("请输入一个长整型数字作为信用卡号，长度应在13~16之间");
        Scanner input =new Scanner (System.in);
        long num =input.nextLong();
        if(isValid(num))
        {
            if(prefixMatched(num,(int)getPrefix(num,1))||prefixMatched(num,(int)getPrefix(num,2)))
            {
                if((sumOfDoubleEvenPlace (num)+sumOfOddPlace (num))%10==0)
                {
                    System.out.println("输入的卡号有效");
                }
                else
                {
                    System.out.println("输入的卡号无效");
                }
            }
            else
            {
                System.out.println("输入的信用卡号"+num+"前缀有误");
            }
        }
    }
}

/*
import java.util.*;
public class credit {
    public static void main(String[] args)
    {
        System.out.println("请输入卡号");
        Scanner input=new Scanner(System.in);
        long num=input.nextLong();
        if(isValid(num))
        {

        }
    }
    public static boolean isValid(long number)
    {
        if(getSize(number)<13)
        {
           System.out.println("输入的信用卡"+number+"有"+getSize()+"位");
            return false;
        }
        else if(getSize(number)>16)
        {
            System.out.println("输入的信用卡"+number+"有"+getSize()+"位");
            return false;
        }
        else
            return true;
    }
    public static int sumOfDoubleEvenPlace(long number)
    {

    }
    public static int getDigit(int number)
    {

    }
    public static int sumOfOddPlace(long number)
    {

    }
    public static boolean prefixMatched(long number, int d)
    {

    }
    public static int getSize(long d)
    {
        String d1=String.valueOf(d);
        return d1.length();
    }
    public static long getPrefix(long number, int k)
    {

    }
}*/
