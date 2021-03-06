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
import sample.CriteriaFilters.CriteriaID;
import sample.CriteriaFilters.CriteriaName;
import sample.CriteriaFilters.CriteriaSurname;


public class MainWindowController implements Initializable  {

    public DbQuery query = DbQuery.getInstance();
    List<DbKlient> klienci = query.selectKlient();
    List<DbKlient> fullListKlienci = klienci;
    List<String> klienciGender = new ArrayList<String>();
    List<String> klienciId = new ArrayList<String>();
    List<String> klienciName = new ArrayList<String>();
    List<String> klienciSurname = new ArrayList<String>();



    @FXML
    public TableView<DbKlient> klienciTable = new TableView<DbKlient>();

    @FXML
    public Label idShowLabel;
    @FXML
    public Label imieShowLabel;
    @FXML
    public Label nazwiskoShowLabel;
    @FXML
    public Label telefonShowLabel;
    @FXML
    public Label wiekShowLabel;

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
    public ChoiceBox<String> tableIdChoiceBox;
    @FXML
    public ChoiceBox<String> tableNameChoiceBox;
    @FXML
    public ChoiceBox<String> tableSurnameChoiceBox;
    @FXML
    public ChoiceBox<String> tableGenderChoiceBox;


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
    private void getIdChoice(ActionEvent event){
        for(DbKlient client : klienci){
            klienciId.add(client.getStringId());
        }
        String value = tableIdChoiceBox.getValue();
        System.out.println(value);
        CriteriaID id = new CriteriaID(value);
        klienciTable.setItems(FXCollections.observableArrayList(id.meetCriteria(klienci)));
    }

    @FXML
    private void getNameChoice(ActionEvent event){
        for(DbKlient client : klienci){
            klienciName.add(client.getImie());
        }
        String value = tableNameChoiceBox.getValue();
        System.out.println(value);
        CriteriaName name = new CriteriaName(value);
        klienciTable.setItems(FXCollections.observableArrayList(name.meetCriteria(klienci)));
    }

    @FXML
    private void getSurnameChoice(ActionEvent event){
        for(DbKlient client : klienci){
            klienciSurname.add(client.getNazwisko());
        }
        String value = tableSurnameChoiceBox.getValue();
        System.out.println(value);
        CriteriaSurname surname = new CriteriaSurname(value);
        klienciTable.setItems(FXCollections.observableArrayList(surname.meetCriteria(klienci)));
    }


    @FXML
    private void getGenderChoice(ActionEvent event){
        for(DbKlient client : klienci){
            klienciGender.add(client.getGender());
        }
        String value = tableGenderChoiceBox.getValue();
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
        tableGenderChoiceBox.getSelectionModel().selectFirst();
        search.setText("");
        klienciTable.setItems(FXCollections.observableArrayList(fullListKlienci));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading user data...");
        klienciTable.setItems(FXCollections.observableArrayList(klienci));
        for(DbKlient client : klienci){
            klienciId.add(client.getStringId());
            klienciName.add(client.getImie());
            klienciSurname.add(client.getNazwisko());
        }
        tableIdChoiceBox.setItems(FXCollections.observableArrayList(klienciId));
        tableNameChoiceBox.setItems(FXCollections.observableArrayList(klienciName));
        tableSurnameChoiceBox.setItems(FXCollections.observableArrayList(klienciSurname));
        tableGenderChoiceBox.setItems(FXCollections.observableArrayList( "Male", "Female"));



    }

}
