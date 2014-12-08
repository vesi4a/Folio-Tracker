package com.team11.Tracker.View;

import com.team11.Tracker.Controller.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class guigen {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static JTabbedPane tabbedPane;
	private JScrollPane scrollPane;

	// private static JScrollPane scrollPane2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					guigen window = new guigen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guigen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Folio Tracker");
//		frame.setBounds(100, 100, 800, 600);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar mainMnu = menuSetup();
		frame.setJMenuBar(mainMnu);

		frame.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 788, 484);
		frame.getContentPane().add(tabbedPane);

		createTab("Portfolio1");

		// Labels and text fields
		JLabel lblAddStock = new JLabel("Add Stock:");
		lblAddStock.setBounds(16, 485, 84, 16);
		frame.getContentPane().add(lblAddStock);

		JLabel lblTickerSymbol = new JLabel("Ticker Symbol");
		lblTickerSymbol.setBounds(112, 485, 89, 16);
		frame.getContentPane().add(lblTickerSymbol);

		textField = new JTextField();
		textField.setBounds(213, 479, 84, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(309, 485, 55, 16);
		frame.getContentPane().add(lblAmount);

		textField_1 = new JTextField();
		textField_1.setBounds(363, 479, 72, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(545, 480, 117, 29);
		btnAdd.addActionListener(new addStockController());
		frame.getContentPane().add(btnAdd);

		JButton btnDel = new JButton("Delete");
		btnDel.setBounds(545, 521, 117, 29);
		btnDel.addActionListener(new deleteStockController());
		frame.getContentPane().add(btnDel);

		JButton btnHist = new JButton("History");
		btnHist.setBounds(247, 529, 117, 29);
		btnHist.addActionListener(new historyStockController());
		frame.getContentPane().add(btnHist);

		JLabel lblnull_1 = new JLabel("(null)");
		lblnull_1.setBounds(694, 487, 61, 22);
		frame.getContentPane().add(lblnull_1);

		JLabel lblTotalValue = new JLabel("Total value of portfolio:");
		lblTotalValue.setBounds(16, 534, 159, 16);
		frame.getContentPane().add(lblTotalValue);

		JLabel lblnull = new JLabel("(null)"); // <<<<<<<WHAT IS THIS??????
		lblnull.setBounds(177, 534, 61, 16);
		frame.getContentPane().add(lblnull);

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(662, 521, 117, 29);
		btnClose.addActionListener(new closeStockController());
		frame.getContentPane().add(btnClose);

		// confirmDelete();
		// createNewPortfolio();
		// stockAddingError();
		// editStock();

	}

	private void createTab(String PortfolioName) {
		// Create columns names
		String columnNames[] = { "Ticker Symbol", "Name", "Number of Shares",
				"Price", "Value" };

		// Create some data
		String dataValues[][] = { { "TST1", "Test1", "50", "1.50", "75.00" } };

		// Create a new table instance
		JTable table = new JTable(dataValues, columnNames);
		table.setFillsViewportHeight(true);

		// Add the table to a scrolling pane
		scrollPane = new JScrollPane(table);
		tabbedPane.addTab(PortfolioName, null, scrollPane, null);

	}

	private static void editStock() {
		// // Create columns names
		// String columnNames[] = { "", ""};
		//
		// // Create some data
		// String dataValues[][] = { {"TST1", "Test Stock 3"},
		// {"Current Value: ", "3.0"}, {"Daily Change: ", "0.0"},
		// {"Number of Shares", "300"}, {"Initial value", "1.0"}, {"Total gain",
		// "-127.0"} };
		//
		// // Create a new table instance
		// JTable table = new JTable(dataValues, columnNames);
		// //table.setFillsViewportHeight(true);
		//
		// // Add the table to a scrolling pane
		// scrollPane2 = new JScrollPane(table);
		// scrollPane2.setMaximumSize(new Dimension(100,100));
		// JOptionPane.showMessageDialog(null, scrollPane2,
		// "dialog test with textarea",
		// JOptionPane.INFORMATION_MESSAGE);
		JFrame frame2;
		JTextField textField1;
		JTextField textField2;

		frame2 = new JFrame("Edit stock");
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		frame2.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 364, 221);
		frame2.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Editing Portfolio:");
		lblNewLabel.setBounds(6, 6, 115, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("TestPortfolio 1");
		lblNewLabel_1.setBounds(185, 6, 121, 16);
		panel.add(lblNewLabel_1);

		JLabel lblTst = new JLabel("TST3");
		lblTst.setBounds(6, 32, 115, 16);
		panel.add(lblTst);

		JLabel lblTes = new JLabel("Test Stock 3");
		lblTes.setBounds(185, 32, 111, 16);
		panel.add(lblTes);

		JLabel lblCurrentValue = new JLabel("Current Value:");
		lblCurrentValue.setBounds(6, 60, 115, 16);
		panel.add(lblCurrentValue);

		JLabel lblNewLabel_2 = new JLabel("3.0");
		lblNewLabel_2.setBounds(133, 60, 51, 16);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Daily Change:");
		lblNewLabel_3.setBounds(185, 60, 98, 16);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("0.0");
		lblNewLabel_4.setBounds(295, 60, 61, 16);
		panel.add(lblNewLabel_4);

		JLabel lblNumberOfShares = new JLabel("Number Of Shares:");
		lblNumberOfShares.setBounds(6, 88, 121, 16);
		panel.add(lblNumberOfShares);

		textField1 = new JTextField();
		textField1.setBounds(185, 82, 134, 28);
		panel.add(textField1);
		textField1.setColumns(10);

		JLabel lblInitialValue = new JLabel("Initial Value:");
		lblInitialValue.setBounds(6, 117, 121, 16);
		panel.add(lblInitialValue);

		textField2 = new JTextField();
		textField2.setBounds(185, 111, 134, 28);
		panel.add(textField2);
		textField2.setColumns(10);

		JLabel lblTotalGain = new JLabel("Total Gain:");
		lblTotalGain.setBounds(6, 145, 115, 16);
		panel.add(lblTotalGain);

		JLabel lblNewLabel_5 = new JLabel("-297.0");
		lblNewLabel_5.setBounds(133, 145, 80, 16);
		panel.add(lblNewLabel_5);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(6, 175, 117, 29);
		panel.add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(128, 175, 117, 29);
		panel.add(btnCancel);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(247, 175, 117, 29);
		panel.add(btnDelete);

	}

	private static void stockAddingError() {
		JOptionPane.showMessageDialog(frame,
				"Number of shares must be a positive number",
				"Error Adding Stock", JOptionPane.INFORMATION_MESSAGE);
	}

	private static void confirmDelete() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(frame,
				"Are you sure you want to delete this portfolio?",
				"Delete Portfolio", dialogButton);
		if (dialogResult == 0)
			System.out.println("Yes option");
		else
			System.out.println("No Option");
	}

	public static void createNewPortfolio() {
		JTextField folioName = new JTextField(20);

		JFileChooser inputfile = new JFileChooser();
		inputfile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		File file = inputfile.getSelectedFile();
		// String fullpath = file.getAbsolutePath();

		JPanel jpanel = new JPanel();

		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));

		JLabel projectNameLabel = new JLabel("Project Name:");
		projectNameLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jpanel.add(projectNameLabel);
		jpanel.add(folioName);

		jpanel.add(new JLabel("Import stock file (optional)"));
		jpanel.add(inputfile);
		int result = JOptionPane.showConfirmDialog(null, jpanel,
				"Create new PortFolio", JOptionPane.OK_CANCEL_OPTION);
		String projname = (folioName.getText());
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

		menuItem = new JMenuItem("New Portfolio", KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Open a new Tab");
		menuItem.addActionListener(new com.team11.Tracker.Controller.MenuBarController());
		menu.add(menuItem);

		menuItem = new JMenuItem("Open", KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Open a portfolio file");
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
}
