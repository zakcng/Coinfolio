//https://gist.githubusercontent.com/anonymous/d94752f3c64ceaf1c4ea/raw/f8f0c11f89a40da2cb1a0c858e900425fd78973e/AppController.java

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.coinmarketcap.CoinMarketCapExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public List<String> cpList = new ArrayList<>();

    ListProperty<String> listProperty = new SimpleListProperty<>();



    @FXML
    private ListView list;
    private ListView sList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Exchange exchange = ExchangeFactory.INSTANCE.createExchange(CoinMarketCapExchange.class.getName());

        //Uses ExchangeData function to retrieve currencyPairs
        List<CurrencyPair> currencyPairs = lib.ExchangeData.getExchangeCurrencyPairs(org.knowm.xchange.coinmarketcap.CoinMarketCapExchange.class.getName());


        //Keeps index of current position of currency to be stored.
        //Will need to be updated if program is saved and reloaded
        int index = 0;
        //Converts to string including index
        //Uses : as delimiter
        for(CurrencyPair currencyPair : currencyPairs){
            if (currencyPair.toString().contains("USD")) {
                cpList.add(currencyPair.toString());
            }
        }



        list.itemsProperty().bind(listProperty);
        //list.setItems(filteredList);

        //This does not work, you can not directly add to a ListProperty
        //listProperty.addAll( asianCurrencyList );
        listProperty.set(FXCollections.observableArrayList(cpList));
    }

    public void btnSaveButtonClicked() {
        System.out.println("Saved!");
    }

    public void btnAddButtonClicked() {
        ObservableList listOfItems = list.getSelectionModel().getSelectedItems();

        System.out.println(listOfItems.toString());
        sList.setItems(FXCollections.observableList(listOfItems));

    }


}
