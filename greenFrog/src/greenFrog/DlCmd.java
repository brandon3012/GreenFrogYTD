package greenFrog;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

public class DlCmd {
	//final String PLAYLIST = "-cit";
	final String PLAYLIST = "--yes-playlist";
	final String NOPLAYLIST = "--no-playlist";
	final String EXTRACTAUDIO = "-x";
	final String AUDIOFORMAT = "--audio-format";
	final String RECODEVID = "--recode-video";
	final String MP3 = "mp3";
	final String MP4 = "mp4";
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
	
	//called from the loading meny
	public void download(String url, String path, String audioTyp,
			String vidTyp, Boolean isPlaylist, Boolean audioOnly) throws IOException, InterruptedException {
		/*
		this.url = url;
		this.path = path;
		this.audioTyp = audioTyp;
		this.vidTyp = vidTyp;
		this.isPlaylist = isPlaylist;
		*/
		
		command = makeCommand(url, path, audioTyp, vidTyp, 
				isPlaylist, audioOnly);
		runCommand(command);
	}
	
	//puts together a command to send to youtube-dl
	private ArrayList<String> makeCommand(String url, String path, String audioTyp,
			String vidTyp, Boolean isPlaylist, Boolean audioOnly) {
		
		ArrayList<String>output = new ArrayList<String>();
		
		output.add(path);
		if(audioOnly) {
			output.add(EXTRACTAUDIO);
			output.add(AUDIOFORMAT);
			output.add(audioTyp);
		}
		
		else {
			output.add(RECODEVID);
			output.add(vidTyp);
		}
		
		output.add(url);
		return output;
	}
	
	//runs a command
	private void runCommand(ArrayList<String> toExecute) throws IOException, InterruptedException {
		ProcessBuilder processBuilder = new ProcessBuilder(toExecute);
		Process process = processBuilder.inheritIO().start();
		process.waitFor();
	}
}
