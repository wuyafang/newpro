//1)	��ӡ��100���ڵ�����:�����ֳ�������ֻ�ܱ�1����������������������1��
public class ���� {

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
