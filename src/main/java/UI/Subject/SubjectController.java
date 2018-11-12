package UI.Subject;

import Model.Course;
import Model.TeachingClass;
import UI.Course.CourseController;
import Main.Main;
import UI.Login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.List;

public class SubjectController extends GridPane {

    @FXML
    private Pane sbj1;
    @FXML
    private Label alias1;
    @FXML
    private Label name1;
    private Course course1;

    @FXML
    private Pane sbj2;
    @FXML
    private Label alias2;
    @FXML
    private Label name2;
    private Course course2;

    @FXML
    private Pane sbj3;
    @FXML
    private Label alias3;
    @FXML
    private Label name3;
    private Course course3;

    @FXML
    private ImageView arwl;
    @FXML
    private ImageView arwr;
    @FXML
    private Button logout;
    private ColorAdjust color = new ColorAdjust();

    private List<Course> courses;
    private int index = 0;


    public SubjectController() {
        super();
        try {
            URL url = new File("src/main/java/UI/Subject/subject.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Subject/subject.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SubjectController(List<Course> courses){
        this();
        this.courses = courses;
        setAllCourseDetail();
        System.out.println("3");
    }

    private void setCourse1Detail(String alias, String name, Course course) {
        alias1.setText(alias);
        name1.setText(name);
        course1 = course;
    }

    private void setCourse2Detail(String alias, String name, Course course) {
        alias2.setText(alias);
        name2.setText(name);
        course2 = course;
    }

    private void setCourse3Detail(String alias, String name, Course course) {
        alias3.setText(alias);
        name3.setText(name);
        course3 = course;
    }

    public void setAllCourseDetail() {
        setCourse1Detail(this.courses.get(index).getAlias(), this.courses.get(index).getName(), this.courses.get(index));
        setCourse2Detail(this.courses.get(index+1).getAlias(), this.courses.get(index+1).getName(), this.courses.get(index+1));
        setCourse3Detail(this.courses.get(index+2).getAlias(), this.courses.get(index+2).getName(), this.courses.get(index+2));
    }

    private void displayBlueShadow(Pane subject) {
        subject.setStyle("-fx-effect: dropshadow(three-pass-box, #0399D8, 30, 0, 0, 0);");
    }

    private void displayBlackShadow(Pane sbj) {
        sbj.setStyle("-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
    }

    @FXML
    private void onSubject1Entered() throws IOException {
        displayBlueShadow(sbj1);
    }

    @FXML
    private void onSubject1Exited() throws IOException {
        displayBlackShadow(sbj1);
    }

    @FXML
    private void onSubject1Clicked() throws IOException {
//        List<TeachingClass> teachingClasses = new ArrayList<TeachingClass>();
//        teachingClasses.add(new TeachingClass(new Date(System.currentTimeMillis())));
//        teachingClasses.add(new TeachingClass(new Date(System.currentTimeMillis())));
//        teachingClasses.add(new TeachingClass(new Date(System.currentTimeMillis())));
//        teachingClasses.add(new TeachingClass(new Date(System.currentTimeMillis())));
//        teachingClasses.add(new TeachingClass(new Date(System.currentTimeMillis())));
//        teachingClasses.add(new TeachingClass(new Date(System.currentTimeMillis())));
//        teachingClasses.add(new TeachingClass(new Date(System.currentTimeMillis())));
//        teachingClasses.add(new TeachingClass(new Date(System.currentTimeMillis())));
//
//        Course course = new Course(teachingClasses);
//        course.setName("OOAD NAJA");
//        course.setAnnouncement("อาจารย์ยงดสอน");
        CourseController courseController = new CourseController(course1);
        Main.getApplicationController().navigateTo(courseController);
    }

    @FXML
    private void onSubject2Entered() throws IOException {
        displayBlueShadow(sbj2);
    }

    @FXML
    private void onSubject2Exited() throws IOException {
        displayBlackShadow(sbj2);
    }

    @FXML
    private void onSubject2Clicked() throws IOException {
        CourseController courseController = new CourseController(course2);
        Main.getApplicationController().navigateTo(courseController);
    }

    @FXML
    private void onSubject3Entered() throws IOException {
        displayBlueShadow(sbj3);
    }

    @FXML
    private void onSubject3Exited() throws IOException {
        displayBlackShadow(sbj3);
    }

    @FXML
    private void onSubject3Clicked() throws IOException {
        CourseController courseController = new CourseController(course3);
        Main.getApplicationController().navigateTo(courseController);
    }

    @FXML
    private void onLeftAction() throws IOException {
        if(this.index > 0) {
            if(this.index-3 == 0) {
                arwl.setVisible(false);
            }
            arwr.setVisible(true);
            this.index -= 3;
            setAllCourseDetail();
        }
    }

    @FXML
    private void onLeftEntered() throws IOException {
        color.setBrightness(-100.0);
        arwl.setEffect(color);
    }

    @FXML
    private void onLeftExited() throws IOException {
        color.setBrightness(0.0);
        arwl.setEffect(color);
    }

    @FXML
    private void onRightAction() throws IOException {
        if(this.index < this.courses.size()) {
            if(this.index+6 >= this.courses.size()) {
                arwr.setVisible(false);
            }
            arwl.setVisible(true);
            this.index += 3;
            setAllCourseDetail();
        }
    }

    @FXML
    private void onRightEntered() throws IOException {
        color.setBrightness(-100.0);
        arwr.setEffect(color);
    }

    @FXML
    private void onRightExited() throws IOException {
        color.setBrightness(0.0);
        arwr.setEffect(color);
    }

    @FXML
    private void onLogoutAction() throws IOException {
        Parent root = new LoginController();
        Main.getApplicationController().navigateTo(root);
    }

    @FXML
    private void onLogoutEntered() throws IOException {
        logout.setStyle("-fx-text-fill: white;");
    }

    @FXML
    private void onLogoutExited() throws IOException {
        logout.setStyle("-fx-text-fill: #0399D8;");
    }

}
