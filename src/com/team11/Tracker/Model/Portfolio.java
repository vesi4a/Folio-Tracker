package com.team11.Tracker.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {


    // All the shares held within this portfolio
    private ArrayList<Share> shares;



	public Portfolio() {
        // Creates an empty arraylist
		shares = new ArrayList<Share>();
	}

    public void loadFolio() {
        // TODO: Implement
    }

    public void saveFolio() {
        // TODO: Implement
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
	public void addShare(String shareName, Integer numberOfShares) {
        Quote q = new Quote(false);
        try {
            q.setValues(shareName);
            shares.add(new Share(shareName, q.getLatest(), numberOfShares));
        }
        catch (Exception e) {

        }
	}

    public void sellShare() {
        // TODO: Implement
    }

    public Share getShare(String ticker) {
        for (Share s : shares) {
            if (s.getShareName().equals(ticker)) {
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

}
