package UI.Login;

import Main.Main;
import Model.Course;
import Model.Student;
import Model.Teacher;
import Model.TeachingClass;
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
//--------------------------------------------- Moc data for test ---------------------------------------------
//            List<String> names = new ArrayList<String>();
//            Main.getApplicationController().setUser(new Student());
            List<Course> courses = new ArrayList<Course>();
            courses.add(new Course("Object Oriented A & D", "OOAD", "0000000000", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
            courses.add(new Course("Comp Arch", "CA", "0000000001", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
            courses.add(new Course("Software End", "SE", "0000000002", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
            courses.add(new Course("Comp Net", "CN", "0000000003", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
            courses.add(new Course("Foundation Eng", "FE", "0000000004", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
            courses.add(new Course("Infomation Retrieval", "IR", "0000000005", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
            courses.add(new Course("Micro Robot", "MR", "0000000006", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
            courses.add(new Course("Operation System", "OS", "0000000007", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));
            courses.add(new Course("Compiler Comp", "CC", "0000000008", "-", "annaaaaa!!!", new ArrayList<TeachingClass>(1)));

            Student exstudent = new Student("Example Mocstudent");
            exstudent.setUserid("1234567890");
            exstudent.setPin("1234567890");
            exstudent.setEnrolledCourses(courses);
            Main.getApplicationController().setUser(exstudent);
//-------------------------------------------------------------------------------------------------------------

            if( userid.getText().equals(exstudent.getUserid()) && pin.getText().equals(exstudent.getPin())) {
                Parent root = new SubjectController(exstudent.getEnrolledCourses()); // Pass moc data
//            Parent root = new SubjectController();
                Main.getApplicationController().navigateTo(root);
            }
            else if(userid.getText().equals(exstudent.getUserid())) {
                inc_pin.setVisible(true);
            }
            else{
                inc_userid.setVisible(true);
            }
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
        }
    }

    @FXML
    private void onPinAction() throws IOException {
        if (inc_pin.isVisible() == true) {
            inc_pin.setVisible(false);
        }
    }
}
