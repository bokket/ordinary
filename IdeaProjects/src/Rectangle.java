import java.util.Scanner;
class rectangle
{
    private double width=1, height=1;
    rectangle()
    {

    }
    rectangle(double m_w,double m_h)
    {
        width=m_w;
        height=m_h;
    }
    public double getArea()
    {
        return width*height;
    }
    public double getPerimeter()
    {
        return (width+height)*2;
    }
}

/* 你的代码将被嵌入到这里 */
public class Rectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double w = input.nextDouble();
        double h = input.nextDouble();
        rectangle myRectangle = new rectangle(w, h);
        System.out.println(myRectangle.getArea());
        System.out.println(myRectangle.getPerimeter());
        input.close();
    }
}