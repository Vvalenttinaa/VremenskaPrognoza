package com.example.vremenskaprognoza.Model;

import java.util.*;

public class Nalog {
    private Integer id;
    private String korisnickoIme;
    private String lozinka;
    private Character uloga;


    public Nalog() {
    }

    public Nalog(Integer id) {
        this.id = id;
    }

    public Nalog(String korisnickoIme, String lozinka, Character uloga) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.uloga = uloga;
    }

    public Nalog(Integer id, String korisnickoIme, String lozinka, Character uloga) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.uloga = uloga;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Character getUloga() {
        return uloga;
    }

    public void setUloga(Character uloga) {
        this.uloga = uloga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nalog nalog = (Nalog) o;
        return Objects.equals(id, nalog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Nalog{" +
                "id=" + id +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", uloga='" + uloga + '\'' +

                '}';
    }
}
