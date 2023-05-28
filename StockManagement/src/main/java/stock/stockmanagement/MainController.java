package stock.stockmanagement;

import javafx.animation.KeyValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * JAFAFX Class to define the main controller
 * @author hectorpascualmarin
 * @version 1.0
 */

public class MainController implements Initializable {
    @FXML private Label totalChangeText;
    @FXML private Label dividendText;
    @FXML private PieChart countryChart;
    @FXML private PieChart currencyChart;
    @FXML private  PieChart stockChart;
    @FXML private  PieChart sectorChart;
    @FXML private Label valueText;
    @FXML private ListView stockList;
    private Stock selected;
    public static File file;
    public static Portfolio portfolio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateListView();
    }
    private void updateListView() {
        addStocks();
        addStockChart();
        addCurrencyChart();
        addCountryChart();
        addSectorChart();
        addText();
    }
    public void addText(){
        valueText.setText(portfolio.calculateValue() + "€");
        dividendText.setText(portfolio.calculateDividend() + "%");
        if(portfolio.calculateChange()>=0)
            totalChangeText.setTextFill(Color.GREEN);
        else
            totalChangeText.setTextFill(Color.RED);
        totalChangeText.setText(portfolio.calculateChange() + "%");
    }
    public void addStocks(){
        stockList.getItems().clear();
        for(Stock e : portfolio.getStockList()){
            stockList.getItems().add(e.getName() + " - Price: " + e.getActualPrice() +
                    "€ - Change: " + e.getChange() + "%");
            PieChart.Data pieChart = new PieChart.Data(e.getName(), e.totalPrice());
            stockChart.getData().add(pieChart);
        }
    }
    public void addStockChart(){
        stockChart.getData().clear();
        stockChart.setTitle("Stock Chart");
        for(Stock e : portfolio.getStockList()){
            PieChart.Data pieChart = new PieChart.Data(e.getName(), e.totalPrice());
            stockChart.getData().add(pieChart);
        }
    }
    public void addSectorChart(){
        sectorChart.getData().clear();
        sectorChart.setTitle("Sector Chart");
        Map<String, Double> sector = new HashMap<>();
        for(Stock e : portfolio.getStockList()){
            if(!(sector.containsKey(e.getSector()))){
                sector.put(e.getSector(), e.totalPrice());
            }else {
                Double price = sector.get(e.getSector()) + e.totalPrice();
                sector.replace(e.getSector(), price);
            }
        }
        for(Map.Entry<String, Double> e : sector.entrySet()){
            PieChart.Data pieChart = new PieChart.Data(e.getKey(), e.getValue());
            sectorChart.getData().add(pieChart);
        }
    }
    public void addCurrencyChart(){
        currencyChart.getData().clear();
        currencyChart.setTitle("Currency Chart");
        Map<String, Double> currency = new HashMap<>();
        for(Stock e : portfolio.getStockList()){
            if(!(currency.containsKey(e.getCurrency()))){
                currency.put(e.getCurrency(), e.totalPrice());
            }else {
                Double price = currency.get(e.getCurrency()) + e.totalPrice();
                currency.replace(e.getCurrency(), price);
            }
        }
        for(Map.Entry<String, Double> e : currency.entrySet()){
            PieChart.Data pieChart = new PieChart.Data(e.getKey(), e.getValue());
            currencyChart.getData().add(pieChart);
        }
    }
    public void addCountryChart(){
        countryChart.getData().clear();
        countryChart.setTitle("Country Chart");
        Map<String, Double> country = new HashMap<>();
        for(Stock e : portfolio.getStockList()){
            if(!(country.containsKey(e.getCountry()))){
                country.put(e.getCountry(), e.totalPrice());
            }else {
                Double price = country.get(e.getCountry()) + e.totalPrice();
                country.replace(e.getCountry(), price);
            }
        }
        for(Map.Entry<String, Double> e : country.entrySet()){
            PieChart.Data pieChart = new PieChart.Data(e.getKey(), e.getValue());
            countryChart.getData().add(pieChart);
        }
    }
    public void addStockBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addstock.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
        Node source = (Node) actionEvent.getSource();
        Stage currentStage = (Stage) source.getScene().getWindow();
        currentStage.close();
    }

    public void removeStockBtn(ActionEvent actionEvent) {
        if(selected != null){
            portfolio.removeStock(selected);
            updateListView();
        }
    }
    public void itemClicked(MouseEvent mouseEvent) {
        if(!stockList.getSelectionModel().isEmpty()){
            int position = stockList.getSelectionModel().getSelectedIndex();
            if(position<portfolio.getStockList().size())
                selected = portfolio.getStockList().get(position);
        }
    }

    public void saveStockBtn(ActionEvent actionEvent) {
        File.saveFile(portfolio);
    }
}