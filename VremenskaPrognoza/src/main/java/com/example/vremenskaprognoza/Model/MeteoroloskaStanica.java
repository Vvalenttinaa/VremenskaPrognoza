package com.example.vremenskaprognoza.Model;

import java.util.*;

public class MeteoroloskaStanica {
    private Integer id;

    private Adresa adresa;

    public MeteoroloskaStanica() {
    }

    public MeteoroloskaStanica(Integer id) {
        this.id = id;
    }

    public MeteoroloskaStanica(Integer id, Adresa adresa) {
        this.id = id;
        this.adresa = adresa;
    }


    public MeteoroloskaStanica(Adresa adresa){
        this.adresa =adresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeteoroloskaStanica that = (MeteoroloskaStanica) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MeteoroloskaStanica{" +
                "id=" + id +
                ", adresa=" + adresa +
                '}';
    }
}
