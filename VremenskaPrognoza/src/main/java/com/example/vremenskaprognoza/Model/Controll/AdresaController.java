package com.example.vremenskaprognoza.Model.Controll;

import com.example.vremenskaprognoza.DBUtil.*;
import com.example.vremenskaprognoza.Model.*;

import java.sql.*;
import java.util.*;

public class AdresaController {

    public List<Adresa> prikaziAdrese() {


        List<Adresa> adrese = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from adresa");

            while(rs.next()){
                adrese.add(new Adresa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }


        } catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return adrese;
    }


    public Adresa nadjiId(String ulica, Integer broj, String grad){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Adresa retVal = null;
        Integer grad_id=null;

        GradController gradController = new GradController();
        System.out.println("Trazi id grada" + grad);
        grad_id = gradController.nadjiId(grad).getId();
        System.out.println("Nasao id grada" + grad + grad_id);

        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from adresa where ulica=? and broj=? and grad_id=?");
            ps.setString(1,ulica);
            ps.setInt(2, broj);
            ps.setInt(3, grad_id);
            rs = ps.executeQuery();

            if(rs.next()){
                retVal = new Adresa( rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return retVal;
    }

    public Adresa nadjiAdresu(Integer id){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Adresa retVal = null;

        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from adresa where id=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();

            if(rs.next()){
                retVal = new Adresa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return retVal;
    }

    public void dodaj(Adresa adresa){
        Connection c = null;
        PreparedStatement ps = null;

        AdresaController adresaContoller = new AdresaController();
        List<Adresa> adresaList = adresaContoller.prikaziAdrese();

        for (Adresa a:adresaList
             ) {
            if(a.getBroj().equals(adresa.getBroj()) && a.getUlica().equals(adresa.getUlica()) && a.getGrad_id().equals(adresa.getGrad_id())) {
                return;
            }
        }

        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("insert into adresa(ulica, broj, grad_id) values (?,?,?)");
            ps.setString(1,adresa.getUlica());
            ps.setInt(2,adresa.getBroj());
            ps.setInt(3, adresa.getGrad_id());
            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {

            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    }

}
