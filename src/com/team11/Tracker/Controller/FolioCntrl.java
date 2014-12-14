package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.View.View;

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

        view.getNewFolioMenuItem().addActionListener(new MenuBarListener(this));
        view.getOpenFolioMenuItem().addActionListener(new MenuBarListener(this));
        view.getCloseFolioMenuItem().addActionListener(new MenuBarListener(this));
        view.getCloseAllFolioMenuItem().addActionListener(new MenuBarListener(this));




        // Other buttons here
    }


}
