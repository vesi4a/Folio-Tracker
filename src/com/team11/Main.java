package com.team11;


import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.Model.PortfolioHolder;
import com.team11.Tracker.View.MainGUI;

public class Main {
    public static void main(String[] args) {


        PortfolioHolder model = new PortfolioHolder();




        Portfolio folio = new Portfolio("Portfolio1");
        Portfolio folio2 = new Portfolio("Portfolio2");


        model.addPortfolio(folio);
        model.addPortfolio(folio2);

        //View view = new View(model);
        MainGUI view = new MainGUI(model);


        folio.addObserver(view);
        folio2.addObserver(view);



    }
}
