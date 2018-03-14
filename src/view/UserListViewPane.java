package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import model.CurrencyPair;

public class UserListViewPane extends StackPane {
    private ListView<String> listViewCurrencyPair;

    private ObservableList<String> currencyPairStrings;

    public UserListViewPane() {
        currencyPairStrings = FXCollections.observableArrayList();

        listViewCurrencyPair = new ListView<>(currencyPairStrings);

        listViewCurrencyPair.setPrefSize(200, 150);

        listViewCurrencyPair.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        this.getChildren().addAll(listViewCurrencyPair);
    }

    public void addCurrencyPair(String cp) {
        currencyPairStrings.add(cp);
    }

    public String getSelectedItem() {
        return listViewCurrencyPair.getSelectionModel().getSelectedItem();
    }
    public void removeSelectedItem() {
        int index = listViewCurrencyPair.getSelectionModel().getSelectedIndex();

        if (index != -1) {
            currencyPairStrings.remove(getSelectedItem());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Selection Error");
            alert.setContentText("Please select an item to remove.");
            alert.showAndWait();
        }
    }

    /*
    public ObservableList<CurrencyPair> getCurrencyPairs() {
        return currencyPairs;
    }*/

    /*
    public CurrencyPair getSelectedItem() {
        return listViewCurrencyPair.getSelectionModel().getSelectedItem();
    }*/
}
