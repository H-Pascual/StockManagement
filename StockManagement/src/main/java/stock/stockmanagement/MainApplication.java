/*
Héctor Pascual Marín
Proyecto Entornos
 */
package stock.stockmanagement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * JAFAFX Class to define the main application
 * @author hectorpascualmarin
 * @version 1.0
 */
public class MainApplication extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Home - Stock Management");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        MainController.portfolio = new Portfolio();
        MainController.file = new File();
        File.readFile(MainController.portfolio);
        launch();
    }
}