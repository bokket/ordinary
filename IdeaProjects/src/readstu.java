import java.io.*;
import java.util.Scanner;
class students
{
    String number;
    String name;
    double Math;
    double Chinese;
    double English;
    double sum;

    public void setSum(double sum) {
        this.sum = sum;
    }
    public students(String number, String name, double Math, double Chinese, double English) {
        this.number = number;
        this.name = name;
        this.Math = Math;
        this.Chinese = Chinese;
        this.English = English;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
    public double getChinese() {
        return Chinese;
    }

    public double getEnglish() {
        return English;
    }

    public double getMath() {
        return Math;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", Math=" + Math +
                ", Chinese=" + Chinese +
                ", English=" + English +
                ", sum=" + sum +
                '}';
    }
}


public class readstu
{
    public static void main(String[] args) throws IOException
    {
        File fe = new File("/home/bokket/文档/实验报告/readstu.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fe));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fe));
        students[] stu=new students[5];
        Scanner sc=new Scanner(System.in);

        //写
        for(int i=0;i<stu.length;i++){
            stu[i]=new students(sc.next(),sc.next(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
            oos.writeObject(stu[i]);
        }
        students[] stus=new students[5];
        int cnt=-1;
        try{
            while(true) {
                stus[++cnt]= (students) ois.readObject();
            }
        }
        catch(EOFException | ClassNotFoundException e) {
            System.out.println("read end of the student file!") ;
        }
        for(int i=0;i<stus.length;++i){
            stus[i].setSum(stus[i].getMath()+stus[i].getChinese()+stus[i].getEnglish());
        }
        for(int i=0;i<stus.length-1;++i){
            for(int j=i+1;j<stus.length;++j){
                if(stus[i].getSum()<stus[j].getSum()){
                    students temp=stus[i];
                    stus[i]=stus[j];
                    stus[j]=temp;
                }
            }
        }
        for(int j=0;j<3;j++)
            System.out.println(stus[j]);
    }

}

