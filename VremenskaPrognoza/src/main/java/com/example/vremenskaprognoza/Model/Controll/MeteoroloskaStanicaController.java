package com.example.vremenskaprognoza.Model.Controll;

import com.example.vremenskaprognoza.DBUtil.*;
import com.example.vremenskaprognoza.Model.*;

import java.sql.*;
import java.util.*;

public class MeteoroloskaStanicaController {

    public List<MeteoroloskaStanica> prikaziStanice() {
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        List<MeteoroloskaStanica> meteoroloskaStanica = new ArrayList<>();
        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from meteoroloska_stanica");

            AdresaController adresaContoller = new AdresaController();

            while (rs.next())
                //System.out.println(rs.getInt(1) + " " + rs.getString(2));
                meteoroloskaStanica.add(new MeteoroloskaStanica(rs.getInt(1), new Adresa(adresaContoller.nadjiAdresu(rs.getInt(2)))));
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
        return meteoroloskaStanica;
    }

    public MeteoroloskaStanica nadjiId(Adresa adresa){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MeteoroloskaStanica retVal = null;

        AdresaController adresaContoller = new AdresaController();
        GradController gradController = new GradController();
        Integer adresa_id = adresaContoller.nadjiId(adresa.getUlica(), adresa.getBroj(),
                gradController.nadjiNaziv(adresa.getGrad_id()).getNaziv()).getId();

        adresa.setId(adresa_id);

        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from meteoroloska_stanica where adresa_id=?");
            ps.setInt(1,adresa_id);
            rs = ps.executeQuery();

            if(rs.next()){
                retVal = new MeteoroloskaStanica(rs.getInt(1), adresa);
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

    public MeteoroloskaStanica nadjiStanicu(Integer id){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MeteoroloskaStanica retVal = null;

        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from meteoroloska_stanica where id=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();

            if(rs.next()){
                AdresaController adresaContoller = new AdresaController();
                Adresa adresa = adresaContoller.nadjiAdresu(rs.getInt(2));
                retVal = new MeteoroloskaStanica(rs.getInt(1), adresa);
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

    public Boolean dodaj(String ulica, String broj, String grad, String drzava) {
        Connection c = null;
        PreparedStatement ps = null;

        Boolean retValue = false;

        Boolean adresaExists = false;
        Boolean gradExists = false;
        Boolean drzavaExists = false;
        Boolean meteoroloskaStanicaExists = false;


        Integer adresa_id = null;
        Integer grad_id = null;

        DrzavaController drzavaController = new DrzavaController();
        List<Drzava> drzavaList = drzavaController.prikaziDrzave();

        for (Drzava d : drzavaList
        ) {
            if (d.getNaziv().equals(drzava)) {
                drzavaExists = true;
                break;
            }
        }
        if(!drzavaExists){
            drzavaController.dodaj(drzava);
            drzavaExists=true;
        }

        GradController gradController = new GradController();
        List<Grad> gradList = gradController.prikaziGradove();

        for (Grad g : gradList
        ) {
            if (g.getNaziv().equals(grad)) {
                gradExists = true;
                grad_id = g.getId();
                break;
            }
        }
        if(!gradExists){
            gradController.dodaj(grad, drzava);
            gradExists=true;
        }

        AdresaController adresaController = new AdresaController();
        List<Adresa> adresaList = adresaController.prikaziAdrese();

        for (Adresa a : adresaList
        ) {
            System.out.println(a);
            if (a.getUlica().equals(ulica) && a.getBroj().equals(broj)) {
                adresaExists = true;
                adresa_id = a.getId();

                System.out.println("Postoji" + a);
                break;
            }
        }

        if(!adresaExists){
            adresaController.dodaj(new Adresa(ulica, Integer.parseInt(broj), grad));
            adresa_id=adresaController.nadjiId(ulica, Integer.parseInt(broj), grad).getId();
            adresaExists=true;
        }

        if(adresaExists && gradExists && drzavaExists) {
            MeteoroloskaStanicaController meteoroloskaStanicaController = new MeteoroloskaStanicaController();
            List<MeteoroloskaStanica> meteoroloskaStanicaList = meteoroloskaStanicaController.prikaziStanice();

            for (MeteoroloskaStanica ms : meteoroloskaStanicaList
            ) {

                if ( adresa_id.equals(ms.getAdresa().getId())) {
                    meteoroloskaStanicaExists = true;
                    System.out.println("Stanica vec postoji");
                    return false;
                }
            }

        }

        if (!meteoroloskaStanicaExists) {
            try {
                c = ConnectionPool.getInstance().checkOut();
                ps = c.prepareStatement("insert into meteoroloska_stanica(adresa_id) values (?)");
                ps.setInt(1, adresa_id);
                ps.executeUpdate();
                retValue = true;

            } catch (SQLException e) {
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
        return retValue;
    }


}
