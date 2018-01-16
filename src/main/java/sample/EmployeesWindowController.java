package sample;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmployeesWindowController implements Initializable{

    public DbConnection connection = new DbConnection();
    List<DbPracownik> pracownicy = connection.selectPracownik();

    @FXML
    public ListView pracownicyListView = new ListView<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading user data...");
        pracownicyListView.setItems(FXCollections.observableArrayList(pracownicy));
    }
}
