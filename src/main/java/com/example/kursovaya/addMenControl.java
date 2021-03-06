package com.example.kursovaya;

import Service.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class addMenControl {

    @FXML
    private Button addButton;
    @FXML
    private Button exits;
    @FXML
    private Button back;

    @FXML
    private TextField first_name;

    @FXML
    private TextField addLog;

    @FXML
    private TextField second_name;

    @FXML
    private PasswordField addPass;
    @FXML
    void initialize() {
        


        addButton.setOnAction(event -> {
            signUpNewUser();


        });
        back.setOnAction(event -> {
            back();


        });
        exits.setOnAction(event -> {
            System.exit(0);


        });
    }

    private void signUpNewUser() {
        Systema.DataBaseHandler dbHandler = new Systema.DataBaseHandler();
        String login =addLog.getText();
        String password=addPass.getText();
        String firstname=first_name.getText();
        String secondname=second_name.getText();
        User user =new User(login,password,firstname,secondname);
        dbHandler.signUpUser(user);
    }
    private void back() {
        Stage stage = (Stage)this.back.getScene().getWindow();
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
