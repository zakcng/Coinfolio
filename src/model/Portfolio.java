package model;

public class Portfolio {
    private double value;

    public Portfolio() {
        value = 0;
    }

    public void setValue(double i) {
        this.value = i;
    }

    public double getValue() {
        return value;
    }
}
