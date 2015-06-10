package 课余;

import java.util.Arrays;

public class 输出数组的Arrays方法 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={2,3,6,9,5,2};
		System.out.print(a.toString());//输出乱码
		System.out.print(Arrays.toString(a));//输出：[2, 3, 6, 9, 5, 2]
	}

}
