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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

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

		JMenuItem mntmSavePortfolio = new JMenuItem("Save Portfolio");
		mntmSavePortfolio.setActionCommand("SaveFolio");
		mntmSavePortfolio.addActionListener(new MenuBarListener(this,
				portfolioHolder));
		mnFile.add(mntmSavePortfolio);

		mnFile.addSeparator();
		JMenuItem mntmViewHistory = new JMenuItem("View History");
		mntmViewHistory.setActionCommand("ViewHistory");
		mntmViewHistory.addActionListener(new MenuBarListener(this,
				portfolioHolder));

		JMenuItem mntmRefresh = new JMenuItem("Refresh Portfolio");
		mntmRefresh.setActionCommand("RefreshFolio");
		mntmRefresh
				.addActionListener(new MenuBarListener(this, portfolioHolder));
		mnFile.add(mntmRefresh);
		// mnFile.add(mntmSellFromSelected);
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
		frmFolioTracker.getContentPane().add(lblTickerSymbol);

		// Buy Share Quantity label
		JLabel lblQuantity = new JLabel("Quantity:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQuantity, 0,
				SpringLayout.NORTH, lblTickerSymbol);
		frmFolioTracker.getContentPane().add(lblQuantity);

		// Portfolio View Section
		tpPortfolioView = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.WEST, tpPortfolioView, 10,
				SpringLayout.WEST, frmFolioTracker.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tpPortfolioView, -10,
				SpringLayout.EAST, frmFolioTracker.getContentPane());
		frmFolioTracker.getContentPane().add(tpPortfolioView);
		tpPortfolioView.addChangeListener(new TabChangeListener(this,
				portfolioHolder));

		// Buy Share Confirmation button
		JButton btnAddStock = new JButton("Add Stock");
		frmFolioTracker.getContentPane().add(btnAddStock);
		btnAddStock.addActionListener(new StockAddListener(this,
				portfolioHolder));

		// Buy/Sell Share indicator label
		JLabel lblAddStock = new JLabel("Buy/Sell:");
		springLayout.putConstraint(SpringLayout.WEST, lblTickerSymbol, 11,
				SpringLayout.EAST, lblAddStock);
		springLayout.putConstraint(SpringLayout.SOUTH, lblTickerSymbol, 0,
				SpringLayout.SOUTH, lblAddStock);
		springLayout.putConstraint(SpringLayout.NORTH, lblAddStock, 25,
				SpringLayout.NORTH, frmFolioTracker.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblAddStock, 10,
				SpringLayout.WEST, frmFolioTracker.getContentPane());
		frmFolioTracker.getContentPane().add(lblAddStock);

		// Buy Share Ticker text field
		txtTickerSymbol = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, lblQuantity, 6,
				SpringLayout.EAST, txtTickerSymbol);
		springLayout.putConstraint(SpringLayout.NORTH, txtTickerSymbol, -6,
				SpringLayout.NORTH, lblTickerSymbol);
		springLayout.putConstraint(SpringLayout.WEST, txtTickerSymbol, 6,
				SpringLayout.EAST, lblTickerSymbol);
		springLayout.putConstraint(SpringLayout.EAST, txtTickerSymbol, 113,
				SpringLayout.EAST, lblTickerSymbol);
		txtTickerSymbol.setPreferredSize(new Dimension(120, 28));
		frmFolioTracker.getContentPane().add(txtTickerSymbol);

		// Buy Share Quantity text field
		txtQuantity = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, btnAddStock, 56,
				SpringLayout.EAST, txtQuantity);
		springLayout.putConstraint(SpringLayout.NORTH, txtQuantity, -6,
				SpringLayout.NORTH, lblTickerSymbol);
		springLayout.putConstraint(SpringLayout.WEST, txtQuantity, 6,
				SpringLayout.EAST, lblQuantity);
		txtQuantity.setPreferredSize(new Dimension(120, 28));
		frmFolioTracker.getContentPane().add(txtQuantity);

		// Portfolio Value Label
		JLabel lblPortfolioValTitle = new JLabel("Portfolio Value:");
		springLayout.putConstraint(SpringLayout.SOUTH, tpPortfolioView, -10,
				SpringLayout.NORTH, lblPortfolioValTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblPortfolioValTitle, 20,
				SpringLayout.WEST, frmFolioTracker.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPortfolioValTitle,
				-10, SpringLayout.SOUTH, frmFolioTracker.getContentPane());
		frmFolioTracker.getContentPane().add(lblPortfolioValTitle);

		// Portfolio Value Content
		lblPortfolioValue = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, lblPortfolioValue, 0,
				SpringLayout.NORTH, lblPortfolioValTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblPortfolioValue, 6,
				SpringLayout.EAST, lblPortfolioValTitle);
		frmFolioTracker.getContentPane().add(lblPortfolioValue);

		// Sell Share Confirmation button
		JButton btnSellStock = new JButton("Sell Stock");
		springLayout.putConstraint(SpringLayout.NORTH, tpPortfolioView, 0,
				SpringLayout.SOUTH, btnSellStock);
		// btnSellStock.addActionListener(new StockAddListener(this,
		// portfolioHolder));

		JLabel lblSelectExisting = new JLabel(
				"Select an existing portfolio or create new porfolio from file menu");
		lblSelectExisting.setHorizontalAlignment(SwingConstants.CENTER);
		tpPortfolioView.addTab("Welcome", null, lblSelectExisting, null);
		springLayout.putConstraint(SpringLayout.NORTH, btnSellStock, 34,
				SpringLayout.NORTH, frmFolioTracker.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAddStock, 0,
				SpringLayout.NORTH, btnSellStock);
		springLayout.putConstraint(SpringLayout.EAST, btnSellStock, 0,
				SpringLayout.EAST, btnAddStock);
		btnSellStock.setPreferredSize(new Dimension(108, 29));
		frmFolioTracker.getContentPane().add(btnSellStock);

		// Create an initial Tab
		// createTab("Portfolio1");

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

		// Add the table to a scrolling pane
		scrollPane = new JScrollPane(table);

		tpPortfolioView.addTab(PortfolioName, null, scrollPane, null);

		if (tpPortfolioView.getTabCount() > 0 && tables.isEmpty()) {
			tpPortfolioView.removeTabAt(0);
		}
		tables.add(table);

	}

	public int showSaveBeforeCloseAlert() {
		JPanel jp = new JPanel();
		jp.add(new JLabel("Do you want to save the folio before closing?"));
		int result = JOptionPane.showConfirmDialog(null, jp,
				"Save Before Close", JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			return 1;
		}
		if (result == JOptionPane.NO_OPTION) {
			return 2;
		}
		if (result == JOptionPane.CANCEL_OPTION) {
			return 3;
		}
		return -1;

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

		String tickerTest;
		// Add entries for all the shares in the portfolio
		for (Share s : test.getShares()) {
			tickerTest = s.getTicker();
			if (s.getPreviousPrice() < s.getCurrentSharePrice()) {
				tickerTest = s.getTicker() + " > ";
			} else if (s.getPreviousPrice() > s.getCurrentSharePrice()) {
				tickerTest = s.getTicker() + " < ";
			}
			tblModel.addRow(new Object[] {
					tickerTest,
					s.getAmountOwned(),
					new DecimalFormat("0.00").format(s.getCurrentSharePrice()),
					// DecimalFormat helps make the value presentable and not
					// have several decimal places
					new DecimalFormat("0.00").format(test.getShare(
							s.getTicker()).getCurrentSharePrice()
							* s.getAmountOwned()) });

		}
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		this.getLblPortfolioValue().setText(
				formatter.format(test.getFolioValue()));
	}
}
