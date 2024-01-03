package com.example.vremenskaprognoza;

import com.example.vremenskaprognoza.Model.*;
import com.example.vremenskaprognoza.Model.Controll.*;
import com.example.vremenskaprognoza.Pregled.DetaljanPregled.*;
import com.example.vremenskaprognoza.Zaposleni.Mjerenje.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
          /*  Mjerenje mjerenje = new Mjerenje();
            mjerenje.setMjerenjeId(1);
            mjerenje.setLokacijaId(4);
            */
          //  LokacijaInstrumenataController lokacijaInstrumenataController = new LokacijaInstrumenataController();
           List<String> l=  PregledInicijalizacija.prikaziDostupnaVremena(12);

            for (String s:l
                 ) {
                System.out.println(s);
            }
/*
            LokacijaInstrumenataController lokacijaInstrumenataController = new LokacijaInstrumenataController();
            List<LokacijaInstrumenata> lokacijaInstrumenata =   lokacijaInstrumenataController.prikaziLokacijeInstrumenata();

            for (LokacijaInstrumenata li: lokacijaInstrumenata
                 ) {

                AdresaController adresaController = new AdresaController();
                MeteoroloskaStanicaController meteoroloskaStanicaController = new MeteoroloskaStanicaController();

                System.out.println("ID: " + li.getId() + "na adresi" + adresaController.nadjiAdresu(li.getAdresa_id()) + " pripada stanici"
                + meteoroloskaStanicaController.nadjiStanicu(li.getMeteoroloska_stanica_id()));
            }
            */

            //MeteoroloskaStanicaController meteoroloskaStanicaController = new MeteoroloskaStanicaController();
          //  List<MeteoroloskaStanica> meteoroloskaStanica = meteoroloskaStanicaController.prikaziStanice();

          //System.out.println(meteoroloskaStanicaController.nadjiId(new Adresa("Majke Jugovica", 1,"Banja Luka")));
         // System.out.println(meteoroloskaStanicaController.nadjiStanicu(1));
         // meteoroloskaStanicaController.dodaj(new Adresa("Majora Gavrilovic", 5, "Prijedor"), new Grad("Prijedor"), new Drzava("Bosna i Hercegovina"));

          /*
            for (MeteoroloskaStanica ms:meteoroloskaStanica
                 ) {
                System.out.println(ms);
            }
            */

         /*  DrzavaController drzavaController = new DrzavaController();
           drzavaController.dodaj("Bosna i Hercegovina");
            List <Drzava> drzave = drzavaController.prikaziDrzave();
            for (Drzava drzava:drzave
                 ) {
              //  System.out.println(drzava);
            }
*//*
            GradController gradController = new GradController();
            gradController.dodaj("Novi Sad", "Srbija");
            */

           /* AdresaContoller adresaContoller = new AdresaContoller();
            adresaContoller.dodaj(new Adresa("Majora Gavrilovic", 5, "Prijedor"));
*/

         //   gradController.dodaj("Prijedor", drzavaController.nadjiId("Bosna i Hercegovina").getId());

            //System.out.println("id za Prijedor je " + gradController.nadjiId("Prijedor").getId());
            //System.out.println("naziv sa id 1 je " + gradController.nadjiNaziv(1).getNaziv());

        /*    List <Grad> gradovi = gradController.prikaziGradove();
            for (Grad grad:gradovi
                 ) {
                System.out.println(grad);
            }
            */

           /* drzavaController.dodaj("Srbija");
            System.out.println(drzavaController.nadjiId("Srbija"));
            System.out.println(drzavaController.nadjiNaziv(1));
*/

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        Parent root = FXMLLoader.load(getClass().getResource("pocetna.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Vremenska prognoza");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}