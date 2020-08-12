package greenFrog;

import java.awt.EventQueue;

public class Start {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.getFrame().setVisible(true);					
				} catch (Exception e) {
					//System.out.println("Error initialzing program");
					ErrorMsg error = new ErrorMsg("Error starting program");
					e.printStackTrace();
				}
			}
		});
	}
}
