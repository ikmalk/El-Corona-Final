package corona.simulator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class LogUpdate extends JFrame{

	private JTextArea log;
	
	public LogUpdate() {
		super("Log");
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 265, 283);
		getContentPane().add(scrollPane);
		
		log = new JTextArea();
		scrollPane.setViewportView(log);
		log.setBounds(5,5,255,245);
		log.setEditable(false);
		
		DefaultCaret caret = (DefaultCaret)log.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
	}
	
	public void setLog(int name, int day, String building) {
		
		log.append(String.format("%d infected on day %d in %s\n", name,day,building));
		
	}
	
	public void reset() {
		log.setText("Infected List: \n");
	}
}
