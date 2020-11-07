import java.util.*;
/*
public class calendar
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        int month = input.nextInt();
        //打印用户输入的年月份的日历
        printMonth(year,month);
    }

    //打印月份
    public static void printMonth(int year, int month)
    {
        printMonthTile(year,month);
        printMonthBody(year,month);
    }
    //打印月份的标题
    public static void printMonthTile(int year,int month)
    {
        System.out.println("\t\t"+getMonthName(month)+"  "+year);
        System.out.println("------------------------------");
        //System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
    }
    //打印月份的主体
    public static void printMonthBody(int year,int month)
    {
        int startDay = getStartDay(year,month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
        int i = 0;
        for(i = 0;i < startDay; i++)
            System.out.print("\t");
        for(i = 1;i <= numberOfDaysInMonth;i++){
            System.out.printf("\t%d",i);
            if((i + startDay) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }
    //月份对应的英文字符串
    public static String getMonthName(int month){
        String monthName = "";
        switch(month){
            case 1:monthName = "January";break;
            case 2:monthName = "February";break;
            case 3:monthName = "March";break;
            case 4:monthName = "April";break;
            case 5:monthName = "May";break;
            case 6:monthName = "June";break;
            case 7:monthName = "July";break;
            case 8:monthName = "August";break;
            case 9:monthName = "September";break;
            case 10:monthName = "October";break;
            case 11:monthName = "November";break;
            case 12:monthName = "December";break;
        }
        return monthName;
    }
    //得到某个月第一天的星期数
    public static int getStartDay(int year,int month)
    {
        final int START_DAY_FOR_JAN_1_1800 = 3;
        //得到从1800，1，1到year，month，1之间的天数
        int totalNumberOfDays = getTotalNumberOfDays(year,month);
        //返回year，month，1的开始天
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }
    //得到年份之间的总天数
    public static int getTotalNumberOfDays(int year,int month)
    {
        int total = 0;
        //得到从1800到1/1/year的总天数
        for(int i = 1800; i < year;i++){
            if(isLeapYear(i))
                total += 366;
            else
                total +=365;
        }
        //将一月到日历月的天数加到总天数中去
        for(int i = 1;i < month;i++)
            total +=getNumberOfDaysInMonth(year,i);
        return total;
    }
    //得到某个月的天数
    public static int getNumberOfDaysInMonth(int year,int month)
    {
        switch (month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
                //break;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
                //break;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    return 29;
                } else {
                    return 28;
                }
        }
        return 0;*/
        /*if(month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12)
            return 31;
        if(month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        if(month == 2)
            return isLeapYear(year) ? 29 : 28;
        return 0;*/
    //}
    //判断某年是否是闰年
   /* public static boolean isLeapYear(int year)
    {
        if(year % 400 == 0||(year % 4 == 0 && year % 100 != 0) )
            return true;
        else
            return false;
    }
}*/
/*
public class calendar {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter full year (e.g 2014): ");
        int year = input.nextInt();
        System.out.print("Enter month as number between 1 and 12: ");
        int month = input.nextInt();
        printMonth(year,month);
    }

    //打印月份
    public static void printMonth(int year, int month){
        System.out.print(month+" "+year);
    }
    //打印月份的标题
    public static void printMonthTile(int year,int month){

    }
    //打印月份的主体
    public static void printMonthBody(int year,int month){

    }
    //得到月份对应的英文字符串
    public static String getMonthName(int month){
        return "January";
    }
    //得到某个月第一天的星期数
    public static int getStartDay(int year,int month){
        return 10000;
    }
    //得到某个月的天数
    public static int getNumberOfDaysInMonth(int year,int month){
        return 31;
    }
    //判断某年是否是闰年
    public static boolean isLeapYear(int year){
        return true;
    }
}*/
/*
public class calendar {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入年月信息：");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int sum = 0, day = 0;
        // 计算从1990年开始到当前年的总天数
        for (int i = 1990; i < year; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                sum += 366;
            } else {
                sum += 365;
            }
            //}
            // 计算当年内到当前月的天数
            for (int j = 1; j <= month; j++)
            {
                switch (j)
                {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        sum += 31;
                        day = 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        sum += 30;
                        day = 30;
                        break;
                    case 2:
                        if (j % 4 == 0 && j % 100 != 0 || j % 400 == 0)
                        {
                            sum += 29;
                            day = 29;
                        }
                        else
                        {
                            sum += 28;
                            day = 28;
                        }
                        break;
                }
            }
            System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
            // 计算出上个月多余的天数并跳过
            int moreDay = (sum - day) % 7 + 1;
            for (i = 1; i <= moreDay; i++) {
                System.out.print("\t");
            }
            for (i = 1; i <= day; i++) {
                if ((sum - day) % 7 + 1 == 6) {
                    System.out.print(i + "\n");
                } else {
                    System.out.print(i + "\t");
                }
                sum += 1;
            }
        }
    }
}

*/
public class calendar {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入年月信息：");
        int year = input.nextInt();
        int month = input.nextInt();
        int sum = 0, day = 0;

        for (int i = 1800; i < year; i++)
        {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                sum += 366;
            } else {
                sum += 365;
            }
        }

        for (int j = 1; j <= month; j++) {
            switch (j) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    sum += 31;
                    day = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    sum += 30;
                    day = 30;
                    break;
                case 2:
                    if (j % 4 == 0 && j % 100 != 0 || j % 400 == 0) {
                        sum += 29;
                        day = 29;
                    } else {
                        sum += 28;
                        day = 28;
                    }
                    break;
            }

        }
        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
        // 计算出上个月多余的天数并跳过
        int moreDay = (sum - day) % 7 + 1;
        for (int i = 1; i <= moreDay; i++) {
            System.out.print("\t");
        }
        for (int i = 1; i <= day; i++) {
            if ((sum - day) % 7 + 1 == 6) {
                System.out.print(i + "\n");
            } else {
                System.out.print(i + "\t");
            }
            sum += 1;
        }
    }
}



/*
public class calendar {
    //定义方法，判断一个年是否是闰年
    public static boolean ifLeapyear(int year)
    {
        if(year%4==0 && year%100!=0 || year%400==0)
            return true;
        else
            return false;
    }


    //判断某年某月有多少天
    public static int getDays(String yearMonth)
    {
        String array[] = yearMonth.split("-");
        int year = Integer.parseInt( array[0] );
        int month = Integer.parseInt( array[1] );
        int monthOne[] = {31,29,31,30,31,30,31,31,30,31,30,31};
        int monthTwo[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        if( calendar.ifLeapyear(year) )
        {
            return monthOne[month-1];
        }

        return monthTwo[month-1];
    }
    //接收用户的输入
    public static String getInput()
    {
        Scanner input=new Scanner(System.in);
        String yearMonth="";
        //System.out.println( "请输入年月，中间用'-'分开：" );
        yearMonth = input.next();
        return yearMonth;
    }


}*/
