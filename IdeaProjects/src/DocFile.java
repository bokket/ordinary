import java.io.IOException;
import java.util.*;
import java.text.*;
import java.io.*;
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
