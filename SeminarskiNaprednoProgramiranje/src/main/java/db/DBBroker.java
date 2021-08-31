/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import domain.*;;
public class DBBroker {
    private static DBBroker instance;
    private Connection connection;

    public DBBroker() {
        try {
            connection=
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/turistickaagencija", "root", "");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBBroker getInstance() {
        if(instance==null)
            instance=new DBBroker();
        return instance;
    }

	public static ArrayList<Hotel> vratiHotele() {
		ArrayList<Hotel> lista = new ArrayList<>();
        String upit = "SELECT * FROM Hotel";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
            	Hotel h = new Hotel(rs.getLong("hotelID"), rs.getString("nazivHotela"), rs.getString("grad"));
                lista.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
	}

	public static ArrayList<Vodic> vratiVodice() {
		ArrayList<Vodic> lista = new ArrayList<>();
        String upit = "SELECT * FROM Vodic";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
            	Vodic v = new Vodic(rs.getLong("VodicID"),rs.getString("Ime"),rs.getString("Prezime"), rs.getString("BrojTelefona"), rs.getString("Email"), rs.getInt("GodineIskustva"));
                lista.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
	}

	public static ArrayList<TipPrevoza> vratiPrevoz() {
		ArrayList<TipPrevoza> lista = new ArrayList<>();
        String upit = "SELECT * FROM TipPrevoza";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
            	TipPrevoza tp = new TipPrevoza(rs.getLong("tipPrevozaID"), rs.getString("opis"));
                lista.add(tp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
	}

	public static ArrayList<Termin> vratiTermine() {
		ArrayList<Termin> lista = new ArrayList<>();
        String upit = "SELECT * FROM TERMIN T "
                + "JOIN ARANZMAN A ON (A.ARANZMANID = T.ARANZMANID) "
                + "JOIN TIPPREVOZA TP ON (TP.TIPPREVOZAID = T.TIPPREVOZAID) "
                + "JOIN VODIC V ON (A.VODICID = V.VODICID) "
                + "JOIN HOTEL H ON (H.HOTELID = A.HOTELID) "
                + "JOIN KLIJENT K ON (K.KLIJENTID = T.KLIJENTID)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
            	Hotel h = new Hotel(rs.getLong("HotelID"), rs.getString("NazivHotela"),
                        rs.getString(11));

                Vodic v = new Vodic(rs.getLong("VodicID"),
                        rs.getString(17), rs.getString(18),
                        rs.getString(19), rs.getString(20), rs.getInt("GodineIskustva"));

                Aranzman a = new Aranzman(rs.getLong("AranzmanID"), rs.getString("Opis"), v, h, null);

                TipPrevoza tp = new TipPrevoza(rs.getLong("TipPrevozaID"), rs.getString(15));
                
                Klijent k = new Klijent(rs.getLong("KlijentID"),
                        rs.getString(26), rs.getString(27), 
                        rs.getString(28), rs.getString(29));

                Termin t = new Termin(a, rs.getInt("TerminID"), rs.getDate("DatumOd"),
                        rs.getDate("DatumDo"), rs.getDouble("CenaBezPDV"), rs.getDouble("PoreskaStopa"),
                        rs.getDouble("CenaSaPDV"), k, tp);

                lista.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
	}

	public static ArrayList<Klijent> vratiKlijente() {
		ArrayList<Klijent> lista = new ArrayList<>();
        String upit = "SELECT * FROM Klijent";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
            	Klijent k = new Klijent(rs.getLong("klijentID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("brojTelefona"), rs.getString("Email"));
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
	}
    
    
    
}
