package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.CurrencyPair;

public class UserListViewPane extends VBox {
    private ListView<String> listViewCurrencyPair;
    private TextField txtValue;

    private ObservableList<String> currencyPairStrings;

    public UserListViewPane() {
        currencyPairStrings = FXCollections.observableArrayList();

        listViewCurrencyPair = new ListView<>(currencyPairStrings);

       listViewCurrencyPair.setPrefWidth(200);

        listViewCurrencyPair.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        txtValue = new TextField("Portfolio = $0");
        txtValue.setStyle("-fx-font-weight: bold;");
        txtValue.setEditable(false);

        StackPane.setAlignment(txtValue, Pos.BOTTOM_CENTER);


        this.getChildren().addAll(listViewCurrencyPair, txtValue);

    }

    public void addCurrencyPair(String cp) {
        currencyPairStrings.add(cp);
    }

    public String getSelectedItem() {
        return listViewCurrencyPair.getSelectionModel().getSelectedItem();
    }

    public void setLblValue(double i) {
        txtValue.setText("Portfolio = $" + Math.floor(i * 100) / 100);
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
