package com.team11.Tracker.Model;



    // Class to the hold a purchases of shares
    // holds the sharename, the price paid and the amount purchased
public class Share implements IShare {
	private String ticker;
    private Double currentSharePrice;
    private Double previousPrice;
    private Integer amountOwned;


            /*
	 * @Requires ticker != null, currentSharePrice != null, currentSharePrice >= 0.0, amountOwned != null, amountOwned >= 0
	 * @Effects creates a share object consisting of a ticker symbol, the current value of the share and the number of that particular share owned
	 * @Modifies this
	 */

    // Initialises the object without a previousSharePrice value
    // This will set the previousShare price to the same as the current price
    public Share(String ticker, Double currentSharePrice, Integer amountOwned) {
    	this.ticker = ticker;
    	this.currentSharePrice = currentSharePrice;
        previousPrice = currentSharePrice;
        this.amountOwned = amountOwned;
    }

            /*
	 * @Requires ticker != null, currentSharePrice != null, currentSharePrice -> 0.0, amountOwned != null, amountOwned >= 0
	 * @Effects creates a share object consisting of a ticker symbol, the current value of the share, the previous value of the share
	 * and the number of that particular share owned
	 * @Modifies this
	 */

    // Initialises the object with a previousSharePrice value
    public Share(String ticker, Double currentSharePrice, Double previousSharePrice,  Integer amountOwned) {
        this.ticker = ticker;
       this.currentSharePrice = currentSharePrice;
        this.amountOwned = amountOwned;
        this.previousPrice = previousSharePrice;
    }

        /*
 * @Requires amountOwned != null, amountOwned >= 0
 * @Effects sets this.amountOwned to amountOwned
 * @Modifies this
 */
    public void setAmountOwned(Integer amountOwned) {
        this.amountOwned = amountOwned;
    }




    // Updates the values of the share
    // Sets the previousSharePrice as the value held in currentSharePrice
    // Then updates the currentSharePrice with the retrieved new value

        /*
 * @Effects previousSharePrice = currentSharePrice, then updates the currentSharePrice with the retrieved value
 * @Modifies this
 */
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

        /*
         * @Requires currentSharePrice != null, currentSharePrice >= 0.00
         * @Effects sets this.currentSharePrice to currentSharePrice
         * @Modifies this
         */
    public void setCurrentSharePrice(Double currentSharePrice) {
        this.currentSharePrice = currentSharePrice;
    }
        /*
          * @Effects returns the previous price of the share
          */
    public Double getPreviousPrice() {
        return previousPrice;
    }
        /*
         * @Effects returns the current price of the share
         */
    public Double getCurrentSharePrice() {
        return currentSharePrice;
    }


        /*
         * @Effects returns the amount owned
         */
    public Integer getAmountOwned() {
        return amountOwned;
    }
        /*
         * @Effects returns the ticker symbol
         */
	public String getTicker() {
		return ticker;
	}
	
	//String representation for testing purposes and file reading/writing purposes*/
        	/*
	 * @Effects returns a string representation of the share
	 */
	public String toString(){
		return (ticker + " "  + amountOwned + " " + previousPrice + " " + currentSharePrice);
	}
}
