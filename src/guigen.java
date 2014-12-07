import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.KeyStroke;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class guigen {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_2;
	private static JPanel panel_4, panel_1, panel_2, panel_3, panel;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600
				);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar mainMnu = menuSetup();
		frame.setJMenuBar(mainMnu);
	
		JPanel panel_4 = new JPanel();
		JPanel panel = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_1 = new JPanel();
		
		initialiseTabSetup();
		
		
		jTableSetup t = null;
		t.setTopPanel(panel_4);
		t = new jTableSetup();
		t.setVisible(true);
		
		//Labels and text fields
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
	}
	
	
	
	
	

	private static void initialiseTabSetup() {
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 788, 484);
		frame.getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("Portfolio 1", null, panel, null);

		tabbedPane.addTab("Portfolio 2", null, panel_1, null);

		
		tabbedPane.addTab("Portfolio 3", null, panel_2, null);
		

		tabbedPane.addTab("Portfolio 4", null, panel_3, null);
		
		
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
}
