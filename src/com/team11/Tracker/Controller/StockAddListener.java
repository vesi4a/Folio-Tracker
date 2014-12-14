package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.Model.Share;
import com.team11.Tracker.View.View;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;


public class StockAddListener implements ActionListener, Observer {

    private View view;
    private Portfolio portfolio;
    private FolioCntrl cntrl;


    StockAddListener(FolioCntrl cntrl) {
        this.portfolio = cntrl.getCurrentFolio();
        this.view = cntrl.getView();
        this.cntrl = cntrl;
    }

    // An action has been performed
    @Override
    public void actionPerformed(ActionEvent e) {
        addStockErrorCheck();
        portfolio = cntrl.getCurrentFolio();

        String ticker = view.getTxtFieldTicker().getText();
        int amount = Integer.parseInt(view.getTxtFieldAmount().getText());

        if (!portfolio.ownShare(ticker)) {
            // Add a stock to the portfolio
            portfolio.addShare(ticker, amount);
        }
    }


    // Something on the backend has changed, Update the UI to reflect this change.
    @Override
    public void update(Observable o, Object arg) {
        // Update the UI?
        DefaultTableModel tblModel = (DefaultTableModel) view.getTables().get(view.getTabbedPane().getSelectedIndex()).getModel();
        // Clear the table
        tblModel.setRowCount(0);

        // Add entries for all the shares in the portfolio
        for (Share s: portfolio.getShares()) {
            tblModel.addRow(new Object[]{
                    s.getTicker(),
                    s.getAmountOwned(),
                    new DecimalFormat("0.00").format(s.getCurrentSharePrice()),
                    // DecimalFormat helps make the value presentable and not have several decimal places
                    new DecimalFormat("0.00").format(portfolio.getShare(s.getTicker()).getCurrentSharePrice() * s.getAmountOwned())
            });

        }

        // Update the folio value label
        cntrl.updateFolioValue();
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
