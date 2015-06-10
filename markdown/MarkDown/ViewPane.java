package gui;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import com.petebevin.markdown.MarkdownProcessor;

public class ViewPane implements Observer{
	//滚动面板
	private final JScrollPane previewPane = new JScrollPane();
	private final JLabel previewLabel = new JLabel();
	
	/**
	 * Creates the HTML JLabel and sets its vertical alignment as in the top.
	 */
	public ViewPane() {
		previewLabel.setVerticalAlignment(JLabel.TOP);
		previewPane.getViewport().add(previewLabel, null);
	}


	public JScrollPane get() {
		return previewPane;
	}
	
	//重写更新
	//edit的notify信号发出时做出更新
	@Override
	public void update(final Observable o, final Object data) {
		if (o instanceof EditPane) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					String content = (String)data;
					MarkdownProcessor processor = new MarkdownProcessor();
					//写文本
					previewLabel.setText(String.format("<html>%s</html>", processor.markdown(content)).replaceAll("src=\"", "src=\"file:")); // Fix to display images properly.
				}
			});
		}
	}

}
