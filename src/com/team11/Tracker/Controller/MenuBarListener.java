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
				Portfolio pf = holder.loadFolio(f, view);

				// Add the portfolio to the holder
				holder.addPortfolio(pf);
				// Create a new tab for the portfolio
				view.createTab(pf.getPortfolioName());
				// Set the new tab as the active tab so that we can add a share to
				// its table
				view.getTpPortfolioView().setSelectedIndex(
						view.getTpPortfolioView().getTabCount() - 1);



			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getActionCommand().equals("SaveFolio")) {
			System.out.println("Save folio menu item pressed");
			Portfolio currentPortfolio = holder.getPortfolios().get(view.getTpPortfolioView().getSelectedIndex());
			holder.saveFolio(currentPortfolio, currentPortfolio.getPortfolioName());
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
