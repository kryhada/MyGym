package sample;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable {


    @FXML
    private Label invalidLabel;
    @FXML
    private JFXTextField login;
    @FXML
    private JFXPasswordField haslo;

    @FXML
    private void handleLoginAction(ActionEvent event) throws  Exception {
        System.out.println("Start Login procedure...");
        System.out.println("Login: " + login.getText());
        System.out.println("Haslo: " + haslo.getText());
        DbConnection connection = new DbConnection();
        if (connection.selectUzytkownik(login.getText(), haslo.getText()).isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Niepoprawne logowanie");
            alert.setHeaderText(null);
            alert.setContentText("Dane do logowania sa bledne, sprobuj ponownie");


            alert.showAndWait();

        }else{
            System.out.println(connection.selectUzytkownik(login.getText(), haslo.getText()));
            System.out.println("Logowanie Powiodlo sie");
            Parent mainWindowSceneParent = FXMLLoader.load(getClass().getResource("/mainWindow.fxml"));
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

