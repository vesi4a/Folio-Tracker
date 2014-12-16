package com.team11.Tracker.Model;


import com.team11.Tracker.View.MainGUI;

import javax.sound.sampled.Port;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PortfolioHolder implements IPortfolioHolder {

    private ArrayList<Portfolio> portfolios;


    /*
  * @Effects Creates a new PortfolioHolder object with an initially empty ArrayList of Portfolios
  * @Modifies this
  */
    public PortfolioHolder() {
        portfolios = new ArrayList<Portfolio>();
    }

    /*
   * @Effects returns an ArrayList containing all the portfolios
   */
    public ArrayList<Portfolio> getPortfolios() {
        return portfolios;
    }

    /*
 * @Requires folio != null
 * @Effects appends folio to the ArrayList of Portfolios
 * @Modifies this
 */
    public void addPortfolio(Portfolio folio) {
        portfolios.add(folio);
    }

    /*
 * @Requires portfolio != null, portfolios.contains(portfolio) == true
 * @Effects removes the portfolio from the ArrayList containing all the portfolios
 * @Modifies this
 */
    public void removeFolio(Portfolio portfolio) {
        portfolios.remove(portfolio);
    }


    /*
 * @Requires file must be valid, file != null, view != null, file.getextension == .txt
 * @Effects returns a new Portfolio object with data read from a txt file
 * @Modifies this
 */
    public Portfolio loadFolio(File file, MainGUI view) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Portfolio pf = null;
        if (scanner.hasNextLine()){
            String portfolioName = scanner.nextLine();
            pf = new Portfolio(portfolioName);
            pf.addObserver(view);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] stringSplit = line.split("\\s+");
                String ticker = stringSplit[0];
                Integer amountOwned = Integer.parseInt(stringSplit[1]);
                Double sharePrice = Double.parseDouble(stringSplit[2]);
                //Share sh = new Share(ticker, sharePrice, amountOwned);
                Share sh = new Share(ticker, sharePrice, sharePrice, amountOwned);
//                String shareName = "";
//                for(int i =3; i < stringSplit.length; i++){
//                    shareName+=stringSplit[i];
//                    if(stringSplit.length!=i+1){
//                        shareName+= " ";
//                    }
//                }
//                sh.setShareName(shareName);
                //pf.getShares().add(sh);
                pf.addShare(sh);
            }

        }
        return pf;
    }

    /*
  * @Requires portfolio != null, folioName != null
  * @Effects creates a new txt file, titled by folioName, that contains the name of the folio and data on all its shares held
  */
    public void saveFolio(Portfolio portfolio, String folioName) {
        try
        {
            String filename= folioName + ".txt";
            FileWriter fw = new FileWriter(filename,false); // append to text file
            fw.write(portfolio.getPortfolioName()+ System.getProperty("line.separator"));
            for (Share s: portfolio.getShares()){
                fw.write(s.getTicker() + " " + s.getAmountOwned() + " " + s.getCurrentSharePrice() + System.getProperty("line.separator"));
                //fw.write(s.getTicker() + " " + s.getAmountOwned() + " " + s.getCurrentSharePrice());

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
