package com.team11.Tracker.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Portfolio extends Observable {


    // All the shares held within this portfolio
    private ArrayList<Share> shares;

	//
    private String portfolioName;

	/*
	 * @Requires name != null, name != ""
	 * @Effects creates a new Portfolio object with the portfolioName = name and an initial empty ArrayList of shares
	 * @Modifies this
	 */
	public Portfolio(String name) {
        // Creates an empty arraylist
		shares = new ArrayList<Share>();
		portfolioName = name;
	}


	/*
 * @Effects returns the ArrayList containing the shares the portfolio holds
 */
	public ArrayList<Share> getShares() {
		return shares;
	}

	/*
 * @Effects returns the total value of the portfolio (the sum of all shares at the current price multiplied by the number of shares owned)
 */
	public String getPortfolioName() {
		return portfolioName;
	}

	/*
	 * @Effects updates all shares held in the portfolio with their latest value
	 * @Modifies this
	 */
	public void updateAllShares() {
		for (Share s: shares) {
			s.updateShare();
		}

		// Update the UI
		setChangedAndNotify();
	}

	/*
 * @Effects returns the total value of the portfolio (the sum of all shares at the current price multiplied by the number of shares owned)
 */
	public void setChangedAndNotify() {
		setChanged();
		notifyObservers();
	}


	// Returns the total value of the portfolio
	public double getFolioValue() {
		double runningTotal = 0;
		for (Share s : shares) {

                runningTotal += (s.getCurrentSharePrice() * s.getAmountOwned());
            }


        return runningTotal;
	}

	// Adds shareObject to the shares array assuming the portfolio doesn't already own the share
	// This version of addShare takes a preexisting Share object as its parameter
	public void addShare(Share shareObject) {
		if (!ownShare(shareObject.getTicker())) {
			shares.add(shareObject);

			// Tell the listener to update the UI
			setChangedAndNotify();
		}
		else {
			System.out.println("Share already owned");
		}
	}




	/*
	 * @Requires tickerSymbol != null, numberOfShares != null
	 * @Effects If the specific share is already present in the shares ArrayList in the Portfolio it increases the
	 * AmountOwned of this share by the numberOfShares. It then notifies the observers to inform GUI of changes.
	 * Else (if the share is not already owned) it adds a new Share object to the shares ArrayList. The observers are now notified
	 * so the GUI is updated.
	 * If tickerSymbol is invalid, throw NoSuchTickerException
	 * @Modifies this
	 */

	public void addShare(String tickerSymbol, Integer numberOfShares) {

		// Adds shareObject to the shares array assuming we don't already own the share
		// If the portfolio already owns it, It will update the amount owned

		if (ownShare(tickerSymbol)) {
			int currentNumberOfShares = getShare(tickerSymbol).getAmountOwned();
			int newNumberOfShares = currentNumberOfShares + numberOfShares;
			getShare(tickerSymbol).setAmountOwned(newNumberOfShares);


			setChangedAndNotify();
		}
		else{
			// We don't own any of this share so the share object needs to be created
			// Add a new share to the folio
			Quote q = new Quote(false);
			try {
				q.setValues(tickerSymbol);
				shares.add(new Share(tickerSymbol, q.getLatest(), numberOfShares));

				// Tell the listener to update the UI
				setChangedAndNotify();

			}
			catch (NoSuchTickerException nste) {
				JOptionPane.showMessageDialog(null,"Please enter a valid Ticker ID!",
						"No Such Ticker!", JOptionPane.WARNING_MESSAGE);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
 * @Requires ticker != null
 * @Effects if share is owned && amount selling < current amount owned, current amount owned -= amount selling
 * if share is owned && amount selling == current amount owned, current amount owned = 0
 * if share is owned && amount selling > current amount owned, current amount owned = 0
 * @Modifies this
 */
    public void sellShare(String ticker, int amount) {
        if (ownShare(ticker)) {
			Share shareObject = getShare(ticker);
			int currentlyOwned = shareObject.getAmountOwned();
			if (amount < shareObject.getAmountOwned()) {
				shareObject.setAmountOwned(currentlyOwned - amount);
			}
			else {
				// Delete the share
				System.out.println("amount = amount owned");
				shares.remove(shareObject);
			}

			setChangedAndNotify();
		}
		else {
			// Can't sell share that you don't own
		}
	}


	/*
 * @Requires ticker != null
 * @Effects returns true if ArrayList contains the share having ticker, else returns false
 */
	public boolean ownShare(String ticker) {
		boolean owned = false;
		for (Share s : shares) {
			if (s.getTicker().equals(ticker)) {
				owned = true;
			}
		}
		return owned;
	}

	/*
 * @Requires ticker != null
 * @Effects return the Share whose ticker matches the parameter,
 * else, return null if there if there is no Share whose ticker matches the parameter
 */
    public Share getShare(String ticker) {
		// Check that we own a share that matches the paramater
		if (ownShare(ticker)) {
			// Find the share within the array
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


}
