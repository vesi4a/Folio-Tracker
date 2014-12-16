package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.IPortfolioHolder;
import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.View.MainGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StockSellListener implements ActionListener {

    private MainGUI view;
    private IPortfolioHolder holder;

    public StockSellListener(MainGUI view, IPortfolioHolder holder) {
        this.view = view;
        this.holder = holder;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (!holder.getPortfolios().isEmpty()) {
            Portfolio portfolio = holder.getPortfolios().get(view.getTpPortfolioView().getSelectedIndex());

            try {
                String ticker = view.getFtxtTickerSymbol().getText();
                if (ticker.length() == 0) {
                    throw new Exception("Ticker Symbol field is incomplete");
                }
                int amount = Integer.parseInt(view.getFtxtQuantity().getText());
                if (amount < 1) {
                    throw new Exception("Can't sell less than one");
                }

                portfolio.sellShare(ticker, amount);

            } catch (Exception exc) {
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
