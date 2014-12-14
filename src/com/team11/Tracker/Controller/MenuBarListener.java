package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.View.View;


import javax.swing.*;
import java.awt.*;
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

            // TODO: This should be moved to a function in the view.

            while (true){
                JTextField portFolioNameEntry = new JTextField(20);

                JPanel newPortFolioPanel = new JPanel();

                JLabel enterPortFolioNameLabel = new JLabel("Enter PortFolio Name:");

                newPortFolioPanel.setLayout(new BoxLayout(newPortFolioPanel,
                        BoxLayout.Y_AXIS));

                portFolioNameEntry.setMaximumSize(new Dimension(1500, 20));

                newPortFolioPanel.add(enterPortFolioNameLabel);
                newPortFolioPanel.add(portFolioNameEntry);

                int result = JOptionPane.showConfirmDialog(null, newPortFolioPanel,
                        "Create New PortFolio", JOptionPane.OK_CANCEL_OPTION);

                String projname = (portFolioNameEntry.getText());

                if (result == JOptionPane.CANCEL_OPTION){
                    break;
                }
                if (projname.equals("") || projname.equals(null)){
                    // TODO: Add check for a unique Portfolio name
                    JLabel enterFilenameLabel = new JLabel("File Name required.");
                    newPortFolioPanel.add(enterFilenameLabel);

                }
                else{
                    // Creates the tab and portfolio
                    view.createTab(projname);
                    cntrl.getPortfolioHolder().addPortfolio(new Portfolio(projname));
                    break;
                }
            }

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
