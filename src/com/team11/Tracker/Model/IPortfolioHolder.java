package com.team11.Tracker.Model;

import com.team11.Tracker.View.MainGUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IPortfolioHolder {

    Portfolio loadFolio(File file, MainGUI view) throws FileNotFoundException;
    void saveFolio(Portfolio portfolio, String folioName);
    void addPortfolio(Portfolio folio);
    ArrayList<Portfolio> getPortfolios();
    void removeFolio(Portfolio portfolio);
}
