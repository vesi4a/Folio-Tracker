package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.IPortfolioHolder;
import com.team11.Tracker.View.MainGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        }
        else if (e.getActionCommand().equals("CloseFolio")) {
            System.out.println("Close folio menu item pressed");
        }
        else if (e.getActionCommand().equals("CloseAllFolios")) {
            System.out.println("Close all folios menu item pressed");
        }
        else if (e.getActionCommand().equals("Exit")) {
            System.out.println("Exit menu item pressed");
            // Add a popup to confirm?
            System.exit(0);
        }



    }
}
