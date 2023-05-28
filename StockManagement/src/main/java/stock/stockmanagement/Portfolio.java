package stock.stockmanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * Class to define the portfolio with all the stocks saved
 * @author hectorpascualmarin
 * @version 1.0
 */
public class Portfolio {
    private ArrayList<Stock> stocks;
    public Portfolio(){
        stocks = new ArrayList<>();
    }
    public void addStock(Stock stock){
        stocks.add(stock);
    }
    public void removeStock(Stock stock){
        stocks.remove(stock);
    }
    public ArrayList<Stock> getStockList(){
        return stocks;
    }
    public double calculateChange(){
        double change=0;
        for(Stock a:stocks){
            change += a.getQuantity() * a.getChange();
        }
        return Math.round(change/calculateQuantity() * 100.00) / 100.00;
    }
    public double calculateQuantity(){
        double quantity = 0;
        for(Stock a : stocks){
            quantity += a.getQuantity();
        }
        return Math.round(quantity * 100.00) / 100.00;
    }
    public double calculateValue(){
        double price = 0;
        for (Stock a : stocks){
            price += a.getActualPrice();
        }
        return Math.round(price * 100.00) / 100.00;
    }
    public double calculateDividend(){
        double dividend = 0;
        for(Stock a : stocks){
            dividend += a.getDividend() * a.getQuantity();
        }

        return Math.round(dividend/calculateQuantity() * 100.00) / 100.00;
    }
}