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
import view.ButtonPane;
import view.CoinfolioRootPane;
import view.CurrencyListViewPane;
import view.UserListViewPane;
import java.util.ArrayList;
import java.util.List;

public class CoinfolioController {
    private ButtonPane bp;
    private CurrencyListViewPane clvp;
    private UserListViewPane ulvp;

    private CurrencyList model;
    private CoinfolioRootPane view;

    private List<String> cpList = new ArrayList<>();


    public CoinfolioController(CoinfolioRootPane view, CurrencyList model) {
        this.model = model;
        this.view = view;

        bp = view.getButtonPane();
        clvp = view.getCurrencyListViewPane();
        ulvp = view.getUserListViewPane();

        this.attachEventHandlers();
        this.initialize();
    }

    private void attachEventHandlers() {
        bp.addAddHandler(new AddHandler());
    }

    public class AddHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            CurrencyPair cp = new CurrencyPair();
            cp.setCurrencyPair("Test");
            clvp.addCurrencyPair(cp);


        }

    }

    public void initialize() {
        Exchange exchange = ExchangeFactory.INSTANCE.createExchange(CoinMarketCapExchange.class.getName());

        //Uses ExchangeData function to retrieve currencyPairs
        List<org.knowm.xchange.currency.CurrencyPair> currencyPairs = lib.ExchangeData.getExchangeCurrencyPairs(org.knowm.xchange.coinmarketcap.CoinMarketCapExchange.class.getName());


        //Keeps index of current position of currency to be stored.
        //Will need to be updated if program is saved and reloaded
        int index = 0;
        //Converts to string including index
        //Uses : as delimiter
        for (org.knowm.xchange.currency.CurrencyPair currencyPair : currencyPairs) {
            if (currencyPair.toString().contains("USD")) {
                CurrencyPair cp = new CurrencyPair();
                cp.setCurrencyPair(currencyPair.toString());
                clvp.addCurrencyPair(cp);

            }
        }


        //cvlp.itemsProperty().bind(listProperty);
        //list.setItems(filteredList);

        //This does not work, you can not directly add to a ListProperty
        //listProperty.addAll( asianCurrencyList );
        //listProperty.set(FXCollections.observableArrayList(cpList));
    }

}
