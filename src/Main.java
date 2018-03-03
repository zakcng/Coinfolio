import lib.ExchangeData;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.coinmarketcap.CoinMarketCapExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
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



       // System.out.println(currencyPairs.get(0).toString());

    }


}

