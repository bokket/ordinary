import java.util.*;

public class repeat
{
    public static void main(String[] agrs) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String s=input.nextLine();
        String[] s1=s.split(" ");
        Set<Integer> set=new HashSet<>();

        for(int i=0;i<n;i++)
            set.add(Integer.parseInt(s1[i]));

        if(set.size()==n)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}