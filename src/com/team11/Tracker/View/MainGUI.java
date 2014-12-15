package com.team11.Tracker.View;

import com.team11.Tracker.Controller.MenuBarListener;
import com.team11.Tracker.Controller.StockAddListener;
import com.team11.Tracker.Controller.TabChangeListener;
import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.Model.PortfolioHolder;
import com.team11.Tracker.Model.Share;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGUI implements Observer {

	private JFrame frmFolioTracker;
	private JTextField textField;
	private JTable tblPortfolio;
	private ArrayList<JTable> tables;
	private JTabbedPane tpPortfolioView;
	private JScrollPane scrollPane;
	private JTextField txtTickerSymbol;
	private JTextField txtQuantity;

	public JTextField getFtxtTickerSymbol() {
		return txtTickerSymbol;
	}

	public JTextField getFtxtQuantity() {
		return txtQuantity;
	}

	public JTabbedPane getTpPortfolioView() {
		return tpPortfolioView;
	}

	private JLabel lblPortfolioValue;

	public JLabel getLblPortfolioValue() {
		return lblPortfolioValue;
	}

	private PortfolioHolder portfolioHolder;

	/**
	 * Create the application.
	 */
	public MainGUI(PortfolioHolder portfolioHolder) {
		this.portfolioHolder = portfolioHolder;
		initialize();
	}

	// the wbp comment allows WindowBuilder to parse the UI and display what's
	// been made without needing to run the main code
	/**
	 * Initialise the contents of the frame.
	 */
	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		// ===========================
		// Initialise the
		// Folio Tracker Form
		// ===========================

		tables = new ArrayList<JTable>();
		frmFolioTracker = new JFrame();
		frmFolioTracker.setTitle("Folio Tracker");
		frmFolioTracker.setSize(800, 600);
		frmFolioTracker.setLocationRelativeTo(null);

		frmFolioTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ===========================
		// Create the Menu Bar
		// ===========================

		JMenuBar menuBar = new JMenuBar();
		frmFolioTracker.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNewPortfolio = new JMenuItem("New Portfolio");
		mntmNewPortfolio.setActionCommand("NewFolio");
		mntmNewPortfolio.addActionListener(new MenuBarListener(this,
				portfolioHolder));
		mnFile.add(mntmNewPortfolio);

		JMenuItem mntmOpenExistingPortfolio = new JMenuItem(
				"Open Existing Portfolio");
		mntmOpenExistingPortfolio.setActionCommand("OpenFolio");
		mntmOpenExistingPortfolio.addActionListener(new MenuBarListener(this,
				portfolioHolder));
		mnFile.add(mntmOpenExistingPortfolio);

		mnFile.addSeparator();

		JMenuItem mntmViewHistory = new JMenuItem("View History");
		mntmViewHistory.setActionCommand("ViewHistory");
		mntmViewHistory.addActionListener(new MenuBarListener(this,
				portfolioHolder));

		JMenuItem mntmSellFromSelected = new JMenuItem(
				"Sell From Selected Shares");
		mntmSellFromSelected.setActionCommand("SellSelected");
		mntmSellFromSelected.addActionListener(new MenuBarListener(this,
				portfolioHolder));

		JMenuItem mntmRefresh = new JMenuItem("Refresh Portfolio");
		mntmRefresh.setActionCommand("RefreshFolio");
		mntmRefresh
				.addActionListener(new MenuBarListener(this, portfolioHolder));
		mnFile.add(mntmRefresh);
		mnFile.add(mntmSellFromSelected);
		mnFile.add(mntmViewHistory);

		JMenuItem mntmCloseCurrentPortfolio = new JMenuItem(
				"Close Current Portfolio");
		mntmCloseCurrentPortfolio.setActionCommand("CloseFolio");
		mntmCloseCurrentPortfolio.addActionListener(new MenuBarListener(this,
				portfolioHolder));
		mnFile.add(mntmCloseCurrentPortfolio);

		mnFile.addSeparator();

		JMenuItem menuItem = new JMenuItem("Exit");
		menuItem.setActionCommand("Exit");
		menuItem.addActionListener(new MenuBarListener(this, portfolioHolder));
		mnFile.add(menuItem);
		SpringLayout springLayout = new SpringLayout();
		frmFolioTracker.getContentPane().setLayout(springLayout);

		// ===========================
		// Main Interface Content
		// ===========================

		// Buy Share Ticker Label
		JLabel lblTickerSymbol = new JLabel("Ticker Symbol:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTickerSymbol, 10,
				SpringLayout.NORTH, frmFolioTracker.getContentPane());
		frmFolioTracker.getContentPane().add(lblTickerSymbol);

		// Buy Share Quantity label
		JLabel lblQuantity = new JLabel("Quantity:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQuantity, 0,
				SpringLayout.NORTH, lblTickerSymbol);
		springLayout.putConstraint(SpringLayout.WEST, lblQuantity, 150,
				SpringLayout.EAST, lblTickerSymbol);
		frmFolioTracker.getContentPane().add(lblQuantity);

		// Portfolio View Section
		tpPortfolioView = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.EAST, tpPortfolioView, 0,
				SpringLayout.EAST, frmFolioTracker.getContentPane());
		frmFolioTracker.getContentPane().add(tpPortfolioView);
		tpPortfolioView.addChangeListener(new TabChangeListener(this,
				portfolioHolder));

		// Buy Share Confirmation button
		JButton btnAddStock = new JButton("Add Stock");
		springLayout.putConstraint(SpringLayout.NORTH, btnAddStock, -5,
				SpringLayout.NORTH, lblTickerSymbol);
		frmFolioTracker.getContentPane().add(btnAddStock);
		btnAddStock.addActionListener(new StockAddListener(this,
				portfolioHolder));

		// Buy Share indicator label
		JLabel lblAddStock = new JLabel("Buy Stock:");
		springLayout.putConstraint(SpringLayout.WEST, tpPortfolioView, 0,
				SpringLayout.WEST, lblAddStock);
		springLayout.putConstraint(SpringLayout.WEST, lblTickerSymbol, 20,
				SpringLayout.EAST, lblAddStock);
		springLayout.putConstraint(SpringLayout.WEST, lblAddStock, 10,
				SpringLayout.WEST, frmFolioTracker.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblAddStock, 10,
				SpringLayout.NORTH, frmFolioTracker.getContentPane());
		frmFolioTracker.getContentPane().add(lblAddStock);

		// Buy Share Ticker text field
		txtTickerSymbol = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtTickerSymbol, 10,
				SpringLayout.EAST, lblTickerSymbol);
		txtTickerSymbol.setPreferredSize(new Dimension(120, 28));
		springLayout.putConstraint(SpringLayout.NORTH, txtTickerSymbol, -6,
				SpringLayout.NORTH, lblTickerSymbol);
		springLayout.putConstraint(SpringLayout.EAST, txtTickerSymbol, 126,
				SpringLayout.EAST, lblTickerSymbol);
		frmFolioTracker.getContentPane().add(txtTickerSymbol);

		// Buy Share Quantity text field
		txtQuantity = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, btnAddStock, 30,
				SpringLayout.EAST, txtQuantity);
		springLayout.putConstraint(SpringLayout.WEST, txtQuantity, 10,
				SpringLayout.EAST, lblQuantity);
		springLayout.putConstraint(SpringLayout.NORTH, txtQuantity, -6,
				SpringLayout.NORTH, lblTickerSymbol);
		springLayout.putConstraint(SpringLayout.EAST, txtQuantity, 126,
				SpringLayout.EAST, lblQuantity);
		txtQuantity.setPreferredSize(new Dimension(120, 28));
		frmFolioTracker.getContentPane().add(txtQuantity);

		// Portfolio Value Label
		JLabel lblPortfolioValTitle = new JLabel("Portfolio Value:");
		springLayout.putConstraint(SpringLayout.SOUTH, tpPortfolioView, -47,
				SpringLayout.NORTH, lblPortfolioValTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblPortfolioValTitle, 10,
				SpringLayout.WEST, frmFolioTracker.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPortfolioValTitle,
				-10, SpringLayout.SOUTH, frmFolioTracker.getContentPane());
		frmFolioTracker.getContentPane().add(lblPortfolioValTitle);

		// Portfolio Value Content
		lblPortfolioValue = new JLabel("$0.00");
		springLayout.putConstraint(SpringLayout.NORTH, lblPortfolioValue, 0,
				SpringLayout.NORTH, lblPortfolioValTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblPortfolioValue, 6,
				SpringLayout.EAST, lblPortfolioValTitle);
		frmFolioTracker.getContentPane().add(lblPortfolioValue);

		// Quantity Validation Label
		JLabel lblQtyValidation = new JLabel("Please Enter a Valid Quantity");
		springLayout.putConstraint(SpringLayout.NORTH, tpPortfolioView, 18,
				SpringLayout.SOUTH, lblQtyValidation);
		springLayout.putConstraint(SpringLayout.NORTH, lblQtyValidation, 6,
				SpringLayout.SOUTH, lblQuantity);
		springLayout.putConstraint(SpringLayout.WEST, lblQtyValidation, 10,
				SpringLayout.WEST, lblQuantity);
		frmFolioTracker.getContentPane().add(lblQtyValidation);

		// Ticker Validation Label
		/*
		 * JLabel lblTickerValidation = new
		 * JLabel("Please enter a valid Ticker Symbol");
		 * springLayout.putConstraint(SpringLayout.NORTH, lblTickerValidation,
		 * 6, SpringLayout.SOUTH, lblTickerSymbol);
		 * springLayout.putConstraint(SpringLayout.EAST, lblTickerValidation, 0,
		 * SpringLayout.EAST, ftxtTickerSymbol);
		 * frmFolioTracker.getContentPane().add(lblTickerValidation);
		 */

		// Create an initial Tab
		createTab("Portfolio1");

		// Make the whole thing Visible!
		frmFolioTracker.setVisible(true);

	}

	public File showLoadFolioAlert() {
		JFileChooser fileChooser = new JFileChooser();
		JPanel jp = new JPanel();
		if (fileChooser.showOpenDialog(jp) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			return file;
		}
		return null;

	}

	public void showCloseAlert() {
		JPanel jp = new JPanel();
		jp.add(new JLabel("Are you sure you want to exit?"));
		int result = JOptionPane.showConfirmDialog(null, jp, "Exit",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.CANCEL_OPTION) {
			return;
		}
		if (result == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}

	// TODO: Move to a separate file
	public void showNewFolioAlert() {

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

		String folioName = (portFolioNameEntry.getText());

		if (result == JOptionPane.CANCEL_OPTION) {
			return;
		}
		if (folioName.equals("")) {
			// TODO: Add check for a unique Portfolio name
			JLabel enterFilenameLabel = new JLabel("File Name required.");
			newPortFolioPanel.add(enterFilenameLabel);
			JOptionPane.showMessageDialog(null, "Error: File Name Required");
			showNewFolioAlert();

		} else {
			// Creates the tab and portfolio
			createTab(folioName);
			Portfolio folio = new Portfolio(folioName);
			folio.addObserver(this);
			portfolioHolder.addPortfolio(folio);

		}
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

	// Updates the table
	@Override
	public void update(Observable o, Object arg) {
		Portfolio test = (Portfolio) o;

		// Update the UI?
		DefaultTableModel tblModel = (DefaultTableModel) this.tables.get(
				this.getTpPortfolioView().getSelectedIndex()).getModel();
		// Clear the table
		tblModel.setRowCount(0);

		// Add entries for all the shares in the portfolio
		for (Share s : test.getShares()) {
			tblModel.addRow(new Object[] {
					s.getTicker(),
					s.getAmountOwned(),
					new DecimalFormat("0.00").format(s.getCurrentSharePrice()),
					// DecimalFormat helps make the value presentable and not
					// have several decimal places
					new DecimalFormat("0.00").format(test.getShare(
							s.getTicker()).getCurrentSharePrice()
							* s.getAmountOwned()) });

		}

		this.getLblPortfolioValue().setText("$" + test.getFolioValue());
	}
}
