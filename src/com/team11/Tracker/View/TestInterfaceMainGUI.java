package com.team11.Tracker.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.ScrollPane;
import java.util.ArrayList;

public class TestInterfaceMainGUI {

	private JFrame frmFolioTracker;
	private JTextField textField;
	private JTable tblPortfolio;
	private ArrayList<JTable> tables;
	private JTabbedPane tpPortfolioView;
	private JScrollPane scrollPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestInterfaceMainGUI window = new TestInterfaceMainGUI();
					window.frmFolioTracker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestInterfaceMainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		tables = new ArrayList<JTable>();
		frmFolioTracker = new JFrame();
		frmFolioTracker.setTitle("Folio Tracker");
		// frmFolioTracker.setBounds(100, 100, 800, 600);
		frmFolioTracker.setSize(800, 600);
		frmFolioTracker.setLocationRelativeTo(null);

		frmFolioTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmFolioTracker.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNewPortfolio = new JMenuItem("New Portfolio");
		mnFile.add(mntmNewPortfolio);

		JMenuItem mntmOpenExistingPortfolio = new JMenuItem(
				"Open Existing Portfolio");
		mnFile.add(mntmOpenExistingPortfolio);

		mnFile.addSeparator();

		JMenuItem mntmSeeHistory = new JMenuItem("See History");
		mnFile.add(mntmSeeHistory);

		JMenuItem mntmCloseCurrentPortfolio = new JMenuItem(
				"Close Current Portfolio");
		mnFile.add(mntmCloseCurrentPortfolio);

		mnFile.addSeparator();

		JMenuItem menuItem = new JMenuItem("Exit");
		mnFile.add(menuItem);
		SpringLayout springLayout = new SpringLayout();
		frmFolioTracker.getContentPane().setLayout(springLayout);

		JLabel lblTickerSymbol = new JLabel("Ticker Symbol:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTickerSymbol, 10,
				SpringLayout.NORTH, frmFolioTracker.getContentPane());
		frmFolioTracker.getContentPane().add(lblTickerSymbol);

		JLabel lblQuantity = new JLabel("Quantity:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQuantity, 0,
				SpringLayout.NORTH, lblTickerSymbol);
		springLayout.putConstraint(SpringLayout.WEST, lblQuantity, 150,
				SpringLayout.EAST, lblTickerSymbol);
		frmFolioTracker.getContentPane().add(lblQuantity);

		tpPortfolioView = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, tpPortfolioView, 43,
				SpringLayout.NORTH, frmFolioTracker.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, tpPortfolioView, 0,
				SpringLayout.WEST, frmFolioTracker.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tpPortfolioView, -96,
				SpringLayout.SOUTH, frmFolioTracker.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tpPortfolioView, -10,
				SpringLayout.EAST, frmFolioTracker.getContentPane());
		frmFolioTracker.getContentPane().add(tpPortfolioView);

		JButton btnAddStock = new JButton("Add Stock");
		springLayout.putConstraint(SpringLayout.NORTH, btnAddStock, -5,
				SpringLayout.NORTH, lblTickerSymbol);
		frmFolioTracker.getContentPane().add(btnAddStock);

		JLabel lblAddStock = new JLabel("Add Stock:");
		springLayout.putConstraint(SpringLayout.WEST, lblTickerSymbol, 20,
				SpringLayout.EAST, lblAddStock);
		springLayout.putConstraint(SpringLayout.WEST, lblAddStock, 10,
				SpringLayout.WEST, frmFolioTracker.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblAddStock, 10,
				SpringLayout.NORTH, frmFolioTracker.getContentPane());
		frmFolioTracker.getContentPane().add(lblAddStock);

		JFormattedTextField ftxtTickerSymbol = new JFormattedTextField();
		springLayout.putConstraint(SpringLayout.WEST, ftxtTickerSymbol, 10,
				SpringLayout.EAST, lblTickerSymbol);
		ftxtTickerSymbol.setPreferredSize(new Dimension(120, 28));
		springLayout.putConstraint(SpringLayout.NORTH, ftxtTickerSymbol, -6,
				SpringLayout.NORTH, lblTickerSymbol);
		springLayout.putConstraint(SpringLayout.EAST, ftxtTickerSymbol, 126,
				SpringLayout.EAST, lblTickerSymbol);
		frmFolioTracker.getContentPane().add(ftxtTickerSymbol);

		JFormattedTextField ftxtQuantity = new JFormattedTextField();
		springLayout.putConstraint(SpringLayout.WEST, btnAddStock, 30,
				SpringLayout.EAST, ftxtQuantity);
		springLayout.putConstraint(SpringLayout.WEST, ftxtQuantity, 10,
				SpringLayout.EAST, lblQuantity);
		springLayout.putConstraint(SpringLayout.NORTH, ftxtQuantity, -6,
				SpringLayout.NORTH, lblTickerSymbol);
		springLayout.putConstraint(SpringLayout.EAST, ftxtQuantity, 126,
				SpringLayout.EAST, lblQuantity);
		ftxtQuantity.setPreferredSize(new Dimension(120, 28));
		frmFolioTracker.getContentPane().add(ftxtQuantity);

		JLabel lblPortfolioValLabel = new JLabel("Portfolio Value:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPortfolioValLabel, 6,
				SpringLayout.SOUTH, tpPortfolioView);
		springLayout.putConstraint(SpringLayout.WEST, lblPortfolioValLabel, 10,
				SpringLayout.WEST, tpPortfolioView);
		frmFolioTracker.getContentPane().add(lblPortfolioValLabel);

		JLabel lblPortfolioValue = new JLabel("$0.00");
		springLayout.putConstraint(SpringLayout.WEST, lblPortfolioValue, 6,
				SpringLayout.EAST, lblPortfolioValLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPortfolioValue, 0,
				SpringLayout.SOUTH, lblPortfolioValLabel);
		frmFolioTracker.getContentPane().add(lblPortfolioValue);

		
		
		createTab("Portfolio1");
		
		frmFolioTracker.setVisible(true);

	}

	public void createTab(String PortfolioName) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Ticker Symbol");
		model.addColumn("Number of Shares");
		model.addColumn("Price ($)");
		model.addColumn("Value ($) ");

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

		tpPortfolioView.addTab(PortfolioName, null, scrollPane, null);

	}
}
