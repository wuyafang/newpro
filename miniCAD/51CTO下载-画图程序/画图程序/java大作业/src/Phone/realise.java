package Phone;

public class realise {

	public static void main(String[] args) {
		phone p=new phone();
		p.speak();
		mobile m=new mobile();
		m.speak();
		m.move();
		telephone t=new telephone();
		t.speak();
		t.say();
		nolinephone n=new nolinephone();
		n.speak();
		n.say();
		n.show();
	}
}
