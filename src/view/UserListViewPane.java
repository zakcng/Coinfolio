package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import model.CurrencyPair;

public class UserListViewPane extends StackPane {
    private ListView<CurrencyPair> listViewCurrencyPair;

    private ObservableList<CurrencyPair> currencyPairs;

    public UserListViewPane() {
        currencyPairs = FXCollections.observableArrayList();

        listViewCurrencyPair = new ListView<>(currencyPairs);

        listViewCurrencyPair.setPrefSize(200, 150);

        listViewCurrencyPair.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        this.getChildren().addAll(listViewCurrencyPair);
    }

    public void addCurrencyPair(CurrencyPair cp) {
        currencyPairs.add(cp);
    }

    public ObservableList<CurrencyPair> getCurrencyPairs() {
        return currencyPairs;
    }

    public CurrencyPair getSelectedItem() {
        return listViewCurrencyPair.getSelectionModel().getSelectedItem();
    }
}
