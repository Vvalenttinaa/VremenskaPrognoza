package com.example.vremenskaprognoza.Zaposleni.Mjerenje;

import com.example.vremenskaprognoza.Model.*;
import com.example.vremenskaprognoza.Model.Controll.*;
import com.example.vremenskaprognoza.Zaposleni.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

public class DodavanjeMjerenjaController implements Initializable {

    private Integer lokacija;
    private Integer lokacijaMjernihInstrumenata;
    private Integer padavine;
    private static Integer id_stanice;

    private Timestamp time;

    private static Integer idNalog;
/*
    @FXML
    private ComboBox<?> idAlarm;
*/
    @FXML
    private Button idDodaj;

    @FXML
    private TextField idKolicinaPadavina;

    @FXML
    private ComboBox idLokacijaMjerenja;

    @FXML
    private ComboBox idLokacijaMjernihInstrumenata;
/*
    @FXML
    private Label idMeteorolog;
*/
    @FXML
    private ComboBox idMeteoroloskaStanica;

    @FXML
    private TextField idOpisPadavine;

    @FXML
    private ComboBox idPadavine;

    @FXML
    private TextField idTemperatura;

    @FXML
    private TextField idUV;

    @FXML
    private TextField idVjerovatnocaPadavina;

    @FXML
    private TextField idVremenskaNepogoda;

    @FXML
    private TextField idVrijeme;
/*
    @FXML
    void chooseAlarm(ActionEvent event) {

    }
*/
    @FXML
    void choosePadavine(ActionEvent event) {
        String s = idPadavine.getSelectionModel().getSelectedItem().toString();

        String[] parts = s.split("-");
        padavine = Integer.parseInt(parts[0]);
        System.out.println("izabrane su " + padavine + " " + parts[1]);
    }

    @FXML
    void dodajButtonClick(ActionEvent event) {
        Mjerenje mjerenje = new Mjerenje();
        Timestamp timestamp = null;
        MjerenjeController mjerenjeController = new MjerenjeController();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(idVrijeme.getText());
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
            System.out.println(timestamp);
            mjerenje.setTime(timestamp);
            System.out.println(mjerenje.getTime());
        }catch (Exception e){
            e.printStackTrace();
        }

        mjerenje.setTemperatura(Integer.parseInt(idTemperatura.getText()));
        mjerenje.setUvIndeks(Integer.parseInt(idUV.getText()));
        mjerenje.setZaposleniId(idNalog);
        mjerenje.setLokacijaId(lokacija);
        mjerenje.setLokacijaMjernihInstrumenataId(lokacijaMjernihInstrumenata);


        if(!idPadavine.getSelectionModel().isEmpty() ) {
            mjerenje.setPadavineTip(padavine);
            mjerenje.setPadavineOpis(idOpisPadavine.getText());
            mjerenje.setPadavineKolicina(Integer.parseInt(idKolicinaPadavina.getText()));
            mjerenje.setPadavineVjerovatnoca(Integer.parseInt(idVjerovatnocaPadavina.getText()));


            mjerenjeController.dodajMjerenje(mjerenje.getTime(), mjerenje.getLokacijaId(),mjerenje.getLokacijaMjernihInstrumenataId(),
                    mjerenje.getZaposleniId(), mjerenje.getTemperatura(), mjerenje.getUvIndeks(), mjerenje.getPadavineOpis(),
                    mjerenje.getPadavineKolicina(), mjerenje.getPadavineVjerovatnoca(), mjerenje.getPadavineTip());

        }
        else {
            mjerenjeController.dodajMjerenje(mjerenje.getTime(), mjerenje.getLokacijaId(),mjerenje.getLokacijaMjernihInstrumenataId(),
                    mjerenje.getZaposleniId(), mjerenje.getTemperatura(), mjerenje.getUvIndeks());
        }

