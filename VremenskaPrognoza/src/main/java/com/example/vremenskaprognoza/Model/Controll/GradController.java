package com.example.vremenskaprognoza.Model.Controll;

import com.example.vremenskaprognoza.DBUtil.*;
import com.example.vremenskaprognoza.Model.*;

import java.sql.*;
import java.util.*;

public class GradController {

    public List<Grad> prikaziGradove() {


        List<Grad> gradovi = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = ConnectionPool.getInstance().checkOut();
           s = c.createStatement();
           rs = s.executeQuery("select * from grad");

           while(rs.next()){
               gradovi.add(new Grad(rs.getInt(1), rs.getString(2), rs.getInt(3)));
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
        return gradovi;
    }


    public Grad nadjiId(String naziv){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Grad retVal = null;

        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from grad where naziv=?");
            ps.setString(1,naziv);
            rs = ps.executeQuery();

            if(rs.next()){
                retVal = new Grad( rs.getInt(1), rs.getString(2));
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

    public Grad nadjiNaziv(Integer id){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Grad retVal = null;

        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from grad where id=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();

            if(rs.next()){
                retVal = new Grad(rs.getInt(1), rs.getString(2), rs.getInt(3));
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

    public void dodaj(String name, String drzava){
        Connection c = null;
        PreparedStatement ps = null;
        Integer drzava_id = null;

        DrzavaController drzavaController = new DrzavaController();
        List<Drzava> drzavaList = drzavaController.prikaziDrzave();
        for (Drzava d:drzavaList
             ) {
            if(d.getNaziv().equals(drzava))
            drzava_id = d.getId();
        }

        if(drzava_id == null){
            return;
        }

        GradController gradController = new GradController();
        List<Grad> gradList = gradController.prikaziGradove();

        for (Grad grad:gradList
             ) {
            if(grad.getNaziv().equals(name)){
                return;
            }
        }

        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("insert into grad(naziv, drzava_id) values (?,?)");
            ps.setString(1,name);
            ps.setInt(2,drzava_id);
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
