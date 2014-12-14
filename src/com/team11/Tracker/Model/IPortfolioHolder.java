package com.team11.Tracker.Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IPortfolioHolder {

    void loadFolio() throws FileNotFoundException;
    void saveFolio(Portfolio portfolio);
    void addPortfolio(Portfolio folio);
    ArrayList<Portfolio> getPortfolios();
}
