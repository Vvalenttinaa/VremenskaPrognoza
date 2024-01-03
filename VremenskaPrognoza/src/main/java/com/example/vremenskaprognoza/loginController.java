package com.example.vremenskaprognoza;

import com.example.vremenskaprognoza.Model.*;
import com.example.vremenskaprognoza.Zaposleni.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.*;

import java.io.*;

public class loginController {

    Character role = null;
    Nalog nalog = null;

    @FXML
    private CheckBox idAdministrator;

    @FXML
    private Label idKorisnickoIme;

    @FXML
    private TextField idKorisnickoImePolje;

    @FXML
    private Label idLozinka;

    @FXML
    private PasswordField idLozinkaPolje;

    @FXML
    private CheckBox idMeteorolog;

    @FXML
    private Button idPrijava;

    @FXML
    void inputKorisnickoIme(ActionEvent event) {

    }

    @FXML
    void inputLozinka(ActionEvent event) {

    }

    @FXML
    void administratorClicked(ActionEvent event) {
        role = 'A';
    }

    @FXML
    void meteorologClicked(ActionEvent event) {
        role = 'M';
    }

    @FXML
    void prijavaClicked(ActionEvent event) throws IOException {
        String username = idKorisnickoImePolje.getText();
        String password = idLozinkaPolje.getText();

        boolean exists;

        if(username.isEmpty() || password.isEmpty() || role == null){
            return;
        }

        NalogController nalogController = new NalogController();
        nalog =  nalogController.ucitajNalog(username,password,role);

        System.out.println(nalog);

        UserSession.getInstace(nalog.getId());

        if(nalogController.exist()) {
            exists = true;
            System.out.println("Kreiran nalog koji postoji u bazi" + nalog);

        } else {
            exists = false;
        }


        //provjeri je l ovaj nalog postoji u bazi

        if(exists && role == 'A'){
            System.out.println("Prijavljen administrator...");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Zaposleni/Administracija/dodavanjeMeteoroloskeStanice.fxml"));
            primaryStage.setResizable(false);
            primaryStage.setTitle("Administracija");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        else if(exists && role == 'M'){
            System.out.println("Prijavljen meteorolog...");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Zaposleni/Mjerenje/dodavanjeMjerenja.fxml"));
            primaryStage.setResizable(false);
            primaryStage.setTitle("Mjerenje");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }

    }

}
