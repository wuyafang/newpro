package ����;

import java.io.*;
/**
��1��ÿ�ζ�һ��byte����ô��
��2��Ϊ�����ĵĶ��ǡ�������
*/
public class Stream {
  public static void main(String[] args) {
    int b = 0;
    FileInputStream in = null;
    try {
      in = new FileInputStream("F:\\������ѧ�ڴ�\\Java�������\\chapter 8\\TestFileInputStream.java");
    } catch (FileNotFoundException e) {
      System.out.println("�Ҳ���ָ���ļ�"); 
      System.exit(-1);
    }
    
    try {
      long num = 0;byte[] a=new byte[2];
      while((b=in.read(a))!=-1){  //��ȡһ��byte
        System.out.print((char)b); 
        num++;
      }
      in.close();  
      System.out.println();
      System.out.println("����ȡ�� "+num+" ���ֽ�");
    } catch (IOException e1) {
      System.out.println("�ļ���ȡ����"); 
    }
  }
}
