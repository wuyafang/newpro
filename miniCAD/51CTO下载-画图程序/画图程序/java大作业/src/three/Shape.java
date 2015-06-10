package three;
/*1、按照要求使用Java进行编码。
1)	编写一个抽象类Shape，其中有抽象方法getArea（）和getPerimeter（）
2)	在Shape类的基础上派生出Rectangle和Circle类，二者都实现了计算面积的方法getArea（）和计算周长的方法getPerimeter（）；
3)	构造main函数，生成Rectangle和Circle对象，并用Shape类型的变量调用Rectangle和Circle对象的getArea（）和getPerim（）方法。
*/
public abstract class Shape {
	 public abstract double getArea();
	 public abstract double getPerimeter();
}

