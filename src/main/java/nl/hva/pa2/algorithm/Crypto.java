package nl.hva.pa2.algorithm;

import java.io.Serializable;
import java.util.List;

public class Crypto implements Serializable, Comparable<Crypto> {
    private static final long serialVersionUID = 3160259504361441602L;

    private String cryptoName;
    private String date;
    private double priceChange;

    public Crypto(String cryptoName, String date, double priceChange) {
        this.cryptoName = cryptoName;
        this.date = date;
        this.priceChange = priceChange;
    }

    public String getCryptoName() {
        return this.cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPriceChange() {
        return this.priceChange;
    }

    public void setPriceChange(double priceChange) {
        this.priceChange = priceChange;
    }

    public String toString() {
        return String.format("[ Crypto: %s, Date:%s, pricechange %2f ] ", this.cryptoName, this.date, this.priceChange);
    }

    @Override
    public int compareTo(Crypto crypto) {
        return (int) (this.priceChange - crypto.priceChange);
    }
}
