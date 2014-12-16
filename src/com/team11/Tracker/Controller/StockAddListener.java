package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.IPortfolioHolder;
import com.team11.Tracker.Model.Portfolio;
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

		if (!holder.getPortfolios().isEmpty()) {
			Portfolio portfolio = holder.getPortfolios().get(view.getTpPortfolioView().getSelectedIndex());

			try {
				String ticker = view.getFtxtTickerSymbol().getText();
				if (ticker.length() == 0) {
					throw new Exception("Ticker has no data");
				}
				int amount = Integer.parseInt(view.getFtxtQuantity().getText());
				if (amount < 1) {
					throw new Exception("Can't buy less than one");
				}

				// Add a stock to the portfolio
				portfolio.addShare(ticker, amount);

			}
			catch (Exception exc) {
				view.showErrorAlert(exc.getMessage());
				System.out.println("Invalid entry");
			}
		}
		else {
			// We have no tabs
			view.showNoOpenFolioAlert();
		}


    }
}
