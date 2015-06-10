import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.SimpleDateFormat;

public class Analyzer  {
//	public static class Student {
//		String stdname;
//		String classname;
//		int score;
//		public Student(String stdname,String classname,int score){
//			this.stdname=stdname;
//			this.classname=classname;
//			this.score=score;
//		}
//	}
	public static class Log{
		String ip;
		int hour;
		String date;
		String page;
		int mark;
		int datamount;
		public Log(String ip,String date,int hour,String page,int mark,int datamount){
			this.ip=ip;
			this.date=date;
			this.hour=hour;
			this.page=page;
			this.mark=mark;//404
			this.datamount=datamount;
		}
	}
	/**
     * ����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ�
     */
	public static void main(String[] args)
	{	
		String maxip="error";
		String maxpage;
		int maxhour;
		int minhour;
		boolean isbroken;
		int totaldata;
		//�����ļ�
		File file = new File("E:/java_project/log analyzer","access.log");
		ArrayList<Log> records=new ArrayList<Log>();
		//����
		Load("access.log",records);
		//��������ip
		maxip=Findmaxip(records);
		System.out.println("the ip took the most pages from the site is:"+maxip);
		//����������ַ
		maxpage=Findmaxpage(records);
		System.out.println("the most popular page is:"+maxpage);
		//��������ʱ��
		maxhour=Findmaxhour(records);
		System.out.println("the most busiest hour is:"+maxhour);
		//�������ٵ�ʱ��
		minhour=Findminhour(records);
		System.out.println("the most quietest hour is:"+minhour);
		//�Ƿ�broken
		isbroken=Isbroken(records);
		if(isbroken)
			System.out.println("other sites appear to have broken links to this site��s pages");
		else
			System.out.println("other sites doesn't appear to have broken links to this site��s pages");
		//��������
		totaldata=Findtotal(records);
		System.out.println("the total data delivered to clients is "+totaldata+" byte");
		System.exit(0);
	}
	public static String Findmaxip(ArrayList<Log> records)
	{
		int i=0;
		String ip=null;
		String maxip=null;
		Log temp;
		int times=0;
		int maxtime=0;
		//System.out.println("start ip");
		TreeMap<String,Integer> map=new TreeMap<String,Integer>();
		while(i<records.size())
		{
			temp=records.get(i);
			ip=temp.ip;
			if (map.containsKey(ip)) {// ��������ü������ʳ��ֹ�
                times = map.get(ip);// �õ����ʳ��ֵĴ���
                map.put(ip, times + 1);
            } else {
                map.put(ip, 1);// ���򵥴ʵ�һ�γ��֣���ӵ�ӳ����
            }
			i++;
		}
		//System.out.println("finished put");
		Iterator it = map.keySet().iterator();
		int currentkey=0;
		while (it.hasNext()) {
			ip=it.next().toString();
			currentkey=map.get(ip);
			//System.out.println("ip:"+ip);
			//System.out.println("currentkey:"+currentkey);
			if(currentkey>=maxtime){
				maxip=ip;
				maxtime=currentkey;
			}
		}
		//System.out.println("finished ip");
		//System.out.println("maxip:"+maxip);
		return maxip;
	}

