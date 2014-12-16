package com.team11.Tracker.Model;

public interface IShare {

    public void setAmountOwned(Integer amountOwned);
    public void setCurrentSharePrice(Double currentSharePrice);
    public String getShareName();
    public Double getPreviousPrice();
    public Double getCurrentSharePrice();
    public void setShareName(String shareName);
    public Integer getAmountOwned();
    public String getTicker();
    public String toString();

}
