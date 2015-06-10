import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


@SuppressWarnings("serial")
public class MyWindow extends JFrame implements ActionListener,MouseMotionListener,MouseListener{
	JLabel label = new JLabel();
	JMenuBar mb = new JMenuBar(),mb2 = new JMenuBar();// �����˵������
	JMenu mu = new JMenu("�ļ�(F)");// �����˵����
	JMenu qu = new JMenu("��ɫ(C)");
	JMenu ru = new JMenu("����(H)");
	JPopupMenu pmu = new JPopupMenu();// ��������ʽ�˵�ѡ��
	JPanel jpanel1 = new JPanel(), jpanel2 = new JPanel(),
           jpanel3 = new JPanel(), jpanel4 = new JPanel();
	JButton btn1 = new JButton("Ǧ         ��"), btn2 = new JButton("��         Ƥ"),
			btn3 = new JButton("��        ��"), btn4 = new JButton("ֱ         ��"),
			btn5 = new JButton("��         ��"), btn6= new JButton("Բ         ��"),
	        btn7 = new JButton("��         Բ"), btn8 = new JButton("Բ�Ǿ���"),
	        btn9 = new JButton("��  ��  ��");
	JSeparator seperate1=new JSeparator(),seperate2=new JSeparator();//�����»���
	JMenuItem  openfile, save, saveas, exit, help, about,coloredit;
	Box box = Box.createVerticalBox();
	@SuppressWarnings("unchecked")
	Vector point= null;//��������
	Color color = new Color(0,0,0);
	Point mark = new Point(-1, -1, 15, color);//��ضϱ�־
	int flag=1;//�жϵ�ǰ���õĹ���,Ĭ��ΪǦ��
	int x=-1,y=-1;//��ǰ�������
	int n=1;
	

