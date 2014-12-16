package com.team11.Tracker.Model;



    // Class to the hold a purchases of shares
    // holds the sharename, the price paid and the amount purchased
public class Share implements IShare {
	private String ticker;
    private String shareName;
    private Double currentSharePrice;
    private Double previousPrice;
    private Integer amountOwned;


    // Initialises the object without a previousSharePrice value
    // This will set the previousShare price to the same as the current price
    public Share(String ticker, Double currentSharePrice, Integer amountOwned) {
    	this.ticker = ticker;
    	shareName = " "; /* Placeholder, user can specify name later*/
        this.currentSharePrice = currentSharePrice;
        previousPrice = currentSharePrice;
        this.amountOwned = amountOwned;
    }

    // Initialises the object with a previousSharePrice value
    public Share(String ticker, Double currentSharePrice, Double previousSharePrice,  Integer amountOwned) {
        this.ticker = ticker;
        shareName = " "; /* Placeholder, user can specify name later*/
        this.currentSharePrice = currentSharePrice;
        this.amountOwned = amountOwned;
        this.previousPrice = previousSharePrice;
    }

    public void setAmountOwned(Integer amountOwned) {
        this.amountOwned = amountOwned;
    }

    // Updates the values of the share
    // Sets the previousSharePrice as the value held in currentSharePrice
    // Then updates the currentSharePrice with the retrieved new value
    public void updateShare() {
        // Creates a quote object.
        // Quote objects are how the share prices are being retrived
        Quote q = new Quote(false);
        double currentValue = currentSharePrice;
        try {
            q.setValues(ticker);
            setCurrentSharePrice(q.getLatest());

            previousPrice = currentValue;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setCurrentSharePrice(Double currentSharePrice) {
        this.currentSharePrice = currentSharePrice;
    }

    public String getShareName() {
        return shareName;
    }

    public Double getPreviousPrice() {
        return previousPrice;
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
	
	//String representation for testing purposes and file reading/writing purposes*/
	public String toString(){
		return (ticker + " "  + amountOwned + " " + previousPrice + " " + currentSharePrice + " " + shareName);
	}
}
