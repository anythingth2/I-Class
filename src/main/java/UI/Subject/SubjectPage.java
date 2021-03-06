package UI.Subject;

import Model.Course;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class SubjectPage extends GridPane {

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

    private SubjectController subjectController;
    private List<Course> courses;
    private int index = 0;


    private SubjectPage() {
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

    public SubjectPage(SubjectController controller, List<Course> courses) {
        this();
        this.subjectController = controller;
        this.courses = courses;
        setAllCourseDetail();
    }

    public void setAllCourseDetail() {
        try {
            setCourse1Detail(courses.get(this.index).getAlias(), courses.get(this.index).getName(), courses.get(this.index));
            setCourse1Visible(true);
        } catch (Exception e) {
            setCourse1Visible(false);
        }
        try {
            setCourse2Detail(courses.get(this.index + 1).getAlias(), courses.get(this.index + 1).getName(), courses.get(this.index + 1));
            setCourse2Visible(true);
        } catch (Exception e) {
            setCourse2Visible(false);
        }
        try {
            setCourse3Detail(courses.get(this.index + 2).getAlias(), courses.get(this.index + 2).getName(), courses.get(this.index + 2));
            setCourse3Visible(true);
        } catch (Exception e) {
            setCourse3Visible(false);
        }
        if(courses.size() < 3){
            arwr.setVisible(false);
        }
    }

    private void setCourse1Detail(String alias, String name, Course course) {
        this.alias1.setText(alias);
        this.name1.setText(name);
        this.course1 = course;
    }

    private void setCourse2Detail(String alias, String name, Course course) {
        this.alias2.setText(alias);
        this.name2.setText(name);
        this.course2 = course;
    }

    private void setCourse3Detail(String alias, String name, Course course) {
        this.alias3.setText(alias);
        this.name3.setText(name);
        this.course3 = course;
    }

    private void setCourse1Visible(boolean mode) {
        this.sbj1.setVisible(mode);
        this.alias1.setVisible(mode);
        this.name1.setVisible(mode);
    }

    private void setCourse2Visible(boolean mode) {
        this.sbj2.setVisible(mode);
        this.alias2.setVisible(mode);
        this.name2.setVisible(mode);
    }

    private void setCourse3Visible(boolean mode) {
        this.sbj3.setVisible(mode);
        this.alias3.setVisible(mode);
        this.name3.setVisible(mode);
    }


    private void displayBlueShadow(Pane subject) {
        subject.setStyle("-fx-effect: dropshadow(three-pass-box, #0399D8, 30, 0, 0, 0);");
    }

    private void displayBlackShadow(Pane sbj) {
        sbj.setStyle("-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
    }

    @FXML
    private void onSubject1Entered() throws IOException {
        displayBlueShadow(this.sbj1);
    }

    @FXML
    private void onSubject1Exited() throws IOException {
        displayBlackShadow(this.sbj1);
    }

    @FXML
    private void onSubject1Clicked() throws IOException {
        this.onSelectCourse(this.course1);
    }

    @FXML
    private void onSubject2Entered() throws IOException {
        displayBlueShadow(this.sbj2);
    }

    @FXML
    private void onSubject2Exited() throws IOException {
        displayBlackShadow(this.sbj2);
    }

    @FXML
    private void onSubject2Clicked() throws IOException {
        this.onSelectCourse(this.course2);
    }

    @FXML
    private void onSubject3Entered() throws IOException {
        displayBlueShadow(this.sbj3);
    }

    @FXML
    private void onSubject3Exited() throws IOException {
        displayBlackShadow(this.sbj3);
    }

    @FXML
    private void onSubject3Clicked() throws IOException {
        this.onSelectCourse(this.course3);
    }

    @FXML
    private void onLeftAction() throws IOException {
        if (this.index > 0) {
            if (this.index - 3 == 0) {
                this.arwl.setVisible(false);
            }
            this.arwr.setVisible(true);
            this.index -= 3;
            setAllCourseDetail();
        }
    }

    @FXML
    private void onLeftEntered() throws IOException {
        this.color.setBrightness(-100.0);
        this.arwl.setEffect(this.color);
    }

    @FXML
    private void onLeftExited() throws IOException {
        this.color.setBrightness(0.0);
        this.arwl.setEffect(this.color);
    }

    @FXML
    private void onRightAction() throws IOException {
        if (this.index < this.courses.size()) {
            if (this.index + 6 >= this.courses.size()) {
                this.arwr.setVisible(false);
            }
            this.arwl.setVisible(true);
            this.index += 3;
            setAllCourseDetail();
        }
    }

    @FXML
    private void onRightEntered() throws IOException {
        this.color.setBrightness(-100.0);
        this.arwr.setEffect(this.color);
    }

    @FXML
    private void onRightExited() throws IOException {
        this.color.setBrightness(0.0);
        this.arwr.setEffect(this.color);
    }

    @FXML
    private void onLogoutAction() throws IOException {
        this.subjectController.logout();
    }

    @FXML
    private void onLogoutEntered() throws IOException {
        this.logout.setStyle("-fx-text-fill: white;");
    }

    @FXML
    private void onLogoutExited() throws IOException {
        this.logout.setStyle("-fx-text-fill: #0399D8");
    }

    private void onSelectCourse(Course course) {
        this.subjectController.selectCourse(course);
    }


}
