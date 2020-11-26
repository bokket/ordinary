import java.util.*;

interface IntegerStack
{
    public Integer push(Integer item);
//如果item为null，则不入栈直接返回null。如果栈满，也返回null。如果插入成功，返回item。

    public Integer pop();   //出栈，如果为空，则返回null。出栈时只移动栈顶指针，相应位置不置为null
    public Integer peek();  //获得栈顶元素，如果为空，则返回null.
    public boolean empty(); //如果为空返回true
    public int size();      //返回栈中元素个数
}

class ArrayIntegerStack1 implements IntegerStack
{
    Integer a[];
    int size=0;
    ArrayIntegerStack1(int n)
    {
        a=new Integer[n];
    }
    public Integer push(Integer item)
    {
        if(item==null)
            return null;
        if(size==a.length)
            return null;
        a[size]=item;
        size++;
        return item;
    }
    public Integer pop();   //出栈，如果为空，则返回null。出栈时只移动栈顶指针，相应位置不置为null
    {
        if(!empty())
            return null;
        size--;
        return a[size];
    }
    public Integer peek();  //获得栈顶元素，如果为空，则返回null.
    {
        if(!empty())
            return null;
        return a[size-1];
    }
    public boolean empty(); //如果为空返回true
    {
        if(size==0)
            return false;
        else
            return true;
    }
    public int size();      //返回栈中元素个数
    {
        return size;
    }
    public String toString()
    {
        return Array.toString(a);
    }
}
public class ArrayIntegerStack
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int n;
        n=input.nextInt();
        ArrayIntegerStack1 A=new ArrayIntegerStack1(n);
        int m;
        for(int i=0;i<m;i++)
            System.out.println(A.push(input.nextInt()));


        System.out.println(A.peek()+","+A.empty()+","+A.size());
        String s=A.toString();
        System.out.println(A.toString());
        int cnt=input.nextInt();

        for(int i=0;i<cnt;i++)
        {
            System.out.println(A.pop());
        }
        System.out.println(A.peek()+","+A.empty()+","+A.size());
        System.out.println(s);
    }
}
