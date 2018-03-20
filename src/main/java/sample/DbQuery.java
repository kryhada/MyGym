package sample;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DbQuery{

    private DbConnection connnection = DbConnection.getInstance();
    private static DbQuery instance = new DbQuery();


    private DbQuery(){}

    public static DbQuery getInstance(){
        return instance;
    }

    public boolean insertUzytkownik(int id, String login, String haslo, String imie, String nazwisko){
        try{
            PreparedStatement prepStm = connnection.conn.prepareStatement(
                    "insert into uzytkownik values (?, ?, ?, ?, ?);");
            prepStm.setInt(1, id);
            prepStm.setString(2, login);
            prepStm.setString(3, haslo);
            prepStm.setString(4, imie);
            prepStm.setString(5, nazwisko);
            prepStm.execute();
        } catch(SQLException e){
            System.err.println("Blad przy dodawaniu rekordu");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    List<DbUzytkownik> selectUzytkownik(String arg1, String arg2){
        List<DbUzytkownik> uzytkownicy = new LinkedList<DbUzytkownik>();
        try{
            // ResultSet result = stat.executeQuery("select * from uzytkownik where login like ? AND haslo like ? ");
            PreparedStatement prepStm = connnection.conn.prepareStatement("select * from uzytkownik where login like ? AND haslo like ? ");
            prepStm.setString(1, arg1);
            prepStm.setString(2, arg2);
            ResultSet result =prepStm.executeQuery();
            int id;
            String login, haslo, imie, nazwisko;
            while(result.next()){
                id = result.getInt("id");
                login = result.getString("login");
                haslo = result.getString("haslo");
                imie = result.getString("imie");
                nazwisko = result.getString("nazwisko");
                uzytkownicy.add(new DbUzytkownik(id, login, haslo, imie, nazwisko));
            }
        } catch(SQLException e){
            System.out.println("Blad odczytu z bazy");
            e.printStackTrace();
            return null;
        }
        return uzytkownicy;
    }

    List<DbKlient> selectKlient(){
        List<DbKlient> klienci = new LinkedList<DbKlient>();
        try{
            ResultSet result = connnection.stat.executeQuery("select * from klient");
            int id, wiek;
            String imie, nazwisko, nr_telefonu, gender;
            while(result.next()){
                id = result.getInt("id");
                imie = result.getString("imie");
                nazwisko = result.getString("nazwisko");
                nr_telefonu = result.getString("nr_telefonu");
                wiek = result.getInt("wiek");
                gender = result.getString("gender");
                klienci.add(new DbKlient(id, imie, nazwisko, nr_telefonu, wiek, gender));

            }
        } catch(SQLException e){
            System.out.println("Blad odczytu z bazy");
            e.printStackTrace();
            return null;
        }
        return klienci;
    }

    List<DbPracownik> selectPracownik(){
        List<DbPracownik> pracownicy = new LinkedList<>();
        try{
            ResultSet result = connnection.stat.executeQuery("select p.id p.imie, p.nazwisko, p.nr_telefonu, p.email,  s.nazwa from pracownik p join stanowisko s on p.stanowisko = s.id ");
            int id;
            String imie, nazwisko, telefon, email, stanowisko;
            while(result.next()){
                id = result.getInt("id");
                imie = result.getString("imie");
                nazwisko = result.getString("nazwisko");
                telefon = result.getString("nr_telefonu");
                email = result.getString("email");
                stanowisko = result.getString("stanowisko");
                pracownicy.add(new DbPracownik(id, imie, nazwisko, telefon, email, stanowisko));
            }
        } catch(SQLException e){
            System.out.println("Blad odczytu z bazy");
            e.printStackTrace();
            return null;
        }
        return pracownicy;
    }



}
