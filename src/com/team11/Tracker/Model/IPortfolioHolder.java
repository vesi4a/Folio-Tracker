package com.team11.Tracker.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IPortfolioHolder {

	Portfolio loadFolio(File file) throws FileNotFoundException;
    void saveFolio(Portfolio portfolio);
    void addPortfolio(Portfolio folio);
    ArrayList<Portfolio> getPortfolios();
}
