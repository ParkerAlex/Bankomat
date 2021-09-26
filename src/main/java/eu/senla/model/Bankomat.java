package eu.senla.model;


public class Bankomat {

    private long price;
    private long priceMax;
    private long limitMoney;

    public Bankomat(long price, long priceMax, long limitMoney) {
        this.price = price;
        this.priceMax = priceMax;
        this.limitMoney = limitMoney;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(long priceMax) {
        this.priceMax = priceMax;
    }

    public long getLimitMoney() {
        return limitMoney;
    }

    public void setLimitMoney(long limitMoney) {
        this.limitMoney = limitMoney;
    }

    @Override
    public String toString() {
        return "Bankomat{" +
                "price=" + price +
                ", priceMax=" + priceMax +
                ", limitMoney=" + limitMoney +
                '}';
    }
}
