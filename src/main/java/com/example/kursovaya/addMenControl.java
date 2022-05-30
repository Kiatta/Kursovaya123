package com.example.kursovaya;

import Service.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class addMenControl {

    @FXML
    private Button addButton;

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
}
