package com.team11.Tracker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Interface {

	public static void show() {
		// Main Swing Interface can go here

		// Create and set up the window.
		JFrame mainApp = new JFrame("Folio Tracker");
		mainApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainApp.setSize(800, 600);
		mainApp.setLocationRelativeTo(null);

		JMenuBar mainMnu = menuSetup();

		mainApp.setJMenuBar(mainMnu);

		// =============================================
		// Began working on tabs
		JTabbedPane tabbedPane = new JTabbedPane();
		mainApp.setContentPane(tabbedPane);
		JComponent pnl1 = makeTextPanel("Portfolio: 1");
		tabbedPane.addTab("Tab 1", pnl1);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent pnl2 = makeTextPanel("Portfolio: 2");
		tabbedPane.addTab("Tab 2", pnl2);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
		// =============================================

		// Display the window.
		// frame.pack();
		mainApp.setVisible(true);
	}

	private static JMenuBar menuSetup() {

		// Where the GUI is created:
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;

		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the first menu.
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.getAccessibleContext().setAccessibleDescription(
				"File Menu for performing application specific tasks");
		menuBar.add(menu);

		// a group of JMenuItems

		menuItem = new JMenuItem("New Tab", KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Open a new Tab");
		menu.add(menuItem);

		menuItem = new JMenuItem("Delete", KeyEvent.VK_D);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Delete a Portfolio");
		menu.add(menuItem);

		menuItem = new JMenuItem("Close All ", KeyEvent.VK_C);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Close all portfolios");
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Exit", KeyEvent.VK_X);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Terminate the Application");
		menu.add(menuItem);

		return menuBar;
	}



	// private static Component newTab(JTabbedPane tabbedPane){
	//
	// JComponent pnl1 = makeTextPanel("Portfolio: ");
	// tabbedPane.addTab("Tab 1", pnl1);
	// tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
	//
	// return tabbedPane;
	//
	// }
	//

	// =============================================
	// Code for experimental tabs. Will almost certainly need substantial
	// changes
	protected static JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}
	// =============================================

}
