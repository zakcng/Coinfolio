package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import model.CurrencyList;
import model.CurrencyPair;

public class CurrencyListViewPane extends StackPane {
    private ListView<CurrencyPair> listView;
    private ObservableList<CurrencyPair> currencyPairs;
    private TextField txtSearch;

    public CurrencyListViewPane() {
        currencyPairs = FXCollections.observableArrayList();
        listView = new ListView<>(currencyPairs);
        listView.setPrefSize(200, 150);

        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        txtSearch = new TextField();
        txtSearch.setPromptText("Search...");
        StackPane.setAlignment(txtSearch, Pos.BOTTOM_CENTER);

        this.getChildren().addAll(listView,txtSearch);

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
