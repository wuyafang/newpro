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
	private Frame f = new Frame("�򵥻�ͼ��");
	private MenuBar mb = new MenuBar();
	private Menu file = new Menu("�ļ�");
	private Menu edit = new Menu("�༭");
	private MenuItem newfile = new MenuItem("��");
	private MenuItem savefile = new MenuItem("����");
	private MenuItem exit = new MenuItem("�˳�");
	private Menu color = new Menu("��ɫ");
	private MenuItem red = new MenuItem("��ɫ");
	private MenuItem green = new MenuItem("��ɫ");
	private MenuItem blue = new MenuItem("��ɫ");
	private MenuItem clear = new MenuItem("���");
	private Box b1 = Box.createVerticalBox();
	private Panel p2 = new Panel();
	private Button line = new Button("��");
	private Button circle = new Button("Բ");
	private Button rect = new Button("����");
	private Button oval = new Button("��Բ");
	FileDialog dialogopen = new FileDialog(f,"ѡ����Ҫ�򿪵��ļ�",FileDialog.LOAD);
	FileDialog dialogsave = new FileDialog(f,"ѡ�񱣴��ļ���·��",FileDialog.SAVE);
	private DrawCanvas drawarea = new DrawCanvas();
	BufferedImage image = new BufferedImage(AREA_WIDTH,AREA_HEIGHT,BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();

	//ȫ�ֱ���ȷ����ɫ
	private Color currentcolor=new Color(0,0,0);
	private String shape=null;
	//��ʼ������
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
		//Ϊ�齨����¼���Ӧ
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
	//������
	public static void main(String[]args)
	{
		new DrawTool().init();
	}

	//ָ��������ɫ��
	class MyColor implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("��ɫ"))
			{
				currentcolor = new Color(255,0,0);
			}
			if(e.getActionCommand().equals("��ɫ"))
			{
				currentcolor = new Color(0,255,0);
			}
			if(e.getActionCommand().equals("��ɫ"))
			{
				currentcolor = new Color(0,0,255);
			}
			if(e.getActionCommand().equals("���"))
			{
				g.setColor(new Color(255,255,255));
				g.fillRect(0,0,AREA_WIDTH,AREA_HEIGHT);
				drawarea.repaint();
			}
		}
	}
	//��������϶�������
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
	//��������¼�
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


	//canvas ����д
	class DrawCanvas extends Canvas
	{
		public void paint(Graphics g)
		{
			g.drawImage(image,0,0,null);
		}
	}
	//ȷ������ͼ��
	class ShapeChoose implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("��"))
			{
				shape="line";
			}
			if(e.getActionCommand().equals("Բ"))
			{
				shape="circle";
			}
			if(e.getActionCommand().equals("����"))
			{
				shape="rect";
			}
			if(e.getActionCommand().equals("��Բ"))
			{
				shape="oval";
			}
		}
	}
	//������ļ��˵����ʵ��
	class FileSaveAndOpen implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("��"))
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
			if(e.getActionCommand().equals("����"))
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
			if(e.getActionCommand().equals("�˳�"))
			{
				System.exit(0);
			}
		}
	}

}
//�رմ�����
class MyWindowListener extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}

