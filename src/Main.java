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

        List<CurrencyPair> currencyPairs = lib.ExchangeData.getExchangeCurrencyPairs(org.knowm.xchange.coinmarketcap.CoinMarketCapExchange.class.getName());

        for(CurrencyPair currencyPair : currencyPairs){
            if (currencyPair.toString().contains("USD")) {
                System.out.println(currencyPair);
            }
        }

    }


}

