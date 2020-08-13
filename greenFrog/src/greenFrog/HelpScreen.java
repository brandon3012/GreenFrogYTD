package greenFrog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class HelpScreen extends Menu {

	private JTextArea instrArea;
	private String instructions;
	private JButton goBackBtn;
	private MainMenu mainMenu;
	
	public HelpScreen() {
		initialize();
	}
	
	public void initialize() {
		frame.setBounds(100, 100, 500, 350);
		
		instructions = "Welcome! This program may or may not be run by an army of assorted frogs\n\n"
				+ "    IMPORTANT: You need to download toutube-dl or our friendly frogs won't know where to go."
				+ " Here's their webpage: https://youtube-dl.org/ \n\n"
				+ "    If you're having some trouble, youtube-dl might not be in your working directory. "
				+ "Not a problem! Just type the filepath to youtube-dl in \"Path to youtube-dl\", when "
				+ "downloading your video. Don't know where youtube-dl is? Just type \"type youtube-dl\", "
				+ "into your terminal, if you are using mac or linux. You will find the terminal for mac under the \"utilities\""
				+ " folder in your applications. If you don't know how to use the Linux terminal (you should if you're using Linux) "
				+ "type \"control + alt + t\", you're welcome. I'm not sure how to find youtube-dl in windows"
				+ " using the command prompt. I would just search for it like a normal file.\n\n"
				+ "That's all I can think of at the moment...";
		
		instrArea = new JTextArea(instructions);
		instrArea.setBounds(10, 10, 465, 250);
		instrArea.setLineWrap(true);
		instrArea.setBackground(blue);
		panel.add(instrArea);
		
		//back button
		goBackBtn = new JButton("Go Back");
		goBackBtn.setBounds(10, 270, 100, 25);
		goBackBtn.setBackground(buttonColor);
		goBackBtn.setForeground(btnTxtColor);
		goBackBtn.setFont(btnFont);
		goBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				goBack();
			}
		});
		panel.add(goBackBtn);
		
	}
	
	private void goBack() {
		mainMenu = new MainMenu();
	}
	
}
