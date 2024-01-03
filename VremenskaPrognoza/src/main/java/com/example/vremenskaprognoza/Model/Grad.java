package com.example.vremenskaprognoza.Model;

import java.util.*;

public class Grad {
    private Integer id;
    private String naziv;
    private Integer drzava_id;

    public Grad(){
    }

    public Grad(Integer id){
        this.id = id;
    }

    public Grad(String naziv){
        this.naziv=naziv;
    }

    public Grad(Integer id, String naziv){
        this.id = id;
        this.naziv = naziv;
    }

    public Grad(String naziv, Integer drzava_id) {
        this.naziv = naziv;
        this.drzava_id = drzava_id;
    }

    public Grad( Integer id, String naziv, Integer drzava_id) {
        this.naziv = naziv;
        this.drzava_id = drzava_id;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grad grad = (Grad) o;
        return Objects.equals(id, grad.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Grad{" +
                "id='" + id + '\'' +
                "naziv='" + naziv + '\'' +
                ", drzava_id=" + drzava_id +
                '}';
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getDrzava_id() {
        return drzava_id;
    }

    public void setDrzava_id(Integer drzava_id) {
        this.drzava_id = drzava_id;
    }
}
