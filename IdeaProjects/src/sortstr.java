import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.*;
public class sortstr
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);

        String s=input.nextLine();
        char[] a=new char[s.length()];
        StringBuffer s1=new StringBuffer();

        for(int i=0;i<s.length();i++)
            a=s.toCharArray();

        Arrays.sort(a);
        //s1=Arrays.toString(a);
        s1.append(a);

        //for(int i=0;i<s.length();i++)
        System.out.println(s1);
    }
}