	public static String Findmaxpage(ArrayList<Log> records)
	{
		int i=0;
		String page=null;
		String maxpage=null;
		Log temp;
		int times=0;
		int maxtime=0;
//		System.out.println("start page");
		TreeMap<String,Integer> map=new TreeMap<String,Integer>();
		while(i<records.size())
		{
			temp=records.get(i);
			page=temp.page;
			if (map.containsKey(page)) {// ��������ü������ʳ��ֹ�
                times = map.get(page);// �õ����ʳ��ֵĴ���
                map.put(page, times + 1);
            } else {
                map.put(page, 1);// ���򵥴ʵ�һ�γ��֣���ӵ�ӳ����
            }
			i++;
		}
//		System.out.println("finished put");
		Iterator it = map.keySet().iterator();
		int currentkey=0;
		while (it.hasNext()) {
			page=it.next().toString();
			currentkey=map.get(page);
//			System.out.println("page:"+page);
//			System.out.println("currentkey:"+currentkey);
			if(currentkey>=maxtime){
				maxpage=page;
				maxtime=currentkey;
			}
		}
//		System.out.println("finished page");
//		System.out.println("maxpage:"+maxpage);
		return maxpage;
	}
	public static int Findmaxhour(ArrayList<Log> records)
	{
		int i=0;
		int hour;
		int maxhour=0;
		Log temp;
		int times=0;
		int maxtime=0;
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		while(i<records.size())
		{
			temp=records.get(i);
			hour=temp.hour;
			if (map.containsKey(hour)) {// ��������ü������ʳ��ֹ�
                times = map.get(hour);// �õ����ʳ��ֵĴ���
                map.put(hour, times + 1);
            } else {
                map.put(hour, 1);// ���򵥴ʵ�һ�γ��֣���ӵ�ӳ����
            }
			i++;
		}
		Iterator it = map.keySet().iterator();
		int currentkey=0;
		while (it.hasNext()) {
			//objectת����int:��ת����string��ת����int
			hour=Integer.parseInt(it.next().toString());
			currentkey=map.get(hour);
//			System.out.println("hour:"+hour);
//			System.out.println("currentkey:"+currentkey);
			if(currentkey>=maxtime){
				maxhour=hour;
				maxtime=currentkey;
			}
		}
//		System.out.println("maxhour:"+maxhour);
		return maxhour;
	}
	public static int Findminhour(ArrayList<Log> records)
	{
		int i=0;
		int hour;
		int minhour=0;
		Log temp;
		int times=0;
		int mintime=100000000;
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		while(i<records.size())
		{
			temp=records.get(i);
			hour=temp.hour;
			if (map.containsKey(hour)) {// ��������ü������ʳ��ֹ�
                times = map.get(hour);// �õ����ʳ��ֵĴ���
                map.put(hour, times + 1);
            } else {
                map.put(hour, 1);// ���򵥴ʵ�һ�γ��֣���ӵ�ӳ����
            }
			i++;
		}
		Iterator it = map.keySet().iterator();
		int currentkey=0;
		while (it.hasNext()) {
			//objectת����int:��ת����string��ת����int
			hour=Integer.parseInt(it.next().toString());
			currentkey=map.get(hour);
//			System.out.println("hour:"+hour);
//			System.out.println("currentkey:"+currentkey);
			if(currentkey<=mintime){
				minhour=hour;
				mintime=currentkey;
			}
		}
//		System.out.println("minhour:"+minhour);
		return minhour;
	}
	public static boolean Isbroken(ArrayList<Log> records)
	{
		int i=0;
		int mark;
		while(i<records.size())
		{
			Log temp=records.get(i);
			mark=temp.mark;
			if(mark>=400)
				return true;
			i++;
		}
		return false;
	}
	public static int Findtotal(ArrayList<Log> records)
	{
		int i=0;
		int total=0;
		while(i<records.size())
		{
			Log temp=records.get(i);
			total+=temp.datamount;
			i++;
		}
		return total;
	}
	public static void Load(String fileName,ArrayList<Log> records) 
	  {
		 String ip=null;
		 int hour;
		 String date;
		 String page;
		 int mark;
		 int datamount;
		 File file = new File(fileName);
		 BufferedReader reader = null;
		 try {
	            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            int line = 1;
	            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
	           
	            while ((tempString = reader.readLine()) != null) {
	            	//�ָ��ַ���
	            	//10.171.204.201 - - [25/Mar/2012:21:28:47 +0800] "GET /showCourse.php?id=55 HTTP/1.1" 200 12275
	            	//System.out.println("line " + line + ": "+tempString);
	            	int start=0;
	            	int end=0;
	            	start=tempString.indexOf(" -");
	            	ip=tempString.substring(0,start);
	            	//System.out.println("ip:"+ip);
	            	//date
	            	start=tempString.indexOf("[",start);
	            	end=tempString.indexOf("] \"");
	            	String joinDate;
	            	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss"); 
	            	joinDate=tempString.substring(start,end);
	            	String temp[]=joinDate.split(" ");
	            	date=temp[0].substring(1,temp[0].length());
	            	//System.out.println("date:"+date);
	            	String a[]=date.split(":");
	            	//System.out.println("a[1]:"+a[1]);    
	            	hour=Integer.parseInt(a[1]);
	            	//page
	            	start=end+3;
	            	end=tempString.indexOf("\"",start);
	            	page=tempString.substring(start,end);
	            	start=page.indexOf(" ")+1;
	            	page=page.substring(start,page.length());
	            	//System.out.println("page:"+page);
	            	//mark
	            	start=end+2;
	            	end=tempString.indexOf(" ",start);
	            	String m=tempString.substring(start,end);
	            	//System.out.println("mark:"+m);
	            	mark=Integer.parseInt(m);          	
	            	//dataamount
	            	start=end+1;
	            	String d=tempString.substring(start,tempString.length());
	            	//System.out.println("datamount:"+d);
	            	if(d.indexOf("-")!=-1)
	            		datamount=0;
	            	else
	            		datamount=Integer.parseInt(d);
	            	records.add(new Log(ip,date,hour,page,mark,datamount));
	            	 // ��ʾ�к�
	            	line++;
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
		 System.out.println("finished load!");
	    }
	
//	public static void querybystd(ArrayList<Student> records)
//	{
//		System.out.println("querybystd!");
//		int i=0;
//		boolean found=false;
//		Student temp =null;
//	  	String tempString=null;
//	  	int countclass=0;
//	  	int total=0;
//	  	int average=0;
//	  	Scanner in =new Scanner(System.in);
//	  	tempString=in.nextLine(); 
//		while(i<records.size())
//		{
//			temp=records.get(i);
//			if(temp.stdname.equals(tempString))
//			{
//				System.out.println(temp.stdname+","+temp.classname+","+temp.score);
//				countclass++;
//				total+=temp.score;
//				found=true;
//				i++;
//			}
//			else
//			{
//				i++;
//			}
//		}
//		//û���ҵ�
//		if(!found)
//		{
//			System.out.println("û�и�ѧ��");
//		}
//		else
//		{
//			average=total/countclass;
//			System.out.println("�ܷ�Ϊ��	"+total);
//			System.out.println("ƽ����Ϊ:	"+average);
//		}
//	}
//	public static void querybyclass(ArrayList<Student> records)
//	{
//		System.out.println("querybyclass!");
//		int i=0;
//		boolean found=false;
//		Student temp =null;
//
//	  	String tempString=null;
//	  	int countstudent=0;
//	  	int total=0;
//	  	int average=0;
//	  	Scanner in =new Scanner(System.in);
//	  	tempString=in.nextLine(); 
//		while(i<records.size())
//		{
//			temp=records.get(i);
//			if(temp.classname.equals(tempString))
//			{
//				System.out.println(temp.stdname+","+temp.classname+","+temp.score);
//				countstudent++;
//				total+=temp.score;
//				found=true;
//				i++;
//			}
//			else
//			{
//				i++;
//			}
//		}
//		//û���ҵ�
//		if(!found)
//		{
//			System.out.println("û�иÿγ�");
//		}
//		else
//		{
//			average=total/countstudent;
//			System.out.println("ѧ����Ϊ��	"+countstudent);
//			System.out.println("ƽ����Ϊ:	"+average);
//		}
//	}
//	public static void writeCSV(String fileName,ArrayList<Student> records)
//	{
//		System.out.println("write!");
//		int i=0;
//		Student temp =null;	
//		try{
//			File file = new File(fileName);
//			BufferedWriter writer=new BufferedWriter(new FileWriter(file,false));
//			while(i<records.size()){
//				temp=records.get(i);
//				i++;
//				writer.write(temp.stdname+","+temp.classname+","+temp.score);
//				writer.newLine();
//			}
//			writer.close();
//		}
//		catch(FileNotFoundException ee){	
//			ee.printStackTrace();
//		}
//		catch(IOException ee){	
//			ee.printStackTrace();
//		}
//		
//	}
//	  public static void readFileByLines(String fileName,ArrayList<Student> records) 
//	  {
//		  	String stdname=null;
//		  	String classname=null;
//		  	int score=0;
//		  	int i=0;
//	        File file = new File(fileName);
//	        BufferedReader reader = null;
//	        try {
//	            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
//	            reader = new BufferedReader(new FileReader(file));
//	            String tempString = null;
//	            int line = 1;
//	            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
//	            while ((tempString = reader.readLine()) != null) {
//	            	//�ָ��ַ���
//	            	String ss[]=tempString.split(",");
//	            	//���ݿ⸳ֵ
//	            	stdname=ss[0];
//	            	classname=ss[1];
//	            	score=Integer.parseInt(ss[2]);
//	            	records.add(new Student(stdname,classname,score));
////	            	 // ��ʾ�к�
////	            	System.out.println("line " + line + ": "+tempString);
////	            	System.out.println("ss[0]" + ss[0]);
////	            	System.out.println("ss[1]" + ss[1]);
////	            	System.out.println("ss[2]" + ss[2]);
////	                //System.out.println("line " + line + ": " + tempString);
////	                line++;
//	            }
//	            reader.close();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        } finally {
//	            if (reader != null) {
//	                try {
//	                    reader.close();
//	                } catch (IOException e1) {
//	                }
//	            }
//	        }
//	    }
}
