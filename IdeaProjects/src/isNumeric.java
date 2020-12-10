import java.util.*;
public class isNumeric
{
public static void isNumeric(String token) {
    int count=0;
    boolean isNum=true;
    for(int i = 0; i < token.length(); i++)
    {
        if(token.charAt(i) < '0' && token.charAt(i) != '.' || token.charAt(i) > '9')
        {
            isNum=false;
            break;
        }
        if(token.charAt(i) >= '0' && token.charAt(i) <= '9' || token.charAt(i) == '.')
        {
            if (token.charAt(i) == '.')
                ++count;
        }
    }

    if (token.charAt(0) == '0' && token.charAt(1) != '.')
    {
        isNum = false;
    }
    if (token.charAt(token.length() - 1) == '.')
    {
        isNum = false;
    }
    if (count <= 1 && isNum == true)
        System.out.println("true");
    else
        System.out.println("false");
}
}
