package sample;

import sample.LogFactory.Log;
import sample.LogFactory.LogFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DbConnection {

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:C:/Users/Krystian/IdeaProjects/MyGym/src/main/DataBase/myDB";

    protected Connection conn;
    protected Statement stat;
    private static DbConnection instance = new DbConnection();
    LogFactory logFactory = new LogFactory();
    Log log = logFactory.getLog("DATABASE");

    private DbConnection(){
        try{
            Class.forName(DbConnection.DRIVER);
        } catch (ClassNotFoundException e){
            log.writeLog("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try{
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch(SQLException e) {
            log.writeLog("Problem z otwarciem poùàczenia");
            e.printStackTrace();
        }
    }

    public static DbConnection getInstance(){
        return instance;
    }

    public void closeConnection(){
        try{
            conn.close();
        } catch (SQLException e){
            log.writeLog("Problem z zamknieciem poùàczenia");
            e.printStackTrace();
        }
    }
}
