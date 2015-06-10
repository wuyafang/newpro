//log��������־����
import java.util.*;
import java.io.*;
//public class logAnaysiser {

	/**
	 * @param args
	 */
	//����ദ��һ����ַ����Ϣ
	public class Access {
		String Host;//��������ַ
		String Time;//����ʱ��
		String Request;//���ʵ�����
		String Method;//���ʵķ���
		//String Content;//���������
		String URL;//���ʵ���ҳ
		int status;//״̬
		int size = 0;//��С
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
		int totalRecords;//�ܵļ�¼��
		totalRecords = 0;
		int index;
		int [] PagesToken;//���ÿ��ip���ʵ���ҳ��
		PagesToken = new int[1000000];
		int MaxPagesToken = 0;//������վ���Ĵ���
		int [] PopularPage;
		PopularPage = new int[100000];//ÿ��page�ķ�����
		int MostPopularPage = 0;//���ܻ�ӭ����ַ
		int temp = 0; //��¼���ip��λ��
		int temp1 = 0; //��¼���ܻ�ӭ����ַ��λ��
		//try {
			BufferedReader bf = new BufferedReader (new FileReader("access.log"));
			//System.out.println("open file okay!\n");
			String line;
			LinkedList ipList = new LinkedList();//��Ų�ͬ��ip��ַ
			LinkedList pageList = new LinkedList();//��Ų�ͬ��page
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
				//��ip���д���
				if(!ipList.contains(as.Host)){
					ipList.addLast(as.Host);
					//ipList.
				}
				//ͳ�Ƶ���ip�ķ��ʵ���ҳ��
				else {
					index = ipList.indexOf(as.Host);
					PagesToken[index] ++;
					//for(int i = 0; i < index; i++){	
					//System.out.println(MaxPagesToken[i]);
				}
				//����.ip�������
				//����ҳ��ַ���д���
				//System.out.println(as.Request);
				if(!pageList.contains(as.URL))
					pageList.addLast(as.URL);
				else {
					index = pageList.indexOf(as.URL);
					PopularPage[index]++;
				}
				//...��ҳ�������
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
			while(i < ipList.size()){//��ʾ���в�ͬ��ip��ַ
				System.out.println(""+ipList.get(i));
				i++;
				
			}*/
			//Ѱ��������������ַ
			for(i = 0; i < PopularPage.length; i++){
				if(PopularPage[i] > MostPopularPage){
					MostPopularPage = PopularPage[i];
					temp1 = i;
				}
			}
			System.out.println("The most popular page is "+pageList.get(temp1));
			System.out.println("visited "+ MostPopularPage + " times");
			//Ѱ��������������Ӧ��ip��ַ
			for(i = 0; i < PagesToken.length; i++){
				
				if(PagesToken[i] > MaxPagesToken){
					MaxPagesToken = PagesToken[i];
					temp = i;
				}
				
			}
			System.out.println("The ip who took the most pages are "+ipList.get(temp));
			System.out.println(MaxPagesToken+" times");
			/*for(i = 0; i < PagesToken.length; i++){//��ʾÿ��ip�ķ��ʴ���
				if(PagesToken[i] != 0)
					System.out.println(PagesToken[i]);
			}*/
		//} catch(Exception e){
		//	System.out.println("read file exception occurred\n");
		//}
		
		//System.out.println(totalRecords);
		

	}

}
