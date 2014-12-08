package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.View.View;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by cameron on 08/12/2014.
 */
public class Controller {
    private View view;
    private Portfolio model;

    public Controller(View view, Portfolio model) {
        this.view = view;
        this.model = model;

        setUpViewEvents();
    }


    private void setUpViewEvents() {
        // Action listener for add button
        view.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add button pressed");

                // Placeholder values
                // These will come from the UI later
                String ticker = "AAPL";
                int amount = 10;

                // Add a stock to the model
                model.addShare(ticker, amount);


                // Updating the table
                DefaultTableModel tblModel = (DefaultTableModel) view.getTable().getModel();
                tblModel.addRow(new Object[]{
                        ticker,
                        amount,
                        new DecimalFormat("0.00").format(model.getShare(ticker).getSharePrice()),
                        // DecimalFormat helps make the value presentable and not have several decimal places
                        new DecimalFormat("0.00").format(model.getShare(ticker).getSharePrice() * amount)
                });
            }
        });


        // Other buttons here
    }


}
