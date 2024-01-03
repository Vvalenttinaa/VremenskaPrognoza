package com.example.vremenskaprognoza.Model.Controll;

import com.example.vremenskaprognoza.DBUtil.*;
import com.example.vremenskaprognoza.Model.*;

import java.sql.*;
import java.util.*;

public class PadavineController {

    public List<Padavine> prikaziPadavine() {
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        List<Padavine> padavine = new ArrayList<>();
        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from padavine");

            while (rs.next()) {
                System.out.println(rs.getString(2) + " " + rs.getInt(1));
                padavine.add(new Padavine(rs.getString(2), rs.getInt(1)));
            }
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
        return padavine;
    }
    public Drzava nadjiNaziv(Integer id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Drzava retVal = null;

        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from drzava where id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                retVal = new Drzava(rs.getString(2), rs.getInt(1));
            }

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
        return retVal;
    }
}
