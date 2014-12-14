package com.team11.Tracker.Model;

import javax.sound.sampled.Port;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by cameron on 14/12/2014.
 */
public class PortfolioHolder {

    ArrayList<Portfolio> portfolios;

    public ArrayList<Portfolio> getPortfolios() {
        return portfolios;
    }

    public PortfolioHolder() {
        portfolios = new ArrayList<Portfolio>();
    }

    public void addPortfolio(Portfolio folio) {
        portfolios.add(folio);
    }

    // Untested
    public void loadFolio() throws FileNotFoundException {
        File file = new File("portfolios.txt");
        Scanner scanner = new Scanner(file);
        if (scanner.hasNextLine()){
            String portfolioName = scanner.nextLine();
            Portfolio pf = new Portfolio(portfolioName);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] stringSplit = line.split("\\s+");
                String ticker = stringSplit[0];
                Integer amountOwned = Integer.parseInt(stringSplit[1]);
                Double sharePrice = Double.parseDouble(stringSplit[2]);
                Share sh = new Share(ticker, sharePrice, amountOwned);
                String shareName = "";
                for(int i =3; i < stringSplit.length; i++){
                    shareName+=stringSplit[i];
                    if(stringSplit.length!=i+1){
                        shareName+= " ";
                    }
                }
                sh.setShareName(shareName);
                pf.getShares().add(sh);
            }
        }
    }

    // Untested
    public void saveFolio(Portfolio portfolio) {
        try
        {
            String filename= "portfolios.txt";
            FileWriter fw = new FileWriter(filename,true); // append to text file
            fw.write(portfolio.getPortfolioName()+ System.getProperty("line.separator"));
            for (Share s: portfolio.getShares()){
                fw.write(s.toString() + System.getProperty("line.separator"));
            }
            //fw.write("/*end" + System.getProperty("line.separator"));
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

}