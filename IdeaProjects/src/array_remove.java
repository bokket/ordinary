import java.util.*;
public class array_remove
{
    public static void main(String[] args)
    {
        int[] newArr=new int[12];
        int[] oldArr={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
        int j=0;
        for(int i=0;i<oldArr.length;i++)
        {
            if(oldArr[i]==0)
                continue;
            else {
                newArr[j]=oldArr[i];
                j++;
            }
        }
        for(int elem:newArr)
            System.out.println(elem);

        System.out.println();

        int[] resultArr=new int[6];
        int k=0;
        for(int i=0;i<newArr.length;i++)
        {
            boolean flag=true;
            for(j=i+1;j<newArr.length;j++)
            {
                if(newArr[i]==newArr[j])
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
            {
                resultArr[k]=newArr[i];
                k++;
            }
        }

        for(int elem:resultArr)
            System.out.println(elem);

    }
}
