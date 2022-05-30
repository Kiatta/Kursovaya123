package com.example.kursovaya;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
                    this.loginuser(loginText,loginPass);
                    else
                        System.out.println("Login and password is empty");

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
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Пользователь не найден, проверьте логин и пароль");
                alert.showAndWait();

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
        stage.setTitle("4Clients apps");
        stage.setResizable(false);
        stage.show();
    }

}
