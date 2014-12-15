package com.team11.Tracker.View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Window.Type;
import java.util.Observable;
import java.util.Observer;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;

public class SellStockGUI implements Observer {

	private JFrame frmSellStock;
	private JTextField txtSellAmount;

	/**
	 * Create the application.
	 */
	public SellStockGUI() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frmSellStock = new JFrame();
		frmSellStock.setType(Type.UTILITY);
		frmSellStock.setTitle("Sell Stock");
		frmSellStock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSellStock.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblStockSymbol = new JLabel("Stock Symbol:");
		frmSellStock.getContentPane().add(lblStockSymbol, "2, 2");

		JLabel lblSymbol = new JLabel("SMPL");
		frmSellStock.getContentPane().add(lblSymbol, "4, 2");

		JLabel lblCurrentValue = new JLabel("Current Value:");
		frmSellStock.getContentPane().add(lblCurrentValue, "2, 4");

		JLabel lblValue = new JLabel("0.00");
		frmSellStock.getContentPane().add(lblValue, "4, 4");

		JLabel lblSellAmount = new JLabel("Amount to Sell:");
		frmSellStock.getContentPane().add(lblSellAmount, "2, 6");

		txtSellAmount = new JTextField();
		txtSellAmount.setPreferredSize(new Dimension(36, 28));
		frmSellStock.getContentPane().add(txtSellAmount, "4, 6, fill, default");
		txtSellAmount.setColumns(10);

		JButton btnSell = new JButton("Sell Shares");
		btnSell.setPreferredSize(new Dimension(86, 29));
		frmSellStock.getContentPane().add(btnSell, "2, 8");

		JButton btnCancel = new JButton("Cancel");
		frmSellStock.getContentPane().add(btnCancel, "4, 8");

		frmSellStock.pack();
		frmSellStock.setLocationRelativeTo(null);
		frmSellStock.setVisible(true);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
