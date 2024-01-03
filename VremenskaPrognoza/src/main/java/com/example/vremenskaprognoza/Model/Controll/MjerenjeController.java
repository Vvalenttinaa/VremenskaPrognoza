package com.example.vremenskaprognoza.Model.Controll;

import com.example.vremenskaprognoza.DBUtil.*;
import com.example.vremenskaprognoza.Zaposleni.Mjerenje.*;

import java.sql.*;

public class MjerenjeController {


    public void dodajMjerenje(Timestamp timestamp, Integer lokacijaId, Integer lokacijaMjernihInstrumenataId, Integer zaposleniId, Integer temperatura,
                              Integer uvIndeks){
        Connection c = null;
        CallableStatement cs = null;

        try{

            c = ConnectionPool.getInstance().checkOut();
            cs=c.prepareCall("{ call INSERT_MJERENJE1(?,?,?,?,?,?) }");
            cs.setInt(1,zaposleniId);
            cs.setInt(2, lokacijaId);
            cs.setInt(3,lokacijaMjernihInstrumenataId);
            cs.setInt(4,temperatura);
            cs.setInt(5,uvIndeks);
            cs.setTimestamp(6, timestamp);
            cs.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }

    }

    public void dodajMjerenje(Timestamp timestamp, Integer lokacijaId, Integer lokacijaMjernihInstrumenataId, Integer zaposleniId, Integer temperatura,
                              Integer uvIndeks, String opisPadavine, Integer kolicinaPadavine, Integer vjerovatnocaPadavine,
                              Integer padavineTip){
        Connection c = null;
        CallableStatement cs = null;

        try{

            c = ConnectionPool.getInstance().checkOut();
            cs=c.prepareCall("{ call INSERT_MJERENJE(?,?,?,?,?,?,?,?,?,?) }");
            cs.setInt(1,zaposleniId);
            cs.setInt(2, lokacijaId);
            cs.setInt(3,lokacijaMjernihInstrumenataId);
            cs.setInt(4,temperatura);
            cs.setInt(5,uvIndeks);
            cs.setString(6, opisPadavine);
            cs.setInt(7,kolicinaPadavine);
            cs.setInt(8,vjerovatnocaPadavine);
            cs.setInt(9,padavineTip);
            cs.setTimestamp(10, timestamp);
            cs.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }

    }

    public Mjerenje ucitajMjerenje(Timestamp timestamp, Integer lokacijaId){

        Connection c = null;
        CallableStatement cs = null;
        Mjerenje mjerenje = null;

        try{

            c = ConnectionPool.getInstance().checkOut();
            String query = "call MJERENJE_REZULTAT(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            cs=c.prepareCall(query);
            cs.setInt(1,lokacijaId);
            cs.setTimestamp(2, timestamp);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.registerOutParameter(4,Types.VARCHAR);
            cs.registerOutParameter(5,Types.VARCHAR);
            cs.registerOutParameter(6,Types.VARCHAR);
            cs.registerOutParameter(7,Types.INTEGER);
            cs.registerOutParameter(8,Types.VARCHAR);
            cs.registerOutParameter(9,Types.INTEGER);

            cs.executeQuery();

            mjerenje = new Mjerenje(cs.getInt(3), cs.getString(4), cs.getString(5),
                                cs.getString(6), cs.getInt(7), cs.getString(8),
                                cs.getInt(9)) ;


        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return mjerenje;
    }

    public Integer getAdresaId(String drzava, String grad, String ulica, Integer broj
    ){

        Connection c = null;
        CallableStatement cs = null;
        Integer adresaId = null;

        try{

            c = ConnectionPool.getInstance().checkOut();
            String query = "call ADRESA_ID(?, ?, ?, ?, ?)";
            cs=c.prepareCall(query);
            cs.setString(1,drzava);
            cs.setString(2, grad);
            cs.setString(3, ulica);
            cs.setInt(4, broj);

            cs.registerOutParameter(5, Types.INTEGER);


            cs.executeQuery();
            System.out.println(adresaId);
            adresaId = cs.getInt(5);
            System.out.println(adresaId);


        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return adresaId;
    }

    public Mjerenje ucitajMjerenjePoId(Integer id){

        Connection c = null;
        CallableStatement cs = null;
        Mjerenje mjerenje = null;

        try{

            c = ConnectionPool.getInstance().checkOut();
            String query = "call MJERENJE_REZULTAT_PO_ID(?, ?, ?, ?, ?, ?, ?, ?)";
            cs=c.prepareCall(query);
            cs.setInt(1,id);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.registerOutParameter(3,Types.VARCHAR);
            cs.registerOutParameter(4,Types.VARCHAR);
            cs.registerOutParameter(5,Types.VARCHAR);
            cs.registerOutParameter(6,Types.INTEGER);
            cs.registerOutParameter(7,Types.VARCHAR);
            cs.registerOutParameter(8,Types.INTEGER);

            cs.executeQuery();

            mjerenje = new Mjerenje(cs.getInt(2), cs.getString(3), cs.getString(4),
                    cs.getString(5), cs.getInt(6), cs.getString(7),
                    cs.getInt(8)) ;


        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return mjerenje;

    }

}
