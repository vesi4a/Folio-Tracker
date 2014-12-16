package com.team11.Tracker.View;

import java.awt.EventQueue;

import javax.swing.JFrame;


import java.util.Observable;
import java.util.Observer;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;

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
		//frmSellStock.setType(Type.UTILITY);
		frmSellStock.setTitle("Sell Stock");
		frmSellStock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSellStock.getContentPane().setLayout(new GridLayout(4, 2, 5, 5));
	
		JLabel lblStockSymbol = new JLabel("Stock Symbol:");
		frmSellStock.getContentPane().add(lblStockSymbol);

		JLabel lblSymbol = new JLabel("SMPL");
		frmSellStock.getContentPane().add(lblSymbol);

		JLabel lblCurrentValue = new JLabel("Current Value:");
		frmSellStock.getContentPane().add(lblCurrentValue);

		JLabel lblValue = new JLabel("0.00");
		frmSellStock.getContentPane().add(lblValue);

		JLabel lblSellAmount = new JLabel("Amount to Sell:");
		frmSellStock.getContentPane().add(lblSellAmount);

		txtSellAmount = new JTextField();
		frmSellStock.getContentPane().add(txtSellAmount, "fill, default");
		txtSellAmount.setColumns(10);

		JButton btnSell = new JButton("Sell Shares");
		frmSellStock.getContentPane().add(btnSell);

		JButton btnCancel = new JButton("Cancel");
		frmSellStock.getContentPane().add(btnCancel);

		frmSellStock.pack();
		frmSellStock.setLocationRelativeTo(null);
		frmSellStock.setVisible(true);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
