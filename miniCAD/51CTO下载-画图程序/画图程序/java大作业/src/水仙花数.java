//ˮ�ɻ�����ָһ��nλ����n>=3)������ÿ��λ�ϵ����ֵ�n����֮�͵�����������153,370,371,407.
public class ˮ�ɻ��� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i;
		for(i=100;i<1000;i++)
		{
			if((Math.pow(i/100, 3)+Math.pow(i%100/10,3)+Math.pow(i%100%10,3))==i)
				System.out.println(i);
		}
	}
}
