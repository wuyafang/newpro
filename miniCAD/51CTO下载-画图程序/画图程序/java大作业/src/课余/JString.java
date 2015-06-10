package ฟฮำเ;

public class JString {
public static void operate(String x,String y){
	x.concat(y);
	y=x;
}
public static void main(String args[]){
	String a="A";
	String b="B";
	operate(a,b);
	System.out.println(a+"."+b);
}

}
