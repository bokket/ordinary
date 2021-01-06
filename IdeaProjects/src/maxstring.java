import java.util.*;
public class maxstring {
    public static void main(String[] args)
    {

        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String [] s1=s.split(" ");
        int max=s1[0].length();
        int index=0;
        for(int i=0;i<s1.length;i++)
        {
            if (max < s1[i].length())
            {
                max = s1[i].length();
                index=i;
            }
        }

        System.out.println(s1[index]);
    }
}
