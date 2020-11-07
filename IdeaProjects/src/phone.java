import java.util.*;

public class phone
{

    //int num;
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);

        Map<String,String> phone =new HashMap<String, String>();
        while(input.hasNext())
        {
            String name= input.next();
            if(name.equals("noname"))
            {
                break;
            }
            else
            {
                String num=input.next();
                phone.put(name,num);
            }
        }
        String find= input.next();
        if(phone.containsKey(find))
            System.out.println(phone.get(find));
        else
            System.out.println("Not found.");
    }
}
