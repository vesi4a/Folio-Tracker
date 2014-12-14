package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.View.View;

import javax.sound.sampled.Port;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by cameron on 14/12/2014.
 */
public class StockAddListener implements ActionListener {

    View view;
    Portfolio model;

    FolioCntrl cntrl;

    StockAddListener(FolioCntrl cntrl) {
        //this.model = model;
        //this.view = view;
        this.model = cntrl.getModel();
        this.view = cntrl.getView();
        this.cntrl = cntrl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Add button pressed");


        // TODO: Check that the fields have actual values within them
        String ticker = view.getTxtFieldTicker().getText();
        int amount = Integer.parseInt(view.getTxtFieldAmount().getText());

        // Add a stock to the model
        model.addShare(ticker, amount);


        // Updating the table
        // .get(0) is for adding to the 1st tabs table
        // .get(1) would add to the 2 tab and so on
        DefaultTableModel tblModel = (DefaultTableModel) view.getTables().get(0).getModel();
        tblModel.addRow(new Object[]{
                ticker,
                amount,
                new DecimalFormat("0.00").format(model.getShare(ticker).getSharePrice()),
                // DecimalFormat helps make the value presentable and not have several decimal places
                new DecimalFormat("0.00").format(model.getShare(ticker).getSharePrice() * amount)
        });

        cntrl.updateFolioValue();
    }
}
