package three;

public class Rectangle extends Shape{
	 private double length;
	 private double width;
	 public void set(double len,double wid)
	 {
		 this.length=len;
		 this.width=wid;
	 }
	 public double getArea()
	 {
		 return length*width;
	 }
	 public double getPerimeter()
	 {
		 return 2*length*width;
	 }
}