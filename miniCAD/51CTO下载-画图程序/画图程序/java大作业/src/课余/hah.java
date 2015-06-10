package 课余;

public class hah {
		int getSum()//该方法返回十个整数（ram >=0&& ram <=10）的和
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
			if(result>=50)//如果是这十个数相加大于50则为大，否则为小。
			{		isBig=true;			}	
			System.out.println("\n reslut="+result);
			System.out.println("isBig="+isBig);
			
		}


	}
