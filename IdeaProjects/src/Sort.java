import java.util.Arrays;
public class Sort {
    public static void main(String[] args)
    {
        int[] a = {1, 7, 9, 11, 13, 15, 17, 19};
        int[] b = {2, 4, 6, 8, 10};
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; ++i)
        {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; ++i)
        {
            c[a.length + i] = b[i];
        }
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
    }
}