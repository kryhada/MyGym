package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable {

    @FXML
    private Label invalidLabel;
    @FXML
    private TextField login;
    @FXML
    private TextField haslo;

    @FXML
    private void handleLoginAction(ActionEvent event) throws  Exception {
        System.out.println("Start Login procedure...");
        System.out.println("Login: " + login.getText());
        System.out.println("Haslo: " + haslo.getText());
        DbConnection connection = new DbConnection();
        if (connection.selectUzytkownik(login.getText(), haslo.getText()).isEmpty()) {
            System.out.println("Bùædny login lub hasùo");
            invalidLabel.setText("Bledny login lub haslo!!! \n Sprobuj Ponownie!!!");
        } else {
            System.out.println(connection.selectUzytkownik(login.getText(), haslo.getText()));
            System.out.println("Logowanie Powiodùo siæ");
            Parent mainWindowSceneParent = FXMLLoader.load(getClass().getResource("/test.fxml"));
            Scene mainWindowScene = new Scene(mainWindowSceneParent);
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(mainWindowScene);
            stage.show();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading user data...");
    }


}