        System.out.println(mjerenje);
    }

    @FXML
    void inputKolicinaPadavina(ActionEvent event) {

    }
    @FXML
    void inputOpisPadavine(ActionEvent event) {

    }

    @FXML
    void inputTemperatura(ActionEvent event) {
    }

    @FXML
    void inputUV(ActionEvent event) {

    }

    @FXML
    void inputVjerovatnocaPadavina(ActionEvent event) {

    }

    @FXML
    void inputVremenskaNepogoda(ActionEvent event) {

    }

    @FXML
    void izaberiLokaciju(ActionEvent event) {
        String s = idLokacijaMjerenja.getSelectionModel().getSelectedItem().toString();

        String[] parts = s.split("-");
        lokacija = Integer.parseInt(parts[0]);

    }

    @FXML
    void izaberiLokacijuMjernihInstrumenata(ActionEvent event) {
        String s = idLokacijaMjernihInstrumenata.getSelectionModel().getSelectedItem().toString();

        String[] parts = s.split("-");
        System.out.println(Integer.parseInt(parts[0]));

        lokacijaMjernihInstrumenata = Integer.parseInt(parts[0]);

    }

    @FXML
    void izaberiMeteoroloskuStanicu(ActionEvent event) {
        //String s = idMeteoroloskaStanica.getSelectionModel().getSelectedItem().toString();
        //String[] parts = s.split("-");



        String s = idMeteoroloskaStanica.getSelectionModel().getSelectedItem().toString();

        String[] parts = s.split("-");
        id_stanice = Integer.parseInt(parts[0]);
        System.out.println("izabrana " + id_stanice );

        ObservableList<String> lokacijeMjernihInstrumenata = FXCollections.observableArrayList();
        LokacijaInstrumenataController lokacijaInstrumenataController = new LokacijaInstrumenataController();
        List<String> lokacijaInstrumenataList = new ArrayList<>();
        lokacijaInstrumenataList = lokacijaInstrumenataController.prikaziLokacijeInstrumenataStanice(id_stanice);


        for (String li:lokacijaInstrumenataList
        ) {
            lokacijeMjernihInstrumenata.add(li);
        }
        idLokacijaMjernihInstrumenata.setItems(lokacijeMjernihInstrumenata);


    }

    public static void getNalog(){

        idNalog = UserSession.getId();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        getNalog();



        /*
        ObservableList<String> lokacijeMjernihInstrumenara = FXCollections.observableArrayList();
        LokacijaInstrumenataController lokacijaInstrumenataController = new LokacijaInstrumenataController();
        List<LokacijaInstrumenata> lokacijaInstrumenataList = new ArrayList<>();
        lokacijaInstrumenataList = lokacijaInstrumenataController.prikaziLokacijeInstrumenata();


        for (LokacijaInstrumenata li:lokacijaInstrumenataList
             ) {
            lokacijeMjernihInstrumenara.add(li.getId() + "-" + adresaController.nadjiAdresu(li.getAdresa_id()).toString());
        }
        idLokacijaMjernihInstrumenata.setItems(lokacijeMjernihInstrumenara);
*/


        AdresaController adresaController = new AdresaController();
        ObservableList<String> adrese = FXCollections.observableArrayList();
        List<Adresa> adresaList = new ArrayList<>();
        adresaList = adresaController.prikaziAdrese();

        GradController gradController = new GradController();
        DrzavaController drzavaController = new DrzavaController();


        for (Adresa a:adresaList
             ) {
            Grad g = gradController.nadjiNaziv(a.getGrad_id());
            System.out.println(g);
            System.out.println("id drzave" + g.getDrzava_id());
            Drzava drzava = drzavaController.nadjiNaziv(g.getDrzava_id());

            adrese.add(a.getId() + "-" + a.getUlica() + ", " + a.getBroj() + " ," + gradController.nadjiNaziv(a.getGrad_id()).getNaziv()
                    + ", " +drzava.getNaziv());
        }
            idLokacijaMjerenja.setItems(adrese);

        ObservableList<String> stanice = FXCollections.observableArrayList();
        MeteoroloskaStanicaController meteoroloskaStanicaController = new MeteoroloskaStanicaController();
        List<MeteoroloskaStanica>meteoroloskaStanicaList = new ArrayList<>();
        meteoroloskaStanicaList = meteoroloskaStanicaController.prikaziStanice();

        for (MeteoroloskaStanica ms:meteoroloskaStanicaList
        ) {
            stanice.add(ms.getId() + "-" + ms.getAdresa().toString());
            System.out.println(ms.getId() + "-" + ms.getAdresa().toString());
        }
        for (String stanica :stanice
             ) {
            System.out.println("Nije null" + stanica);
        }

        idMeteoroloskaStanica.setItems(stanice);


       // LokacijaInstrumenataController lokacijaInstrumenataController = new LokacijaInstrumenataController();



       // List<String> l=  lokacijaInstrumenataController.prikaziLokacijeInstrumenataStanice(id_stanice);



        PadavineController padavineController = new PadavineController();
        List<Padavine>padavineList = new ArrayList<>();
        padavineList = padavineController.prikaziPadavine();

        ObservableList<String> padavine = FXCollections.observableArrayList();
        for (Padavine p:padavineList
        ) {
            System.out.println(p);
            padavine.add(p.getId() + "-" + p.getNaziv());
        }
        idPadavine.setItems(padavine);

    }

}
