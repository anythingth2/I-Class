package UI.Login;


import Main.Main;
import Main.MockData;
import Model.*;
import UI.Subject.SubjectController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javax.lang.model.type.NullType;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginController extends GridPane {
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
    private Label inc_data;

    public LoginController() {
        super();
        try {
            URL url = new File("src/main/java/UI/Login/login.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Login/login.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validateUserLogin() {
//--------------------------------------------- Moc data for test ---------------------------------------------
        List<User> users = MockData.users;
//-------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < users.size(); i++) {
            if (this.userid.getText().equals(users.get(i).getUserid()) && this.pin.getText().equals(users.get(i).getPin())) {
                Main.getApplicationController().setUser(users.get(i)); // Set user in applicationController
                Parent root = new SubjectController(users.get(i).getUserCourse()); // Change page
                Main.getApplicationController().navigateTo(root);
            } else {
                this.inc_data.setVisible(true);
            }
        }
    }

    @FXML
    private void onLoginAction() throws IOException {
        boolean pass = true;
        if (this.userid.getText().trim().isEmpty()) {
            this.inc_userid.setVisible(true);
            pass = false;
        }
        if (this.pin.getText().trim().isEmpty()) {
            this.inc_pin.setVisible(true);
            pass = false;
        }
        if (pass) {
            validateUserLogin();
        }
    }

    @FXML
    private void onLoginEntered() throws IOException {
        this.login.setStyle("-fx-background-color: #0399D8;");

    }

    @FXML
    private void onLoginExited() throws IOException {
        this.login.setStyle("-fx-background-color: #2275A0;");
    }

    @FXML
    private void onLoginPressed() throws IOException {
        this.login.setStyle("-fx-background-color: #2275A0;");
    }

    @FXML
    private void onLoginReleased() throws IOException {
        this.login.setStyle("-fx-background-color: #0399D8;");
    }

    @FXML
    private void onIdAction() throws IOException {
        if (this.inc_userid.isVisible() == true) {
            this.inc_userid.setVisible(false);
        }
        this.inc_data.setVisible(false);
    }

    @FXML
    private void onPinAction() throws IOException {
        if (this.inc_pin.isVisible() == true) {
            this.inc_pin.setVisible(false);
        }
        this.inc_data.setVisible(false);
    }
}
