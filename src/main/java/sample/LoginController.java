package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;

import java.util.Collections;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources){
        System.out.println("Loading user data...");
    }

    private Button button;
    @FXML
    private TextField login;
    @FXML
    private TextField haslo;

    @FXML
    public void LoginClick(){
        System.out.println("Start Login procedure...");
        System.out.println("Login: "+login.getText());
        System.out.println("Haslo: "+haslo.getText());
        DbConnection connection = new DbConnection();
        if(connection.selectUzytkownik(login.getText(), haslo.getText()).isEmpty()){
            System.out.println("Bùædny login lub hasùo");
        }
        else{
            System.out.println(connection.selectUzytkownik(login.getText(), haslo.getText()));
            System.out.println("Logowanie Powiodùo siæ");
        }




    }
}
