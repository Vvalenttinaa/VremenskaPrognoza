package com.example.vremenskaprognoza.Zaposleni.Administracija;

import com.example.vremenskaprognoza.Model.*;
import com.example.vremenskaprognoza.Model.Controll.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class DodavanjeMeteoroloskeStaniceController implements Initializable {

    MeteoroloskaStanica stanicaZaInstrumente = null;
    @FXML
    private Label idAdministrator;

    @FXML
    private TextField idBroj;

    @FXML
    private TextField idBroj1;

    @FXML
    private Button idDodajLokacijuZaInstrumenteButton;

    @FXML
    private Button idDodajMeteoroloskuStanicuButton;

    @FXML
    private TextField idDrzava;

    @FXML
    private TextField idDrzava1;

    @FXML
    private TextField idGrad;

    @FXML
    private TextField idGrad1;

    @FXML
    private Label idInstrumentiZaMjerenje;

    @FXML
    private TextField idUlica;

    @FXML
    private TextField idUlica1;

    @FXML
    private ComboBox idStanica;

    @FXML
    void select(ActionEvent event) {
        String s = idStanica.getSelectionModel().getSelectedItem().toString();

        String[] parts = s.split("-");

        MeteoroloskaStanicaController meteoroloskaStanicaController = new MeteoroloskaStanicaController();
        stanicaZaInstrumente = meteoroloskaStanicaController.nadjiStanicu(Integer.parseInt(parts[0]));
        System.out.println("Stanica za instrumente je " + stanicaZaInstrumente);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        ObservableList<String> stanice = FXCollections.observableArrayList();
        MeteoroloskaStanicaController meteoroloskaStanicaController = new MeteoroloskaStanicaController();
        List<MeteoroloskaStanica>meteoroloskaStanicaList = new ArrayList<>();
        meteoroloskaStanicaList = meteoroloskaStanicaController.prikaziStanice();

        for (MeteoroloskaStanica ms:meteoroloskaStanicaList
             ) {
            stanice.add(ms.getId() + "-" + ms.getAdresa().toString());
        }
        idStanica.setItems(stanice);

    }

    @FXML
    void dodajLokacijuZaInstrumenteButtonClicked(ActionEvent event) {

        if( idStanica.getSelectionModel().isEmpty() || idUlica1.getText().trim().isEmpty() || idBroj1.getText().trim().isEmpty() || idGrad1.getText().trim().isEmpty() ||
                idDrzava1.getText().trim().isEmpty() ){
            return;
        }

        LokacijaInstrumenataController lokacijaInstrumenataController = new LokacijaInstrumenataController();
        LokacijaInstrumenata lokacijaInstrumenata = new LokacijaInstrumenata();

        Boolean uspjesno = lokacijaInstrumenataController.dodaj(idUlica1.getText(), idBroj1.getText(), idGrad1.getText(),
                idDrzava1.getText(), stanicaZaInstrumente);


    }

    @FXML
    void dodajMeteoroloskuStanicuButtonClicked(ActionEvent event) throws IOException {

        if(idUlica.getText().trim().isEmpty() || idBroj.getText().trim().isEmpty() || idGrad.getText().trim().isEmpty() ||
               idDrzava.getText().trim().isEmpty() ){
            return;
        }
        MeteoroloskaStanicaController meteoroloskaStanicaController = new MeteoroloskaStanicaController();
        Boolean uspjesno = meteoroloskaStanicaController.dodaj(idUlica.getText(), idBroj.getText(), idGrad.getText(), idDrzava.getText());

     /*   if(uspjesno){
            System.out.println("Uspjesno dodavanje...");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("GUIUtil/UspjesnoDodavanje.fxml"));
            primaryStage.setResizable(false);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } else {
            System.out.println("Neuspjesno dodavanje...");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("GUIUtil/NeuspjesnoDodavanje.fxml"));
            primaryStage.setResizable(false);
            primaryStage.setTitle("Administracija");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
*/
    }

    @FXML
    void inputBroj(ActionEvent event) {

    }

    @FXML
    void inputDrzava(ActionEvent event) {

    }

    @FXML
    void inputGrad(ActionEvent event) {

    }

    @FXML
    void inputUlica(ActionEvent event) {

    }

}
