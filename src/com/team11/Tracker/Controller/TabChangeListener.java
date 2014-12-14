package com.team11.Tracker.Controller;

import com.team11.Tracker.Model.IPortfolioHolder;
import com.team11.Tracker.View.View;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

/**
 * Created by cameron on 14/12/2014.
 */
public class TabChangeListener implements ChangeListener {

    private View view;
    private IPortfolioHolder holder;

    public TabChangeListener(View view, IPortfolioHolder holder) {
        this.view = view;
        this.holder = holder;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof JTabbedPane) {
            JTabbedPane pane = (JTabbedPane) e.getSource();
            view.getLblFolioValue().setText("$" + holder.getPortfolios().get(view.getTabbedPane().getSelectedIndex()).getFolioValue());
            System.out.println("Selected paneNo : " + pane.getSelectedIndex());
        }
    }
}
