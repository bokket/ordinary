import java.util.*;
public class number
{
    static void cout(String s)
    {
        String s1="[\u4e00-\u9fa5]"; //汉字
        String s2="[a-zA-Z]";
        String s3="[0-9]";
        String s4="\\s"; //空格

        int cntChinese=0;
        int cntLetter=0;
        int cntNumber=0;
        int cntSpace=0;
        int cntOther=0;
        char[] arry_char=s.toCharArray();
        String[] arry_str=new String[arry_char.length];
        for(int i=0;i<arry_char.length;i++)
        {
            arry_str[i]=String.valueOf(arry_char[i]);

            for(String elem:arry_str)
            {
                if(elem.matches(s1))
                    cntChinese++;
                else if(elem.matches(s2))
                    cntLetter++;
                else if(elem.matches(s3))
                    cntNumber++;
                else if(elem.matches(s4))
                    cntSpace++;
                else
                    cntOther++;
            }
        }
        System.out.println("输入的汉字个数："+cntChinese);
        System.out.println("输入的字母个数："+cntLetter);
        System.out.println("输入的数字个数："+cntNumber);
        System.out.println("输入的空格个数："+cntSpace);
        System.out.println("输入的其他字符个数："+cntOther);
    }
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();

        cout(s);

    }
}
