import java.io.*;
public class FileDemo{
    public static void main(String args[])throws IOException{
        method_path();
        method_create();
        method_get();
        method_list();
        new FileDemo().method_FileterList();
    }

    public static void method_path() throws IOException {
        File f = new File("/home/bokket/文档\n");
        sys(f.getCanonicalFile());
        sys(f.getAbsoluteFile());
    }

    public static void method_create()throws IOException{
        File f = new File("xy.txt");
        File f1 = new File("abc");
        f1.mkdir();
        sys("create:"+f.createNewFile());
    }
    public static void method_get()throws IOException{
        File f = new  File("xy.txt");
        sys("getParent:"+f.getParent());
    }

    public static void method_list(){
        File f = new File("/home/bokket/文档\n");
        File[] files = f.listFiles();
        for(File file : files){
            sys("list盘符："+file);
        }
    }
    public void method_FileterList(){
        File f = new File("/home/bokket/文档\n");
        String []fileNames = f.list(new FilenameFilter(){
            public boolean accept(File dir,String name){
                return name.endsWith(".java");
            }
        });
        for(String fileName:fileNames){
            sys("--->"+fileName);
        }
    }
    public static void sys(Object object){
        System.out.println(object);
    }
}