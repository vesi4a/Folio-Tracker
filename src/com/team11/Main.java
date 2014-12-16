package com.team11;


import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.Model.PortfolioHolder;
import com.team11.Tracker.View.MainGUI;

public class Main {
    public static void main(String[] args) {


        PortfolioHolder model = new PortfolioHolder();

       // Portfolio folio = new Portfolio("Portfolio1");


       // model.addPortfolio(folio);

        //View view = new View(model);
        MainGUI view = new MainGUI(model);


        //folio.addObserver(view);




    }
}
