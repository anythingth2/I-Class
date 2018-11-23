package UI.Login;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LoginPage extends GridPane {

    private LoginController controller;
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

    private LoginPage() {
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

    public LoginPage(LoginController controller) {
        this();
        this.controller = controller;
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
            boolean result = this.controller.validateUserLogin(this.userid.getText(), this.pin.getText());
            this.inc_data.setVisible(!result);
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