	@SuppressWarnings("unchecked")
	public MyWindow() {
		super();
		openfile = new JMenuItem("��(O)",KeyEvent.VK_O);
		save = new JMenuItem("����(S)",KeyEvent.VK_S);
		saveas = new JMenuItem("���Ϊ(D)",KeyEvent.VK_D);
		exit = new JMenuItem("�˳�(X)",KeyEvent.VK_F4);
		coloredit = new JMenuItem("�༭��ɫ(E)",KeyEvent.VK_E); 
		help = new JMenuItem("��������(H)",KeyEvent.VK_H);
		about = new JMenuItem("���ڻ�ͼ(M)",KeyEvent.VK_M);

		//����ť���ñ���ͼƬ
		btn1.setIcon(new ImageIcon("D:\\��ͼ����\\Ǧ��.jpg"));
		btn2.setIcon(new ImageIcon("D:\\��ͼ����\\��Ƥ��.jpg"));
		btn3.setIcon(new ImageIcon("D:\\��ͼ����\\ѡ����ɫ.jpg"));
		btn4.setIcon(new ImageIcon("D:\\��ͼ����\\ֱ��.jpg"));
		btn5.setIcon(new ImageIcon("D:\\��ͼ����\\����.jpg"));
		btn6.setIcon(new ImageIcon("D:\\��ͼ����\\Բ.jpg"));
		btn7.setIcon(new ImageIcon("D:\\��ͼ����\\��Բ.jpg"));
		btn9.setIcon(new ImageIcon("D:\\��ͼ����\\�����.jpg"));
		btn8.setIcon(new ImageIcon("D:\\��ͼ����\\Բ�Ǿ���.jpg"));
		
		
		// ��ѡ����뵽�˵�����
		mb.add(mu);
		mu.add(openfile);
		mu.add(save);
		mu.add(saveas);
		mu.add(seperate1);// ����ָ���
		mu.add(exit);
		mb.add(qu);
		qu.add(coloredit);
		mb.add(ru);
		ru.add(help);
		ru.add(seperate2);
		ru.add(about);
		pmu.add("�����ߣ�");
		pmu.add("�λ�����");
		jpanel1.add(box);
		box.add(btn1);
		box.add(new JSeparator());
		box.add(btn2);
		box.add(new JSeparator());
		box.add(btn3);
		box.add(new JSeparator());
		box.add(btn4);
		box.add(new JSeparator());
		box.add(btn5);
		box.add(new JSeparator());
		box.add(btn6);
		box.add(new JSeparator());
		box.add(btn7);
		box.add(new JSeparator());
		box.add(btn8);
		box.add(new JSeparator());
		box.add(btn9);
		//p2.add(label);
		//label.setBackground(Color.white);
		
		//���ÿ�ݼ�
		mu.setMnemonic(KeyEvent.VK_F);
		qu.setMnemonic(KeyEvent.VK_C);
		ru.setMnemonic(KeyEvent.VK_H);
		//exit.setMnemonic(KeyEvent.VK_F4);//ͬ�¾�����һ��
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.ALT_MASK));
		openfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		saveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		coloredit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		
		// ���Ӽ�����
		openfile.addActionListener(this);
		save.addActionListener(this);
		saveas.addActionListener(this);
		exit.addActionListener(this);
		coloredit.addActionListener(this);
		about.addActionListener(this);
		help.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);

		// ���ô���λ�úʹ�С
		setTitle("��ͼ");
		setBounds(300, 200, 700, 450);
		setBackground(jpanel4.getBackground());// ���ô��ڱ�����ɫ
		setJMenuBar(mb);// ���˵������뵽����
		mb2.setBackground(Color.lightGray);
		add(mb2,BorderLayout.SOUTH);
		mb2.add(label);
		point = new Vector();
		add(jpanel1,BorderLayout.WEST);
		add(jpanel2,BorderLayout.NORTH);
		add(jpanel3,BorderLayout.EAST);
		add(jpanel4,BorderLayout.CENTER);
		jpanel1.setBackground(Color.gray);
		jpanel2.setBackground(Color.gray);
		jpanel3.setBackground(Color.gray);
		jpanel4.setBackground(Color.white);
		setVisible(true);// ��ʾ����		
		add(pmu);// ������ʽ�˵����뵽����	
		pmu.show(this, 350, 200);// ��ָ��������ʾ����ʽ�˵�
		pmu.setBackground(Color.gray);
		validate();
	}

	//��Ӧ�¼�
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {// ��ȡ�¼�Դ
			int result = JOptionPane.showConfirmDialog(this, "�����ı��浽 δ������", "��ͼ",
					JOptionPane.YES_NO_OPTION);
			switch (result) {
			case JOptionPane.YES_OPTION:
				FileDialog FD2 = new FileDialog(this, "����", FileDialog.SAVE);
				FD2.setVisible(true);
				try {
					File fileout = new File(FD2.getDirectory(),FD2.getFile()+".jpg");
					FileOutputStream fout = new FileOutputStream(fileout);
					ObjectOutputStream oout = new ObjectOutputStream(fout);
					oout.writeObject(point);
					oout.close();
				} catch (IOException IOe) {
					int res = JOptionPane.showConfirmDialog(this, "���ļ��޷����棡", "����",
							JOptionPane.CANCEL_OPTION);
					if(res==JOptionPane.CANCEL_OPTION) {
						return;
					}
				}
				break;
			case JOptionPane.NO_OPTION:
				System.exit(0);
				break;
			}
		}else if (e.getSource() == openfile) {
			FileDialog FD1 = new FileDialog(this, "��", FileDialog.LOAD);
			FD1.setVisible(true);
			if (FD1.getFile() != null) {
			    int tempflag=0;
			    tempflag = flag;
			    flag=0;
			    repaint();
				try {
					point.removeAllElements();
					File filein = new File(FD1.getDirectory(),FD1.getFile());
					FileInputStream fin = new FileInputStream(filein);
					ObjectInputStream oin = new ObjectInputStream(fin);
					point = (Vector) oin.readObject();
					oin.close();
					repaint();
					flag= tempflag;
				}
				catch (IOException e1) {
					repaint();
					flag = tempflag;
					int result = JOptionPane.showConfirmDialog(this, "���ļ��޷���ȡ��", "����",
							JOptionPane.CANCEL_OPTION);
					if(result==JOptionPane.CANCEL_OPTION) {
						return;
					}
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					repaint();
					flag = tempflag;
					int result = JOptionPane.showConfirmDialog(this, "���ļ��޷���ȡ��", "����",
							JOptionPane.CANCEL_OPTION);
					if(result==JOptionPane.CANCEL_OPTION) {
						return;
					}
				}
			}
		} else if (e.getSource() == save) {
			FileDialog FD2 = new FileDialog(this, "����", FileDialog.SAVE);
			FD2.setVisible(true);
			try {
				File fileout = new File(FD2.getDirectory(),FD2.getFile()+".jpg");
				FileOutputStream fout = new FileOutputStream(fileout);
				ObjectOutputStream oout = new ObjectOutputStream(fout);
				oout.writeObject(point);
				oout.close();
			} catch (IOException IOe) {
				int result = JOptionPane.showConfirmDialog(this, "���ļ��޷����棡", "����",
						JOptionPane.CANCEL_OPTION);
				if(result==JOptionPane.CANCEL_OPTION) {
					return;
				}
			}
		} else if (e.getSource() == saveas) {
			FileDialog FD3 = new FileDialog(this, "���Ϊ", FileDialog.SAVE);
			FD3.setVisible(true);
			try {
				File fileout = new File(FD3.getDirectory(),FD3.getFile()+".jpg");
				FileOutputStream fout = new FileOutputStream(fileout);
				ObjectOutputStream oout = new ObjectOutputStream(fout);
				oout.writeObject(point);
				oout.close();
			} catch (IOException IOe) {
				int result = JOptionPane.showConfirmDialog(this, "���ļ��޷����棡", "����",
						JOptionPane.CANCEL_OPTION);
				if(result==JOptionPane.CANCEL_OPTION) {
					return;
				}
			}
		} else if (e.getSource() == coloredit) {
			Color newColor = JColorChooser.showDialog(this, "��ɫ��",
					jpanel4.getBackground());
			if (jpanel4.getBackground() != null) {
				jpanel4.setBackground(newColor);
			}
		}else if (e.getSource() == btn3) {
			Color newColor = JColorChooser.showDialog(this, "��ɫ��",color);
		    color=newColor;
		    flag=1;
		}else if (e.getSource() == about) {
				JDialog D = new JDialog(this, "���ڻ�ͼ");
				((JComponent) D.getContentPane()).setOpaque(false);//��ȡ��岢�ѱ�������Ϊ͸�� �����Ͳ�����ס����ı��� 
				ImageIcon img = new ImageIcon("D:\\��ͼ����\\about.jpg"); 
				JLabel background = new JLabel(img);
				D.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
				background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 
				D.setBounds(400, 250, img.getIconWidth(), img.getIconHeight());
				D.setResizable(false);
				D.setVisible(true);
		}else if(e.getSource()==help){
				try {
					//Runtime.getRuntime().exec("C:\\Program Files\\Kingsoft\\WPS Office School\\office6\\wps.exe c:\\help.doc");
					Runtime.getRuntime().exec("cmd.exe /c start D:\\��ͼ����\\help.chm");//�򿪰����ĵ�
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "�޷����ĵ�");
				}
			}else if(e.getSource()==btn1){
				flag=1;//Ǧ��
			}else if(e.getSource()==btn2){
				flag=2;//��Ƥ
			}else if(e.getSource()==btn3){
				flag=3;//����
			}else if(e.getSource()==btn4){
				flag=4;//ֱ��
			}else if(e.getSource()==btn5){
				flag=5;//����
			}else if(e.getSource()==btn6){
				flag=6;//Բ��
			}else if(e.getSource()==btn7){
				flag=7;//��Բ
			}else if(e.getSource()==btn8){
				flag=8;//Բ�Ǿ���
			}else if(e.getSource()==btn9){
				flag=9;//�����
			}
		}

	public void paint(Graphics g) {
		Graphics2D grap = (Graphics2D) g;
		Point p1, p2;
		n = point.size();
		if (flag == 0){
			g.clearRect(0, 0, getSize().width, getSize().height);// ���
		    repaint();
		}
		for (int i = 0; i < n - 1; i++) {
			p1 = (Point) point.elementAt(i);
			p2 = (Point) point.elementAt(i + 1);
			grap.setColor(p1.color);
			if (p1.tool == p2.tool) {
				switch (p1.tool) {
				case 1:// ����
					Line2D line1 = new Line2D.Double(p1.x, p1.y, p2.x, p2.y);
					grap.draw(line1);
					break;
				case 2:// ��Ƥ
					setBackground(jpanel4.getBackground());
					g.clearRect(p1.x, p1.y, 20, 20);
					break;
				case 4:// ��ֱ��
					Line2D line2 = new Line2D.Double(p1.x, p1.y, p2.x, p2.y);
					grap.draw(line2);
					break;
				case 5:// ������
					Rectangle2D rect = new Rectangle2D.Double(p1.x, p1.y,
							Math.abs(p2.x - p1.x), Math.abs(p2.y - p1.y));
					grap.draw(rect);
					break;
				case 6:// ��Բ
					Arc2D circle = new Arc2D.Double(p1.x, p1.y,
							Math.abs(p2.x - p1.x), Math.abs(p2.x - p1.x),0,360,Arc2D.OPEN);
					grap.draw(circle);
					break;
				case 7:// ����Բ
					Ellipse2D ellipse = new Ellipse2D.Double(p1.x, p1.y,
							Math.abs(p2.x - p1.x), Math.abs(p2.y - p1.y));
					grap.draw(ellipse);
					break;
				case 8:// ��Բ�Ǿ���
					RoundRectangle2D rect_round = new RoundRectangle2D.Double(
							p1.x, p1.y, Math.abs(p2.x - p1.x), Math.abs(p2.y
									- p1.y), 20, 10);
					grap.draw(rect_round);
					break;
				case 9:// �������
					int px[]={p1.x,p2.x,p1.y,p2.y};
					int py[]={p1.y,p2.y,p2.x,p1.x};
					g.drawPolyline(px, py, 3);
					break;
				case 15:// �ضϣ�����
					i = i + 1;
					break;
				default:
				}
			}
		}
	}
	
	 public void update(Graphics g)
	 {
	  paint(g);
	 }

	@SuppressWarnings("unchecked")
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		  Point p3 ;
		  switch(flag){
		   case 1://Ǧ��
		   case 2://��Ƥ
		     x = (int)e.getX();
		     y = (int)e.getY();
		     p3 = new Point(x, y, flag,color);
		     point.addElement(p3);
		     repaint();
		     break;
		   default :
		  }
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		switch (flag) {
		case 1: // Ǧ��
			label.setText("                    ��һ�����ؿ�������״������");
			break;
		case 2: // ��Ƥ
			label.setText("                    ʹ����Ƥ����ȥͼƬ��һ����");
			break;
		case 3:
		    label.setText("                    ѡ�񻭱���ɫ");
		    break;
		case 4: // ֱ��
			label.setText("                    ��һ��ֱ��");
			break;
		case 5: // ����
			label.setText("                    ��һ������");
			break;
		case 6: // Բ
			label.setText("                    ��һ��Բ");
			break;
		case 7: // ��Բ
			label.setText("                    ��һ����Բ");
			break;
		case 8: // Բ�Ǿ���
			label.setText("                    ��һ��Բ�Ǿ���");
			break;
		case 9: // �����
			label.setText("                    ��һ�������");
			break;
		default:
			label.setText("                    ��ӭʹ�ã�");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p1;
		switch(flag){
		   case 4://ֱ��
		   case 5: //����
		   case 6: //Բ
		   case 7: //��Բ
		   case 8: //Բ�Ǿ���
		   case 9: //�����
			     x = (int)e.getX();
			     y = (int)e.getY();
			     p1 = new Point(x, y, flag, color);
			     point.addElement(p1);
			     break;
		   default :
		  } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p2;
		switch (flag) {
		case 1: // Ǧ��
		case 2: // ��Ƥ
			point.addElement(mark);
			break;
		case 4: // ֱ��
		case 5: // ����
		case 6: // Բ
		case 7: // ��Բ
		case 8: // Բ�Ǿ���
		case 9: // �����
			x = (int) e.getX();
			y = (int) e.getY();
			p2 = new Point(x, y, flag, color);
			point.addElement(p2);
			point.addElement(mark);
			repaint();
			break;
		default:
		}
	}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	@SuppressWarnings("unused")
	MyWindow win=new MyWindow();	
}
}
