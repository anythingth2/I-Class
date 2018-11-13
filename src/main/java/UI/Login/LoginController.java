package UI.Login;

import Main.Main;
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

    private void validateUserLogin(){
//--------------------------------------------- Moc data for test ---------------------------------------------
        List<Course> courses = new ArrayList<Course>();
        Course mockCourse = new Course("Object Oriented A & D", "OOAD", "0000000000", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1));
        mockCourse.getTeachingClasses().add(new TeachingClass(new Date(System.currentTimeMillis()), new Material("Introduction"), new Homework("What is OOAD")));
        mockCourse.getTeachingClasses().add(new TeachingClass(new Date(System.currentTimeMillis()), new Material("Use case")));

        courses.add(mockCourse);
        courses.add(new Course("Comp Arch", "CA", "0000000001", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Software End", "SE", "0000000002", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Comp Net", "CN", "0000000003", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Foundation Eng", "FE", "0000000004", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Infomation Retrieval", "IR", "0000000005", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Micro Robot", "MR", "0000000006", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Operation System", "OS", "0000000007", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
        courses.add(new Course("Compiler Comp", "CC", "0000000008", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));

        List<User> users = new ArrayList<User>(10);
        users.add(new Student("Example Student1", "001", "001", courses));
        users.add(new Student("Example Student2", "002", "002", courses));
        users.add(new Student("Example Student3", "003", "003", courses));
        users.add(new Teacher("Example Teacher1", "004", "004", courses));
        users.add(new Teacher("Example Teacher2", "005", "005", courses));
//-------------------------------------------------------------------------------------------------------------
        for(int i=0; i<users.size(); i++) {
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
