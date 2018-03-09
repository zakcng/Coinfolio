package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.CurrencyList;
import model.CurrencyPair;
import view.ButtonPane;
import view.CoinfolioRootPane;
import view.CurrencyListViewPane;
import view.UserListViewPane;

public class CoinfolioController {
    private ButtonPane bp;
    private CurrencyListViewPane clvp;
    private UserListViewPane ulvp;

    private CurrencyList model;
    private CoinfolioRootPane view;

    public CoinfolioController(CoinfolioRootPane view, CurrencyList model) {
        this.model = model;
        this.view = view;

        bp = view.getButtonPane();
        clvp = view.getCurrencyListViewPane();
        ulvp = view.getUserListViewPane();

        this.attachEventHandlers();
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

}
