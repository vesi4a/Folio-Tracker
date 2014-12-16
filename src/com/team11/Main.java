package com.team11;

import com.team11.Tracker.Model.PortfolioHolder;
import com.team11.Tracker.View.MainGUI;

public class Main {
    public static void main(String[] args) {

        // Create the model
        PortfolioHolder model = new PortfolioHolder();

        // Create and display the view
        MainGUI view = new MainGUI(model);

    }
}
