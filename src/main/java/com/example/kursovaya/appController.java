package com.example.kursovaya;

import Systema.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class appController {

    @FXML
    private Button exits;
    @FXML
    private Button back;
    @FXML
    private Button addClient;

    @FXML
    private Button addOrd;

    @FXML
    private Button delClient;

    @FXML
    private Button infoRes;

    @FXML
    private Button updClient;
    @FXML
    private Button addMen;
    @FXML
    void initialize() {

        addMen.setOnAction(event -> {

            this.addmen();


        });
        addClient.setOnAction(event -> {

            this.addclient();


        });
        back.setOnAction(event -> {
           this.back();


        });
        addOrd.setOnAction(event -> {
            this.addOrdBT();


        });
        exits.setOnAction(event -> {
            System.exit(0);


        });
    }
        public void addmen() {
            Stage stage = (Stage)this.addMen.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("addMen.fxml"));

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
    public void addclient() {
        Stage stage = (Stage)this.addClient.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("addClient.fxml"));

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
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    private void delete() {

    }
    private void addOrdBT() {
        Stage stage = (Stage)this.back.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("Product.fxml"));

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

