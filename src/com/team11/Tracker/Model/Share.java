package com.team11.Tracker.Model;

/**
 * Created by camsh on 08/12/14.
 */

    // Class to the hold a purchares of shares
    // holds the sharename, the price paid and the amount purchased
public class Share {
    private String shareName;
    private Double sharePrice;
    private Integer amountOwned;



    public Share(String shareName, Double sharePrice, Integer amountOwned) {
        this.shareName = shareName;
        this.sharePrice = sharePrice;
        this.amountOwned = amountOwned;
    }

    public String getShareName() {
        return shareName;
    }

    public Double getSharePrice() {
        return sharePrice;
    }

    public Integer getAmountOwned() {
        return amountOwned;
    }
}
