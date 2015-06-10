package Teacher;

import java.util.Arrays;
/*在实验2中所实现的Teacher类的基础上，修改Teacher类的代码，
 * 要求：由多个Teacher对象所形成的数组可以使用Arrays.sort方法进行排序
 * （编号由低到高排序）。
 */




public class Teacher implements Comparable{
	private int no;
	private String name;
	private String seminary;



	public void setTeacher(int No,String Name,String sem)
	{
		this.no=No;
		this.name=Name;
		this.seminary=sem;
	}

	public int compareTo(Object o) {//按编号排序//必须重写compareTo方法
		Teacher t = (Teacher) o;
		if (no < t.no)
			return -1;
		if (no > t.no)
			return 1;
		return 0;
	}
//	public int compareTo(Object o) {//按姓名排序
//		Teacher t = (Teacher) o;
//		return name.compareTo(t.name.substring(0));//调用String类的compare()和substring()方法。
//	}

	public String toString(){
		return "编号为"+this.no+"姓名为"+this.name+"的"+this.seminary+"学院老师";	
	}

	public static void main(String[] arg){
		Teacher[]s=new Teacher[3];
		s[0]=new Teacher();//必须初始化
		s[1]=new Teacher();
		s[2]=new Teacher();
		s[0].setTeacher(2,"王浩","信息学院");
		s[1].setTeacher(3,"曹波","地质学院");
		s[2].setTeacher(1,"李强","测绘学院");
		Arrays.sort(s);
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}

	}
}
