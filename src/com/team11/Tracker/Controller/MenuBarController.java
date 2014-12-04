package com.team11.Tracker.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarController implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		if ("New Tab".equals(e.getActionCommand())) {
			// Add a new tab. Remove this if windows used
			System.out.println("New Tab clicked!");

		} else if ("Delete".equals(e.getActionCommand())) {
			// delete a tab/windowed portfolio
			System.out.println("Delete clicked!");

		} else if ("Close All".equals(e.getActionCommand())) {
			// Close all tabs/windows
			System.out.println("Close All clicked!");

		} else if ("Exit".equals(e.getActionCommand())) {
			// Close the application
			System.out.println("Exit clicked!");
			System.exit(0);
		}

	}

}