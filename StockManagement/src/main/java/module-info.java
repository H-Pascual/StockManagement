module stock.stockmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens stock.stockmanagement to javafx.fxml;
    exports stock.stockmanagement;
}