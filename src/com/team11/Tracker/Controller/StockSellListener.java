package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.IPortfolioHolder;
import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.View.MainGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by camsh on 16/12/14.
 */
public class StockSellListener implements ActionListener {

    private MainGUI view;
    private IPortfolioHolder holder;

    public StockSellListener(MainGUI view, IPortfolioHolder holder) {
        this.view = view;
        this.holder = holder;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        Portfolio portfolio = holder.getPortfolios().get(view.getTpPortfolioView().getSelectedIndex());

    }
}
