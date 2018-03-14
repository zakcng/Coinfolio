package main;

import controller.CoinfolioController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CurrencyList;
import model.Portfolio;
import view.CoinfolioRootPane;

public class ApplicationLoader extends Application {

    private CoinfolioRootPane view;

    @Override
    public void init() {
        CurrencyList model = new CurrencyList();
        view = new CoinfolioRootPane();
        Portfolio portfolio = new Portfolio();
        new CoinfolioController(view, model, portfolio);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Coinfolio");
        stage.setScene(new Scene(view));
        stage.setMinHeight(450);
        stage.setMinWidth(450);
        stage.setMaxWidth(450);
        stage.setMaxHeight(450);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
