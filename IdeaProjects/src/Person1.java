import java.util.*;
class person
{
    private String name;
    private String gender;
    private int age;
    public person(String name, String gender, int age)
    {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    @Override
    public String toString()
    {
        return "Person{" + "name='" + name + '\'' + ", gender='" + gender + '\'' + ", age=" + age + '}';
    }
}

public class Person1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        person[] people=new person[2];
        String name,gender;
        int age;
        for (int i=0;i<2;++i)
        {
            System.out.println("请输入第" + (i + 1) + "个人的信息");
            System.out.println("请输入姓名：");
            name = input.nextLine();
            System.out.println("请输入性别：");
            gender = input.nextLine();
            while ((!"male".equals(gender)) && (!"female".equals(gender))) {
                System.out.println("性别输入有误,请重新输入！（“male”或“female”）");
                gender = input.nextLine();
            }
            System.out.println("请输入年龄：");
            age = input.nextInt();
            while (age < 0 || age > 120) {
                System.out.println("年龄输入有误,请重新输入！（0~120之间）");
                age = input.nextInt();
            }

            input.nextLine();
            people[i]=new person(name, gender, age);
        }
        for (person elem:people)
        {
            System.out.println(elem.toString());
        }

    }

}
/*
class person
{
    public String name,sex,age;
    person(String name_,String sex_,String age_)
    {
        name=name_;
        sex=sex_;
        age=age_;
    }
}
public class Person
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        throws Exception
        {

            person p1=new person();
            person p2=new person();
            System.out.println("请输入姓名:");
            p1.name=input.next();
            System.out.println("请输入性别:");
            while(1)
            {
                p1.sex=input.next();
                if(p1.sex=="man")
                    break;
                else
                    System.out.println("性别输入有误，请重新输入！");
            }
            System.out.println("请输入年龄:");
            while(1)
            {
                p1.age=input.next();
                if(p1.age>=0&&p1.age<=120)
                    break;
                else
                    System.out.println("年龄输入有误，请重新输入！");
            }
            //输出第一个人的信息
            System.out.println("第一个人的姓名:"+p1.name+"\n性别"+p1.sex+"\n年龄："+p1.age);
            //输入p2的信息
            System.out.println("请输入姓名:");
            p2.name=input.next();
            System.out.println("请输入性别:");
            while(1)
            {
                p2.sex=System.in.read();
                if(p2.sex=="female")
                    break;
                else
                    System.out.println("性别输入有误，请重新输入！");
            }
            System.out.println("请输入年龄:");
            while(1)
            {
                p2.age=System.in.read();
                if(p2.age>=0&&p2.age<=120)
                    break;
                else
                    System.out.println("年龄输入有误，请重新输入！");
            }
            //输出第二个人的信息
            System.out.println("第二个人的姓名:"+p2.name+"\n性别"+p2.sex+"\n年龄："+p2.age);
        }
    }
}
*/