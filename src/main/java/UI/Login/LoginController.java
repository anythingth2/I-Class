package UI.Login;

import Main.ApplicationController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import Main.Main;

public class LoginController {
    @FXML
    private TextField userid;
    @FXML
    private TextField pin;
    @FXML
    private Button login;
    @FXML
    private Label inc_userid;
    @FXML
    private Label inc_pin;

    @FXML
    private void onLoginAction() throws IOException {
        boolean pass = true;
        if (userid.getText().trim().isEmpty()) {
            inc_userid.setVisible(true);
            pass = false;
        }
        if (pin.getText().trim().isEmpty()) {
            inc_pin.setVisible(true);
            pass = false;
        }
        if (pass) {
//            Main.showPage("src/main/java/UI/Subject/subject.fxml");
//            Main.showPage("src/main/java/UI/Course/course.fxml");
            Main.getApplicationController().navigateTo(ApplicationController.Resource.Subject);
//            Main.showPage("src/main/java/UI/Teacher/TeacherHome.fxml");
        }
    }

    @FXML
    private void onLoginEntered() throws IOException {
        login.setStyle("-fx-background-color: #0399D8;");
    }

    @FXML
    private void onLoginExited() throws IOException {
        login.setStyle("-fx-background-color: #2275A0;");
    }

    @FXML
    private void onLoginPressed() throws IOException {
        login.setStyle("-fx-background-color: #2275A0;");
    }

    @FXML
    private void onLoginReleased() throws IOException {
        login.setStyle("-fx-background-color: #0399D8;");
    }

    @FXML
    private void onIdAction() throws IOException {
        if (inc_userid.isVisible() == true) {
            inc_userid.setVisible(false);
            userid.setText("");
        }
    }

    @FXML
    private void onPinAction() throws IOException {
        if (inc_pin.isVisible() == true) {
            inc_pin.setVisible(false);
            pin.setText("");
        }
    }
}
