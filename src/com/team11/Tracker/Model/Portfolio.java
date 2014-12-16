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

	public void updateAllShares() {
		for (Share s: shares) {
			s.updateShare();
		}

		setChanged();
		notifyObservers();
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

	public void addShare(Share shareObject) {
		if (!ownShare(shareObject.getTicker())) {
			shares.add(shareObject);

			// Tell the listener to update the UI
			setChanged();
			notifyObservers();
		}
	}


	// Only adds shares at the current price, Could be modified to allow the
	// price to be specified
	public void addShare(String tickerSymbol, Integer numberOfShares) {
		// We already own this shares, We need to add on the extra shares and
		// average the purchase price

		if (ownShare(tickerSymbol)) {
			int currentNumberOfShares = getShare(tickerSymbol).getAmountOwned();
			int newNumberOfShares = currentNumberOfShares + numberOfShares;
			getShare(tickerSymbol).setAmountOwned(newNumberOfShares);
			setChanged();
			notifyObservers();
		}
		else{

			// Add a new share to the folio
			Quote q = new Quote(false);
			try {
				q.setValues(tickerSymbol);
				shares.add(new Share(tickerSymbol, q.getLatest(), numberOfShares));

				// Tell the listener to update the UI
				setChanged();
				notifyObservers();

			}
			catch (NoSuchTickerException nste) {
				System.out.println("No such ticker");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

    public void sellShare(String ticker, int amount) {
        if (ownShare(ticker)) {
			Share shareObject = getShare(ticker);
			int currentlyOwned = shareObject.getAmountOwned();
			if (amount < shareObject.getAmountOwned()) {
				shareObject.setAmountOwned(currentlyOwned - amount);
			}
			else if (amount == shareObject.getAmountOwned()) {
				// Delete the share
				System.out.println("amount = amount owned");
				shares.remove(shareObject);
			}
			else {
				// Can't sell that many. Sell what we own
				System.out.println("Selling what we have");
				shares.remove(shareObject);
			}

			setChanged();
			notifyObservers();
		}
		else {
			// Can't sell share that you don't own
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
