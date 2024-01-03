package com.example.vremenskaprognoza.Model.Controll;

import com.example.vremenskaprognoza.DBUtil.*;
import com.example.vremenskaprognoza.Model.*;

import java.sql.*;
import java.util.*;

public class LokacijaInstrumenataController {

    public List<LokacijaInstrumenata> prikaziLokacijeInstrumenata() {
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        List<LokacijaInstrumenata> lokacijaInstrumenata = new ArrayList<>();
        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from lokacija_instrumenata");

            AdresaController adresaContoller = new AdresaController();

            while (rs.next())
                //System.out.println(rs.getInt(1) + " " + rs.getString(2));
                //drugi argument adresa id, a treci stanica id
                lokacijaInstrumenata.add(new LokacijaInstrumenata(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
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
        return lokacijaInstrumenata;
    }

    public List<String> prikaziLokacijeInstrumenataStanice(Integer id_stanice) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> lokacijaInstrumenata = new ArrayList<>();
        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from instrumenti_stanice where id_stanice=?");
            ps.setInt(1,id_stanice);
           rs = ps.executeQuery();

            while (rs.next()){
                lokacijaInstrumenata.add(rs.getInt(5) + "-" + rs.getString(1) + ", " + rs.getInt(2) +
                        ", " + rs.getString(3) + ", " + rs.getString(4) );
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
        return lokacijaInstrumenata;
    }

    public Integer nadjiId(Adresa adresa) {

        List<LokacijaInstrumenata> lokacijaInstrumenatas = new ArrayList<>();
        LokacijaInstrumenataController lokacijaInstrumenataController = new LokacijaInstrumenataController();

        lokacijaInstrumenatas = lokacijaInstrumenataController.prikaziLokacijeInstrumenata();
        for (LokacijaInstrumenata li : lokacijaInstrumenatas
        ) {
            if (li.getAdresa_id().equals(adresa.getId())) {
                return li.getId();
            }
        }
        return null;

    }

    public MeteoroloskaStanica nadjiStanicu(Integer id) {

        MeteoroloskaStanica ms = null;

        List<LokacijaInstrumenata> lokacijaInstrumenata = new ArrayList<>();

        LokacijaInstrumenataController lokacijaInstrumenataController = new LokacijaInstrumenataController();
        lokacijaInstrumenata = lokacijaInstrumenataController.prikaziLokacijeInstrumenata();

        for (LokacijaInstrumenata li : lokacijaInstrumenata
        ) {
            if (li.getId().equals(id)) {
                MeteoroloskaStanicaController meteoroloskaStanicaController = new MeteoroloskaStanicaController();
                ms = meteoroloskaStanicaController.nadjiStanicu(id);
                return ms;
            }
        }

        return ms;
    }

    public Boolean dodaj(String ulica, String broj, String grad, String drzava, MeteoroloskaStanica meteoroloskaStanica) {
        Connection c = null;
        PreparedStatement ps = null;
        //Boolean retValue = false;

        Boolean adresaExists = false;
        Boolean gradExists = false;
        Boolean drzavaExists = false;

        Integer adresa_id = null;
        Integer grad_id = null;
        Integer meteoroloskaStanica_id = null;

        if (ulica.equals(null) || grad.equals(null) || broj.equals(null) || drzava.equals(null)) {
            System.out.println("String nije proslijedjen u dodaj");
            return null;
        }
        System.out.println(" u dodaj je " + ulica + broj + grad + drzava + meteoroloskaStanica);

        MeteoroloskaStanicaController meteoroloskaStanicaController = new MeteoroloskaStanicaController();
        List<MeteoroloskaStanica> meteoroloskaStanicaList = meteoroloskaStanicaController.prikaziStanice();
        for (MeteoroloskaStanica ms : meteoroloskaStanicaList
        ) {
            System.out.println("iz liste je" + ms.getId() + "dodajem" + meteoroloskaStanica.getId());

            if (ms.getId().equals(meteoroloskaStanica.getId())) {
                meteoroloskaStanica_id = ms.getId();
            }
        }
            if (meteoroloskaStanica_id == null) {
                System.out.println("Stanica ne postoji");
                return false;
            }


        DrzavaController drzavaController = new DrzavaController();
        List<Drzava> drzavaList = drzavaController.prikaziDrzave();

        for (Drzava d : drzavaList
        ) {
            if (d.getNaziv().equals(drzava)) {
                drzavaExists = true;
                break;
            }
        }
        if (!drzavaExists) {
            drzavaController.dodaj(drzava);
            drzavaExists = true;
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
            if (!gradExists) {
                gradController.dodaj(grad, drzava);
                gradExists = true;
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

            if (!adresaExists) {
                adresaController.dodaj(new Adresa(ulica, Integer.parseInt(broj), grad));
                adresa_id = adresaController.nadjiId(ulica, Integer.parseInt(broj), grad).getId();
                adresaExists = true;
            }

            if (adresaExists && gradExists && drzavaExists) {
                LokacijaInstrumenataController lokacijaInstrumenataController = new LokacijaInstrumenataController();
                List<LokacijaInstrumenata> lokacijeInstrumenata = lokacijaInstrumenataController.prikaziLokacijeInstrumenata();

                for (LokacijaInstrumenata li : lokacijeInstrumenata
                ) {
                    if (adresa_id.equals(li.getAdresa_id()) && li.getMeteoroloska_stanica_id().equals(meteoroloskaStanica_id)) {
                        System.out.println("Vec postoji lokacija za instrumente jer je " + adresa_id + "isto kao" + li.getAdresa_id()
                        + " i " + meteoroloskaStanica_id + "isto kao " + li.getMeteoroloska_stanica_id() + "retVal je " );
                        return false;
                    }
                }
            }
            try {
                System.out.println("Dodajem lokaciju za mjerenje");
                c = ConnectionPool.getInstance().checkOut();
                ps = c.prepareStatement("insert into lokacija_instrumenata(adresa_id, meteoroloska_stanica_id) values (?,?)");
                ps.setInt(1, adresa_id);
                ps.setInt(2, meteoroloskaStanica_id);
                ps.executeUpdate();


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
        return true;
    }
}

