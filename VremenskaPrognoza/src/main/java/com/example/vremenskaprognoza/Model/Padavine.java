package com.example.vremenskaprognoza.Model;

import java.util.*;

public class Padavine {
    String naziv;
    Integer id;

    public Padavine() {
    }

    public Padavine(String naziv, Integer id){
        this.id=id;
        this.naziv=naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Padavine padavine = (Padavine) o;
        return Objects.equals(id, padavine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Padavine{" +
                "naziv='" + naziv + '\'' +
                ", id=" + id +
                '}';
    }
}
