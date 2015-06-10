//log服务器日志分析
import java.util.*;
import java.io.*;
//public class logAnaysiser {

	/**
	 * @param args
	 */
	//这个类处理一个网址的信息
	public class Access {
		String Host;//服务器地址
		String Time;//访问时间
		String Request;//访问的请求
		String Method;//访问的方法
		//String Content;//请求的内容
		String URL;//访问的网页
		int status;//状态
		int size = 0;//大小
		//String Referer;
		//String UserAgent;
	public Access(String Data){
		StringTokenizer Splitter = new StringTokenizer(Data," \t");
		String skip;
		//127.0.0.1 - - [03/Sep/2012:13:53:07 +0800] "GET / HTTP/1.1" 200 44
		Host = Splitter.nextToken();//127.0.0.1
		skip = Splitter.nextToken();//-
		skip = Splitter.nextToken("[");// - [
		Time = Splitter.nextToken(" \t");//03/Sep/2012:13:53:07 +0800
		skip = Splitter.nextToken("\"");//] "
		Request = Splitter.nextToken();//GET / HTTP/1.1
		
		skip = Splitter.nextToken(" \t");//" 
		status = Integer.parseInt(Splitter.nextToken(" \t"));
		try {
			size = Integer.parseInt(Splitter.nextToken(" \t"));
		} catch(Exception e) {
			size = 0;
		}
		Splitter = new StringTokenizer(Request);
		Method = Splitter.nextToken();
		if(Splitter.hasMoreTokens()){
			skip = Splitter.nextToken();
			URL = Splitter.nextToken();
		}
		
	}
	
	
	public static void main (String[] args) throws Exception {
		// TODO Auto-generated method stub
		int totalRecords;//总的记录数
		totalRecords = 0;
		int index;
		int [] PagesToken;//存放每个ip访问的网页数
		PagesToken = new int[1000000];
		int MaxPagesToken = 0;//访问网站最多的次数
		int [] PopularPage;
		PopularPage = new int[100000];//每个page的访问量
		int MostPopularPage = 0;//最受欢迎的网址
		int temp = 0; //记录这个ip的位置
		int temp1 = 0; //记录最受欢迎的网址的位置
		//try {
			BufferedReader bf = new BufferedReader (new FileReader("access.log"));
			//System.out.println("open file okay!\n");
			String line;
			LinkedList ipList = new LinkedList();//存放不同的ip地址
			LinkedList pageList = new LinkedList();//存放不同的page
			/*line = bf.readLine();
			while(line != null){
				System.out.println(line);
				line = bf.readLine();
				totalRecords++;
			}
			*/
			//logAnaysiser la = new logAnaysiser();
			line = bf.readLine();
			while(line != null){
				Access as = new Access(line);
				//对ip进行处理
				if(!ipList.contains(as.Host)){
					ipList.addLast(as.Host);
					//ipList.
				}
				//统计单个ip的访问的网页数
				else {
					index = ipList.indexOf(as.Host);
					PagesToken[index] ++;
					//for(int i = 0; i < index; i++){	
					//System.out.println(MaxPagesToken[i]);
				}
				//。。.ip处理结束
				//对网页地址进行处理
				//System.out.println(as.Request);
				if(!pageList.contains(as.URL))
					pageList.addLast(as.URL);
				else {
					index = pageList.indexOf(as.URL);
					PopularPage[index]++;
				}
				//...网页处理结束
				/*StringTokenizer Splitter2 = new StringTokenizer(as.Request);
				System.out.println(Splitter2.nextToken());
				System.out.println(Splitter2.nextToken());
				System.out.println(Splitter2.nextToken());
				*/
				//totalRecords--;
				line = bf.readLine();
				
			}
			int i = 0;
			/*
			while(i < ipList.size()){//显示所有不同的ip地址
				System.out.println(""+ipList.get(i));
				i++;
				
			}*/
			//寻找最多访问量的网址
			for(i = 0; i < PopularPage.length; i++){
				if(PopularPage[i] > MostPopularPage){
					MostPopularPage = PopularPage[i];
					temp1 = i;
				}
			}
			System.out.println("The most popular page is "+pageList.get(temp1));
			System.out.println("visited "+ MostPopularPage + " times");
			//寻找最多访问量所对应的ip地址
			for(i = 0; i < PagesToken.length; i++){
				
				if(PagesToken[i] > MaxPagesToken){
					MaxPagesToken = PagesToken[i];
					temp = i;
				}
				
			}
			System.out.println("The ip who took the most pages are "+ipList.get(temp));
			System.out.println(MaxPagesToken+" times");
			/*for(i = 0; i < PagesToken.length; i++){//显示每个ip的访问次数
				if(PagesToken[i] != 0)
					System.out.println(PagesToken[i]);
			}*/
		//} catch(Exception e){
		//	System.out.println("read file exception occurred\n");
		//}
		
		//System.out.println(totalRecords);
		

	}

}
