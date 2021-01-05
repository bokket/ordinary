import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import java.util.*;
public class copyFile
{
        public static void main(String[] args) throws IOException
        {
            InputStream is = null;
            BufferedInputStream bis = null;
            OutputStream os = null;
            BufferedOutputStream bos = null;
            try{
                is = new FileInputStream("/home/bokket/文档/实验报告/test.txt");
                bis = new BufferedInputStream(is);
                os = new FileOutputStream("/home/bokket/文档/实验报告/test2.txt");
                bos = new BufferedOutputStream(os);
                while(bis.available()>0){
                    bos.write(bis.read());
                }
                bos.flush();
                System.out.println("succeed");
            } catch (FileNotFoundException e) {
                System.err.println("文件不存在！");
            }
        }
}
    /*
    public static void copyUsingFileStreams(File source,File dest) throws IOException
    {
        FileInputStream input=null;
        FileOutputStream output=null;
        try
        {
            input=new FileInputStream(source);
            output=new FileOutputStream(dest);
            byte[] buf=new byte[1024];
            int bytesRead;
            while((bytesRead=input.read(buf))!=-1)
            {
                output.write(buf,0,bytesRead);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(output != null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }*/
/*
    public static void main(String[] args) throws IOException
    {
        File f1=new File("");
        System.out.println("this");
        File f2=new File("dest.txt");
        FileInputStream input=null;
        FileOutputStream output=null;
        try
        {
            input=new FileInputStream(f1);
            output=new FileOutputStream(f2);
            byte[] buf=new byte[1024];
            int bytesRead;
            while((bytesRead=input.read(buf))!=-1)
            {
                output.write(buf,0,bytesRead);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(output != null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}*/
