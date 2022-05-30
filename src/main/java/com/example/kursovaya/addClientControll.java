package com.example.kursovaya;

import Service.Client;
import Service.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.time.LocalDate;

public class addClientControll {

    @FXML
    private Button addClient;
    @FXML
    private DatePicker dateClient;

    @FXML
    private TextField FIOClient;

    @FXML
    private TextField Time;

    @FXML
    private TextField numberClient;


    @FXML
    void initialize() {



        addClient.setOnAction(event -> {
            signUpNewUser();

        });
    }

    private void signUpNewUser() {
        Systema.DataBaseHandler dbHandler = new Systema.DataBaseHandler();
        String FIO =FIOClient.getText();
        String Mobile=numberClient.getText();
        Date data= Date.valueOf(dateClient.getValue());
        String time=Time.getText();
        Client client =new Client(FIO,Mobile,data,time);
        dbHandler.signUpClient(client);
    }
}
