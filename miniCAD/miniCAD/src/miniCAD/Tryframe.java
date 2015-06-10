package miniCAD;
import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.*;   
import javax.swing.event.*;   

import java.awt.*;   
import java.awt.event.*;   
import java.awt.geom.*;   
import java.awt.image.BufferedImage;
import java.util.*;   

import javax.swing.filechooser.FileFilter;   

import java.io.*;   

public class Tryframe extends JFrame implements MouseListener,ItemListener,KeyListener,ActionListener,MouseMotionListener{
	public  static Color color=Color.black;//默认颜色为黑色
	//框架    frame
	public static JFrame frame,f2;
	public static Dialog d;
	//菜单条 jmb
	public static JMenuBar jmb=new JMenuBar(); 
	//菜单
	public static JMenu jm1,jm2,jm3,jm4,jm5;
	//菜单项
	public static JMenuItem fo,fc,fcr;
	public static JMenuItem line1,rect1,oval1,circle1;
	public static JMenuItem ccolor;
	public static JMenuItem csize;
	public static JMenuItem text,zihao;
	static Panel p;
	public static  Choice c,cfont;
	public  static  Label l;
	static Thread t=new Thread(); 
	int font=10;
	public static String dir;
	public static int flag=0;//line:1,rect:2,oval:3,circle:4,text:5
	int x1,y1,x2,y2; 
	int width = 550;  
    int height =600;
    //文件
    FileDialog dialogopen = new FileDialog(frame,"选择需要打开的文件",FileDialog.LOAD);
	FileDialog dialogsave = new FileDialog(frame,"选择保存文件的路径",FileDialog.SAVE);
	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	Graphics2D g1 = (Graphics2D)image.getGraphics();
	Graphics2D g;
	public Tryframe()
	{
		
	}
	
	public void display(){
		//建立窗口frame
		frame=new JFrame("miniCaD");
		t.start(); 
		//设置窗口大小
		frame.setSize(width,height);
		//设置窗口位置
		frame.setLocation(450,50);
		frame.setVisible(true);
		//建立菜单条jmb
		jmb=new JMenuBar();
		//把菜单条添加到框架顶端
		frame.setJMenuBar(jmb);
		
		
		//创建菜单并添加进菜单条jmb中:在把菜单添加到菜单条之前，菜单是不可见的
		jm1=new JMenu("文件");
		jm2=new JMenu("形状");
		jm3=new JMenu("颜色");
		jm4=new JMenu();
		jm5=new JMenu("文本");
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		//菜单项：文件打开与保存
		fo=new JMenuItem("打开");
		fc=new JMenuItem("保存");
		fcr=new JMenuItem("新建");
		jm1.add(fo);
		jm1.add(fc);
		jm1.add(fcr);
		//菜单项:形状
		line1=new JMenuItem("直线");
		rect1=new JMenuItem("矩形");
		oval1=new JMenuItem("椭圆");
		circle1=new JMenuItem("圆");
		jm2.add(line1);
		jm2.add(rect1);
		jm2.add(oval1);
		jm2.add(circle1);
		//菜单项:颜色
		ccolor=new JMenuItem("请选择颜色");
		jm3.add(ccolor);
		//菜单项：大小
		csize=new JMenuItem("更改大小");
		jm4.add(csize);
		//菜单项：文字
		text=new JMenuItem("创建文字");
		
		jm5.add(text);
//		jm5.add(csize);
//		jm5.add(ccolor);
		zihao=new JMenuItem("字号");

		jm5.add(zihao);
		f2=new JFrame("文字");
		f2.setSize(100,100);
		f2.setVisible(false);
		p=new Panel();   
		cfont=new Choice();
		p.setLayout(new GridLayout(14,1,0,0));      
		p.add(new JLabel("字号"));   
		cfont.add("10");   
		cfont.add("12");   
		cfont.add("16");   
		cfont.add("20");   
		cfont.add("24");   
		cfont.add("26");   
		cfont.add("28");   
		cfont.add("36");   
		cfont.add("48");   
		cfont.add("72");   
		p.add(cfont);   
		f2.add(p,BorderLayout.NORTH); 
		cfont.addItemListener(this); 
//		color=JColorChooser.showDialog(frame,"颜色",Color.red);
		//添加监听器
		
		frame.addMouseListener(this);   
		frame.addMouseMotionListener(this);   
		frame.addKeyListener(this); 
		//为菜单添加监听器
		jm1.addActionListener(this);   
		jm2.addActionListener(this);
		jm3.addActionListener(this);
		jm4.addActionListener(this);
		jm5.addActionListener(this);
		//要为单个的添加监听器
		fc.addActionListener(this);   
		fo.addActionListener(this); 
		fcr.addActionListener(this);   
		ccolor.addActionListener(this); 
		csize.addActionListener(this);   
		text.addActionListener(this); 
		zihao.addActionListener(this); 
		line1.addActionListener(this);   
		rect1.addActionListener(this); 
		oval1.addActionListener(this);   
		circle1.addActionListener(this); 
		
		
//		g.setBackground(new Color(255,255,255));  
//		g.setPaint(new Color(0,0,0));  
//      
//		g.clearRect(0, 0, width, height); 
	}
	public void itemStateChanged(ItemEvent e){   
			 
		if(e.getSource()==cfont){   
					 
			font=Integer.parseInt(cfont.getSelectedItem());   
					 
		}   
			 
			 
			 
	}   
	 
