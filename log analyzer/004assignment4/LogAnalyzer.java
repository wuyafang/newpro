package LogAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class LogAnalyzer {
	public static void  main(String[]args) throws IOException, ParseException
	{
		System.out.println("question 1 : which are the most popular pages they provide");
		System.out.println("question 2 : which ip took the most pages from the site");
		System.out.println("question 3 : whether other sites appear to have broken links to this site’s pages");
		System.out.println("question 4 : how much data is being delivered to clients");
		System.out.println("question 5 : the busiest periods over the course of a day, or week, or month");
		System.out.println("input the number of the question from 1 to 5,input EOF to quit");
		
		
		
		
		while(true)
		{
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();	
			String filename = "access.log";
			FileReader fr = new FileReader(filename);
			BufferedReader file = new BufferedReader(fr);
			Map<String,Integer> record_num=new HashMap<String,Integer>();
		if(str.equals("1"))
		{
			String line = file.readLine();
			while(line!=null)
			{
				String word[]=line.split(" ");
				if(record_num.containsKey(word[0])){
					int value=record_num.get(word[0]);
					value++;
					record_num.put(word[0], value);
				}
				else{
					record_num.put(word[0], 1);	
				}		
								
				line = file.readLine();
			}
			
			Iterator<String> iterator = record_num.keySet().iterator();
			Iterator<String> iterator1 =record_num.keySet().iterator();
			Object key1 = iterator1.next();   
			while (iterator.hasNext()) {    
	            Object key2 = iterator.next();    
	            if(record_num.get(key2)>record_num.get(key1))
	            	key1=key2;
	           
	        }		
			System.out.println("The IP that took the most pages "+key1);
			System.out.println("Number: "+record_num.get(key1));
			file.close();
			
		}
		if(str.equals("2"))
		{
			String line = file.readLine();
			while(line!=null)
			{
				String word[]=line.split(" ");
				String word1[]=word[6].split("\\?");
				if(record_num.containsKey(word1[0])){
					int value=record_num.get(word1[0]);
					value++;
					record_num.put(word1[0], value);
				}
				else{
					record_num.put(word1[0], 1);	
				}		
				
				
				line = file.readLine();
			}
			
			Iterator<String> iterator = record_num.keySet().iterator();
			Iterator<String> iterator1 =record_num.keySet().iterator();
			Object key1 = iterator1.next();   
			while (iterator.hasNext()) {    
	            Object key2 = iterator.next();    
	            if(record_num.get(key2)>record_num.get(key1))
	            	key1=key2;
	           
	        }		
			System.out.println("The most popular pages "+key1);
			System.out.println("Number: "+record_num.get(key1));
			file.close();
		}
		if(str.equals("3"))
		{
			String line=file.readLine();
			while(line!=null){
				String word[]=line.split(" ");
				if(word[word.length-2].charAt(0)=='4'){
					String wt=word[word.length-2];
					if(record_num.containsKey(wt)){
						int value=record_num.get(wt);
						value++;
						record_num.put(wt, value);
					}
					else{
						record_num.put(wt, 1);	
					}
					
				}
				line=file.readLine();
			}
			
			Iterator<String> iterator = record_num.keySet().iterator();
			while (iterator.hasNext()) {    
	            Object key2 = iterator.next();    
	            System.out.println("Error type: "+key2+", "+ record_num.get(key2)+" times.");    
	        }		
			file.close();
			
		}
		if(str.equals("4"))
		{
			String line=file.readLine();
			long getnum=0;
			long postnum=0;
			while(line !=null){
				String word[]=line.split(" ");
				if(word[word.length-1].equals("-"))
					
				{
					line=file.readLine();
					continue;
				}
					
				if(word[5].equals("\"POST"))
					postnum=postnum+Integer.parseInt(word[word.length-1]);
				if(word[5].equals("\"GET"))
					getnum=getnum+Integer.parseInt(word[word.length-1]);	
				line=file.readLine();
			}
			System.out.println("The amount of data using GET method : "+getnum+ " bytes");
			System.out.println("The amount of data using POST method : "+postnum+ " bytes");
			file.close();
			
		}
		if(str.equals("5"))
		{
			Map<String,Integer> day=new HashMap<String,Integer>();
			Map<String,Integer> hour=new HashMap<String,Integer>();
			Map<String,Integer> xq=new HashMap<String,Integer>();
			String line=file.readLine();
			while(line!=null){
				String word[]=line.split(" ");
				
				String time=word[3].substring(1);
				String s[]=time.split("/");
				String daytime[]=s[2].split(":");
				if(s[1].equals("Jan"))
					s[1]="01";
				if(s[1].equals("Feb"))
					s[1]="02";
				if(s[1].equals("Mar"))
					s[1]="03";
				if(s[1].equals("Apr"))
					s[1]="04";
				if(s[1].equals("May"))
					s[1]="05";
				if(s[1].equals("Jun"))
					s[1]="06";
				if(s[1].equals("Jul"))
					s[1]="07";
				if(s[1].equals("Aug"))
					s[1]="08";
				if(s[1].equals("Sep"))
					s[1]="09";
				if(s[1].equals("Oct"))
					s[1]="10";
				if(s[1].equals("Nov"))
					s[1]="11";
				if(s[1].equals("Dec"))
					s[1]="12";					
				String datestr=daytime[0]+"-"+s[1]+"-"+s[0];
				SimpleDateFormat formatYMD=new SimpleDateFormat("yyyy-MM-dd");//formatYMD±íÊ¾µÄÊÇyyyy-MM-dd¸ñÊ½
				Calendar calendar = Calendar.getInstance();
		        Date d= new Date();
		        d = formatYMD.parse(datestr);
		        calendar.setTime(d);
		        int xqj = calendar.get(Calendar.DAY_OF_WEEK);		       
		        String dow="";
		        if(xqj==1)
		        	dow="Sunday";
		        if(xqj==2)
		        	dow="Monday";
		        if(xqj==3)
		        	dow="Tuesday";
		        if(xqj==4)
		        	dow="Wednesday";
		        if(xqj==5)
		        	dow="Thursday";
		        if(xqj==6)
		        	dow="Friday";
		        if(xqj==7)
		        	dow="Saturday";	        
				if(day.containsKey(s[0])){
					int value1=day.get(s[0]);
					value1++;
					day.put(s[0], value1);
				}
				else{
					day.put(s[0], 1);	
				}
				if(hour.containsKey(daytime[1])){
					int value=hour.get(daytime[1]);
					value++;
					hour.put(daytime[1], value);
				}
				else{
					hour.put(daytime[1], 1);	
				}	
				if(xq.containsKey(dow)){
					int value=xq.get(dow);
					value++;
					xq.put(dow, value);
				}
				else{
					xq.put(dow, 1);	
				}
				line =file.readLine();
			}
			Iterator<String> iterator = day.keySet().iterator();
			Iterator<String> iterator1 = day.keySet().iterator();
			Object key1 = iterator1.next();   
			while (iterator.hasNext()) {    
	            Object key2 = iterator.next();    
	            if(day.get(key2)>day.get(key1))
	            	key1=key2;
	        }		
			System.out.println("The busiest periods over the course of a month: "+key1+"th of a month.");
			
			iterator = xq.keySet().iterator();
			iterator1 = xq.keySet().iterator();
			key1 = iterator1.next();   
			while (iterator.hasNext()) {    
	            Object key2 = iterator.next();    
	            if(xq.get(key2)>xq.get(key1))
	            	key1=key2;
	        }		
			System.out.println("The busiest periods over the course of a week: "+key1);	
			
			iterator = hour.keySet().iterator();
			iterator1 = hour.keySet().iterator();
			key1 = iterator1.next();   
			while (iterator.hasNext()) {    
	            Object key2 = iterator.next();    
	            if(hour.get(key2)>hour.get(key1))
	            	key1=key2;
	        }		
			System.out.println("The busiest periods over the course of a day: "+key1+":00~"+key1+":59");
			
			file.close();

			
			
			
		}
		if(str.equals("EOF"))
		{
			return;
		}
		
		}
		
		
		
		
	}

}
