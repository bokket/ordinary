import java.util.*;
public class phone_together
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        Set<String> s1=new TreeSet<String>();
        Set<String> s2=new TreeSet<String>();
        Set<String> s3=new TreeSet<String>();

        String name;
        String num;

        while(in.hasNextLine()) {
            name=in.nextLine();
            if(name.equals("end"))
                break;

            s1.add(name);
        }



        while(in.hasNextLine()) {
            num=in.nextLine();
            if(num.equals("end"))
                break;

            s2.add(num);
        }

        s3.addAll(s1);
        s3.addAll(s2);

        Iterator iterator=s3.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());

    }
}
