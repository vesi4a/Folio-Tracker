package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.View.View;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class NewFolioListener implements ActionListener {

    View view;
    Portfolio model;

    FolioCntrl cntrl;

    NewFolioListener(FolioCntrl cntrl) {
        this.model = cntrl.getModel();
        this.view = cntrl.getView();
        this.cntrl = cntrl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Add folio menu item pressed");
        view.createTab("TEST NAME");

    }
}
