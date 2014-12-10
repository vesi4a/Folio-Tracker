package com.team11.Tracker.Model;

/**
 * Created by camsh on 08/12/14.
 */

    // Class to the hold a purchares of shares
    // holds the sharename, the price paid and the amount purchased
public class Share {
	private String ticker; /*Added ticker symbol to constructor and field*/
    private String shareName;
    private Double sharePrice;
    private Integer amountOwned;


    /*Constructor should include ticker symbol*/
    public Share(String ticker, Double sharePrice, Integer amountOwned) {
    	this.ticker = ticker;
    	shareName = " "; /* Placeholder, user can specify name later*/
        this.sharePrice = sharePrice;
        this.amountOwned = amountOwned;
    }

    public String getShareName() {
        return shareName;
    }

    public Double getSharePrice() {
        return sharePrice;
    }
    
    public void setShareName(String shareName) {
    	this.shareName = shareName;
    }

    public Integer getAmountOwned() {
        return amountOwned;
    }

	public String getTicker() {
		return ticker;
	}
	
	/*Added string representation for testing purposes and file reading/writing purposes*/
	public String toString(){
		return (ticker + " "  + amountOwned + " " + sharePrice + " " + shareName);
	}
}
