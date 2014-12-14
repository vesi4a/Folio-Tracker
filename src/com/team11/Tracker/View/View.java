package com.team11.Tracker.View;

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

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class View {

	private static JFrame frame;
	private JTextField txtFieldTicker;
	private JTextField txtFieldAmount;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;

	private ArrayList<JTable> tables;

	private JButton btnAdd;
	private JLabel lblFolioValue;


	private JMenuItem newFolioMenuItem;

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public JMenuItem getNewFolioMenuItem() {
		return newFolioMenuItem;
	}

	public JTextField getTxtFieldTicker() {
		return txtFieldTicker;
	}

	public JTextField getTxtFieldAmount() {
		return txtFieldAmount;
	}

	public JLabel getLblFolioValue() {
		return lblFolioValue;
	}

	public ArrayList<JTable> getTables() {
		return tables;
	}



	public JButton getBtnAdd() {
		return btnAdd;
	}

	// // private static JScrollPane scrollPane2;
	//
	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// @SuppressWarnings("static-access")
	// public void run() {
	// try {
	// View window = new View();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Folio Tracker");

		// frame.setBounds(100, 100, 800, 600);
		frame.setSize(800, 600); // Window boundary
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar mainMnu = menuSetup();  // **listeners required**
		frame.setJMenuBar(mainMnu);

		frame.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP); // Window for displaying portfolio
		tabbedPane.setBounds(6, 30, 788, 400); // old values 6 6 788 484
		frame.getContentPane().add(tabbedPane);


		tables = new ArrayList<JTable>();

		createTab("Portfolio1");
		createTab("Portfolio2"); // second tab to test for layout

		// Labels and text fields
		JLabel lblAddStock = new JLabel("Add Stock:"); // add stock label
		lblAddStock.setBounds(16, 6, 84, 16); // old values 16 485 84 16
		frame.getContentPane().add(lblAddStock);

		JLabel lblTickerSymbol = new JLabel("Ticker Symbol"); // ticker symbol label
		lblTickerSymbol.setBounds(112, 6, 89, 16); // 112 485 89 16
		frame.getContentPane().add(lblTickerSymbol);

		txtFieldTicker = new JTextField();
		txtFieldTicker.setBounds(213, 0, 84, 28); // ticker symbol text box
		frame.getContentPane().add(txtFieldTicker); // old values 213 479 84 28
		txtFieldTicker.setColumns(10);

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(309, 6, 55, 16); // amount label
		frame.getContentPane().add(lblAmount); // old values 309 485 55 16

		txtFieldAmount = new JTextField();
		txtFieldAmount.setBounds(363, 0, 72, 28); // amount text box
		frame.getContentPane().add(txtFieldAmount); // old values 363 479 72 28
		txtFieldAmount.setColumns(10);

		btnAdd = new JButton("Add"); // add button - **listener required**
		btnAdd.setBounds(450, 0, 117, 29); // old values 545 480 117 29
		frame.getContentPane().add(btnAdd);

//		JButton btnDel = new JButton("Delete"); // delete button - **listener required**
//		btnDel.setBounds(545, 521, 117, 29);
//		frame.getContentPane().add(btnDel);

		JLabel lblnull_1 = new JLabel("(Error message placeholder)"); // displays error message
		lblnull_1.setBounds(600, 6, 200, 16); // old values 694 487 61 22
		frame.getContentPane().add(lblnull_1);

		JLabel lblTotalValue = new JLabel("Total value of portfolio:"); // total value label
		lblTotalValue.setBounds(16, 450, 159, 16); // old values 16 534 159 16
		frame.getContentPane().add(lblTotalValue);

		lblFolioValue = new JLabel("$0.00"); // displays total portfolio value
		lblFolioValue.setBounds(177, 450, 61, 16); // old values 177 534 61 16
		frame.getContentPane().add(lblFolioValue);
		
		JButton btnHist = new JButton("History"); // history button - **listener required**
		btnHist.setBounds(600, 445, 117, 29); // old values 247 529 117 29
		frame.getContentPane().add(btnHist);

//		JButton btnClose = new JButton("Close"); // Close button - **listener required**
//		btnClose.setBounds(662, 521, 117, 29);
//		frame.getContentPane().add(btnClose);

		// confirmDelete();
		// createNewPortfolio();
		// stockAddingError();
		// editStock();

		frame.setVisible(true);
	}

	public void createTab(String PortfolioName) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Ticker Symbol");
		model.addColumn("Number of Shares");
		model.addColumn("Price");
		model.addColumn("Value");

		// Create a new table instance that doesn't allow user editing of the
		// cells
		JTable table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.setFillsViewportHeight(false);

		tables.add(table);

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

	public static void createNewPortfolioOld() {
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

	/*
	 * Creates a new dialogue box which has a text field to accept a stringThis
	 * string, provided by the user, will be the name of the newly created
	 * PortFolio
	 */
	private void createNewPortfolio() {
		JTextField portFolioNameEntry = new JTextField(20);
		JPanel newPortFolioPanel = new JPanel();
		JLabel enterPortFolioNameLabel = new JLabel("Enter PortFolio Name:");
		newPortFolioPanel.setLayout(new BoxLayout(newPortFolioPanel,
				BoxLayout.Y_AXIS));
		portFolioNameEntry.setMaximumSize(new Dimension(1500, 20));
		newPortFolioPanel.add(enterPortFolioNameLabel);
		newPortFolioPanel.add(portFolioNameEntry);
		int result = JOptionPane.showConfirmDialog(null, newPortFolioPanel,
				"Create New PortFolio", JOptionPane.OK_CANCEL_OPTION);
		String projname = (portFolioNameEntry.getText());
	}

	private JMenuBar menuSetup() {

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

		newFolioMenuItem = new JMenuItem("New Portfolio", KeyEvent.VK_N);
		newFolioMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.ALT_MASK));
		newFolioMenuItem.getAccessibleContext().setAccessibleDescription(
				"Open a new Tab");
		// menuItem.addActionListener(new MenuBarController());
		menu.add(newFolioMenuItem);

		menuItem = new JMenuItem("Open", KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Open a portfolio file");
		// menuItem.addActionListener(new MenuBarController());
		menu.add(menuItem);

		menuItem = new JMenuItem("Delete", KeyEvent.VK_D);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Delete a Portfolio");
		// menuItem.addActionListener(new MenuBarController());
		menu.add(menuItem);

		menuItem = new JMenuItem("Close All", KeyEvent.VK_C);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Close all portfolios");
		// menuItem.addActionListener(new MenuBarController());
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Exit", KeyEvent.VK_X);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Terminate the Application");
		// menuItem.addActionListener(new MenuBarController());
		menu.add(menuItem);

		return menuBar;
	}
}
