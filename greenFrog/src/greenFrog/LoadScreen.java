package greenFrog;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class LoadScreen extends Menu {
	
	JLabel urlLab;
	String url;
	JFormattedTextField urlField;
	
	JLabel ytdlLab;
	String ytdlPath;
	JFormattedTextField ytdlField;
	
	String fileType;
	JButton download;
	JButton goBack;

	JFormattedTextField pathField; //path to youtube-dl
	
	ButtonGroup fileTypes;
	JRadioButton mp4Btn;
	JRadioButton mp3Btn;
	
	int winX;
	int winY;
	
	public LoadScreen() {
		winX = 400;
		winY = 400;
		ytdlPath = "youtube-dl";
		frame.setBounds(100, 100, winX, winY);
		
		//urlLab = new JLabel("YouTube URL:");
		
		initialize();
	}
	
	public void initialize() {
		addUrl(10, 10);
		addFileTypes(10, 75);
		addPath(10, 120);
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
		urlField.setBounds(x, y + labelY + 10, winX - (4 * x), 20);
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
		ytdlField.setBounds(x, y + labelY + 10, winX - (4 * x), 20);
		panel.add(ytdlField);
	}
	
	private void addFileTypes(int x, int y) {
		
		int vidX = 200;
		int vidY = 15;
		
		mp4Btn = new JRadioButton("Video");
		mp4Btn.setBounds(x, y, vidX, vidY);
		panel.add(mp4Btn);
		
		mp3Btn = new JRadioButton("Audio");
		mp3Btn.setBounds(x, y + vidY + 10,  vidX, vidY);
		panel.add(mp3Btn);
	}
	
	
}
