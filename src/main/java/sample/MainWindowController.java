package sample;

import java.awt.event.MouseEvent;
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
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;


public class MainWindowController implements Initializable  {

    public DbConnection connection = new DbConnection();
    List<DbKlient> klienci = connection.selectKlient();

    @FXML
    public TableView<DbKlient> klienciTable = new TableView<DbKlient>();

    @FXML
    public TextField idShowLabel;
    @FXML
    public TextField imieShowLabel;
    @FXML
    public TextField nazwiskoShowLabel;
    @FXML
    public TextField telefonShowLabel;
    @FXML
    public TextField wiekShowLabel;

    @FXML
    public TableColumn<DbKlient, Integer> idColumn;
    @FXML
    public TableColumn<DbKlient, String> imieColumn;
    @FXML
    public TableColumn<DbKlient, String> nazwiskoColumn;
    @FXML
    public TableColumn<DbKlient, Integer> wiekColumn;
    @FXML
    public TableColumn<DbKlient, String> telefonColumn;

    @FXML
    private void handlePracownicyAction(ActionEvent event) throws Exception{
        Parent mainWindowSceneParent = FXMLLoader.load(getClass().getResource("/employeesWindow.fxml"));
        Scene mainWindowScene = new Scene(mainWindowSceneParent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainWindowScene);
        stage.show();
    }

    @FXML
    private void displaySelected(){
        DbKlient selected =  klienciTable.getSelectionModel().getSelectedItem();
        idShowLabel.setText(selected.getStringId());
        imieShowLabel.setText(selected.getImie());
        nazwiskoShowLabel.setText(selected.getNazwisko());
        telefonShowLabel.setText(selected.getNr_telefonu());
        wiekShowLabel.setText(selected.getStringWiek());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading user data...");
        klienciTable.setItems(FXCollections.observableArrayList(klienci));

    }

}
