package greenFrog;

import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class MainMenu extends Menu {
	

	private JButton toVidBtn;
	private JButton toPlstBtn;
	private JButton toHlpBtn;
	private JLabel welcomeMsg;
	private JLabel frogLbl;
	private LoadScreen loadScreen;
	private ErrorMsg errorMsg;
	
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		//the frame
		frame.setBounds(100, 100, 450, 235);
		
		//opening message
		welcomeMsg = new JLabel("Green Frog YTD");
		welcomeMsg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		welcomeMsg.setBounds(25, 0, 225, 50);
		panel.add(welcomeMsg);
		
		//button to download a video
		toVidBtn = new JButton("Video");
		toVidBtn.setBounds(25, 60, 100, 25);
		toVidBtn.setBackground(buttonColor);
		toVidBtn.setForeground(btnTxtColor);
		panel.add(toVidBtn);
		
		//button to download a playlist
		toPlstBtn = new JButton("Playlist");
		toPlstBtn.setBounds(25, 100, 100, 25);
		toPlstBtn.setBackground(buttonColor);
		toPlstBtn.setForeground(btnTxtColor);
		panel.add(toPlstBtn);
	
		//button to help menu
		toHlpBtn = new JButton("Help");
		toHlpBtn.setBounds(25, 140, 100, 25);
		toHlpBtn.setBackground(buttonColor);
		toHlpBtn.setForeground(btnTxtColor);
		panel.add(toHlpBtn);
		
		//image of a frog, nice
		frogLbl = new JLabel();
		frogLbl.setIcon(new ImageIcon("frogPic.png"));
		frogLbl.setBounds(250, 10, 160, 175);
		panel.add(frogLbl);
	}
	
	/*
	 * OPEN LOAD MENU
	 * opens menu and passes if it is a playlist or not
	 */
	private void openLoadMn(Boolean isItPlay) {
		
	}
	
	/*
	 * OPEN HELP MENU
	 * self explanatory
	 */
	private void openHelp() {
		
	}
}
