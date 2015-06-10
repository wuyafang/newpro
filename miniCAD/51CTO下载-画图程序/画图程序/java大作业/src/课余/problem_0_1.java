package 课余;

public class problem_0_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v={6,3,5,4,6};
		int n=4;
		int c=10;
		int[] w={2,2,6,5,4};
		int[] x=new int[n+1];
		int[][] m = new int[n+1][c+1];
		
		Knapsack(v, w, c, n, m);
		Traceback(m, w, c, n, x);
		int sum=0;
		for (int i = 0; i <=n; i++) {
			if (x[i]==1) {
				System.out.println("第"+(i+1)+"个物品装入了背包中");
				sum=sum+v[i];
		/*	} else {
				System.out.println("第"+(i+1)+"个物品没有装入背包中");*/
			}
		}
		System.out.println("总价值是："+sum);
		//System.out.println("总价值是："+m[1][c]);
		
	}

/**
 * @param v 物品价值
 * @param w 物品重量
 * @param c 背包容量
 * @param n 物品种类
 * @param m m[i][j]:背包容量为j，可选物品为i,i+1...n时背包问题的最优值
 */
static void Knapsack(int[] v,int[] w,int c,int n,int[][] m){
		int jMax = Math.min(w[n]-1, c);
		for(int j=0;j<=jMax;j++){
			m[n][j]=0;     //此时第n个物品无法装入
		}
		for(int j=w[n];j<=c;j++)	m[n][j]=v[n];	//当第n个能装入时
		for (int i = n-1; i >1; i--) {
			jMax = Math.min(w[i]-1, c);
			for (int j = 0; j < jMax; j++) {
				m[i][j]=m[i+1][j];	//第i个无法装入
			}
			for (int j = w[i]; j <=c; j++) {
				m[i][j]=Math.max(m[i+1][j], m[i+1][j-w[i]]+v[i]);
			}
			m[1][c] = m[2][c];
			if(c>=w[1]){
				m[1][c]=Math.max(m[1][c], m[2][c-w[1]]+v[1]);
			}
		}
	}

static void Traceback(int[][] m,int[] w,int c,int n,int[] x){
	for (int i = 0; i < n; i++) {
		if (m[i][c]==m[i+1][c]) {
			x[i]=0;
		} else {
			x[i]=1;
			c=c-w[i];
		}
		x[n]=(m[n][c]!=0)?1:0;
	}
}
}
