import java.util.*;
public class merge
{
    public static void main(String[] args)
    {
        int[] a={1,7,9,11,13,15,17,19};
        int[] b={2,4,6,8,10};
        int[] c=new int[a.length+b.length];
        System.arraycopy(a,0,c,0,a.length);
        System.arraycopy(b,0,c,a.length,b.length);

        /*int j=0,k=0;
        for(int i=0;i<a.length;i++)
        {
            c[i]=a[j];
            j++;
        }
        for(int i=j+1;i<b.length;i++)
        {
            c[i]=b[k];
            k++;
        }*/


        Arrays.sort(c);
        for(int elem:c)
            System.out.println(elem);

    }
}
