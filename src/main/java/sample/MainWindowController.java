package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.transformation.FilteredList;
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
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TextField;
import sample.CriteriaFilters.CriteriaGender;


public class MainWindowController implements Initializable  {

    public DbConnection connection = new DbConnection();
    List<DbKlient> klienci = connection.selectKlient();
    List<DbKlient> fullListKlienci = klienci;
    List<String> klienciGender = new ArrayList<String>();



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
    public TableColumn<DbKlient, String> sexColumn;

    @FXML
    public TextField search;

    @FXML
    public ChoiceBox<String> tableSexChoiceBox;


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

    @FXML
    private void getChoice(ActionEvent event){
        for(DbKlient client : klienci){
            klienciGender.add(client.getGender());
        }
        String value = tableSexChoiceBox.getValue();
        System.out.println(value);
        CriteriaGender gender = new CriteriaGender(value);
        klienciTable.setItems(FXCollections.observableArrayList(gender.meetCriteria(klienci)));

    }

    @FXML
    private void startSearch(ActionEvent event){
        FilteredList<DbKlient> filteredData = new FilteredList<DbKlient>(FXCollections.observableArrayList(klienciTable.getItems()), p -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(klient -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (klient.getImie().toLowerCase().contains(lowerCaseFilter)) {
                    return true; //filter matches imie
                } else if (klient.getNazwisko().toLowerCase().contains(lowerCaseFilter)) {
                    return true; //filter matches nazwisko
                } else if (klient.getStringId().contains(lowerCaseFilter)){
                    return true; // filter matches ID
                }
                return false; //does not match
            });
        });
        SortedList<DbKlient> sortedData = new SortedList<DbKlient>(filteredData);
        sortedData.comparatorProperty().bind(klienciTable.comparatorProperty());
        klienciTable.setItems(sortedData);
        System.out.println(sortedData);
    }

    @FXML
    private void resetFilter(ActionEvent event){
        tableSexChoiceBox.getSelectionModel().selectFirst();
        search.setText("");
        klienciTable.setItems(FXCollections.observableArrayList(fullListKlienci));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading user data...");
        klienciTable.setItems(FXCollections.observableArrayList(klienci));
        tableSexChoiceBox.setItems(FXCollections.observableArrayList( "<default>", "Male", "Female"));



    }

}
