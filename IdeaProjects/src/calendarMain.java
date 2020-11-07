import java.util.*;
import java.util.GregorianCalendar;
public class calendarMain {
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);

        long time =input.nextLong();

        GregorianCalendar calendar=new GregorianCalendar();
        calendar.setTimeInMillis(time);
        System.out.println(calendar.get(Calendar.YEAR)+"-"+ calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH));
    }
}
