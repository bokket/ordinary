import java.io.IOException;
import java.util.*;
import java.text.*;
import java.io.*;

public class DocFile
{
    public static void main(String[] args) throws IOException {
        //File file= new File("/home/bokket/文档");
        File file=new File("/home/bokket/文档/实验报告");

        File allFile[] = file.listFiles();
        //获取目录下所有文件的名称
        for(File f : allFile)
        {
            System.out.println(f.getName());
        }
        //利用数组输出
        File[] doc = file.listFiles(new FChoose("doc"));

        File[] docx = file.listFiles(new FChoose("docx"));
        System.out.println("==================");
        //将数组中的东西存到文件中

        FileWriter fw=new FileWriter("/home/bokket/文档/实验报告/test.txt");
        for(File f : doc){
            fw.write(f.getName());
            fw.write("\n");
        }
        for(File f : docx){
            fw.write(f.getName());
            fw.write("\n");
        }

        fw.close();
        FileReader fd=new FileReader("/home/bokket/文档/实验报告/test.txt");
        BufferedReader br = new BufferedReader(fd);
        String  line = br.readLine();
        while(line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        if(fd != null) {
            try {
                fd.close();
            }catch(Exception e) {
                e.toString();
            }
        }

    }
}
class FChoose implements FilenameFilter {
    String extension = ".";
    public FChoose(String type){
        extension +=type;
    }
    public boolean accept(File dir, String name) {
        return name.endsWith(this.extension);
    }
}


/*
public class DocFile
{
    ArrayList<File> list=new ArrayList<File>();
    public void listFile(File f) throws IOException
    {
        String filename=f.getName();
        if(f.isFile() && filename.substring(filename.lastIndexOf(.)+1).equals("doc") && filename.substring(filename.lastIndexOf(.)+1).equals("docx"))
        {
            list.add(f);
        }
        else
        {
            File[] files=f.listFiles();
            for(File ff:files)
                listFile(ff);
        }
    }
    public void writeToFile() throws IOException
    {
        FileWriter writer=new FileWriter("file.txt");
        for(int i=0;i<list.size();i++)
        {
            writer.write(list.get(i).getName());
        }
        writer.close();
    }
    public static void main(String[] args)
    {
        File f=null;
        f=new File();
    }
}*/
