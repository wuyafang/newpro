package gui;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditPane extends Observable{
	//����д������
	private final JScrollPane inputPane = new JScrollPane();
	private final JTextArea inputTextArea = new JTextArea();
	
	public EditPane() {
		inputPane.getViewport().add(inputTextArea, null);
		//������������
		inputTextArea.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				//�۲���ģʽ
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
