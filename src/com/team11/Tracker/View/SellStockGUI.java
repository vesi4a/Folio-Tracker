package com.team11.Tracker.View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Window.Type;
import java.util.Observable;
import java.util.Observer;

public class SellStockGUI implements Observer{

	private JFrame frmSellStock;

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
		frmSellStock.setSize(800, 600);
		frmSellStock.setLocationRelativeTo(frmSellStock);
		frmSellStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
