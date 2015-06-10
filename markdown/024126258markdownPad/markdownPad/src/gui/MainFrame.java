package gui;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class MainFrame{
	private JFrame markdown;
	private EditPane editPane;
	private ViewPane viewPane;
	
	public MainFrame(){
		//main frame
		markdown = new JFrame();
		markdown.setSize(1000, 600);
		markdown.setTitle("MarkDown");
		markdown.setVisible(true);

		//set the edit and view pane
		//编辑面板和显示面板
		editPane = new EditPane();
		viewPane = new ViewPane();
		//添加观察者
		editPane.addObserver(viewPane);
		//分割面板
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				editPane.get(),viewPane.get());
		
		//set the mainframe
		markdown.add(splitPane);  
		splitPane.setDividerLocation(0.5);
		
	}
	

}
