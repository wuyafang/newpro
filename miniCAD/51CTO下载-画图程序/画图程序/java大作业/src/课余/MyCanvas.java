package 课余;

import java.awt.*;
import java.awt.event.*;

public class MyCanvas extends Canvas implements MouseListener{
	int left=-1,right=-1;//记录左右键用的变量
	int x=-1,y=-1;  //记录鼠标指针用的变量
	MyCanvas(){
		setBackground(Color.cyan);
		addMouseListener(this);
	}
	public void paint(Graphics g){
		if(left==1){
			g.drawOval(x-10, y-10, 20, 20);
		}
		else if(right==1){
			g.drawRect(x-8,y-8,16,16);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		left=-1;
		right=-1;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x=e.getX();
		y=e.getY();
		if(e.getModifiers()==InputEvent.BUTTON1_MASK){
			left=1;
			right=-1;
			repaint();
		}
		else if(e.getModifiers()==InputEvent.BUTTON3_MASK){
			right=1;
			left=-1;
			repaint();
		}
	}

	@Override 
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void update(Graphics g){
		if(left==1||right==1){
			paint(g);
		}
		else{
			super.update(g);
		}
	}
}
