package greenFrog;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingWorker;

public class DlCmd {
	//final String PLAYLIST = "-cit";
	final String PLAYLIST = "--yes-playlist";
	final String NOPLAYLIST = "--no-playlist";
	final String EXTRACTAUDIO = "-x";
	final String AUDIOFORMAT = "--audio-format";
	final String RECODEVID = "--recode-video";
	final String BESTAUDIO = "best";
	final String RICKROLL = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
	
	/*
	private String path;
	private String url;
	private String audioTyp;
	private String vidTyp;
	private Boolean isPlaylist;
	private ArrayList<String> command;
	*/
	
	private ArrayList<String> command;
	private Boolean isFinished;
	
	public DlCmd() {
		/*
		path = "youtube-dl";
		url = RICKROLL;
		audioTyp = BESTAUDIO;
		vidTyp = MP4;
		isPlaylist = false;
		command = new ArrayList<String>();
		*/
		command = new ArrayList<String>();
	}
	
	public DlCmd(String url, String path, String fileType,
			Boolean isPlaylist, Boolean audioOnly) {
		
	}
	
	//called from the loading meny
	public void download(String url, String path, String fileType,
			Boolean isPlaylist, Boolean audioOnly) throws IOException, InterruptedException {
		/*
		this.url = url;
		this.path = path;
		this.audioTyp = audioTyp;
		this.vidTyp = vidTyp;
		this.isPlaylist = isPlaylist;
		*/
		
		command = makeCommand(url, path, fileType, 
				isPlaylist, audioOnly);
		runCommand(command);
	}
	
	//puts together a command to send to youtube-dl
	private ArrayList<String> makeCommand(String url, String path, String fileType,
			Boolean isPlaylist, Boolean audioOnly) {
		
		ArrayList<String>output = new ArrayList<String>();
		
		output.add(path);
		if(audioOnly) {
			output.add(EXTRACTAUDIO);
			output.add(AUDIOFORMAT);
			output.add(fileType);
		}
		
		else {
			//output.add(RECODEVID);
			//output.add(fileType);
		}
		
		if(!isPlaylist) {
			output.add(NOPLAYLIST);
		}
		
		output.add(url);
		return output;
	}
	
	//runs a command
	private void runCommand(ArrayList<String> toExecute) throws IOException, InterruptedException {
		SwingWorker<Void, String> worker = new SwingWorker<Void, String> () {

			@Override
			protected Void doInBackground() throws Exception {
				isFinished = false;
				ProcessBuilder processBuilder = new ProcessBuilder(toExecute);
				Process process = processBuilder.inheritIO().start();
				process.waitFor();
				if(process.exitValue() != 0) {
					ErrorMsg error = new ErrorMsg("Error Downloading Video");
				}
				isFinished = true;				
				return null;
			}			
		};
		worker.execute();
	}
	
	public Boolean getIsFinished() {
		return isFinished;
	}
}
