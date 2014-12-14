package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.IPortfolioHolder;
import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.Model.PortfolioHolder;
import com.team11.Tracker.View.View;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class FolioCntrl {
    private View view;
    private IPortfolioHolder portfolioHolder;

    public FolioCntrl(View view, PortfolioHolder portfolioHolder) {
        this.view = view;
        this.portfolioHolder = portfolioHolder;

        setUpViewEvents();
    }

    public IPortfolioHolder getPortfolioHolder() {
        return portfolioHolder;
    }
    public View getView() {
        return view;
    }
    public Portfolio getCurrentFolio() {
        return portfolioHolder.getPortfolios().get(view.getTabbedPane().getSelectedIndex());
    }


    private void setUpViewEvents() {

        StockAddListener stockAddListener = new StockAddListener(this);
        view.getBtnAdd().addActionListener(stockAddListener);

        for (Portfolio p : portfolioHolder.getPortfolios()) {
            p.addObserver(stockAddListener);
        }

        view.getNewFolioMenuItem().addActionListener(new MenuBarListener(this));
        view.getOpenFolioMenuItem().addActionListener(new MenuBarListener(this));
        view.getCloseFolioMenuItem().addActionListener(new MenuBarListener(this));
        view.getCloseAllFolioMenuItem().addActionListener(new MenuBarListener(this));
        view.getExitMenuItem().addActionListener(new MenuBarListener(this));


        // Needs to be moved to another file
        view.getTabbedPane().addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (e.getSource() instanceof JTabbedPane) {
                    JTabbedPane pane = (JTabbedPane) e.getSource();
                    view.getLblFolioValue().setText("$" + portfolioHolder.getPortfolios().get(view.getTabbedPane().getSelectedIndex()).getFolioValue());
                    System.out.println("Selected paneNo : " + pane.getSelectedIndex());
                }
            }
        });



        // Other buttons here
    }


}
