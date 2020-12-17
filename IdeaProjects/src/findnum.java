import java.util.*;
public class findnum
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        String name;
        String num;
        //String s=new String("noname");

        //name=input.next();

        Map<String,String> map=new HashMap<String, String>();
        while(true)
        {
            name=input.next();
            if(name.equals("noname"))
            {
                break;
            }
            num=input.next();
            map.put(name,num);
        }
        String find=input.next();
        if(map.containsKey(find))
        {
            System.out.println(map.get(find));
        }
        else
            System.out.println("Not found.");
    }
}
/*
public class findnum
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        String name;
        String num;
        String s=new String("noname");
        String s1=new String();

        int flag=0;
        int flag1=0;
        //name=input.next();

        Map<String,String> map=new HashMap<String, String>();
        while(true)
        {
            name=input.next();
            if(!name.equals(s))
            {
                flag=1;
                break;
            }
            num=input.next();
            map.put(name,num);
        }
        if(flag==0)
        {
            name=input.next();
            for(String i:map.keySet())
            {
                if(!i.equals(name))
                {
                    flag1=1;
                    s1=map.get(i);
                    break;
                }
            }
        }
        if(flag1==1)
            System.out.println(s1);
        else
            System.out.println("Not found.");

    }
}*/
