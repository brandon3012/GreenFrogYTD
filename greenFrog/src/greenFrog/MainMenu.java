/*************************************************
 * MAIN MENU
 * you can download a playlist, a video, or go to
 * the help menu
 ************************************************/

package greenFrog;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu extends Menu {
	

	private JButton toVidBtn;
	private JButton toPlstBtn;
	private JButton toHlpBtn;
	private JLabel welcomeMsg;
	private JLabel frogLbl;
	private LoadScreen loadScreen;
	private HelpScreen helpScreen;
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
		welcomeMsg.setFont(new Font("Tempus Sans ITC", Font.BOLD, 21));
		welcomeMsg.setBounds(25, 0, 225, 50);
		panel.add(welcomeMsg);
		
		//button to download a video
		toVidBtn = new JButton("Video");
		toVidBtn.setBounds(25, 60, 100, 25);
		toVidBtn.setBackground(buttonColor);
		toVidBtn.setForeground(btnTxtColor);
		toVidBtn.setFont(btnFont);
		toVidBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				openLoadMn(false);
			}
		});
		panel.add(toVidBtn);
		
		//button to download a playlist
		toPlstBtn = new JButton("Playlist");
		toPlstBtn.setBounds(25, 100, 100, 25);
		toPlstBtn.setBackground(buttonColor);
		toPlstBtn.setForeground(btnTxtColor);
		toPlstBtn.setFont(btnFont);
		toPlstBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				openLoadMn(true);
			}
		});
		panel.add(toPlstBtn);
	
		//button to help menu
		toHlpBtn = new JButton("Help");
		toHlpBtn.setBounds(25, 140, 100, 25);
		toHlpBtn.setBackground(buttonColor);
		toHlpBtn.setForeground(btnTxtColor);
		toHlpBtn.setFont(btnFont);
		toHlpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				openHelp();
			}
		});
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
	private void openLoadMn(Boolean isPlaylist) {
		loadScreen = new LoadScreen();
	}
	
	/*
	 * OPEN HELP MENU
	 * self explanatory
	 */
	private void openHelp() {
		helpScreen = new HelpScreen();
	}
}
