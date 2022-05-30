package com.example.kursovaya;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControllAuth {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSign;

    @FXML
    private TextField logField;

    @FXML
    private PasswordField passField;

    @FXML
    void initialize() {

            authSign.setOnAction(event->{
                String loginText=logField.getText().trim();
                String loginPass=passField.getText().trim();
                if(!loginPass.equals("")&&!loginText.equals(""))
                    loginuser(loginText,loginPass);
                    else
                        System.out.println("Login and password is empty");

            });


    }

    private void loginuser(String loginText, String loginPass) {
    }

}
