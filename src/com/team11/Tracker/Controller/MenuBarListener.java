package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.View.View;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MenuBarListener implements ActionListener {

    View view;
    Portfolio model;

    FolioCntrl cntrl;

    MenuBarListener(FolioCntrl cntrl) {
        this.model = cntrl.getModel();
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



    }
}
