package ru.sapteh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartWindow {
    public Button ProductButton;

    public void ActionProduct(ActionEvent actionEvent) {
        Button ActionProduct = (Button) actionEvent.getSource();
        ActionProduct.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/Product.fxml"));


        try {
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();


    }
}
