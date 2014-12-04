package com.team11.Tracker;


import com.team11.Tracker.View.mainGUI;

public class Main {

	// bootstrap to create initial gui. Should create controller too

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mainGUI.show();
			}
		});


	}
}
