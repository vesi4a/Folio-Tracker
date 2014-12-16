package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.IPortfolioHolder;
import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.Model.Share;
import com.team11.Tracker.View.MainGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class StockAddListener implements ActionListener {

   	private MainGUI view;
	private IPortfolioHolder holder;

	public StockAddListener(MainGUI view, IPortfolioHolder holder) {
		this.view = view;
		this.holder = holder;
	}

    // An action has been performed
    @Override
    public void actionPerformed(ActionEvent e) {

        Portfolio portfolio = holder.getPortfolios().get(view.getTpPortfolioView().getSelectedIndex());

		try {
			String ticker = view.getFtxtTickerSymbol().getText();
			if (ticker.length() == 0) {
				throw new Exception();
			}
			int amount = Integer.parseInt(view.getFtxtQuantity().getText());
			// Add a stock to the portfolio
			portfolio.addShare(ticker, amount);

		}
		catch (Exception exc) {
			System.out.println("Invalid entry");
		}


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
