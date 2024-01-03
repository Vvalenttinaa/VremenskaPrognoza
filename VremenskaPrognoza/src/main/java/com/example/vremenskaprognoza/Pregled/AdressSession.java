package com.example.vremenskaprognoza.Pregled;

import com.example.vremenskaprognoza.Model.*;
import com.example.vremenskaprognoza.Model.Controll.*;

import java.sql.*;

public final class AdressSession {

    private static AdressSession instance;

    private static  Integer adresaId;
    private static Timestamp timestamp;
    private static Integer mjerenjeId;

    public AdressSession(Integer adresaId, Timestamp timestamp, Integer mjerenjeId) {
        this.adresaId = adresaId;
        this.timestamp = timestamp;
        this.mjerenjeId = mjerenjeId;
    }

    public static AdressSession getInstance() {
        return instance;
    }

    public static void setInstance(AdressSession instance) {
        AdressSession.instance = instance;
    }

    public static Integer getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(Integer adresaId) {
        this.adresaId = adresaId;
    }

    public static Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public static String getAdresa(){
        AdresaController adresaController = new AdresaController();
        Adresa adresa =  adresaController.nadjiAdresu(adresaId);
        return adresa.toString();
    }

    public static Integer getMjerenjeId() {
        return mjerenjeId;
    }

    public static void setMjerenjeId(Integer mjerenjeId) {
        AdressSession.mjerenjeId = mjerenjeId;
    }
}
