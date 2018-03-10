package view;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class CoinfolioRootPane extends BorderPane{
    private ButtonPane bp;
    private UserListViewPane ulvp;
    private CurrencyListViewPane clvp;
    private InputPane ip;

    public CoinfolioRootPane() {
        this.setStyle("-fx-background-color: #415D78;");

        bp = new ButtonPane();
        ulvp = new UserListViewPane();
        clvp = new CurrencyListViewPane();
       ip = new InputPane();

        BorderPane rootContainer = new BorderPane();
        rootContainer.setLeft(ulvp);
        rootContainer.setCenter(clvp);
        rootContainer.setBottom(bp);
      rootContainer.setTop(ip);
        rootContainer.setPadding(new Insets(20,20,20,20));

        this.setCenter(rootContainer);
    }

    public ButtonPane getButtonPane() {
        return bp;
    }

    public CurrencyListViewPane getCurrencyListViewPane() {
        return clvp;
    }

    public UserListViewPane getUserListViewPane() {
        return ulvp;
    }

}
