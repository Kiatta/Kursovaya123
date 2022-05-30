package com.example.kursovaya;

import Service.Client;
import Service.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class addClientControll {

    @FXML
    private Button exit1;
    @FXML
    private Button back1;
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
        back1.setOnAction(event -> {
            back();


        });
        exit1.setOnAction(event -> {
            System.exit(0);


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
    private void back() {
        Stage stage = (Stage)this.back1.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("app.fxml"));

        try {
            loader.load();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        Parent root = (Parent)loader.getRoot();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("4Clients");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
