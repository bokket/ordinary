import java.util.*;
public class findreption
{
    public static void main(String[] agrs) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String s=input.nextLine();
        String[] s1=s.split("");
        Set<Integer> set=new HashSet<Integer>();

        for(int i=0;i<n;i++)
            set.add(Integer.parseInt(s1[i]));

        if(set.size()==n)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}

/*
public class findreption 
{
    public static void main(String[] agrs) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int flag = 0;
        int[] s = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++)
            b[i]=0;

        for (int i = 0; i < n; i++) {
            s[i] = input.nextInt();
            b[s[i]]++;
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] > 1)
            {
                flag=1;
                break;
            }
        }
        if(flag==1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}*/
