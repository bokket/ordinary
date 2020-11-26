import java.util.*;
import java.util.concurrent.Callable;
class Complex
{
    double realpart;
    double imaginarypart;
    Complex()
    {

    }
    Complex(double realpart,double imaginarypart)
    {
        this.realpart=realpart;
        this.imaginarypart=imaginarypart;
    }
    Complex add(Complex A)
    {
        Complex result=new Complex(this.realpart+A.realpart,this.imaginarypart+A.imaginarypart);
        return result;
    }
    Complex decrease(Complex A)
    {
        Complex result=new Complex(this.realpart-A.realpart,this.imaginarypart-A.imaginarypart);
        return result;
    }
    Complex multiply(Complex A)
    {
        double newreal=this.realpart*A.realpart - this.imaginarypart*A.imaginarypart;
        double newimaginary=this.realpart*A.imaginarypart + this.imaginarypart*A.realpart;

        Complex result=new Complex(newreal,newimaginary);
        return result;
    }
    Complex divide(Complex A)
    {
        Complex con=new Complex(this.realpart,this.imaginarypart);
        Complex mult=con.multiply(A);
        mult.realpart /= this.realpart*this.realpart+this.imaginarypart*this.imaginarypart;
        mult.imaginarypart /= this.realpart*this.realpart+this.imaginarypart*this.imaginarypart;
        return mult;
    }
    public String toString()
    {
        String show= this.realpart + "+" +this.imaginarypart + "i";
        return show;
    }
}
public class ComplexTest {
    public static void main(String[] args)
    {
        Complex a= new Complex(2,3);
        Complex b= new Complex(1,1);
        System.out.println((a.add(b)).toString());
        System.out.println((a.decrease(b)).toString());
        System.out.println((a.multiply(b)).toString());
        System.out.println((a.divide(b)).toString());
    }
}
