package com.example.vremenskaprognoza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import javafx.scene.Parent;
import javafx.scene.Scene;


import java.io.*;


public class pocetnaController {

    @FXML
    private Button idPregled;

    @FXML
    private Button idPrijava;

    @FXML
    void pregledButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Pregled...");
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Pregled/pregled.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Vremenska prognoza");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @FXML
    void prijavaButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Prijava...");
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Vremenska prognoza");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

       // Stage s = (Stage) login.getScene().getWindow();
       // s.close();
    }

}
