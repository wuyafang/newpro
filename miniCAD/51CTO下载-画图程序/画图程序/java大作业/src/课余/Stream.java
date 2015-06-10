package 课余;

import java.io.*;
/**
（1）每次读一个byte可以么？
（2）为何中文的都是“？”？
*/
public class Stream {
  public static void main(String[] args) {
    int b = 0;
    FileInputStream in = null;
    try {
      in = new FileInputStream("F:\\大三上学期答案\\Java程序设计\\chapter 8\\TestFileInputStream.java");
    } catch (FileNotFoundException e) {
      System.out.println("找不到指定文件"); 
      System.exit(-1);
    }
    
    try {
      long num = 0;byte[] a=new byte[2];
      while((b=in.read(a))!=-1){  //读取一个byte
        System.out.print((char)b); 
        num++;
      }
      in.close();  
      System.out.println();
      System.out.println("共读取了 "+num+" 个字节");
    } catch (IOException e1) {
      System.out.println("文件读取错误"); 
    }
  }
}
