package model;

import java.io.Serializable;

public class CurrencyPair implements Serializable {

    //Fields
    private String currencyPair;

    //Constructors
    public CurrencyPair() {
        currencyPair = "";
    }

    public CurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    //Methods
    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    @Override
    public String toString() {
        return this.getCurrencyPair();
    }

}
