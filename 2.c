lic class Complex
{
private double realPart;
private double imaginaryPart;

public Complex(double a, double b)
{
this.realPart = a;
this.imaginaryPart = b;
}

public Complex add(Complex a)
{
Complex result = new Complex(this.realPart + a.realPart, this.imaginaryPart + a.imaginaryPart);//(why?)
return result;
}

public Complex decrease(Complex a)
{
Complex result = new Complex(this.realPart - a.realPart, this.imaginaryPart - a.imaginaryPart);//(why?)
return result;
}

public Complex multiply(Complex a)
{
double newReal = this.realPart*a.realPart - this.imaginaryPart * a.imaginaryPart;
double newImaginary = this.realPart*a.imaginaryPart + this.imaginaryPart * a.realPart;
Complex result = new Complex(newReal, newImaginary);
return result;
}

public Complex divide(Complex a)
{
Complex conjugate = new Complex(this.realPart, -this.imaginaryPart);
Complex multiplication = conjugate.multiply(a);
multiplication.realPart /= this.realPart*this.realPart + this.imaginaryPart * this.imaginaryPart;
multiplication.imaginaryPart /= this.realPart*this.realPart + this.imaginaryPart * this.imaginaryPart;
return multiplication;
}

public String toString()
{
String show = this.realPart + " + " + this.imaginaryPart + "i";
return show;
}

public static void main(String [] args)
{
Complex a = new Complex (2, 3);
Complex b = new Complex (1,1);
System.out.println((a.add(b)).toString());
System.out.println((a.decrease(b)).toString());
System.out.println((a.multiply(b)).toString());
System.out.println((a.divide(b)).toString());

}

}
