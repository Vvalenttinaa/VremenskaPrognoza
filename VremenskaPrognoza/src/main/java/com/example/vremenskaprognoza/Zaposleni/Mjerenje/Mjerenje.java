package com.example.vremenskaprognoza.Zaposleni.Mjerenje;

import com.example.vremenskaprognoza.Model.Adresa;

import java.sql.*;

public class Mjerenje {

    private Integer mjerenjeId;
    private Timestamp time;

    private Integer lokacijaId;
    private Integer lokacijaMjernihInstrumenataId;
    private Integer zaposleniId;

    private Integer temperatura;
    private Integer uvIndeks;
    private String uvOpis;
    private  String uvBoja;

    private Integer padavineTip;
    private String padavine;
    private String padavineOpis;
    private Integer padavineKolicina;
    private Integer padavineVjerovatnoca;

    public Mjerenje(){
    }

    public Mjerenje(Integer id){
        this.mjerenjeId = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Mjerenje(Timestamp time,Integer lokacijaId, Integer lokacijaMjernihInstrumenataId, Integer zaposleniId, Integer temperatura,
                    Integer uvIndeks, String padavineOpis, Integer padavineKolicina,
                    Integer padavineVjerovatnoca, Integer padavineTip) {

        this.time=time;
        this.lokacijaId = lokacijaId;
        this.lokacijaMjernihInstrumenataId = lokacijaMjernihInstrumenataId;
        this.zaposleniId = zaposleniId;

        this.temperatura = temperatura;
        this.uvIndeks = uvIndeks;
        this.padavineTip=padavineTip;
        this.padavineOpis=padavineOpis;
        this.padavineKolicina=padavineKolicina;
        this.padavineVjerovatnoca=padavineVjerovatnoca;
    }

    public Mjerenje(Timestamp time, Integer mjerenjeId, Integer lokacijaId, Integer lokacijaMjernihInstrumenataId, Integer zaposleniId,
                    Integer temperatura, Integer uvIndeks, String padavineOpis, Integer padavineKolicina,
                    Integer padavineVjerovatnoca, Integer padavineTip) {

        this.mjerenjeId = mjerenjeId;
        this.time=time;

        this.lokacijaId = lokacijaId;
        this.lokacijaMjernihInstrumenataId = lokacijaMjernihInstrumenataId;
        this.zaposleniId = zaposleniId;

        this.temperatura = temperatura;
        this.uvIndeks = uvIndeks;
        this.padavineTip=padavineTip;
        this.padavineOpis=padavineOpis;
        this.padavineKolicina=padavineKolicina;
        this.padavineVjerovatnoca=padavineVjerovatnoca;

    }

    public String getUvOpis() {
        return uvOpis;
    }

    public void setUvOpis(String uvOpis) {
        this.uvOpis = uvOpis;
    }

    public String getUvBoja() {
        return uvBoja;
    }

    public void setUvBoja(String uvBoja) {
        this.uvBoja = uvBoja;
    }

    public String getPadavine() {
        return padavine;
    }

    public void setPadavine(String padavine) {
        this.padavine = padavine;
    }

    public Mjerenje(Integer temperatura, String uvOpis, String uvBoja, String padavine, Integer padavineKolicina, String padavineOpis, Integer padavineVjerovatnoca) {

        this.temperatura = temperatura;
        this.uvOpis = uvOpis;
        this.uvBoja = uvBoja;
        this.padavine = padavine;
        this.padavineOpis = padavineOpis;
        this.padavineKolicina = padavineKolicina;
        this.padavineVjerovatnoca = padavineVjerovatnoca;
    }

    public Integer getMjerenjeId() {
        return mjerenjeId;
    }

    public void setMjerenjeId(Integer mjerenjeId) {
        this.mjerenjeId = mjerenjeId;
    }


    public Integer getLokacijaId() {
        return lokacijaId;
    }

    public void setLokacijaId(Integer lokacijaId) {
        this.lokacijaId = lokacijaId;
    }

    public Integer getLokacijaMjernihInstrumenataId() {
        return lokacijaMjernihInstrumenataId;
    }

    public void setLokacijaMjernihInstrumenataId(Integer lokacijaMjernihInstrumenataId) {
        this.lokacijaMjernihInstrumenataId = lokacijaMjernihInstrumenataId;
    }

    public Integer getZaposleniId() {
        return zaposleniId;
    }

    public void setZaposleniId(Integer zaposleniId) {
        this.zaposleniId = zaposleniId;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getUvIndeks() {
        return uvIndeks;
    }

    public void setUvIndeks(Integer uvIndeks) {
        this.uvIndeks = uvIndeks;
    }
    public String getPadavineOpis() {
        return padavineOpis;
    }

    public void setPadavineOpis(String padavineOpis) {
        this.padavineOpis = padavineOpis;
    }

    public Integer getPadavineKolicina() {
        return padavineKolicina;
    }

    public void setPadavineKolicina(Integer padavineKolicina) {
        this.padavineKolicina = padavineKolicina;
    }

    public Integer getPadavineVjerovatnoca() {
        return padavineVjerovatnoca;
    }

    public void setPadavineVjerovatnoca(Integer padavineVjerovatnoca) {
        this.padavineVjerovatnoca = padavineVjerovatnoca;
    }

    public Integer getPadavineTip() {
        return padavineTip;
    }

    public void setPadavineTip(Integer padavineTip) {
        this.padavineTip = padavineTip;
    }

    @Override
    public String toString() {
        return "Mjerenje{" +
                "mjerenjeId=" + mjerenjeId +
                "vrijeme=" + time +
                ", lokacijaId=" + lokacijaId +
                ", lokacijaMjernihInstrumenataId=" + lokacijaMjernihInstrumenataId +
                ", zaposleniId=" + zaposleniId +
                ", temperatura=" + temperatura +
                ", uvIndeks=" + uvIndeks +
                ", padavineTip=" + padavineTip +
                ", padavineOpis='" + padavineOpis + '\'' +
                ", padavineKolicina=" + padavineKolicina +
                ", padavineVjerovatnoca=" + padavineVjerovatnoca +
                '}';
    }
}
