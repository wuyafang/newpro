package gui;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditPane extends Observable{
	//用于写入的面板
	private final JScrollPane inputPane = new JScrollPane();
	private final JTextArea inputTextArea = new JTextArea();
	
	public EditPane() {
		inputPane.getViewport().add(inputTextArea, null);
		//监听键盘输入
		inputTextArea.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				//观察者模式
				setChanged();
				notifyObservers(inputTextArea.getText());
			}
			
		});
	}
	
	public boolean replaceWith(String text){
		inputTextArea.replaceRange(text, 0,inputTextArea.getSelectionEnd());
		setChanged();
		this.notifyObservers(inputTextArea.getText());
		return true;
	}

	public String getContent(){
		return inputTextArea.getText();
	}
	public JScrollPane get() {
		return inputPane;
	}
	


}
