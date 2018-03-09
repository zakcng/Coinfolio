package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CurrencyList implements Iterable<CurrencyPair>, Serializable {

    //Fields
    private List<CurrencyPair> list;

    //Constructors
    public CurrencyList() {
        list = new ArrayList<CurrencyPair>();
    }

    //Methods
    public void add(CurrencyPair cp) {
        list.add(cp);
    }

    @Override
    public String toString() {
        return "CurrencyList: [list=" + list + "]";
    }



    @Override
    public Iterator<CurrencyPair> iterator() {
        return list.iterator();
    }
}
