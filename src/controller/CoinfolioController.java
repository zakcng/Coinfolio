package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import model.CurrencyList;
import model.CurrencyPair;
import model.Portfolio;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.coinmarketcap.CoinMarketCapExchange;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;
import view.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoinfolioController {
    private ButtonPane bp;
    private CurrencyListViewPane clvp;
    private UserListViewPane ulvp;
    private InputPane ip;

    private CurrencyList model;
    private CoinfolioRootPane view;
    private Portfolio portfolio;

    private List<String> cpList = new ArrayList<>();


    public CoinfolioController(CoinfolioRootPane view, CurrencyList model, Portfolio portfolio) {
        this.model = model;
        this.view = view;
        this.portfolio = portfolio;

        bp = view.getButtonPane();
        clvp = view.getCurrencyListViewPane();
        ulvp = view.getUserListViewPane();
        ip = view.getInputPane();


        this.attachEventHandlers();
        this.initialize();
    }

    private void attachEventHandlers() {
        ip.addAddHandler(new AddHandler());
        bp.addRemoveHandler(new RemoveHandler());

        clvp.addChangeListener( new ChangeListener() {
            public void changed(ObservableValue observable,
                                Object oldVal, Object newVal) {
                handleSearchByKey((String)oldVal, (String)newVal);
            }
        });
    }

    private void handleSearchByKey(String oldVal, String newVal) {
        // If the number of characters in the text box is less than last time
        // it must be because the user pressed delete

        List<String> subentries = FXCollections.observableArrayList();
        if ( oldVal != null && (newVal.length() < oldVal.length()) ) {
            System.out.println("DELETE");
            // Restore the lists original set of entries
            // and start from the beginning
            initialize();
        }

        // Change to upper case so that case is not an issue
        newVal = newVal.toUpperCase();

        // Filter out the entries that don't contain the entered text

        for ( Object entry: clvp.getCurrencyPairs()) {
            String entryText = (String)entry.toString();
            if ( entryText.toUpperCase().contains(newVal) ) {
                subentries.add(entryText);
            }
        }

        clvp.clearCurrencyPairs();

        for (String s : subentries) {
            CurrencyPair cp = new CurrencyPair();
            cp.setCurrencyPair(s);
            clvp.addCurrencyPair(cp);
        }

    }

    private class AddHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {

            String stringValue = new String();
            boolean b1;
            b1 = ip.notEmpty();
            if (b1 == true) {
                System.out.println(clvp.getSelectedItem());
                if (ip.getCboType() == "# Of Coins") {
                    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(CoinMarketCapExchange.class.getName());
                    MarketDataService marketDataService = exchange.getMarketDataService();


                    String[] splitBase = clvp.getSelectedItem().getCurrencyPair().toString().split("/");
                    System.out.println(splitBase[0]);


                    org.knowm.xchange.currency.CurrencyPair c1 = new org.knowm.xchange.currency.CurrencyPair(splitBase[0], splitBase[1]);
                    Ticker ticker0 = null;
                    try {
                        ticker0 = marketDataService.getTicker(c1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String[] splitPrice = ticker0.toString().split(",");
                    stringValue = splitPrice[2].replaceAll("[^\\.0123456789]", "").substring(0, Math.min(splitPrice[2].length(), 7));
                    double stringValueDouble = (Double.parseDouble(stringValue) * ip.getTxtAmount());
                    ulvp.addCurrencyPair(clvp.getSelectedItem().toString() + " $" + (stringValueDouble));
                    portfolio.setValue(portfolio.getValue() + stringValueDouble);
                    bp.setLblValue(portfolio.getValue());

                } else if (ip.getCboType() == "USD") {
                    ulvp.addCurrencyPair(clvp.getSelectedItem().toString() + "$" + ip.getTxtAmount());
                    portfolio.setValue(portfolio.getValue() + ip.getTxtAmount());
                    bp.setLblValue(portfolio.getValue());
                }

                clvp.removeSelectedItem();

            }


        }

    }

    private class RemoveHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {

            double stringValueDouble = (Double.parseDouble(ulvp.getSelectedItem().toString().replaceAll(".*\\$", "")));
            portfolio.setValue(portfolio.getValue()-stringValueDouble);
            bp.setLblValue(portfolio.getValue());
            ulvp.removeSelectedItem();
        }
    }



            public void initialize() {
        Exchange exchange = ExchangeFactory.INSTANCE.createExchange(CoinMarketCapExchange.class.getName());

        List<org.knowm.xchange.currency.CurrencyPair> currencyPairs = lib.ExchangeData.getExchangeCurrencyPairs(org.knowm.xchange.coinmarketcap.CoinMarketCapExchange.class.getName());

        int index = 0;
        for (org.knowm.xchange.currency.CurrencyPair currencyPair : currencyPairs) {
            String[] splitBase = currencyPair.toString().split("/");
           if(splitBase[1].contains("USD")){
                CurrencyPair cp = new CurrencyPair();
                cp.setCurrencyPair(currencyPair.toString());
                clvp.addCurrencyPair(cp);

            }
        }
    }

}
