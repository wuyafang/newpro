package ����;

public class hah {
		int getSum()//�÷�������ʮ��������ram >=0&& ram <=10���ĺ�
		{
			int sum=0;
			for(int i=0;i<10;i++)
			{
			int ram=(int) (Math.random()*11);
			sum=sum+ram;
			System.out.print("   ram="+ram);
			}
			return sum;	
		}

		public static void main(String[] args) {
			hah debug=new hah();	
			int result=	debug.getSum();
	
			boolean isBig=false;
			if(result>=50)//�������ʮ������Ӵ���50��Ϊ�󣬷���ΪС��
			{		isBig=true;			}	
			System.out.println("\n reslut="+result);
			System.out.println("isBig="+isBig);
			
		}


	}
