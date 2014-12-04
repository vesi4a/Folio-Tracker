package com.team11.Tracker.Model;

import java.util.ArrayList;

public class Portfolio {

    ArrayList<Quote> quotes;

    Portfolio() {
        quotes = new ArrayList<Quote>();
    }

    public void getFolioValue() {
        double runningTotal = 0;
        try {
            for (Quote q : quotes) {
                // TODO: Implement numberOfStocks
                //runningTotal += (q.getLatest() * numberOfStocks);
                runningTotal += (q.getLatest());
            }
        }
        catch (Exception e) {

        }
    }

    public void addQuote(Quote quote) {
        quotes.add(quote);
    }

    public ArrayList<Quote> getQuotes() {
        return quotes;
    }


}
