package 课余;

import java.util.TreeSet;

public class treeset相等的元素的的插入 {
	private int count;
	private int number;
	
	public void set(int cou,int num){
		this.count=cou;
		this.number=num;
	}
	
    public boolean equals(Object obj) {//equals方法重写
    	treeset相等的元素的的插入 r = (treeset相等的元素的的插入) obj;
    	if(this.count==r.count)
    		return true;
    	else
    		return false;
        }
    
    
	public int compareTo(Object obj) {//compareTo方法重写
		treeset相等的元素的的插入 r = (treeset相等的元素的的插入) obj;
		if (this.number > r.number) {
			return 1;
		}
		else if (this.number == r.number) {
			return 0;
		}
		else {
			return -1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treeset相等的元素的的插入 e1=new treeset相等的元素的的插入();
		treeset相等的元素的的插入 e2=new treeset相等的元素的的插入();
		e1.set(2, 9);
		e2.set(2, 1);
		TreeSet t=new TreeSet();
		System.out.println(t.add(e1));
		System.out.println(t.add(e2));//单独添加一个可以，当添加第二个时抛出异常。
		
		
	}

}
