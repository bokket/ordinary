import  java.math.*;
import java.util.*;
public class Find_print {

    static public boolean equals(Object obj,Object rob) {
        //return super.equals(obj);
        if(obj==rob)
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        String name;

        String fen;
        int cnt=0;
        HashMap<String,String> map= new HashMap<String, String>();

        while(true)
        {
            name=input.next();
            cnt++;
            if(equals(name,"noname"))
                break;

            fen=input.next();

            map.put(name,fen);
        }

        String find=input.next();

            if(map.containsKey(find))
                System.out.printf("%.2f",Integer.parseInt(map.get(find))*0.21);
            else
                System.out.println("Not found.");


    }
}
