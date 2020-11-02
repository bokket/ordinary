import java.util.*;
public class year {
    public static void main(String[] args)
    {
        int h;
        int q,m,j,k,y;
        String week=null;

        Scanner input=new Scanner(System.in);
        System.out.println("Enter year:");
        y=input.nextInt();

        System.out.println("Enter month:");
        m=input.nextInt();

        System.out.println("Enter the day of the month:");
        q=input.nextInt();

        if(m==1)
        {
            m=13;
            y=y-1;
        }
        else if(m==2)
        {
            m=14;
            y=y-1;
        }
        k=y%7;
        j=y%100+1;
        h=(q+ (26*(m+1)/10) +k +(k/4) +(j/4) +5*j )%7;
        switch (h)
        {
            case 0:
                week="Sunday";
                break;
            case 1:
                week="Monday";
                break;
            case 2:
                week="Tuesday";
                break;
            case 3:
                week="Wednesday";
                break;
            case 4:
                week="Thursday";
                break;
            case 5:
                week="Friday";
                break;
            case 6:
                week="Saturday";
                break;
        }
     System.out.println("Day of the week is "+week);
    }
}
