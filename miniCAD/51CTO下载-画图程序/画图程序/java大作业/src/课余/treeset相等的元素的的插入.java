package ����;

import java.util.TreeSet;

public class treeset��ȵ�Ԫ�صĵĲ��� {
	private int count;
	private int number;
	
	public void set(int cou,int num){
		this.count=cou;
		this.number=num;
	}
	
    public boolean equals(Object obj) {//equals������д
    	treeset��ȵ�Ԫ�صĵĲ��� r = (treeset��ȵ�Ԫ�صĵĲ���) obj;
    	if(this.count==r.count)
    		return true;
    	else
    		return false;
        }
    
    
	public int compareTo(Object obj) {//compareTo������д
		treeset��ȵ�Ԫ�صĵĲ��� r = (treeset��ȵ�Ԫ�صĵĲ���) obj;
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
		treeset��ȵ�Ԫ�صĵĲ��� e1=new treeset��ȵ�Ԫ�صĵĲ���();
		treeset��ȵ�Ԫ�صĵĲ��� e2=new treeset��ȵ�Ԫ�صĵĲ���();
		e1.set(2, 9);
		e2.set(2, 1);
		TreeSet t=new TreeSet();
		System.out.println(t.add(e1));
		System.out.println(t.add(e2));//�������һ�����ԣ�����ӵڶ���ʱ�׳��쳣��
		
		
	}

}
