package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.IPortfolioHolder;
import com.team11.Tracker.View.MainGUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by cameron on 14/12/2014.
 */
public class TabChangeListener implements ChangeListener {

    private MainGUI view;
    private IPortfolioHolder holder;
    public static int paneNo;

    public TabChangeListener(MainGUI view, IPortfolioHolder holder) {
        this.view = view;
        this.holder = holder;
        paneNo = 0;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof JTabbedPane) {
            if (!holder.getPortfolios().isEmpty()) {
                JTabbedPane pane = (JTabbedPane) e.getSource();
                view.getLblPortfolioValue().setText("$" + holder.getPortfolios().get(view.getTpPortfolioView().getSelectedIndex()).getFolioValue());
                System.out.println("Selected paneNo : " + pane.getSelectedIndex());
                paneNo = pane.getSelectedIndex();
            }
            else {
                // We have no tabs

                //Might not need this
                //view.showNoOpenFolioAlert();
            }

        }
    }
}
