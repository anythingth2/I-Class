package UI.Login;

import Main.Main;
import UI.Subject.SubjectController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
            List<String> names = new ArrayList<String>();
            Parent root = new SubjectController();
            Main.getApplicationController().navigateTo(root);
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
