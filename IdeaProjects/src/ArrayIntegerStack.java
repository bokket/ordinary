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

public class ArrayIntegerStack1 implements Integer
{
    private char[] a;
    ArrayIntegerStack1()
}
public class ArrayIntegerStack
{
    public static void main(String[] args)
    {

    }
}
