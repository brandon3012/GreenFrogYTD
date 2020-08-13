/************************************************
 * MENU
 * every windows extends this class
 * **********************************************/
package greenFrog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu {
	protected JFrame frame;
	protected JPanel panel;
	protected Boolean canResize;
	protected ErrorMsg errorMsg;
	protected Color buttonColor;
	protected Color btnTxtColor;
	protected Font btnFont;
	protected int bHeight; //height of a button
	protected int bWidth;
	
	private String title;
	
	
	protected Color lightGreen;
	private Color darkGreen;
	private Color orange;
	private Color red;
	protected Color blue;
	private Color darkOrange;
	protected Color brown;
	
	public Menu() {
		
		//some colors
		lightGreen = new Color(0, 127, 0);
		darkGreen = new Color(0, 76, 0);
		orange = new Color(231, 89, 43);
		red = new Color(153, 0, 0);
		blue = new Color(0, 111, 96);
		darkOrange = new Color(149, 50, 17);
		brown = new Color(128, 98, 30);
		
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
		panel.setBackground(brown);
		
		//button defaults
		buttonColor = darkGreen;
		btnTxtColor = orange;
		btnFont = new Font("Segoe UI Light", Font.BOLD, 15);
		bHeight = 25;
		bWidth = 100;
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
