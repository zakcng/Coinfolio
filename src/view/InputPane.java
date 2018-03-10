package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class InputPane extends HBox{
    private ComboBox<String> cboType;
    private TextField txtAmount;
    private Button addBtn;

    public InputPane() {
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setStyle("-fx-background-color: #EBF6FF;");


        ObservableList<String> types= FXCollections.observableArrayList("Coin","USD");
        cboType = new ComboBox<String>(types);
        cboType.getSelectionModel().select(0);
        cboType.setVisibleRowCount(2);

        txtAmount = new TextField();
        addBtn = new Button();
        txtAmount.setPromptText("Enter amount");
        addBtn.setText("Add");


        this.getChildren().addAll(cboType, txtAmount, addBtn);
    }

    public void addAddHandler(EventHandler<ActionEvent> handler) {
        addBtn.setOnAction(handler);
    }

}