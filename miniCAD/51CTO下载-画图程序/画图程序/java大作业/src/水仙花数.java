//水仙花数是指一个n位数（n>=3)，它的每个位上的数字的n次幂之和等于它本身。如153,370,371,407.
public class 水仙花数 {

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
