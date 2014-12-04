package com.team11.Tracker.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class mainGUI implements MainGUIInterface{
	private static JPanel panel;
	
	public static void show(){
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
		JComponent pnl1 = new JPanel();
		BorderLayout layout = new BorderLayout();
	    pnl1.setLayout(layout); 
	     
		tabbedPane.addTab("Tab 1", pnl1);
		pnl1.setBackground(Color.YELLOW);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		

		
		//Design of the JPanel at the very bottom whose function is to hold the components to support		
		// the basic functionally of adding stock.
		JComponent pnl1p1 = new JPanel();
		pnl1p1.setBackground(Color.GREEN);
		pnl1.add(pnl1p1,BorderLayout.SOUTH);
		FlowLayout fl = new FlowLayout (-4);
		pnl1p1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnl1p1.setLayout(fl);
		
		//Label for Ticker Symbol
		JLabel tickerlabel = new JLabel("Ticker Symbol");
		JTextArea tickerInput = new JTextArea("  ");
		tickerInput.setColumns(5);
		tickerInput.setPreferredSize(new Dimension(20, 20));
		tickerInput.setMaximumSize(new Dimension(20, 20));
		pnl1p1.add(tickerlabel);
				
		//Label for Amount
		pnl1p1.add(tickerInput);
		JLabel amountlabel = new JLabel("  Amount");
		pnl1p1.add(			amountlabel);
		JTextArea amountInput = new JTextArea("  ");
		amountInput.setColumns(5);
		amountInput.setPreferredSize(new Dimension(20, 20));
		amountInput.setMaximumSize(new Dimension(20, 20));
		pnl1p1.add(amountInput);
		
		//Button to add stocks. The button takes the form of an image of a plus sign from a URL.
		JButton button = new JButton();
		  try {
			 URL url = new URL("https://cdn3.iconfinder.com/data/icons/shadcon/512/circle-plus-20.png");
			 Image image = ImageIO.read(url);
		    button.setIcon(new ImageIcon(image));
			pnl1p1.add(button);
		  } catch (IOException ex) {
	  }
	
		//Error label to display error messages. e.g. if ticker symbol is invalid or invalid argument for Amount textbox
		JLabel errorLabel = new JLabel();	
		pnl1p1.add(errorLabel);
		errorLabel.setVisible(false);
		
		
		//JLabel for displaying the table containing the portfolio data
		JComponent pnl1p2 = new JPanel();
		pnl1p2.setBackground(Color.RED);
		pnl1.add(pnl1p2,BorderLayout.NORTH);
		pnl1p2.setPreferredSize(new Dimension(300,300));
		
		
		
		
		
		
		
		JPanel pnl2 = new JPanel();
		tabbedPane.addTab("Tab 2", pnl2);		
		
		JComponent pnl3 = makeTextPanel("Portfolio: 3");
		tabbedPane.addTab("Tab 3", pnl3);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
		
		JComponent pnl4 = makeTextPanel("Portfolio: 4");
		tabbedPane.addTab("Tab 4", pnl4);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
		// =============================================

		
		
		// Display the window.
		// frame.pack();
		mainApp.setVisible(true);
	}

	private static JMenuBar menuSetup() {

		// Where the GUI is created:
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;

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
		menuItem.addActionListener(new com.team11.Tracker.Controller.MenuBarController());
		menu.add(menuItem);

		menuItem = new JMenuItem("Delete", KeyEvent.VK_D);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Delete a Portfolio");
		menuItem.addActionListener(new com.team11.Tracker.Controller.MenuBarController());
		menu.add(menuItem);

		menuItem = new JMenuItem("Close All", KeyEvent.VK_C);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Close all portfolios");
		menuItem.addActionListener(new com.team11.Tracker.Controller.MenuBarController());
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Exit", KeyEvent.VK_X);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Terminate the Application");
		menuItem.addActionListener(new com.team11.Tracker.Controller.MenuBarController());
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
