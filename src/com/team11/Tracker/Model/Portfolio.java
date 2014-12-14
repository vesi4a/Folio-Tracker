package com.team11.Tracker.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class Portfolio extends Observable {


    // All the shares held within this portfolio
    private ArrayList<Share> shares;

	//
    private String portfolioName;



	public Portfolio(String name) {
        // Creates an empty arraylist
		shares = new ArrayList<Share>();
		portfolioName = name;
	}


	// Returns the total value of the portfolio
	public double getFolioValue() {
		double runningTotal = 0;
		try {
            for (Share s : shares) {

                runningTotal += (s.getCurrentSharePrice() * s.getAmountOwned());
            }
		} catch (Exception e) {

		}

        return runningTotal;
	}


    // Only adds shares at the current price, Could be modified to allow the price to be specified
	public void addShare(String tickerSymbol, Integer numberOfShares) {
		if (ownShare(tickerSymbol)) {
			// We already own this shares, We need to add on the extra shares and average the purchase price
		}
		else {
			// Add a new share to the folio
			Quote q = new Quote(false);
			try {
				q.setValues(tickerSymbol);
				shares.add(new Share(tickerSymbol, q.getLatest(), numberOfShares));

				// Tell the listener to update the UI
				setChanged();
				notifyObservers();

			}
			catch (Exception e) {

			}
		}
	}


    public void sellShare(String ticker, int amount) {
        // TODO: Implement
		if (!ownShare(ticker)) {
			// Can't sell shares you don't own.
		}
    }


	// Returns true if the share is currently owned by this portfolio
	public boolean ownShare(String ticker) {
		boolean owned = false;
		for (Share s : shares) {
			if (s.getTicker().equals(ticker)) {
				owned = true;
			}
		}
		return owned;
	}

	// Returns the share object whos sticker matches the paramater
    public Share getShare(String ticker) {
		// Check that we own a share that matches the paramater
		if (ownShare(ticker)) {
			// Find the share withing the array
			for (Share s : shares) {
				// Return the share object
				if (s.getTicker().equals(ticker)) {
					return s;
				}
			}
		}
		else {
			// Throw an exception
			// ShareNotOwnedException?

		}
        return null;
    }

	public ArrayList<Share> getShares() {
		return shares;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

}