	public void actionPerformed(ActionEvent e){
		System.out.println("ok!");
		String s=e.getActionCommand();
		if(e.getSource()==fcr)  //新建 
			xinjian();   
		if(e.getSource()==fo)   //打开
//			act.open();   
			open();
		if(e.getSource()==fc)   //保存
			save();   
		if(e.getSource()==line1)   //直线
			flag=1;
		if(e.getSource()==rect1)   //矩形
			flag=2;
		if(e.getSource()==oval1)   //椭圆
			flag=3;
		if(e.getSource()==circle1)   //圆形
			flag=4;
		
		if(s.equals("请选择颜色"))  //颜色
		{
			color=JColorChooser.showDialog(f2,"颜色",Color.red);
		}
		if(e.getSource()==csize)   //大小
			;
		if(e.getSource()==text)   //文本
			flag=5;
		if(e.getSource()==zihao)   //zihao
			f2.setVisible(true);
				 
	}
   
	public void keyPressed(KeyEvent e){}   
		 
	public void keyReleased(KeyEvent e){}   
		 
		 
	public void mouseClicked(MouseEvent e){
		System.out.println("panel ok!");
	}   
		 
	public void mouseMoved(MouseEvent e){   
 
	}   
	 
	public void mouseExited(MouseEvent e){}   
		 
	public void mouseEntered(MouseEvent e){}   
		 
	public void mouseReleased(MouseEvent e){ 
		//line:1,rect:2,oval:3,circle:4,text:5
		System.out.println("release ok!");
		System.out.println(flag);
		if(flag==1){	
			g = (Graphics2D)frame.getGraphics();
			g.setColor(color);
			g.drawLine(x1,y1,x2,y2);
			g1.setColor(color);
			g1.drawOval(x1,y1,Math.abs(x2-x1),Math.abs(y2-y1));
			System.out.println("drawline ok!");
		}   
			 
		if(flag==2){
			g = (Graphics2D)frame.getGraphics();
			g.setColor(color); 
			g.drawRect(x1,y1,Math.abs(x2-x1),Math.abs(y2-y1));
			g1.setColor(color);
			g1.drawOval(x1,y1,Math.abs(x2-x1),Math.abs(y2-y1));
//			g.drawImage(image,0,0,null);
		}   
			 
		if(flag==3){
			g = (Graphics2D)frame.getGraphics();
			g.setColor(color);
			g.drawOval(x1,y1,Math.abs(x2-x1),Math.abs(y2-y1));
			g1.setColor(color);
			g1.drawOval(x1,y1,Math.abs(x2-x1),Math.abs(y2-y1));
		}   
			 
		if(flag==4){
			g = (Graphics2D)frame.getGraphics();
			g.setColor(color);
			g.drawOval(x1,y1,Math.abs(x2-x1),Math.abs(x2-x1));
			g1.setColor(color);
			g1.drawOval(x1,y1,Math.abs(x2-x1),Math.abs(x2-x1));
		}
		
		
	}   
	//记录起点
	public void mousePressed(MouseEvent e){
		System.out.println("press ok!");
		x1=e.getX();   
		y1=e.getY();
	}  
	//记录终点
	public void mouseDragged(MouseEvent e){ 
		System.out.println("dragged ok!");
		x2=e.getX();   
		y2=e.getY();
	} 
	//文字:按下并松开键时调用该方法
	public void keyTyped(KeyEvent e){   
			String s=String.valueOf(e.getKeyChar());   
			Graphics g=frame.getGraphics();   
		 
			if(flag==5){ 
					g.setColor(color);
					g.setFont(new Font("宋体",Font.BOLD,font));   
					g.drawString(s,x1,y1);   
					g1.setColor(color);   
					g1.setFont(new Font("宋体",Font.BOLD,font));   
					g1.drawString(s,x1,y1); 
					x1+=font;    
			}   
	} 
	public void xinjian()
	{
		System.out.println("xinjian ok!");

		//初始化g
		image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		g1 = (Graphics2D)image.getGraphics();
		
		g1.setBackground(Color.white);  
        g1.setPaint(new Color(0,0,0));  
        

		frame.getContentPane().setBackground(Color.white);
		repaint();
	}
	void open(){
		JFileChooser jf=new JFileChooser();   
		int n=jf.showOpenDialog(frame);   
			 
			 
		try{   
			if(n==JFileChooser.APPROVE_OPTION){   
				File f=jf.getSelectedFile(); 
				java.net.URL url=f.toURL();   	 
				frame.add(new JLabel(new ImageIcon(url)),BorderLayout.CENTER);   
				update(g); 
			}   
		}catch(Exception e){}    
	}   
	
	void save() 
	{
		try
		{
			dialogsave.setVisible(true);
			ImageIO.write(image,"jpeg",new File(dialogsave.getDirectory()+dialogsave.getFile()+".jpg"));
		}
		catch(Exception ee)
		{
		}

	}
	public static void main(String[] args)
	{
		(new Tryframe()).display();
	}
}
