import java.util.*;
import java.text.DecimalFormat;
import java.util.HashMap;

public class noname {
    public static void main(String[]args)
    {
        HashMap<String,String> p=new HashMap<String, String>();
        Scanner input=new Scanner(System.in);
        DecimalFormat format=new DecimalFormat("#.##");
        String name;
        String score;
        while(true)
        {
            name=input.next();
            if(name.equals("noname"))
                break;
            score=input.next();
            p.put(name,score);
        }
        String find= input.next();
        if(p.containsKey(find))
        {
            int f=Integer.parseInt(p.get(find));
            System.out.println(format.format(f*0.21));//将字符串类型转换为int型
        }
        else
            System.out.println("Not found.");
    }
}
