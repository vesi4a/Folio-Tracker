package com.team11.Tracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		if ("New Tab".equals(e.getActionCommand())) {
			// Add a new tab. Remove this if windows used
		} else if ("Delete".equals(e.getActionCommand())) {
			// delete a tab/windowed portfolio
		} else if ("Close All".equals(e.getActionCommand())) {
			// Close all tabs/windows
		} else if ("Exit".equals(e.getActionCommand())) {
			// Close the application
			System.exit(0);
		}

	}

}
