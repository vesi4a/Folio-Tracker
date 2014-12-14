package com.team11;


import com.team11.Tracker.Controller.FolioCntrl;
import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.Model.PortfolioHolder;
import com.team11.Tracker.View.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();

        PortfolioHolder model = new PortfolioHolder();

        Portfolio folio = new Portfolio("Portfolio1");
        model.addPortfolio(folio);

        Portfolio folio2 = new Portfolio("Portfolio2");
        model.addPortfolio(folio2);

        FolioCntrl controller = new FolioCntrl(view, model);

    }
}
