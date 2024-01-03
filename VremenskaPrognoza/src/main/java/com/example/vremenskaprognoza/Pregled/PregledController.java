package com.example.vremenskaprognoza.Pregled;

import com.example.vremenskaprognoza.*;
import com.example.vremenskaprognoza.Model.Controll.*;
import com.example.vremenskaprognoza.Pregled.DetaljanPregled.*;
import com.example.vremenskaprognoza.Zaposleni.Mjerenje.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

public class PregledController implements Initializable{

    private Integer drzava_id;
    private Integer grad_id;
    private Integer adresa_id;
    private Integer mjerenje_id;
    private Timestamp time;

    PregledInicijalizacija pregledInicijalizacija = new PregledInicijalizacija();

    @FXML
    private ComboBox idBroj;

    @FXML
    private ComboBox idDatumVrijeme;

    @FXML
    private ComboBox idDrzava;

    @FXML
    private ComboBox idGrad;

    @FXML
    private Button idPrikaziButton;

    @FXML
    private ComboBox idUlica;


    @FXML
    void selectedBroj(ActionEvent event) {

    }

    @FXML
    void selectedDatumVrijeme(ActionEvent event) {
        String s = idDatumVrijeme.getSelectionModel().getSelectedItem().toString();

        String[] parts = s.split("-",2);
        System.out.println(Integer.parseInt(parts[0]));

        mjerenje_id = Integer.parseInt(parts[0]);
      //  time = (Timestamp) idDatumVrijeme.getSelectionModel().getSelectedItem();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(parts[1]);
            time = new java.sql.Timestamp(parsedDate.getTime());
            System.out.println(time);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void selectedDrzava(ActionEvent event) {
        String s = idDrzava.getSelectionModel().getSelectedItem().toString();

        String[] parts = s.split("-");
        System.out.println(Integer.parseInt(parts[0]));

        drzava_id = Integer.parseInt(parts[0]);

        //inicijalizuj gradove
        ObservableList<String> gradovi = FXCollections.observableArrayList();
        List<String> gradoviList = new ArrayList<>();
        gradoviList = pregledInicijalizacija.prikaziGradoveUDrzavi(drzava_id);
        for (String grad: gradoviList
             ) {
            gradovi.add(grad);
        }
        idGrad.setItems(gradovi);

    }

    @FXML
    void selectedGrad(ActionEvent event) {
        String s = idGrad.getSelectionModel().getSelectedItem().toString();

        String[] parts = s.split("-");
        System.out.println(Integer.parseInt(parts[0]));

        grad_id = Integer.parseInt(parts[0]);

        ObservableList<String> adrese = FXCollections.observableArrayList();
        List<String> adreseList = new ArrayList<>();
        adreseList = pregledInicijalizacija.prikaziAdreseUGradu(grad_id);
        for (String adresa: adreseList
        ) {
            adrese.add(adresa);
            System.out.println(adresa);
        }
        idUlica.setItems(adrese);

    }

    @FXML
    void selectedUlica(ActionEvent event) {
        String s = idUlica.getSelectionModel().getSelectedItem().toString();

        String[] parts = s.split("-");
        System.out.println(Integer.parseInt(parts[0]));

        adresa_id = Integer.parseInt(parts[0]);

        ObservableList<String> vremena = FXCollections.observableArrayList();
        List<String> vremenaList = new ArrayList<>();
        vremenaList = pregledInicijalizacija.prikaziDostupnaVremena(adresa_id);
        for (String vrijeme: vremenaList
        ) {
            vremena.add(vrijeme);
            System.out.println(vrijeme);
        }
        idDatumVrijeme.setItems(vremena);

    }


    @FXML
    void clickedPrikaziButton(ActionEvent event) {/* {
        try {

            if(idDrzava.getText().isEmpty() || idGrad.getText().isEmpty() || idBroj.getText().isEmpty()
            || idUlica.getText().isEmpty() || idDatumVrijeme.getText().isEmpty()) {
                return;
            }

            MjerenjeController mjerenjeController = new MjerenjeController();
            Integer adresaId = mjerenjeController.getAdresaId(idDrzava.getText(), idGrad.getText(), idUlica.getText(),
                    Integer.parseInt(idBroj.getText()));

            Timestamp timestamp = Timestamp.valueOf(idDatumVrijeme.getText());
            AdressSession adressSession = new AdressSession(adresaId, timestamp);

            System.out.println(adresaId + timestamp.toString());

            System.out.println("Pregled...");
            Stage primaryStage = new Stage();
            System.out.println(Path.of("prikaz.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("DetaljanPregled/prikaz.fxml"));
            primaryStage.setResizable(false);
            primaryStage.setTitle("Vremenska prognoza");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Cause is");
            e.getCause();
        }
        */

        if (idDrzava.getSelectionModel().isEmpty() || idGrad.getSelectionModel().isEmpty() || idUlica.getSelectionModel().isEmpty()
                || idDatumVrijeme.getSelectionModel().isEmpty()) {
            return;
        }

        MjerenjeController mjerenjeController = new MjerenjeController();
        AdressSession adressSession = new AdressSession(adresa_id, time, mjerenje_id);
        try {
            System.out.println("Pregled...");
            Stage primaryStage = new Stage();
            System.out.println(Path.of("prikaz.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("DetaljanPregled/prikaz.fxml"));
            primaryStage.setResizable(false);
            primaryStage.setTitle("Vremenska prognoza");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cause is");
            e.getCause();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<String> drzave = FXCollections.observableArrayList();

        List<String> drzaveList = new ArrayList<>();
        drzaveList = pregledInicijalizacija.prikaziDrzave();


        for (String drzava:drzaveList
        ) {
            drzave.add(drzava);
        }
        idDrzava.setItems(drzave);

    }
}
