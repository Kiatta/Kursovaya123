package com.example.kursovaya;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class appController {

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
            stage.setTitle("4Clients apps");
            stage.setResizable(false);
            stage.show();
        }

    }

