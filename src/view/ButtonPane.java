package view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ButtonPane extends HBox {
    //Fields
    private Button /*edit*/ removeBtn, refreshBtn;
    private Label lblValue;

    public ButtonPane() {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(15);
        this.setBorder(new Border(new BorderStroke(Color.web("#111111"), BorderStrokeStyle.SOLID, null, new BorderWidths(1.2))));
        this.setPadding(new Insets(15,15,15,15));


        //editBtn = new Button("Edit");
        removeBtn = new Button("Remove");
        refreshBtn = new Button("Refresh");
        lblValue = new Label("Portfolio = $0");
        lblValue.setStyle("-fx-font-weight: bold;");

        this.getChildren().addAll(/*editBtn*/ removeBtn, refreshBtn);
        for (Node n : this.getChildren()) {
            ((Button) n).setPrefSize(70, 30);
            ((Button) n).setPadding(new Insets(10, 10, 10, 0));
        }

        this.getChildren().add(lblValue);
    }

    public void setLblValue(double i) {
        lblValue.setText("Portfolio = $" + Math.floor(i * 100) / 100);
    }

    /*
    public void addEditHandler(EventHandler<ActionEvent> handler) {
        editBtn.setOnAction(handler);
    }*/

    public void addRemoveHandler(EventHandler<ActionEvent> handler) {
        removeBtn.setOnAction(handler);
    }

    public void addRefreshHandler(EventHandler<ActionEvent> handler) {
        refreshBtn.setOnAction(handler);
    }
}
