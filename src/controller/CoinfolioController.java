package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import model.CurrencyList;
import model.CurrencyPair;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.coinmarketcap.CoinMarketCapExchange;
import view.*;

import java.util.ArrayList;
import java.util.List;

public class CoinfolioController {
    private ButtonPane bp;
    private CurrencyListViewPane clvp;
    private UserListViewPane ulvp;
    private InputPane ip;

    private CurrencyList model;
    private CoinfolioRootPane view;

    private List<String> cpList = new ArrayList<>();


    public CoinfolioController(CoinfolioRootPane view, CurrencyList model) {
        this.model = model;
        this.view = view;

        bp = view.getButtonPane();
        clvp = view.getCurrencyListViewPane();
        ulvp = view.getUserListViewPane();
        ip = view.getInputPane();


        this.attachEventHandlers();
        this.initialize();
    }

    private void attachEventHandlers() {
        ip.addAddHandler(new AddHandler());
    }

    public class AddHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            boolean b1;
            b1 = ip.notEmpty();
            if (b1 == true) {
                System.out.println("Not empty now doing something");
                System.out.println(clvp.getSelectedItem());
                ulvp.addCurrencyPair(clvp.getSelectedItem().toString() + " $" +ip.getTxtAmount());
                clvp.removeSelectedItem();

bp.setLblValue();

            }


        }

    }


    public void initialize() {
        Exchange exchange = ExchangeFactory.INSTANCE.createExchange(CoinMarketCapExchange.class.getName());

        List<org.knowm.xchange.currency.CurrencyPair> currencyPairs = lib.ExchangeData.getExchangeCurrencyPairs(org.knowm.xchange.coinmarketcap.CoinMarketCapExchange.class.getName());

        int index = 0;
        for (org.knowm.xchange.currency.CurrencyPair currencyPair : currencyPairs) {
            if (currencyPair.toString().contains("USD")) {
                CurrencyPair cp = new CurrencyPair();
                cp.setCurrencyPair(currencyPair.toString());
                clvp.addCurrencyPair(cp);

            }
        }
    }

}
