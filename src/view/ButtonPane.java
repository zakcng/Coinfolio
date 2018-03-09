package view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPane extends HBox {
    //Fields
    private Button addBtn, editBtn, removeBtn, refreshBtn;

    public ButtonPane() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);

        addBtn = new Button("Add");
        editBtn = new Button("Edit");
        removeBtn = new Button("Remove");
        refreshBtn = new Button("Refresh");

        this.getChildren().addAll(addBtn, editBtn, removeBtn, refreshBtn);

        for (Node n : this.getChildren()) {
            ((Button) n).setPrefSize(70, 30);
        }
    }

    public void addAddHandler(EventHandler<ActionEvent> handler) {
        addBtn.setOnAction(handler);
    }

    public void addEditHandler(EventHandler<ActionEvent> handler) {
        editBtn.setOnAction(handler);
    }

    public void addRemoveHandler(EventHandler<ActionEvent> handler) {
        removeBtn.setOnAction(handler);
    }

    public void addRefreshHandler(EventHandler<ActionEvent> handler) {
        refreshBtn.setOnAction(handler);
    }
}
