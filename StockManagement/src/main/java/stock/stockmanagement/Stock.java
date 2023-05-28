package stock.stockmanagement;

/**
 * Class to define stocks information
 * @author hectorpascualmarin
 * @version 1.0
 */

public class Stock {
    private String name, ticker, country, sector, currency;
    private double purchasePrice, quantity, actualPrice, dividend, change;

    /**
     * Constructor with parameters
     * @param name A String with the person name
     * @param ticker A String with the ticker
     * @param purchasePrice A double with the purchasePrice
     * @param quantity A double with the quantity
     * @param actualPrice A double with the actualPrice
     * @param country A String with the country
     * @param sector A String with the sector
     * @param currency A String with the type of currency
     * @param dividend A double with the dividend
     * Also the change, calling the calculate price
     */
    public Stock(String name, String ticker, double purchasePrice, double quantity, double actualPrice, String country,
                 String sector, String currency, double dividend) {
        this.name = name;
        this.ticker = ticker;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.actualPrice = actualPrice;
        this.country = country;
        this.sector = sector;
        this.currency = currency;
        this.dividend = dividend;
        change = calculatePriceChange();
    }
    /**
     * Sets the stock name
     * @param name Stock name
     */
    public void setName(String name){this.name = name;}
    /**
     * Returns the stock name
     * @return Stock name
     */
    public String getName(){return name;}
    /**
     * Sets the ticker
     * @param ticker
     */
    public void setTicker(String ticker){this.ticker = ticker;}
    /**
     * Returns the ticker
     * @return Ticker
     */
    public String getTicker(){return ticker;}
    /**
     * Sets the country
     * @param country
     */
    public void setCountry(String country){this.country = country;}
    /**
     * Returns the country
     * @return Country
     */
    public String getCountry(){return country;}
    /**
     * Sets the sector
     * @param sector
     */
    public void setSector(String sector){this.sector = sector;}
    /**
     * Returns the sector
     * @return Sector
     */
    public String getSector(){return sector;}
    /**
     * Sets the currency
     * @param currency
     */
    public void setCurrency(String currency){this.currency = currency;}
    /**
     * Returns the currency
     * @return Currency
     */
    public String getCurrency(){return currency;}
    /**
     * Sets the purchase price
     * @param purchasePrice
     */
    public void setPurchasePrice(double purchasePrice){this.purchasePrice = purchasePrice;}
    /**
     * Returns the purchase price
     * @return Purchase price
     */
    public double getPurchasePrice(){return purchasePrice;}
    /**
     * Sets the quantity
     * @param quantity
     */
    public void setQuantity(double quantity){this.quantity = quantity;}
    /**
     * Returns the quantity
     * @return Quantity
     */
    public double getQuantity(){return quantity;}
    /**
     * Sets the actual price
     * @param actualPrice
     */
    public void setActualPrice(double actualPrice){this.actualPrice = actualPrice;}
    /**
     * Returns the actual price
     * @return Actual price
     */
    public double getActualPrice(){return actualPrice;}
    /**
     * Sets the dividend
     * @param dividend
     */
    public void setDividend(double dividend){this.dividend = dividend;}
    /**
     * Returns the dividend
     * @return Dividend
     */
    public double getDividend(){return dividend;}
    /**
     * Returns the change
     * @return Change
     */
    public double getChange(){return change;}
    /**
     * Method that calculates the total price
     * @return Total price
     */
    public double totalPrice(){
        return Math.round(actualPrice * quantity * 100.00) / 100.00;
    }
    /**
     * Method that calculates the price change
     * @return An integer with the price variation
     */
    public double calculatePriceChange(){
        return Math.round(((actualPrice - purchasePrice)/purchasePrice)*100.00);
    }
}
