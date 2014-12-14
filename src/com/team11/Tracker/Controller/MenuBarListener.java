package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.View.View;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MenuBarListener implements ActionListener {

    View view;
    Portfolio portfolio;

    FolioCntrl cntrl;

    MenuBarListener(FolioCntrl cntrl) {
        this.portfolio = cntrl.getCurrentFolio();
        this.view = cntrl.getView();
        this.cntrl = cntrl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("NewFolio")) {
            System.out.println("Add folio menu item pressed");
            view.createTab("TEST NAME");
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
