package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.IPortfolioHolder;
import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.Model.PortfolioHolder;
import com.team11.Tracker.Model.Share;
import com.team11.Tracker.View.MainGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;


public class MenuBarListener implements ActionListener {

    private MainGUI view;
    private IPortfolioHolder holder;

    public MenuBarListener(MainGUI view, IPortfolioHolder holder) {
        this.view = view;
        this.holder = holder;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("NewFolio")) {
            System.out.println("Add folio menu item pressed");
                view.showNewFolioAlert();
        }
        else if (e.getActionCommand().equals("OpenFolio")) {
            System.out.println("Open folio menu item pressed");
            File f = view.showLoadFolioAlert();
            try {
                // Create the new portfolio
				Portfolio pf = holder.loadFolio(f);
                // Add the view as an observer of the new portfolio
				pf.addObserver(view);
                // Add the portfoli to the holder
                holder.addPortfolio(pf);
                // Create a new tab for the portfolio
                view.createTab(pf.getPortfolioName());
                // Set the new tab as the active tab so that we can add share to its table
                //view.getTpPortfolioView().setSelectedIndex(view.getTpPortfolioView().getSelectedIndex() + 1);
                view.getTpPortfolioView().setSelectedIndex(view.getTpPortfolioView().getTabCount() - 1);

                // Add a share to the portfolio
                pf.addShare("msft", 23);

				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        else if (e.getActionCommand().equals("RefreshFolio")) {
            System.out.println("Refresh item pressed");
            holder.getPortfolios().get(view.getTpPortfolioView().getSelectedIndex()).updateAllShares();
        }
        else if (e.getActionCommand().equals("CloseFolio")) {
            System.out.println("Close folio menu item pressed");
            int currentPaneNumber = TabChangeListener.paneNo;
            if (view.getTpPortfolioView().getTabCount() > 1){
            view.getTpPortfolioView().remove(currentPaneNumber);
            }
        }
        else if (e.getActionCommand().equals("Exit")) {
            System.out.println("Exit menu item pressed");
            // Add a popup to confirm?      
            view.showCloseAlert();
        }



    }
}
