package com.example.kursovaya;

import Systema.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.sql.Date;
import java.time.LocalDate;


public class updClientControll {
    ObservableList Choise = FXCollections.observableArrayList();


    @FXML
    private DatePicker DateInsrt;

    @FXML
    private TextField MobileInsrt;

    @FXML
    private TextField TimeInsrt;

    @FXML
    private Button accept;

    @FXML
    private Button exit;


    @FXML
    private ChoiceBox<String> choice;
    @FXML
    void initialize() {
        /*this.Choise = DataBaseHandler.getCl();
        this.choice.setItems(this.Choise);
        String fs = this.choice.getValue();
        int a=DataBaseHandler.getId(fs);

        this.TimeInsrt.setText(DataBaseHandler.getTime(a));
        this.MobileInsrt.setText(DataBaseHandler.getMob(a));*/
        accept.setOnAction(event -> {
            setAccept();
            Stage stage = (Stage)this.accept.getScene().getWindow();
            stage.close();

        });

        exit.setOnAction(event -> {
            Stage stage = (Stage)this.exit.getScene().getWindow();
            stage.close();

        });

    }
    private void setAccept() {

        try {
            String fs = this.choice.getValue();
            int a=DataBaseHandler.getId(fs);
            String Mobile=MobileInsrt.getText();
            Date data= Date.valueOf(DateInsrt.getValue());
            String time=TimeInsrt.getText();
            DataBaseHandler.updClient(fs,Mobile,data,time,a);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
