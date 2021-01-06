import java.util.*;

class student {
    String number;
    String name;
    float score;

    // Constructor
    student(String number1, String name1, float score1) {
        number = number1;
        name = name1;
        score = score1;
    }

    // Used to print student details in main()
    public String toString() {
        return this.number + " " + this.name + " " + this.score;
    }
}

public class sort_stu {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        ArrayList<student> ar = new ArrayList<student>();

        int n=0;
        while(n<5)
        {
            String num=in.nextLine();
            String name=in.nextLine();
            float score=in.nextFloat();

            student s=new student(num,name,score);
            ar.add(s);
            n++;
        }

        ar.sort(new Comparator<student>() {
            @Override
            public int compare(student o1, student o2) {
                return 0;
            }
        });

//        for()

        /* 请在这里补全代码，使程序完成指定的功能。 */
    }
}