import java.util.*;

public class Strreplace
{
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        String str = input.nextLine();
        String temp;
        while (input.hasNextLine()) {
            temp = input.nextLine();
            if (temp.equals("end"))
                break;
            str = str + '\n' + temp;
        }
        String str1 = input.next();
        String str2 = input.next();
        String newstr = str.replaceAll(str1, str2);
        System.out.println(newstr);
    }
}