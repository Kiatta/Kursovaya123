package com.example.kursovaya;

import Anim.Anim;
import Service.Product;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ProductControll {
    ObservableList<Product> Products = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Product, String> TableColumnName;
    @FXML
    private TableColumn<Product, Integer> TableColumnPrice;
    @FXML
    private TextField Price;

    @FXML
    private TableView<Product> ProductTable;

    @FXML
    private Button addPr;

    @FXML
    private Button back;


    @FXML
    private Button delPr;


    @FXML
    private Button exits;

    @FXML
    private TextField productName;
    @FXML
    void initialize() {


        this.Products = DataBaseHandler.readProduct();
        addColumn();

        addPr.setOnAction(event -> {
            addNewProduct();
            this.Products.clear();
            this.Products = DataBaseHandler.readProduct();

        });

        back.setOnAction(event -> {
            back();


        });
        exits.setOnAction(event -> {
            System.exit(0);


        });
        delPr.setOnAction(event -> {
            deleteProduct();



        });
    }

    private void addNewProduct() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        String productnm = productName.getText();
        String price = Price.getText();
        if (this.productName.getText() != "" && this.Price.getText() != "") {
            try {
                Integer.parseInt(this.Price.getText());
            } catch (Exception var2) {
                Anim Priceadd = new Anim(Price);
                Priceadd.playAnim();
                return;
            }
            Product product = new Product(productnm, Integer.parseInt(this.Price.getText()));
            dbHandler.addProduct(product);
        }
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
    private void addColumn() {

            this.TableColumnName.setCellValueFactory(new PropertyValueFactory<>("NameProduct"));
            this.TableColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
            this.ProductTable.setItems(this.Products);


    }
    private void deleteProduct() {

        try {
            DataBaseHandler.delProduct(((Product)this.ProductTable.getSelectionModel().getSelectedItem()).getNameProduct());
        } catch (Exception var3) {

        }
        this.Products.clear();
        this.Products = DataBaseHandler.readProduct();
        this.addColumn();
    }

}
