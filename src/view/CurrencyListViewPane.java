package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import model.CurrencyList;
import model.CurrencyPair;

public class CurrencyListViewPane extends StackPane {
    private ListView<CurrencyPair> listView;
    private ObservableList<CurrencyPair> currencyPairs;

    public CurrencyListViewPane() {
        currencyPairs = FXCollections.observableArrayList();
        listView = new ListView<>(currencyPairs);
        listView.setPrefSize(200, 150);

        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        this.getChildren().add(listView);

    }

    public void addCurrencyPair(CurrencyPair cp) {
        currencyPairs.add(cp);
    }

    public ObservableList<CurrencyPair> getCurrencyPairs() {
        return currencyPairs;
    }

    public CurrencyPair getSelectedItem() {
        return listView.getSelectionModel().getSelectedItem();
    }
}
