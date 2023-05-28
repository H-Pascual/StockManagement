package stock.stockmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * JAFAFX Class to add a new stock
 * @author hectorpascualmarin
 * @version 1.0
 */

public class Addstock {
    @FXML private TextField ticker;
    @FXML private TextField name;
    @FXML private TextField purchasePrice;
    @FXML private TextField actualPrice;
    @FXML private TextField quantity;
    @FXML private TextField sector;
    @FXML private TextField dividend;
    @FXML private TextField country;
    @FXML private TextField currency;

    public void saveBtn(ActionEvent actionEvent) throws IOException {
        if(validation()){
            String tickerData = ticker.getText();
            String nameData = name.getText();
            String sectorData = sector.getText();
            String countryData = country.getText();
            String currencyData = currency.getText();
            double dividendData = Double.parseDouble(dividend.getText());
            double purchasePriceData = Double.parseDouble(purchasePrice.getText());
            double actualPriceData = Double.parseDouble(actualPrice.getText());
            double quantityData = Double.parseDouble(quantity.getText());
            Stock stock = new Stock(nameData,tickerData,purchasePriceData,quantityData,actualPriceData,countryData,
                    sectorData,currencyData,dividendData);
            MainController.portfolio.addStock(stock);
            returnBtn(actionEvent);
        }
    }

    public void returnBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
        Node source = (Node) actionEvent.getSource();
        Stage currentStage = (Stage) source.getScene().getWindow();
        currentStage.close();
    }

    public boolean validation() {
        boolean validation = true;
        try{

            String tickerData = ticker.getText();
            String nameData = name.getText();
            String purchasePriceData = purchasePrice.getText();
            String actualPriceData = actualPrice.getText();
            String quantityData = quantity.getText();
            String sectorData = sector.getText();
            String dividendData = dividend.getText();
            String countryData = country.getText();
            String currencyData = currency.getText();
            if (Objects.isNull(tickerData) || tickerData.trim().isEmpty()) {
                MostrarAlerta("The ticket is null.");
                validation = false;
            }else if (Objects.isNull(nameData) || nameData.trim().isEmpty()) {
                MostrarAlerta("The name is null.");
                validation = false;
            }else if (Objects.isNull(purchasePriceData) || purchasePriceData.trim().isEmpty()) {
                MostrarAlerta("The purchase price is null.");
                validation = false;
            }else if (Objects.isNull(actualPriceData) || actualPriceData.trim().isEmpty()) {
                MostrarAlerta("The actual price is null.");
                validation = false;
            }else if (Objects.isNull(quantityData) || quantityData.trim().isEmpty()) {
                MostrarAlerta("The quantity is null.");
                validation = false;
            }else if (Objects.isNull(sectorData) || sectorData.trim().isEmpty()) {
                MostrarAlerta("The sector is null.");
                validation = false;
            }else if (Objects.isNull(dividendData) || dividendData.trim().isEmpty()) {
                MostrarAlerta("The dividend is null.");
                validation = false;
            }else if (Objects.isNull(currencyData) || currencyData.trim().isEmpty()) {
                MostrarAlerta("The currency is null.");
                validation = false;
            }else if (Objects.isNull(countryData) || countryData.trim().isEmpty()) {
                MostrarAlerta("The country is null.");
                validation = false;
            }else{
                Double purchase = Double.parseDouble(purchasePriceData);
                Double actual = Double.parseDouble(actualPriceData);
                Double quantityStock = Double.parseDouble(quantityData);
                Double dividendStock = Double.parseDouble(dividendData);
            }
        }catch (Exception e){
            validation = false;
            MostrarAlerta("Error. Wrong data.");
        }
        return validation;
    }

    public void MostrarAlerta(String mensaje){
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText(null);
        dialog.setContentText(mensaje);
        dialog.showAndWait();
    }
}
