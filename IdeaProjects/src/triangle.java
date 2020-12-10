import java.util.*;
public class triangle
{
    private double side1, side2, side3;
    public triangle(double side1, double side2, double side3) throws TriangleException
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1)
        {
            throw new TriangleException();
        }
    }
}
class TriangleException extends Exception
{
    public TriangleException()
    {
        System.out.println("三角形三条边的长度不合法");
    }
}