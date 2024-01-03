package com.example.vremenskaprognoza.Model;

import java.util.*;

public class Drzava {
    private String naziv;
    private Integer id;

    public Drzava(String naziv) {
        this.naziv = naziv;
    }

    public Drzava(String naziv, Integer id) {
        this.naziv = naziv;
        this.id = id;
    }
    public Drzava(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Drzava{" +
                "naziv='" + naziv + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drzava drzava = (Drzava) o;
        return Objects.equals(id, drzava.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
