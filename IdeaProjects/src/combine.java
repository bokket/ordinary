import java.util.*;
public class combine
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt()+input.nextInt();

        int [] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=input.nextInt();
        Arrays.sort(a);
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
    }
}
