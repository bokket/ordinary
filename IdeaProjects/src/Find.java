import java.util.*;

public class Find
{
    public static Object max(Comparable[] a)
    {
        Arrays.sort(a);
        return a[a.length-1];
    }
    public static void main(String[] args)
    {
        String[] sArray = new String[5];
        Integer[] intArray = new Integer[5];
        Scanner input = new Scanner(System.in);
        for(int i=0;i<sArray.length;i++)  {
            sArray[i] = input.next();
        }

        for(int i=0;i<intArray.length;i++)  {
            intArray[i] = new Integer(input.nextInt());
        }

        System.out.println("Max string is " +(String)max(sArray));
        System.out.println("Max integer is " + (Integer)max(intArray));
    }
}