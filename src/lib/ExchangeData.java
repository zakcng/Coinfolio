package lib;


import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.coinmarketcap.CoinMarketCapExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.NonceException;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;
import java.util.List;

public class ExchangeData {

    public static List<CurrencyPair> getExchangeCurrencyPairs(String Classname) {


        {
            List<CurrencyPair> currencyPairList = null;

            Exchange exch = null;

            try {
                exch = ExchangeFactory.INSTANCE.createExchange(CoinMarketCapExchange.class.getName());
                currencyPairList = exch.getExchangeSymbols();
            } catch (NonceException e) {
                System.out.println("Nonce exception...");
            } catch (ExchangeException e) {
                System.out.println("Exchange exception...");
            } catch (Exception e) {
                System.out.println("Ok, we have an issue...");
            }
            return currencyPairList;
        }
    }



        public static String getIndexTickerString (int cpIndex) {
            Exchange exchange = ExchangeFactory.INSTANCE.createExchange(CoinMarketCapExchange.class.getName());
            MarketDataService marketDataService = exchange.getMarketDataService();

            List<CurrencyPair> currencyPairs = lib.ExchangeData.getExchangeCurrencyPairs(org.knowm.xchange.coinmarketcap.CoinMarketCapExchange.class.getName());


            Ticker ticker1 = null;
            try {
                ticker1 = marketDataService.getTicker(currencyPairs.get(cpIndex));
            } catch (IOException e) {
                e.printStackTrace();
            }


            String indexTickerString = new String(ticker1.toString());
            return indexTickerString;
        }


}

