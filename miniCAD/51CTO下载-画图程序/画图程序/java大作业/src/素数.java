//1)	打印出100以内的素数:素数又称质数，只能被1和其自身整除的数（除了1）
public class 素数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stu
            for(int i=2;i<=100;i++)
            {
            	int flag=0;
            	for(int j=1;j<=i;j++)
            	{
            		if(i%j==0)
            		   {
            			    flag++;
            			}
            	}
            	if(flag>2)
            	{
            		continue;
            	}
            	else
            	{
            		System.out.println(i);
            	}
            }
	}
}
