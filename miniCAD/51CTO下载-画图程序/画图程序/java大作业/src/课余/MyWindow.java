package ����;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class MyWindow extends Canvas implements ActionListener{
	Frame f = new Frame("��ͼ");// ��������
	//Panel p=new Panel();
	//ScrollPane sp= new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS); 
	MenuBar mb = new MenuBar();// �����˵������
	Menu mu = new Menu("�ļ�(F)");// �����˵����
	// Menu nu = new Menu("�༭(E)");
	// Menu ou = new Menu("�鿴(V)");
	// Menu pu = new Menu("ͼ��(I)");
	Menu qu = new Menu("��ɫ(C)");
	Menu ru = new Menu("����(H)");
	Menu su = new Menu("�༭��ɫ(E)");
	PopupMenu pmu = new PopupMenu();// ��������ʽ�˵�ѡ��

	MenuItem newfile, openfile, save, saveas, exit, seperator, help, about,choosecolor;
	CheckboxMenuItem red, yellow, black, blue, white;


	public MyWindow() {
		newfile = new MenuItem("�½�(N)");
		openfile = new MenuItem("��(O)");
		save = new MenuItem("����(S)");
		saveas = new MenuItem("���Ϊ(V)");
		exit = new MenuItem("�˳�(X)");
		seperator = new MenuItem("-");

		red = new CheckboxMenuItem("��ɫ");
		black = new CheckboxMenuItem("��ɫ");
		yellow = new CheckboxMenuItem("��ɫ");
		blue = new CheckboxMenuItem("��ɫ");
		white = new CheckboxMenuItem("��ɫ");
		choosecolor = new MenuItem("��ѡ��ɫ");

		help = new MenuItem("��������(H)");
		about = new MenuItem("���ڻ�ͼ(A)");

		pmu.add("��ӭ��λʹ��");
		pmu.add("����鿴����");

		mu.setShortcut(new MenuShortcut(KeyEvent.VK_F));
		qu.setShortcut(new MenuShortcut(KeyEvent.VK_C));
		ru.setShortcut(new MenuShortcut(KeyEvent.VK_H));

		mb.add(mu);// ��"�ļ�(F)"�˵����뵽�˵�����
		mu.add(newfile);
		mu.add(openfile);
		mu.add(save);
		mu.add(saveas);
		mu.add(new MenuItem("-"));
		mu.add(seperator);// ����ָ���
		mu.add(exit);

		newfile.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		openfile.setShortcut(new MenuShortcut(KeyEvent.VK_O));
		save.setShortcut(new MenuShortcut(KeyEvent.VK_S));
		saveas.setShortcut(new MenuShortcut(KeyEvent.VK_A));
		exit.setShortcut(new MenuShortcut(KeyEvent.VK_F4));

		mb.add(qu);
		qu.add(su);
		su.add(red);// ����ѡ�в˵�ѡ��
		su.add(black);
		su.add(yellow);
		su.add(blue);
		su.add(white);
		su.add(seperator);
		su.add(choosecolor);

		mb.setHelpMenu(ru);
		ru.add(help);
		ru.add(new MenuItem("-"));
		ru.add(about);
       
		//���Ӽ�����
		newfile.addActionListener(this);
		openfile.addActionListener(this);
		save.addActionListener(this);
		saveas.addActionListener(this);
		exit.addActionListener(this);
		choosecolor.addActionListener(this);
		about.addActionListener(this);
		/*
		 * ���ÿ�ݼ� mi2.setEnabled(false);// ʹ�˵�ѡ��ʧЧ hu.add(mi1); hu.add(mi2);
		 */

		// ���ô���λ�úʹ�С
		f.setBounds(300, 200, 700, 450);
		f.setBackground(Color.green);//���ô��ڱ�����ɫ
		f.setMenuBar(mb);// ���˵������뵽����
		f.add(pmu);// ������ʽ�˵����뵽����
		//f.add(sp);
		//sp.setBackground(Color.white);
//		sp.setBounds(10, 50, 20, 20);
		f.setVisible(true);// ��ʾ����
//		sp.setBounds(100, 100, 100, 100);
//		sp.add(new MyCanvas(),BorderLayout.CENTER);//��ӻ���
//		f.add(sp);
		f.validate();
		pmu.show(f, 300, 150);// ��ָ��������ʾ����ʽ�˵�
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {//��ȡ�¼�Դ
			int result=JOptionPane.showConfirmDialog(f, "ȷ���˳���","����",JOptionPane.YES_NO_OPTION); 
			switch(result){
			case JOptionPane.YES_OPTION:
				System.exit(0);
				break;
			case JOptionPane.NO_OPTION:
				break;
			}
		} else if (e.getSource() == newfile) {
			f.setBackground(Color.red);
		} else if (e.getSource() == openfile) {
			FileDialog FD1 = new FileDialog(f, "��", FileDialog.LOAD);
			FD1.setVisible(true);
		} else if (e.getSource() == save) {
			FileDialog FD2 = new FileDialog(f, "����", FileDialog.SAVE);
			FD2.setVisible(true);
		} else if (e.getSource() == saveas) {
			FileDialog FD3 = new FileDialog(f, "��", FileDialog.SAVE);
			FD3.setVisible(true);
		}
		else if(e.getSource()== choosecolor){
			Color newColor=JColorChooser.showDialog(this, "��ɫ��", f.getBackground());
			if(f.getBackground()!=null){
				f.setBackground(newColor);
			}else if(e.getSource()==about){
				Dialog D=new Dialog(f,"��Ȩ���У�Υ�߱ؾ���");
				D.setVisible(true);
			}
		}
	}
	
}
