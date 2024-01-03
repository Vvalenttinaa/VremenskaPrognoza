package com.example.vremenskaprognoza.Pregled.DetaljanPregled;

import com.example.vremenskaprognoza.Model.Controll.*;
import com.example.vremenskaprognoza.Pregled.*;
import com.example.vremenskaprognoza.Zaposleni.Mjerenje.*;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.*;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class PrikazVremenskePrognozeController implements Initializable {

    @FXML
    private Label idAlarmVremenskaNepogoda;

    @FXML
    private Label idDan1;

    @FXML
    private Label idDan2;

    @FXML
    private Label idDan3;

    @FXML
    private Label idDan4;

    @FXML
    private Label idDan5;

    @FXML
    private Label idDan6;

    @FXML
    private Label idDan7;

    @FXML
    private Tab idDnevna;

    @FXML
    private ImageView idImage;

    @FXML
    private ImageView idImage1;

    @FXML
    private ImageView idImage2;

    @FXML
    private ImageView idImage3;

    @FXML
    private ImageView idImage4;

    @FXML
    private ImageView idImage5;

    @FXML
    private ImageView idImage6;

    @FXML
    private ImageView idImage7;

    @FXML
    private Label idKolicinaPadavine;

    @FXML
    private Label idLokacija;

    @FXML
    private Label idLokacija1;

    @FXML
    private Label idLokacija2;

    @FXML
    private Tab idMjesecna;

    @FXML
    private Label idNazivPadavine;

    @FXML
    private Label idNazivvremenskaNepogoda;

    @FXML
    private Label idOpisPadavine;

    @FXML
    private Label idOpisVremenskaNepogoda;

    @FXML
    private Tab idSedmicna;

    @FXML
    private Label idTemp1;

    @FXML
    private Label idTemp2;

    @FXML
    private Label idTemp3;

    @FXML
    private Label idTemp4;

    @FXML
    private Label idTemp5;

    @FXML
    private Label idTemp6;

    @FXML
    private Label idTemp7;

    @FXML
    private Label idTemperatura;

    @FXML
    private Label idUV;

    @FXML
    private Label idVjerovatnocaPadavine;

    @FXML
    private Label idVremenskaNepogoda;

    @FXML
    private Label idAlarmUv;

    @FXML
    private Label idOpasnostUv;

    @FXML
    private Label idPadavine;

    @FXML
    private Label idKolicina;

    @FXML
    private Label idOpis;

    @FXML
    private Label idVjerovatnoca;

    @FXML
    private Label idDatumIVrijeme;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        MjerenjeController mjerenjeController = new MjerenjeController();
        Mjerenje mjerenje = new Mjerenje();

        System.out.println("Evo" + AdressSession.getTimestamp().toString() + AdressSession.getAdresaId());
        mjerenje = mjerenjeController.ucitajMjerenjePoId(AdressSession.getMjerenjeId());

        idTemperatura.setText(mjerenje.getTemperatura().toString());
        idPadavine.setText(mjerenje.getPadavine());
        idKolicina.setText(mjerenje.getPadavineKolicina().toString());
        idVjerovatnoca.setText((mjerenje.getPadavineVjerovatnoca()).toString());
        idOpis.setText(mjerenje.getPadavineOpis());
        idAlarmUv.setText(mjerenje.getUvBoja());
        idOpasnostUv.setText(mjerenje.getUvOpis());
        idLokacija.setText(AdressSession.getAdresa());
        idLokacija1.setText(AdressSession.getAdresa());
        idLokacija2.setText(AdressSession.getAdresa());
        idDatumIVrijeme.setText(AdressSession.getTimestamp().toString());

        System.out.println("eo" + mjerenje.getPadavine());

        if(idPadavine.getText() == null) {
            File file = new File("src/main/java/com/example/vremenskaprognoza/Pregled/DetaljanPregled/sun.jpg");
            Image image = new Image(file.toURI().toString());
            System.out.println(file.toURI().toString());
            idImage.setImage(image);
        }
        else if(idPadavine.getText().equals("Kisa")){

            File file = new File("src/main/java/com/example/vremenskaprognoza/Pregled/DetaljanPregled/rain.jpg");
            Image image = new Image(file.toURI().toString());
            System.out.println(file.toURI().toString());
            idImage.setImage(image);

        } else if(idPadavine.getText().equals("Snijeg")){
            File file = new File("src/main/java/com/example/vremenskaprognoza/Pregled/DetaljanPregled/snow.jpg");
            Image image = new Image(file.toURI().toString());
            System.out.println(file.toURI().toString());
            idImage.setImage(image);
        }

    }
}

