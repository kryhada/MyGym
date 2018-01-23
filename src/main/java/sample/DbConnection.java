package sample;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DbConnection {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:C:/Users/Krystian/IdeaProjects/MyGym/src/main/DataBase/myDB";

    private Connection conn;
    private Statement stat;

    public DbConnection(){
        try{
            Class.forName(DbConnection.DRIVER);
        } catch (ClassNotFoundException e){
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try{
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch(SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
    }


    public boolean insertUzytkownik(int id, String login, String haslo, String imie, String nazwisko){
        try{
            PreparedStatement prepStm = conn.prepareStatement(
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

    public List<DbUzytkownik> selectUzytkownik(String arg1, String arg2){
        List<DbUzytkownik> uzytkownicy = new LinkedList<DbUzytkownik>();
        try{
           // ResultSet result = stat.executeQuery("select * from uzytkownik where login like ? AND haslo like ? ");
            PreparedStatement prepStm = conn.prepareStatement("select * from uzytkownik where login like ? AND haslo like ? ");
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

    public List<DbKlient> selectKlient(){
        List<DbKlient> klienci = new LinkedList<DbKlient>();
        try{
            ResultSet result = stat.executeQuery("select * from klient");
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

    public List<DbPracownik> selectPracownik(){
        List<DbPracownik> pracownicy = new LinkedList<>();
        try{
            ResultSet result = stat.executeQuery("select id, imie, nazwisko from pracownik");
            int id;
            String imie, nazwisko;
            while(result.next()){
                id = result.getInt("id");
                imie = result.getString("imie");
                nazwisko = result.getString("nazwisko");
                pracownicy.add(new DbPracownik(id, imie, nazwisko));
            }
        } catch(SQLException e){
            System.out.println("Blad odczytu z bazy");
            e.printStackTrace();
            return null;
        }
        return pracownicy;
    }

    public void closeConnection(){
        try{
            conn.close();
        } catch (SQLException e){
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}
