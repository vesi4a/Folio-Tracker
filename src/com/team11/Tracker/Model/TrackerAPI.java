package com.team11.Tracker.Model;


//import com.team11.Tracker.Portfolio;

public class TrackerAPI {
	// code behind and API for system

	// obtain stock quotes, maintain a database of values, and so on
	// get/set/retrieve

	/*
	 * 
	 */
	public Double getStockPrice(String tickerSymbol) {
		Quote quote = new Quote(false);
		try {
			quote.setValues(tickerSymbol);
			return quote.getLatest();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	/*
	 * 
	 */
	public int calculateValue(int numberOfShares, int price) {

		return numberOfShares * price;
	};

	/*
	 * 
	 */
	public boolean isIncreasing(String tickerSymbol) {
		return false;
	};

	/*
	 * 
	 */
	public void deletePortfolio(Portfolio pf) {
	}

	/*
	 * 
	 */
	public void savePortfolio(Portfolio pf) {
	}

	/*
	 * 
	 */
	public boolean addStock(String tickerSymbol, int amount) {
		return false;
	}
}
