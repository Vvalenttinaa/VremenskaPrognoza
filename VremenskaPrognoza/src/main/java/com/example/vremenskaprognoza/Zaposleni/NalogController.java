package com.example.vremenskaprognoza.Zaposleni;

import com.example.vremenskaprognoza.Model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NalogController {

    //dohvatanje iz baze
    private boolean exist = false;

        public static void main(String[] args) {
            com.example.vremenskaprognoza.Zaposleni.NalogController nalozi = new com.example.vremenskaprognoza.Zaposleni.NalogController();
           Nalog n = nalozi.ucitajNalog("Marko", "lozinka", 'A');
           System.out.println(n);
        }

        public Nalog ucitajNalog( String username, String password, Character role) {
            Connection c = null;
            Statement s = null;
            ResultSet rs = null;
            try {
                c = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/db_vremenska_prognoza", "root", "sifrazamysql");
                s = c.createStatement();
                rs = s.executeQuery("select * from nalog");

                while (rs.next()) {
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));



                    if(rs.getString(2).equals(password) && rs.getString(3).equals(username) && rs.getString(4).equals(String.valueOf(role))){

                        exist = true;
                        Nalog n = new Nalog(rs.getInt(1),username, password, role);
                        return n;
                  }
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
                if (c != null)
                    try {
                        c.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
            return null;
        }

        public boolean exist(){
            return exist;
        }

    }




