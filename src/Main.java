import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lib.ExchangeData;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.coinmarketcap.CoinMarketCapExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Coinfolio");



        primaryStage.setScene(new Scene(root, 600,400));
        primaryStage.show();

    }

    public static void main(String[] args) throws IOException {
        launch(args);


        Exchange exchange = ExchangeFactory.INSTANCE.createExchange(CoinMarketCapExchange.class.getName());
        MarketDataService marketDataService = exchange.getMarketDataService();

        CurrencyPair NEO_BTC = new CurrencyPair("NEO", "BTC");
        Ticker ticker0 = marketDataService.getTicker(NEO_BTC);
        System.out.println(ticker0.toString());

        //Uses ExchangeData function to retrieve currencyPairs
        List<CurrencyPair> currencyPairs = lib.ExchangeData.getExchangeCurrencyPairs(org.knowm.xchange.coinmarketcap.CoinMarketCapExchange.class.getName());


        //Keeps index of current position of currency to be stored.
        //Will need to be updated if program is saved and reloaded
        int index = 0;
        //Converts to string including index
        //Uses : as delimiter
        for(CurrencyPair currencyPair : currencyPairs){
            if (currencyPair.toString().contains("USD")) {
                System.out.println(index + (index++) + ":" + currencyPair.toString());
            }
        }

        //Retrieve from index
        Ticker ticker1 = marketDataService.getTicker(currencyPairs.get(380));
        System.out.println(ticker1.toString());

        for(CurrencyPair currencyPair : currencyPairs){
            if (currencyPair.toString().contains("USD")) {
                Ticker tickerb = marketDataService.getTicker(currencyPair);
                System.out.println(tickerb.toString());
            }
        }

        int cpIndex[] = new int[2];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<2; i++){
            System.out.println("Please enter index of your currency: ");


            int indexNum = sc.nextInt();
            cpIndex[i] = indexNum;
        }
        sc.close();

        for (int cpIndexs : cpIndex) {
            System.out.println("Item: " + cpIndexs);
            ExchangeData.getIndexTickerString(cpIndexs);
        }




    }


}

