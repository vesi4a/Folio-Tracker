package com.team11.Tracker.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Portfolio {


    // All the shares held within this portfolio
    private ArrayList<Share> shares;
    /*Portfolios should be identified by a name given by the user, also included in constructor*/
    private String portfolioName;



	public Portfolio(String name) {
        // Creates an empty arraylist
		shares = new ArrayList<Share>();
		portfolioName = name;
	}

	/*Implemented loadFolio method*/
    public void loadFolio() throws FileNotFoundException{
        // TODO: Implement
    	 File file = new File("portfolios.txt");
    	 Scanner scanner = new Scanner(file);
    	 if (scanner.hasNextLine()){
    		 portfolioName = scanner.nextLine();
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
    			 pf.shares.add(sh);
    		 }
    	 }
    }

    /*Implemented saveFolio method*/
    public void saveFolio() {
        // TODO: Implement
    	try
    	{
    	    String filename= "portfolios.txt";
    	    FileWriter fw = new FileWriter(filename,true); // append to text file
    	    fw.write(portfolioName + System.getProperty("line.separator"));
    	    for (Share s: shares){
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

	public double getFolioValue() {
		double runningTotal = 0;
		try {
            for (Share s : shares) {

                runningTotal += (s.getSharePrice() * s.getAmountOwned());
            }
		} catch (Exception e) {

		}

        return runningTotal;
	}


    // Only adds shares at the current price, Could be modified to allow the price to be specified
	/*Changed the addShare method parameters. This is to match the textboxes on the GUI that the user enters text into*/
	public void addShare(String tickerSymbol, Integer numberOfShares) {
        Quote q = new Quote(false);
        try {
            q.setValues(tickerSymbol);  /*changed incorrect parameter to this method, which takes ticker symbol not the share name*/
            shares.add(new Share(tickerSymbol, q.getLatest(), numberOfShares));
        }
        catch (Exception e) {

        }
	}

    public void sellShare() {
        // TODO: Implement
    }

    public Share getShare(String ticker) {
        for (Share s : shares) {
            if (s.getTicker().equals(ticker)) {
                return s;
            }
        }

        // Throw an exception
        // ShareNotOwnedException?
        return null;
    }

	public ArrayList<Share> getShares() {
		return shares;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

}
