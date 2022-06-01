package com.example.kursovaya;

import Service.Client;
import Systema.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Date;

public class appController {
    ObservableList<Client> Clients = FXCollections.observableArrayList();


    @FXML
    private TableColumn<Client, Date> DateColumn;

    @FXML
    private TableColumn<Client, String> FioColumn;
    @FXML
    private TableColumn<Client, String> Time;

    @FXML
    private TableColumn<Client, String> NumberColumn;

    @FXML
    private TableColumn<Client, ?> PriceColumn;

    @FXML
    private TableView<Client> FnTb;
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
    private Button totalClient;
    @FXML
    void initialize() {

        this.Clients = DataBaseHandler.readClient();
        addClClient();
        addMen.setOnAction(event -> {

            this.addmen();


        });
        back.setOnAction(event -> {

            this.Clients = DataBaseHandler.readClient();
            addClClient();

        });

        addClient.setOnAction(event -> {

            this.addclient();



        });
        delClient.setOnAction(event -> {

            deleteClient();



        });

        addOrd.setOnAction(event -> {
            this.addOrdBT();


        });
        exits.setOnAction(event -> {
            System.exit(0);


        });
        totalClient.setOnAction(event -> {
            totCl();


        });
        updClient.setOnAction(event -> {

            updClients();


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
    public void totCl() {
        Stage stage = (Stage)this.totalClient.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("ClientEnd.fxml"));

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


    private void addOrdBT() {
        Stage stage = (Stage)this.addOrd.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("Product.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = (Parent)loader.getRoot();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    private void deleteClient() {

        try {
            DataBaseHandler.delClient(((Client)this.FnTb.getSelectionModel().getSelectedItem()).getFIO());
        } catch (Exception var3) {

        }
        this.Clients.clear();
        this.Clients = DataBaseHandler.readClient();
        this.addClClient();
    }
    private void addClClient() {

        this.FioColumn.setCellValueFactory(new PropertyValueFactory<>("FIO"));
        this.NumberColumn.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
        this.DateColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        this.Time.setCellValueFactory(new PropertyValueFactory<>("time"));
        this.FnTb.setItems(this.Clients);


    }
    private void updClients() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("updClient.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = (Parent)loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }



    }

