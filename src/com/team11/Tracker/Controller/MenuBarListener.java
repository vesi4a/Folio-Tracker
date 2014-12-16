package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.IPortfolioHolder;
import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.Model.PortfolioHolder;
import com.team11.Tracker.Model.Share;
import com.team11.Tracker.View.MainGUI;
import com.team11.Tracker.View.SellStockGUI;

import java.awt.*;
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
			view.getTpPortfolioView().setSelectedIndex(
					view.getTpPortfolioView().getTabCount() - 1);
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


				pf.updateAllShares();

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
		 else if (e.getActionCommand().equals("RefreshFolio")) {
		System.out.println("Refresh item pressed");
		holder.getPortfolios()
				.get(view.getTpPortfolioView().getSelectedIndex())
				.updateAllShares();
		} else if (e.getActionCommand().equals("ViewHistory")) {
		System.out.println("View History menu item pressed");
		} else if (e.getActionCommand().equals("SellSelected")) {
			System.out.println("Sell Selected menu item pressed");
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SellStockGUI sellShare = new SellStockGUI();

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}		else if (e.getActionCommand().equals("CloseFolio")) {
			System.out.println("Close folio menu item pressed");
			int currentPaneNumber = TabChangeListener.paneNo;
			if (view.getTpPortfolioView().getTabCount() > 1) {

				int result = view.showSaveBeforeCloseAlert();
				if (result == 1) { // yes
					System.out.println("Saving Folio...");
					Portfolio currentPortfolio = holder.getPortfolios().get(
							view.getTpPortfolioView().getSelectedIndex());
					holder.saveFolio(currentPortfolio,
							currentPortfolio.getPortfolioName());
					System.out.println("Folio saved.");
					view.getTpPortfolioView().remove(currentPaneNumber);
					return;
				} else if (result == 2) { // no
					view.getTpPortfolioView().remove(currentPaneNumber);
					return;
				}
			}

		}
		else if (e.getActionCommand().equals("Exit")) {
			System.out.println("Exit menu item pressed");
			// Add a popup to confirm?
			view.showCloseAlert();
		}



	}
}
