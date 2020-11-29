import java.util.*;


import java.util.*;

interface IntegerStack{
    public Integer push(Integer item);
    public Integer pop();
    public Integer peek();
    public boolean empty();
    public int size();
}

class ArrayInteger implements IntegerStack{
    Integer A[];
    int Max,Size = 0;
    public ArrayInteger(int n) {
        A = new Integer[n];
        Max = n;
    }
    public Integer push(Integer item) {
        if(item == null)
            return null;
        else if(Size == Max)
            return null;
        else {
            A[Size] = item;
            Size++;
            return item;
        }
    }

    public Integer pop() {
        if(Size == 0)
            return null;
        Size--;
        return A[Size];
    }

    public Integer peek() {
        if(Size == 0)
            return null;
        else
            return A[Size - 1];
    }

    public boolean empty() {
        if(Size == 0)
            return true;
        else
            return false;
    }

    public int size() {
        return Size;
    }

    public String toString() {
        return Arrays.toString(A);
    }

}
public class ArrayIntegerStack
{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayInteger A = new ArrayInteger(n);
        int m = in.nextInt();
        for(int i = 0;i < m;i++) {
            System.out.println(A.push(in.nextInt()));
        }

        System.out.println(A.peek() + "," + A.empty() + "," + A.size());
        System.out.println(A.toString());

        int x = in.nextInt();
        for(int i = 0;i < x;i++) {
            System.out.println(A.pop());
        }

        System.out.println(A.peek() + "," + A.empty() + "," + A.size());
        System.out.println(A.toString());
        in.close();
    }

}
/*
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
    Integer A[];
    int size=0;
    ArrayIntegerStack1(int n)
    {
        A=new Integer[n];
    }
    public Integer push(Integer item)
    {
        if(item==null)
            return null;
        if(size==A.length)
            return null;
        A[size]=item;
        size++;
        return item;
    }
    public Integer pop()   //出栈，如果为空，则返回null。出栈时只移动栈顶指针，相应位置不置为null
    {
        if(!empty())
            return null;
        size--;
        return A[size];
    }
    public Integer peek()  //获得栈顶元素，如果为空，则返回null.
    {
        if(!empty())
            return null;
        return A[size-1];
    }
    public boolean empty() //如果为空返回true
    {
        if(size==0)
            return true;
        else
            return false;
    }
    public int size()      //返回栈中元素个数
    {
        return size;
    }
    public String toString()
    {
        return Arrays.toString(A);
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

        int m=input.nextInt();
        for(int i=0;i<m;i++)
            System.out.println(A.push(input.nextInt()));


        System.out.println(A.peek()+","+A.empty()+","+A.size());


        System.out.println(A.toString());

        int cnt=input.nextInt();
        for(int i=0;i<cnt;i++)
        {
            System.out.println(A.pop());
        }
        System.out.println(A.peek()+","+A.empty()+","+A.size());
        System.out.println(A.toString());
    }
}*/