/*********************************************************
 * ERROR MESSAGE
 * displays an error message. mostly for testing but if
 * a problem arises the user won't be left wondering
 * why their program is frozen
 ********************************************************/

package greenFrog;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorMsg extends Menu {
	
	private String errorMessage;
	private JLabel errorLabel;
	
	//if this gets called there is a problem
	public ErrorMsg() {
		errorMessage = new String("Default Message");
		initialize();
	}
	
	/*
	 * Will be using this constructor almost always
	 * otherwise we won't know what the error is
	 * */
	
	public ErrorMsg(String inputMsg) {
		errorMessage = new String(inputMsg);
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame.setBounds(100, 100, 450, 100);
		panel.setBackground(Color.PINK);
		errorLabel = new JLabel(errorMessage);
		errorLabel.setBounds(10, 11, 440, 40);
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel.add(errorLabel);
	}	
}
