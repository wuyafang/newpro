package three;

public class Circle extends Shape{
private double r;
final double PI=3.14;
public void set(double rr)
{
	this.r=rr;
}
public double getArea()
{
	return PI*r*r;
}
public double getPerimeter()
{
	return 2*PI*r;
}
}
