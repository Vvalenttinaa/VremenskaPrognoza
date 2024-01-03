package com.example.vremenskaprognoza.Model.Controll;

import com.example.vremenskaprognoza.DBUtil.*;
import com.example.vremenskaprognoza.Model.*;

import java.sql.*;
import java.util.*;

public class DrzavaController {

    public List<Drzava> prikaziDrzave() {
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        List<Drzava> drzave = new ArrayList<>();
        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from drzava");

            while (rs.next())
                //System.out.println(rs.getInt(1) + " " + rs.getString(2));
                drzave.add(new Drzava(rs.getString(2), rs.getInt(1)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return drzave;
    }

    public Drzava nadjiId(String naziv){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Drzava retVal = null;

        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from drzava where naziv=?");
            ps.setString(1,naziv);
            rs = ps.executeQuery();

            if(rs.next()){
                    retVal = new Drzava(rs.getString(2), rs.getInt(1));
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

    public Drzava nadjiNaziv(Integer id){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Drzava retVal = null;

        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from drzava where id=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();

            if(rs.next()){
                retVal = new Drzava(rs.getString(2), rs.getInt(1));
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

    public void dodaj(String name){
        Connection c = null;
        PreparedStatement ps = null;

        DrzavaController drzavaController = new DrzavaController();
        List<Drzava> drzavaList = drzavaController.prikaziDrzave();

        for (Drzava drzava: drzavaList
             ) {
            if(drzava.getNaziv().equals(name)){
                return;
            }
        }

        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("insert into drzava(naziv) values (?)");
            ps.setString(1,name);
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
