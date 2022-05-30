package com.example.kursovaya;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Anim.Anim;
import javafx.scene.control.Alert;

import Service.User;
import Systema.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllAuth {


    @FXML
    private Button exit;
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
                    this.loginuser(loginText,loginPass);
                    else
                        System.out.println("Login and password is empty");

            });
        exit.setOnAction(event -> {
            System.exit(0);


        });




    }

    private void loginuser(String loginText, String loginPass) {
        {
            DataBaseHandler dbHandler =new DataBaseHandler();
            User user = new User();
            user.setLogin(loginText);
            user.setPassword(loginPass);

            ResultSet result = dbHandler.getUser(user);
            int count=0;
            while (true){
                try {
                    if (!result.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                count++;
            }
            if (count>=1){

                authSign();
            }
            else {
                Anim userLoginAnim = new Anim(logField);
                Anim userPassAnim = new Anim(passField);
                userLoginAnim.playAnim();
                userPassAnim.playAnim();

            }
        }

    }
    public void authSign() {
        Stage stage = (Stage)this.authSign.getScene().getWindow();
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
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }


}
