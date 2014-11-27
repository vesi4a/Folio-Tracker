package com.team11.Tracker;

public class TrackerAPI {
	// code behind and API for system

	// obtain stock quotes, maintain a database of values, and so on
	// get/set/retrieve

	/*
	 * 
	 */
	public String getStockPrice(String tickerSymbol) {
		return tickerSymbol;
	};

	/*
	 * 
	 */
	public int calculateValue(int numberOfShares, int price) {
		return price;
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
