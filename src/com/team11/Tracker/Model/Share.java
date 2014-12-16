package com.team11.Tracker.Model;

/**
 * Created by camsh on 08/12/14.
 */

    // Class to the hold a purchares of shares
    // holds the sharename, the price paid and the amount purchased
public class Share implements IShare {
	private String ticker;
    private String shareName;
    private Double currentSharePrice;
    private Double purchasePrice;
    private Integer amountOwned;


    /*Constructor should include ticker symbol*/
    public Share(String ticker, Double currentSharePrice, Integer amountOwned) {
    	this.ticker = ticker;
    	shareName = " "; /* Placeholder, user can specify name later*/
        this.currentSharePrice = currentSharePrice;
        this.amountOwned = amountOwned;
    }

    public void setAmountOwned(Integer amountOwned) {
        this.amountOwned = amountOwned;
    }

    public void setCurrentSharePrice(Double currentSharePrice) {
        this.currentSharePrice = currentSharePrice;
    }

    public String getShareName() {
        return shareName;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public Double getCurrentSharePrice() {
        return currentSharePrice;
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
		return (ticker + " "  + amountOwned + " " + purchasePrice + " " + currentSharePrice + " " + shareName);
	}
}
