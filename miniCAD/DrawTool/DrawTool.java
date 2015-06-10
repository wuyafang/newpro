rawimport java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Box;
import java.awt.image.BufferedImage;
import java.lang.Math ;
public class DrawTool
{
	private int AREA_WIDTH=500;
	private int AREA_HEIGHT=400;
	private int preX=-1;
	private int preY=-1;
	private int flag=0;
	private int tempx,tempy;
	private Frame f = new Frame("简单画图器");
	private MenuBar mb = new MenuBar();
	private Menu file = new Menu("文件");
	private Menu edit = new Menu("编辑");
	private MenuItem newfile = new MenuItem("打开");
	private MenuItem savefile = new MenuItem("保存");
	private MenuItem exit = new MenuItem("退出");
	private Menu color = new Menu("颜色");
	private MenuItem red = new MenuItem("红色");
	private MenuItem green = new MenuItem("绿色");
	private MenuItem blue = new MenuItem("蓝色");
	private MenuItem clear = new MenuItem("清空");
	private Box b1 = Box.createVerticalBox();
	private Panel p2 = new Panel();
	private Button line = new Button("线");
	private Button circle = new Button("圆");
	private Button rect = new Button("矩形");
	private Button oval = new Button("椭圆");
	FileDialog dialogopen = new FileDialog(f,"选择需要打开的文件",FileDialog.LOAD);
	FileDialog dialogsave = new FileDialog(f,"选择保存文件的路径",FileDialog.SAVE);
	private DrawCanvas drawarea = new DrawCanvas();
	BufferedImage image = new BufferedImage(AREA_WIDTH,AREA_HEIGHT,BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();

	//全局变量确定颜色
	private Color currentcolor=new Color(0,0,0);
	private String shape=null;
	//初始化函数
	public void init()
	{
		g.fillRect(0,0,AREA_WIDTH,AREA_HEIGHT);
		file.add(newfile);
		file.add(savefile);
		file.add(exit);
		color.add(red);
		color.add(green);
		color.add(blue);
		edit.add(color);
		edit.add(clear);
		mb.add(file);
		mb.add(edit);
		b1.add(line);
		b1.add(circle);
		b1.add(rect);
		b1.add(oval);
		f.setMenuBar(mb);
		f.add(b1,BorderLayout.WEST);
		drawarea.setPreferredSize(new Dimension(AREA_WIDTH,AREA_HEIGHT));
		f.add(drawarea,BorderLayout.EAST);
		//为组建添加事件响应
		red.addActionListener(new MyColor());
		green.addActionListener(new MyColor());
		blue.addActionListener(new MyColor());
		clear.addActionListener(new MyColor());
		line.addActionListener(new ShapeChoose());
		circle.addActionListener(new ShapeChoose());
		rect.addActionListener(new ShapeChoose());
		oval.addActionListener(new ShapeChoose());
		drawarea.addMouseMotionListener(new MyMouseMotionListener());
		drawarea.addMouseListener(new MyMouseListener());
		newfile.addActionListener(new FileSaveAndOpen());
		savefile.addActionListener(new FileSaveAndOpen());
		exit.addActionListener(new FileSaveAndOpen());

		f.addWindowListener(new MyWindowListener());
		f.pack();
		f.setVisible(true);
	}
	//主函数
	public static void main(String[]args)
	{
		new DrawTool().init();
	}

	//指定画笔颜色类
	class MyColor implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("红色"))
			{
				currentcolor = new Color(255,0,0);
			}
			if(e.getActionCommand().equals("绿色"))
			{
				currentcolor = new Color(0,255,0);
			}
			if(e.getActionCommand().equals("蓝色"))
			{
				currentcolor = new Color(0,0,255);
			}
			if(e.getActionCommand().equals("清空"))
			{
				g.setColor(new Color(255,255,255));
				g.fillRect(0,0,AREA_WIDTH,AREA_HEIGHT);
				drawarea.repaint();
			}
		}
	}
	//监听鼠标拖动动作类
	class MyMouseMotionListener extends MouseMotionAdapter
	{


		public void mouseDragged(MouseEvent e)
		{
			if(shape.equals("line"))
			{
				if(preX>0&&preY>0)
				{
					g.setColor(currentcolor);
					g.drawLine(preX,preY,e.getX(),e.getY());
				}
				preX=e.getX();
				preY=e.getY();
				drawarea.repaint();
			}
			if(shape.equals("rect"))
			{
				preX=e.getX();
				preY=e.getY();
				if(flag==0)
				{
					tempx=preX;
					tempy=preY;
					flag=1;
				}
			}
			if(shape.equals("circle"))
			{
				preX=e.getX();
				preY=e.getY();
				if(flag==0)
				{
					tempx=preX;
					tempy=preY;
					flag=1;
				}
			}
			if(shape.equals("oval"))
			{
				preX=e.getX();
				preY=e.getY();
				if(flag==0)
				{
					tempx=preX;
					tempy=preY;
					flag=1;
				}
			}

		}
	}
	//监听鼠标事件
	class MyMouseListener extends MouseAdapter
	{
		public void mouseReleased(MouseEvent e)
		{
			preX=-1;
			preY=-1;
			if(shape.equals("rect"))
			{
				g.setColor(currentcolor);
				g.drawRect(tempx,tempy,Math.abs(tempx-e.getX()),Math.abs(tempy-e.getY()));
				drawarea.repaint();
				flag=0;
			}
			if(shape.equals("circle"))
			{
				g.setColor(currentcolor);
				g.drawOval(tempx,tempy,Math.abs(tempx-e.getX()),Math.abs(tempx-e.getX()));
				drawarea.repaint();
				flag=0;
			}
			if(shape.equals("oval"))
			{
				g.setColor(currentcolor);
				g.drawOval(tempx,tempy,Math.abs(tempx-e.getX()),Math.abs(tempx-e.getY()));
				drawarea.repaint();
				flag=0;
			}

		}
	}


	//canvas 类重写
	class DrawCanvas extends Canvas
	{
		public void paint(Graphics g)
		{
			g.drawImage(image,0,0,null);
		}
	}
	//确定绘制图形
	class ShapeChoose implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("线"))
			{
				shape="line";
			}
			if(e.getActionCommand().equals("圆"))
			{
				shape="circle";
			}
			if(e.getActionCommand().equals("矩形"))
			{
				shape="rect";
			}
			if(e.getActionCommand().equals("椭圆"))
			{
				shape="oval";
			}
		}
	}
	//最后是文件菜单项的实现
	class FileSaveAndOpen implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("打开"))
			{
				try
				{
					dialogopen.setVisible(true);
					Image srcImage = ImageIO.read(new File(dialogopen.getDirectory()+dialogopen.getFile()));
					g.drawImage(srcImage,0,0,AREA_WIDTH,AREA_HEIGHT,null);
					drawarea.repaint();
				}
				catch(Exception ee)
				{
				}
			}
			if(e.getActionCommand().equals("保存"))
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
			if(e.getActionCommand().equals("退出"))
			{
				System.exit(0);
			}
		}
	}

}
//关闭窗口类
class MyWindowListener extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}

