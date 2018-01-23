package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginView extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        primaryStage.setTitle("MyGym Login");
        primaryStage.setScene(new Scene(root, 500, 350));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}