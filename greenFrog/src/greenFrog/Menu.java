package greenFrog;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu {
	protected JFrame frame;
	protected JPanel panel;
	protected Boolean canResize;
	protected ErrorMsg errorMsg;
	protected Color buttonColor;
	protected Color btnTxtColor;
	private String title;
	
	public Menu() {
		//the frame
		title = "Green Frog YTD";
		frame = new JFrame(title);
		//frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//the panel
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		//panel.setBackground(new Color(219, 181, 116));
		panel.setBackground(new Color(128, 98, 30));
		buttonColor = new Color(0, 76, 0);
		btnTxtColor = new Color(231, 89, 43);
	}
	
	public void initialize() {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
	}
	
	/*
	 * Getters and setters
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/*
	 * OPEN ERROR MESSAGE
	 * every window needs this
	 * */
	private void openError() {
		
	}
	
	
}
