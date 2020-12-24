import java.util.*;
import java.util.Scanner;
public class largerow
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                a[i][j]=input.nextInt();
        }
        int[] row=new int[n];
        int[] col=new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]==1)
                {
                    row[i]+=1;
                    col[j]+=1;
                }
            }
        }
        System.out.print("Highest row: [");
        Find(row);
        System.out.print("Highest column: [");
        Find(col);
    }
    public static void Find(int a[])
    {
        int max=a[0];
        int cnt=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>max)
                max=a[i];

        }
         for(int i=0;i<a.length;++i){
            if(a[i]==max){
                cnt+=1;
            }
        }
        for(int i=0;i<a.length;i++)
        {
            if(cnt==1 && a[i]==max)
                System.out.print(i);
            if(cnt>1 && a[i]==max)
            {
                System.out.print(i+",");
                cnt-=1;
            }
        }
        System.out.println("]");
    }
}
