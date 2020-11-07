import java.util.*;
class circle2D
{
    private double x,y,radius;
    public circle2D()
    {
        this.x=0;
        this.y=0;
        this.radius=1;
    }
    public circle2D(double x,double y,double radius)
    {
        this.x=x;
        this.y=y;
        this.radius=radius;
    }

    public double getArea() { return Math.PI*radius*radius; }
    public double getPerimeter() { return Math.PI*2*radius; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }

    public boolean contains(double x, double y)
    {
        return Math.pow((x-this.x),2)+Math.pow((y-this.y),2) < Math.pow(this.radius,2);
    }
    public boolean contains(circle2D circle)
    {
        return Math.pow((circle.x-this.x),2)+Math.pow((circle.y-this.y),2) <= Math.abs(circle.radius-this.radius);
    }
    public boolean overlaps(circle2D circle)
    {
        return Math.pow((circle.x-this.x),2)+Math.pow((circle.y-this.y),2) > Math.abs(circle.radius-this.radius) && Math.pow((circle.x-this.x),2)+Math.pow((circle.y-this.y),2) < (circle.radius+this.radius);
    }
}

public class Circle2D
{
    public static void main(String[] args)
    {
        circle2D c1= new circle2D(2,2,5.5);
        System.out.println("c1 area:"+c1.getArea());
        System.out.println("c1 perimeter:"+c1.getPerimeter());

        System.out.println("c1 contains is "+c1.contains(3,3));
        System.out.println("c1 contains is "+c1.contains(new circle2D(4,5,10.5)));
        System.out.println("c1 contains is "+c1.contains(new circle2D(3,5,2.3)));


    }
}
