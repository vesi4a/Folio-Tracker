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
public class FolioCntrl {
    private View view;
    private Portfolio model;

    public View getView() {
        return view;
    }

    public Portfolio getModel() {
        return model;
    }


    public FolioCntrl(View view, Portfolio model) {
        this.view = view;
        this.model = model;

        setUpViewEvents();
    }


    public void updateFolioValue() {
        view.getLblFolioValue().setText("$" + model.getFolioValue());
    }

    private void setUpViewEvents() {

        view.getBtnAdd().addActionListener(new StockAddListener(this));

        view.getNewFolioMenuItem().addActionListener(new NewFolioListener(this));

        // Other buttons here
    }


}
