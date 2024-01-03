package com.example.vremenskaprognoza.Pregled.DetaljanPregled;

import com.example.vremenskaprognoza.DBUtil.*;
import com.example.vremenskaprognoza.Model.*;
import com.example.vremenskaprognoza.Model.Controll.*;

import java.sql.*;
import java.util.*;

public class PregledInicijalizacija {

    public List<String> prikaziDrzave() {
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        List<String> drzave = new ArrayList<>();
        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from drzava");


            while (rs.next())
                //System.out.println(rs.getInt(1) + " " + rs.getString(2));
                //drugi argument adresa id, a treci stanica id
                drzave.add(new String(rs.getInt(1) + "-" + rs.getString(2)));
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

    public List<String> prikaziGradoveUDrzavi(Integer drzava_id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> gradovi = new ArrayList<>();
        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from gradovi_u_drzavi where drzava_id=?");
            ps.setInt(1,drzava_id);
            rs = ps.executeQuery();

            while (rs.next())
                gradovi.add(new String(rs.getInt(3) + "-" + rs.getString(1)));
        } catch (SQLException e) {
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
        return gradovi;
    }

    public List<String> prikaziAdreseUGradu(Integer grad_id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> adrese = new ArrayList<>();
        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from ulice_u_gradu where grad_id=?");
            ps.setInt(1,grad_id);
            rs = ps.executeQuery();

            while (rs.next())
                adrese.add(new String(rs.getInt(1) + "-" + rs.getString(2) + rs.getInt(3)));
        } catch (SQLException e) {
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
        return adrese;
    }

    public static List<String> prikaziDostupnaVremena(Integer adresa_id){

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> vremena = new ArrayList<>();
        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select id_mjerenje, vrijeme_mjerenja from mjerenje where adresa_id=?");
            ps.setInt(1,adresa_id);
            rs = ps.executeQuery();

            while (rs.next())
                vremena.add(new String(rs.getInt(1) + "-" + rs.getTimestamp(2)));
        } catch (SQLException e) {
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
        return vremena;
    }

}
