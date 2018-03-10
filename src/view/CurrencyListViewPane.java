package view;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
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

    /*
    public void setObservableList(ObservableList ol) {
        this.listView= ol;
    }*/

    public CurrencyPair getSelectedItem() {
        return listView.getSelectionModel().getSelectedItem();
    }

    public void removeSelectedItem() {
        int index = listView.getSelectionModel().getSelectedIndex();

        if (index != -1) {
            currencyPairs.remove(getSelectedItem());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Selection Error");
            alert.setContentText("Please select an item to remove.");
            alert.showAndWait();
        }
    }


    public void clearCurrencyPairs() {
        currencyPairs.clear();
    }

    public void addChangeListener(ChangeListener<String> listener) {
        txtSearch.textProperty().addListener(listener);
    }

}
