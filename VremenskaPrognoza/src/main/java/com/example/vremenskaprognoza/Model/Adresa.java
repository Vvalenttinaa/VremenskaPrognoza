package com.example.vremenskaprognoza.Model;

import com.example.vremenskaprognoza.Model.Controll.*;

import java.security.*;
import java.util.*;

public class Adresa {
    private Integer id;
    private String ulica;
    private Integer broj;
    private Integer grad_id;

    public Adresa(){
    }
    public Adresa(Integer id) {
        this.id = id;
    }

    public Adresa(String ulica, Integer broj, String grad) {
        this.ulica = ulica;
        this.broj = broj;

        GradController gradController =new GradController();
        this.grad_id = gradController.nadjiId(grad).getId();
    }

    public Adresa(Integer id, String ulica, Integer broj, Integer grad_id) {
        this.id = id;
        this.ulica = ulica;
        this.broj = broj;
        this.grad_id = grad_id;
    }

    public Adresa(Adresa a){
        this.id=a.id;
        this.broj=a.broj;
        this.ulica=a.ulica;
        this.grad_id=a.grad_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public Integer getBroj() {
        return broj;
    }

    public void setBroj(Integer broj) {
        this.broj = broj;
    }

    public Integer getGrad_id() {
        return grad_id;
    }

    public void setGrad_id(Integer grad_id) {
        this.grad_id = grad_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresa adresa = (Adresa) o;
        return Objects.equals(id, adresa.id);
    }

    @Override
    public String toString() {
        GradController gradController = new GradController();
        DrzavaController drzavaController = new DrzavaController();
        return
                 ulica + ", " +
                 + broj + ", " + gradController.nadjiNaziv(grad_id).getNaziv() ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
