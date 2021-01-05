import java.io.*;
import java.util.Random;

public class readnum
{
    public static void main(String[] args) throws IOException{
        File file=new File("/home/bokket/文档/实验报告/readnum.txt");
        DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        int i=0;
        int N=10000;
        Random rd=new Random();
        while(i<5000){
            int num=rd.nextInt(N);
            i++;
            dos.writeInt(num);
            dos.flush();
        }
        System.out.println(i);
        dos.close();
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        while(true){
            System.out.println(dis.readInt());}
    }
}