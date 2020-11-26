import java.util.*;
class Point
{
    double x;
    double y;
    Point()
    {

    }
    Point(double x,double y)
    {
        this.x=x;
        this.y=y;
    }
    void setX(double x)
    {
        this.x=x;
    }
    void setY(double y)
    {
        this.y=y;
    }
    double getX()
    {
        return x;
    }
    double getY()
    {
        return y;
    }
    double distance(Point b)
    {
        return Math.sqrt( (this.x-b.x)*(this.x-b.x) + (this.y-b.y)*(this.y-b.y) );
    }
    boolean equals(Point b)
    {
        double c=( (this.x-b.getX())*(this.x-b.getX()) + (this.y-b.getY())*(this.y-b.getY()) );
        if(c==0)
        {
            return true;
        }
        else
            return false;
    }
}
class Point3D extends Point
{
    double z;
    Point3D()
    {

    }
    Point3D(double z)
    {
        this.z=z;
    }
    Point3D(double z,double x,double y) {
        super(x, y);
        this.z = z;
    }
    double getZ()
    {
        return z;
    }
    void setZ(double z)
    {
        this.z=z;
    }
    double distance(Point3D b)
    {
        return Math.sqrt( (this.x-b.x)*(this.x-b.x) + (this.y-b.y)*(this.y-b.y) + (this.z-b.z)*(this.z-b.z) );
    }
    boolean equals(Point3D b)
    {
        double c=( (this.x-b.x)*(this.x-b.getX()) + (this.y-b.getY())*(this.y-b.getY()) + (this.z-b.getZ())*(this.z-b.getZ()) );
        if(c==0)
        {
            return false;
        }
        else
            return true;
    }
}
public class Testpoint
{
    public static void main(String[] args)
    {
        Point3D A=new Point3D();
        Point3D B=new Point3D(10,50,60);

        A.setZ(5);
        A.setX(10);
        A.setY(20);
        System.out.println("B:("+B.getX()+","+B.getY()+","+B.getZ()+")");
        System.out.println("A:("+A.getX()+","+A.getY()+","+A.getZ()+")");



        boolean flag=A.equals(B);
        if(flag) {
            System.out.println("A---->B:");
            System.out.println(A.distance(B));
        }
        else
            System.out.println("A==B");
    }
}
