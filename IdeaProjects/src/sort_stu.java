import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
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
        String num;
        String name;
        float score;
        for(int i=0;i<5;i++) {
            num = in.next();
             name = in.next();
            score = in.nextFloat();

            student s = new student(num, name, score);
            ar.add(s);
        }


        ar.sort(new Comparator<student>() {
            @Override
            public int compare(student o1, student o2) {
                return (int)(o2.score-o1.score);
            }
        });


        for(student elem:ar)
            System.out.println(elem.toString());

        /* 请在这里补全代码，使程序完成指定的功能。 */
    }
}