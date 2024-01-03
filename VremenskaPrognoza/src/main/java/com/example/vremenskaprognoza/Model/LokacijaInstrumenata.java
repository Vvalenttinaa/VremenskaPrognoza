package com.example.vremenskaprognoza.Model;

import java.util.*;

public class LokacijaInstrumenata {
    private Integer id;
    private Integer adresa_id;
    private Integer meteoroloska_stanica_id;

    public LokacijaInstrumenata() {
    }

    public LokacijaInstrumenata(Integer id) {
        this.id = id;
    }

    public LokacijaInstrumenata(Integer adresa_id, Integer meteoroloska_stanica_id) {
        this.adresa_id = adresa_id;
        this.meteoroloska_stanica_id = meteoroloska_stanica_id;
    }

    public LokacijaInstrumenata(Integer id, Integer adresa_id, Integer meteoroloska_stanica_id) {
        this.id = id;
        this.adresa_id = adresa_id;
        this.meteoroloska_stanica_id = meteoroloska_stanica_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdresa_id() {
        return adresa_id;
    }

    public void setAdresa_id(Integer adresa_id) {
        this.adresa_id = adresa_id;
    }

    public Integer getMeteoroloska_stanica_id() {
        return meteoroloska_stanica_id;
    }

    public void setMeteoroloska_stanica_id(Integer meteoroloska_stanica_id) {
        this.meteoroloska_stanica_id = meteoroloska_stanica_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LokacijaInstrumenata that = (LokacijaInstrumenata) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "LokacijaInstrumenata{" +
                "id=" + id +
                ", adresa_id=" + adresa_id +
                ", meteoroloska_stanica_id=" + meteoroloska_stanica_id +
                '}';
    }
}
