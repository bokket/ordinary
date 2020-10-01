import java.util.*;
public class loop {
    public static void main(String[] args) {
        int i, j, num = 1;
        for (i = 0; i < 8; i++)
        {
            for (j = 7 - i; j > 0; j--)
            {
                System.out.print("\t");
            }
            for (j = 1; j <= num; j *= 2)
            {
                System.out.print(j);
                System.out.print('\t');
            }
            for (j = num / 2; j >= 1; j /= 2)
            {
                System.out.print(j);
                System.out.print('\t');
            }
            System.out.println();
            num*=2;
        }
    }
}
