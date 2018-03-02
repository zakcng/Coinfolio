package lib;


import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.coinmarketcap.CoinMarketCapExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.NonceException;

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
                System.out.println("ok we have an issue...");
            }
            return currencyPairList;
        }
    }
}