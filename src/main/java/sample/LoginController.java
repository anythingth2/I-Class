package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginController {
    @FXML private TextField userid;
    @FXML private TextField pin;
    @FXML private Button login;

//    public LoginController(Stage primaryStage) throws IOException {
//
//    }

    @FXML private void onLoginAction() throws IOException {
        boolean pass = true;
        if(userid.getText().trim().isEmpty() || userid.getStyle() == "-fx-text-fill: red;"){
            userid.setStyle("-fx-text-fill: red;");
            userid.setText("Incorrect ID!");
            pass = false;
        }
        if(pin.getText().trim().isEmpty() || pin.getStyle() == "-fx-text-fill: red;"){
            pin.setStyle("-fx-text-fill: red;");
            pin.setText("Incorrect pin!");
            pass = false;
        }
        if(pass){
//            URL url = new File("src/main/java/sample/view/subject.fxml").toURL();
//            Parent root = FXMLLoader.load(url);
//            primaryStage.setTitle("I-ClassRoom");
//            primaryStage.setScene(new Scene(root, 1366, 768));
//            primaryStage.show();
//            ScreenController screenController = new ScreenController(scene);
//            screenController.add("I-ClassRoom", FXMLLoader.load(getClass().getResource( "subject.fxml" )));
//            screenController.activate("I-ClassRoom");
        }
    }
    @FXML private void onLoginEntered() throws IOException {
        login.setStyle("-fx-background-color: #0399D8;");
    }
    @FXML private void onLoginExited() throws IOException {
        login.setStyle("-fx-background-color: #2275A0;");
    }
    @FXML private void onLoginPressed() throws IOException {
        login.setStyle("-fx-background-color: #2275A0;");
    }
    @FXML private void onLoginReleased() throws IOException {
        login.setStyle("-fx-background-color: #0399D8;");
    }

    @FXML private void onIdAction() throws IOException {
        if(userid.getStyle() == "-fx-text-fill: red;"){
            userid.setStyle("-fx-text-fill: white;");
            userid.setText("");
        }
    }

    @FXML private void onPinAction() throws IOException {
        if(pin.getStyle() == "-fx-text-fill: red;"){
            pin.setStyle("-fx-text-fill: white;");
            pin.setText("");
        }
    }
}
