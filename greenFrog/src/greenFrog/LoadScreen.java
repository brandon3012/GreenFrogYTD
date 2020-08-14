package greenFrog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class LoadScreen extends Menu {
	
	//consts
	final String MP3 = "mp3";
	final String MP4 = "mp4";
	
	//url vars
	JLabel urlLab;
	String url;
	JFormattedTextField urlField;
	
	//path to youtube-dl
	JLabel ytdlLab;
	String ytdlPath;
	JFormattedTextField ytdlField;
	
	String fileType; //mp4, mp3 etc..

	JFormattedTextField pathField; //path to youtube-dl
	
	//radio buttonf for filetype
	ButtonGroup fileTypes;
	JRadioButton mp4Btn;
	JRadioButton mp3Btn;
	
	JButton downloadBtn;
	JButton goBackBtn;
	
	Boolean audioOnly; //is mp3 or other
	
	//a picture of a frog, nice
	JLabel frogLbl;
	
	DlCmd dlCmd; //download command
	Boolean isPlaylist;
	
	JLabel test = new JLabel("Test");
	
	int winX;
	int winY;
	
	public LoadScreen() {
		this.isPlaylist = false;
		winX = 400;
		winY = 300;
		ytdlPath = "youtube-dl";
		frame.setBounds(100, 100, winX, winY);
		initialize();
	}
	
	public LoadScreen(Boolean isPlaylist) {
		this.isPlaylist = isPlaylist;
		winX = 400;
		winY = 300;
		ytdlPath = "youtube-dl";
		frame.setBounds(100, 100, winX, winY);
		initialize();
	}
	
	public void initialize() {
		addUrl(10, 10);
		addFileTypes(10, 75);
		addFrog(210, 75);
		addPath(10, 120);
		addButtons(10, 180);
		test.setBounds(10, 200, 100, 20);
		//panel.add(test);
	}
	
	//x and y are coords of upper left corner of
	//the url label and input field
	private void addUrl (int x, int y) {
		
		//the size of the label
		int labelX = 200;
		int labelY = 20;
		
		urlLab = new JLabel("YouTube URL:");
		urlLab.setBounds(x, y, labelX, labelY);
		panel.add(urlLab);
		
		urlField = new JFormattedTextField();
		urlField.setBounds(x, y + labelY + 5, winX - (4 * x), 20);
		urlField.setBackground(lightGreen);
		panel.add(urlField);
	}
	
	//adds the youtube-dl path
	private void addPath(int x, int y) {
		
		int labelX = 200;
		int labelY = 20;
		
		//add the path label
		ytdlLab = new JLabel("Path to youtube-dl");
		ytdlLab.setBounds(x, y, labelX, labelY);
		panel.add(ytdlLab);
		
		//add the path input field
		ytdlField = new JFormattedTextField(ytdlPath);
		ytdlField.setBounds(x, y + labelY + 5, 180, 20);
		ytdlField.setBackground(lightGreen);
		panel.add(ytdlField);
	}
	
	//adds radio buttons to choose file type
	private void addFileTypes(int x, int y) {
		
		int vidX = 200;
		int vidY = 15;
		
		mp4Btn = new JRadioButton("Video");
		mp4Btn.setBounds(x, y, vidX, vidY);
		mp4Btn.setBackground(brown);
		mp4Btn.setSelected(true);
		panel.add(mp4Btn);
		
		mp3Btn = new JRadioButton("Audio");
		mp3Btn.setBounds(x, y + vidY + 10,  vidX, vidY);
		mp3Btn.setBackground(brown);
		panel.add(mp3Btn);
		
		fileTypes = new ButtonGroup();
		fileTypes.add(mp4Btn);
		fileTypes.add(mp3Btn);		
	}
	
	//add the buttons
	private void addButtons(int x, int y) {
		downloadBtn = new JButton("Download!");
		goBackBtn = new JButton("Go Back");
		
		//download button
		downloadBtn.setBounds(x, y, bWidth, bHeight);
		downloadBtn.setBackground(buttonColor);
		downloadBtn.setForeground(btnTxtColor);
		downloadBtn.setFont(btnFont);
		downloadBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				url = new String(urlField.getText());
				ytdlPath = new String(ytdlField.getText());
				fileType = new String(getFileType());
				
				
				dlCmd = new DlCmd();
				try {
					dlCmd.download(url, ytdlPath, fileType, isPlaylist, audioOnly);
					
					panel.add(test);
					
				} catch (IOException | InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		panel.add(downloadBtn);
		
		//go back button
		goBackBtn.setBounds(x + bWidth + 10, y, bWidth, bHeight);
		goBackBtn.setBackground(buttonColor);
		goBackBtn.setForeground(btnTxtColor);
		goBackBtn.setFont(btnFont);
		goBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainMenu mainMenu = new MainMenu();
			}
		});
		panel.add(goBackBtn);
	}
	
	private void addFrog(int x, int y) {
		//image of a frog, nice
		frogLbl = new JLabel();
		frogLbl.setIcon(new ImageIcon("frogPic.png"));
		frogLbl.setBounds(x, y, 160, 175);
		panel.add(frogLbl);
	}
	
	private String getFileType() {
		String output = new String();
		
		if(mp4Btn.isSelected()) {
			output = MP4;
			audioOnly = false;
		}
		
		else if (mp3Btn.isSelected()) {
			output = MP3;
			audioOnly = true;
		}
		
		return output;
	}
	
}
