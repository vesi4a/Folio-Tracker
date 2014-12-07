import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class guigen {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static JTabbedPane tabbedPane;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar mainMnu = menuSetup();
		frame.setJMenuBar(mainMnu);

		
		frame.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 788, 484);
		frame.getContentPane().add(tabbedPane);
		
		createTab("Portfolio1");

		// Labels and text fields
		JLabel lblAddStock = new JLabel("Add Stock-");
		lblAddStock.setBounds(16, 485, 84, 16);
		frame.getContentPane().add(lblAddStock);

		JLabel lblTickerSymbol = new JLabel("Ticker Symbol");
		lblTickerSymbol.setBounds(125, 485, 89, 16);
		frame.getContentPane().add(lblTickerSymbol);

		textField = new JTextField();
		textField.setBounds(230, 479, 84, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(326, 485, 55, 16);
		frame.getContentPane().add(lblAmount);

		textField_1 = new JTextField();
		textField_1.setBounds(377, 479, 72, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(545, 480, 117, 29);
		btnAdd.addActionListener(new com.team11.Tracker.Controller.addStockController());
		frame.getContentPane().add(btnAdd);

		JButton btnDel = new JButton("Delete");
		btnDel.setBounds(545, 520, 117, 29);
		frame.getContentPane().add(btnDel);

		JButton btnHist = new JButton("History");
		btnHist.setBounds(670, 520, 117, 29);
		frame.getContentPane().add(btnHist);

		JLabel lblnull_1 = new JLabel("(null)");
		lblnull_1.setBounds(708, 482, 61, 22);
		frame.getContentPane().add(lblnull_1);

		JLabel lblTotalValue = new JLabel("Total value of portfolio:");
		lblTotalValue.setBounds(16, 534, 159, 16);
		frame.getContentPane().add(lblTotalValue);

		JLabel lblnull = new JLabel("(null)");
		lblnull.setBounds(177, 534, 61, 16);
		frame.getContentPane().add(lblnull);

		confirmDelete();
		createNewPortfolio();

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

	private static void createNewPortfolio() {
		JTextField folioName = new JTextField(20);

		JFileChooser inputfile = new JFileChooser();
		inputfile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		File file = inputfile.getSelectedFile();
		//String fullpath = file.getAbsolutePath();

		JPanel jpanel = new JPanel();

		

		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
		
		JLabel projectNameLabel = new JLabel("Project Name:");
		projectNameLabel.setHorizontalAlignment (javax.swing.SwingConstants.LEFT);
		jpanel.add(projectNameLabel);
		jpanel.add(folioName);

		jpanel.add(new JLabel("Import stock file (optional)"));
		jpanel.add(inputfile);
		int result = JOptionPane.showConfirmDialog(null, jpanel, "Create new PortFolio", JOptionPane.OK_CANCEL_OPTION);
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
