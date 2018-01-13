package sample;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Application;
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
import javafx.collections.FXCollections;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.collections.ObservableList;



public class MainWindowController implements Initializable  {

    public DbConnection connection = new DbConnection();
    List<DbKlient> klienci = connection.selectKlient();

    @FXML
    public ListView klienciListView = new ListView<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading user data...");
        klienciListView.setItems(FXCollections.observableArrayList(klienci));
    }

}
