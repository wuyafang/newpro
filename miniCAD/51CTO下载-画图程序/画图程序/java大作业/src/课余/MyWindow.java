package 课余;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class MyWindow extends Canvas implements ActionListener{
	Frame f = new Frame("画图");// 创建窗口
	//Panel p=new Panel();
	//ScrollPane sp= new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS); 
	MenuBar mb = new MenuBar();// 创建菜单栏组件
	Menu mu = new Menu("文件(F)");// 创建菜单组件
	// Menu nu = new Menu("编辑(E)");
	// Menu ou = new Menu("查看(V)");
	// Menu pu = new Menu("图像(I)");
	Menu qu = new Menu("颜色(C)");
	Menu ru = new Menu("帮助(H)");
	Menu su = new Menu("编辑颜色(E)");
	PopupMenu pmu = new PopupMenu();// 创建弹出式菜单选项

	MenuItem newfile, openfile, save, saveas, exit, seperator, help, about,choosecolor;
	CheckboxMenuItem red, yellow, black, blue, white;


	public MyWindow() {
		newfile = new MenuItem("新建(N)");
		openfile = new MenuItem("打开(O)");
		save = new MenuItem("保存(S)");
		saveas = new MenuItem("另存为(V)");
		exit = new MenuItem("退出(X)");
		seperator = new MenuItem("-");

		red = new CheckboxMenuItem("红色");
		black = new CheckboxMenuItem("黑色");
		yellow = new CheckboxMenuItem("黄色");
		blue = new CheckboxMenuItem("蓝色");
		white = new CheckboxMenuItem("白色");
		choosecolor = new MenuItem("自选颜色");

		help = new MenuItem("帮助主题(H)");
		about = new MenuItem("关于画图(A)");

		pmu.add("欢迎各位使用");
		pmu.add("点击查看帮助");

		mu.setShortcut(new MenuShortcut(KeyEvent.VK_F));
		qu.setShortcut(new MenuShortcut(KeyEvent.VK_C));
		ru.setShortcut(new MenuShortcut(KeyEvent.VK_H));

		mb.add(mu);// 将"文件(F)"菜单加入到菜单栏里
		mu.add(newfile);
		mu.add(openfile);
		mu.add(save);
		mu.add(saveas);
		mu.add(new MenuItem("-"));
		mu.add(seperator);// 加入分割线
		mu.add(exit);

		newfile.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		openfile.setShortcut(new MenuShortcut(KeyEvent.VK_O));
		save.setShortcut(new MenuShortcut(KeyEvent.VK_S));
		saveas.setShortcut(new MenuShortcut(KeyEvent.VK_A));
		exit.setShortcut(new MenuShortcut(KeyEvent.VK_F4));

		mb.add(qu);
		qu.add(su);
		su.add(red);// 加入选中菜单选项
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
       
		//增加监视器
		newfile.addActionListener(this);
		openfile.addActionListener(this);
		save.addActionListener(this);
		saveas.addActionListener(this);
		exit.addActionListener(this);
		choosecolor.addActionListener(this);
		about.addActionListener(this);
		/*
		 * 设置快捷键 mi2.setEnabled(false);// 使菜单选项失效 hu.add(mi1); hu.add(mi2);
		 */

		// 设置窗口位置和大小
		f.setBounds(300, 200, 700, 450);
		f.setBackground(Color.green);//设置窗口背景颜色
		f.setMenuBar(mb);// 将菜单栏加入到窗口
		f.add(pmu);// 将弹出式菜单加入到窗口
		//f.add(sp);
		//sp.setBackground(Color.white);
//		sp.setBounds(10, 50, 20, 20);
		f.setVisible(true);// 显示窗口
//		sp.setBounds(100, 100, 100, 100);
//		sp.add(new MyCanvas(),BorderLayout.CENTER);//添加画布
//		f.add(sp);
		f.validate();
		pmu.show(f, 300, 150);// 在指定坐标显示弹出式菜单
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {//获取事件源
			int result=JOptionPane.showConfirmDialog(f, "确定退出？","警告",JOptionPane.YES_NO_OPTION); 
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
			FileDialog FD1 = new FileDialog(f, "打开", FileDialog.LOAD);
			FD1.setVisible(true);
		} else if (e.getSource() == save) {
			FileDialog FD2 = new FileDialog(f, "保存", FileDialog.SAVE);
			FD2.setVisible(true);
		} else if (e.getSource() == saveas) {
			FileDialog FD3 = new FileDialog(f, "打开", FileDialog.SAVE);
			FD3.setVisible(true);
		}
		else if(e.getSource()== choosecolor){
			Color newColor=JColorChooser.showDialog(this, "调色板", f.getBackground());
			if(f.getBackground()!=null){
				f.setBackground(newColor);
			}else if(e.getSource()==about){
				Dialog D=new Dialog(f,"版权所有，违者必究！");
				D.setVisible(true);
			}
		}
	}
	
}
