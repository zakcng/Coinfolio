package main;

import controller.CoinfolioController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CurrencyList;
import view.CoinfolioRootPane;

public class ApplicationLoader extends Application {

    private CoinfolioRootPane view;

    @Override
    public void init() {
        CurrencyList model = new CurrencyList();
        view = new CoinfolioRootPane();
        new CoinfolioController(view, model);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Coinfolio");
        stage.setScene(new Scene(view));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
