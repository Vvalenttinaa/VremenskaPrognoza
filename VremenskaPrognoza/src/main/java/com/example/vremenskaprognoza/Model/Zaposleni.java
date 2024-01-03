package com.example.vremenskaprognoza.Model;

import java.util.*;

public class Zaposleni {
    private Integer id;
    private String ime;
    private String prezime;
    private Character uloga;
    private Integer meteoroloska_stanica_id;
    private Integer nalog_id;


    public Zaposleni() {
    }

    public Zaposleni(Integer id) {
        this.id = id;
    }

    public Zaposleni(String ime, String prezime, Character uloga, Integer meteoroloska_stanica_id, Integer nalog_id) {
        this.ime = ime;
        this.prezime = prezime;
        this.uloga = uloga;
        this.meteoroloska_stanica_id = meteoroloska_stanica_id;
        this.nalog_id = nalog_id;
    }

    public Zaposleni(Integer id, String ime, String prezime, Character uloga, Integer meteoroloska_stanica_id, Integer nalog_id) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.uloga = uloga;
        this.meteoroloska_stanica_id = meteoroloska_stanica_id;
        this.nalog_id=nalog_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Character getUloga() {
        return uloga;
    }

    public void setUloga(Character uloga) {
        this.uloga = uloga;
    }

    public Integer getMeteoroloska_stanica_id() {
        return meteoroloska_stanica_id;
    }

    public void setMeteoroloska_stanica_id(Integer meteoroloska_stanica_id) {
        this.meteoroloska_stanica_id = meteoroloska_stanica_id;
    }
    public Integer getNalog_id(){
        return this.nalog_id;
    }

    public void setNalog_id(Integer nalog_id) {
        this.nalog_id = nalog_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zaposleni zaposleni = (Zaposleni) o;
        return id.equals(zaposleni.id);
    }

    @Override
    public String toString() {
        return "Zaposleni{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", uloga=" + uloga +
                ", meteoroloska_stanica_id=" + meteoroloska_stanica_id +
                ", nalog_id=" + nalog_id +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
