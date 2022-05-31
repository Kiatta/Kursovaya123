package com.example.kursovaya;
import Service.EndClient;
import Systema.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;


public class EndControll {
    ObservableList Fio = FXCollections.observableArrayList();
    ObservableList Pr = FXCollections.observableArrayList();

    ObservableList<EndClient> End = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> FioCl;

    @FXML
    private TableColumn<?, ?> FioClCol;

    @FXML
    private TableColumn<?, ?> PricePrCol;

    @FXML
    private ChoiceBox<String> ProductCl;

    @FXML
    private TableView<EndClient> TableEnd;

    @FXML
    private Button Total;

    @FXML
    private Button addEnd;

    @FXML
    private Button back;


    @FXML
    private Button delEnd;


    @FXML
    private Button exits;
    @FXML
    void initialize() {

        this.End.clear();
        this.End = DataBaseHandler.readEndClient();
        DataBaseHandler.delAll();
        back.setOnAction(event -> {
            back();


        });
        addEnd.setOnAction(event -> {
            addEndCl();




        });
        Total.setOnAction(event -> {
            tot();




        });
        delEnd.setOnAction(event -> {
            delete();


        });
        exits.setOnAction(event -> {
            System.exit(0);



        });
        this.Fio = DataBaseHandler.getCl();
        this.FioCl.setItems(this.Fio);
        this.Pr = DataBaseHandler.getPr();
        this.ProductCl.setItems(this.Pr);

    }

    private void back() {
        Stage stage = (Stage)this.back.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("app.fxml"));

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
    private void delete() {
        try {
            DataBaseHandler.delEndClient(((EndClient)this.TableEnd.getSelectionModel().getSelectedItem()).getIdClientpr(), ((EndClient)this.TableEnd.getSelectionModel().getSelectedItem()).getIdPrclient());

        } catch (Exception e) {
            e.printStackTrace();

        }

        this.End.clear();

        try {
            this.End = DataBaseHandler.readEndClient();
        } catch (Exception e) {

        }

        this.addColumn();
        FioCl.hide();
    }
    private void addColumn() {

        this.FioClCol.setCellValueFactory(new PropertyValueFactory<>("idClientpr"));
        this.PricePrCol.setCellValueFactory(new PropertyValueFactory<>("idPrclient"));
        this.TableEnd.setItems(this.End);


    }
    private void addEndCl() {

        try {
            String fs =  this.FioCl.getValue();
            int a=DataBaseHandler.getId(fs);
            String as = this.ProductCl.getValue();
            int b=DataBaseHandler.getPrId(as);
            DataBaseHandler.addEndClient(a,b);

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.End.clear();

        try {
            this.End = DataBaseHandler.readEndClient();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.addColumn();
        FioCl.hide();
    }
    private void tot() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("Total.fxml"));

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
