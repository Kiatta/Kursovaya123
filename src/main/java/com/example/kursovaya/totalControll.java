package com.example.kursovaya;

import Systema.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class totalControll {

    @FXML
    private Button exit;


    @FXML
    private Label tt;
    @FXML
    void initialize() {

        addTotals();
        exit.setOnAction(event -> {
            Stage stage = (Stage)this.exit.getScene().getWindow();
            stage.close();

        });


    }

    private void addTotals() {

        try {
            int b=DataBaseHandler.getId4total();
            tt.setText(String.valueOf(DataBaseHandler.Totals(b)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
