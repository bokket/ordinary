import javax.security.auth.Subject;
import java.util.*;
class Student {
    String name;
    int age;
    String study;
    Student()
    {
        name="wxz";
        age=18;
        study="软件工程";
    }
    Student(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    Student(String name,int age,String study)
    {
        this.name=name;
        this.age=age;
        this.study=study;
    }
    String getName()
    {
        return name;
    }
    int getAge()
    {
        return age;
    }
    String getStudy()
    {
        return study;
    }
    void setName(String name)
    {
        this.name=name;
    }
    void setAge(int age)
    {
        this.age=age;
    }
    void setStudy(String study)
    {
        this.study=study;
    }
    void display()
    {
        System.out.println(getName()+getAge()+getStudy());
    }
}

class undergraduate extends Student
{
    String major;
    String degree;
    undergraduate()
    {

    }
    undergraduate(String major,String degree)
    {
        this.major=major;
        this.degree=degree;
    }
    undergraduate(String major,String degree,String name,int age)
    {
        super(name,age);
        this.major=major;
        this.degree=degree;
    }
    String getMajor()
    {
        return major;
    }
    String getDegree()
    {
        return degree;
    }
    void setMajor()
    {
        this.major=major;
    }
    void setDegree()
    {
        this.degree=degree;
    }
    void display()
    {
        System.out.println(major+degree);
    }
}

class postgraduate extends Student
{
    String studydirection;
    postgraduate()
    {

    }
    postgraduate(String studydirection)
    {
        this.studydirection=studydirection;
    }
    postgraduate(String studydirection,String name,int age)
    {
        super(name,age);
        this.studydirection=studydirection;
    }
    String getStudydirection()
    {
        return studydirection;
    }
    void setStudydirection(String studydirection)
    {
        this.studydirection=studydirection;
    }
    void display()
    {
        System.out.println(studydirection);
    }
}

public class TestStudent
{
    public static void main(String[] args)
    {
        undergraduate stu1=new undergraduate("computer science ","undergraduate");
        stu1.display();
        System.out.println("  undergraduate name is "+ stu1.getName());
        System.out.println("  undergraduate age is "+ stu1.getAge());
        System.out.println("  undergraduate major is "+ stu1.getMajor());
        System.out.println("  undergraduate degree is "+ stu1.getDegree());

        postgraduate stu2=new postgraduate("postgraduate");
        stu2.display();
        System.out.println("  postgraduate name is "+stu2.getName());
        System.out.println("  postgraduate age is "+stu2.getAge());
        System.out.println("  postgraduate direction is "+stu2.getStudydirection());
    }
}