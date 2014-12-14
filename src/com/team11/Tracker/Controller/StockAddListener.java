package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.IPortfolioHolder;
import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.Model.PortfolioHolder;
import com.team11.Tracker.Model.Share;
import com.team11.Tracker.View.View;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class StockAddListener implements ActionListener {

   	private View view;
	private IPortfolioHolder holder;



	public StockAddListener(View view, IPortfolioHolder holder) {
		this.view = view;
		this.holder = holder;
	}

    // An action has been performed
    @Override
    public void actionPerformed(ActionEvent e) {
        addStockErrorCheck();

        Portfolio portfolio = holder.getPortfolios().get(view.getTabbedPane().getSelectedIndex());

        String ticker = view.getTxtFieldTicker().getText();
        int amount = Integer.parseInt(view.getTxtFieldAmount().getText());

        if (!portfolio.ownShare(ticker)) {
            // Add a stock to the portfolio
            portfolio.addShare(ticker, amount);
        }
    }

    private void addStockErrorCheck() {
		Border redBorder = BorderFactory.createLineBorder(Color.RED, 3);
        Border defaultBorder = view.getTxtFieldTicker().getBorder();

           if ((view.getTxtFieldAmount().getText() == null || view.getTxtFieldAmount().getText().equals("")) &&
           		(view.getTxtFieldTicker().getText() == null || view.getTxtFieldTicker().getText().equals(""))) {
				System.out.println("Ticker and Amount required");
				view.getErrorLabel().setText("Ticker and Amount required");
				view.getTxtFieldTicker().setBorder(redBorder);
				view.getTxtFieldAmount().setBorder(redBorder);
				return;
			}
           else{
           	view.getTxtFieldTicker().setBorder(defaultBorder);
				view.getTxtFieldAmount().setBorder(defaultBorder);
           }
			if (view.getTxtFieldTicker().getText() == null || view.getTxtFieldTicker().getText().equals("")) {
				System.out.println("Ticker required");
				view.getErrorLabel().setText("Ticker required");
				view.getTxtFieldTicker().setBorder(redBorder);
				return;
			}
			else{
				view.getTxtFieldTicker().setBorder(defaultBorder);
			}
			if (view.getTxtFieldAmount().getText() == null || view.getTxtFieldAmount().getText().equals("")) {
				System.out.println("Amount required");
				view.getErrorLabel().setText("Amount required");
				view.getTxtFieldAmount().setBorder(redBorder);
				return;
			}
			else{
				view.getTxtFieldAmount().setBorder(defaultBorder);
			}

			if (!view.getTxtFieldAmount().getText().matches("[+-]?\\d*(\\.\\d+)?")){
				System.out.println("Amount must be integer");
				view.getErrorLabel().setText("Amount must be integer");
				view.getTxtFieldAmount().setBorder(redBorder);
				return;
			}
			else{
				view.getTxtFieldAmount().setBorder(defaultBorder);
			}

			/*
			if (getTickerValidity(view.getTxtFieldTicker().getText())){
				System.out.println("Invalid ticker symbol");
				view.getErrorLabel().setText("Invalid ticker symbol");
				return;
			}
			*/
			view.getErrorLabel().setText("");
	}
    private boolean getTickerValidity(String tickerSymbol) {
		try {
			Share s = new Share(tickerSymbol, 0.0, 0);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
}
