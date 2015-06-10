package three;

public class realise {
	public static void main(String[] args) {
		Rectangle rec=new Rectangle();
		Circle cir=new Circle();
		rec.set(2.0,3.0);
		cir.set(4.0);
	
		Shape s1=rec;
		Shape s2=cir;
		System.out.println(s1.getArea());
		System.out.println(s1.getPerimeter());
		System.out.println(s2.getArea());
		System.out.println(s2.getPerimeter());
	}
}
