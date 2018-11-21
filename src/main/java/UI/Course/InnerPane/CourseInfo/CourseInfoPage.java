package UI.Course.InnerPane.CourseInfo;

import Model.Course;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.File;
import java.net.URL;

public class CourseInfoPage extends Pane {
    @FXML
    private TextFlow filename;

    @FXML
    private Label idLabel;

    @FXML
    private Label englishNameLabel;

    @FXML
    private Label thaiNameLabel;

    @FXML
    private Text descriptionText;

    private CourseInfoController controller;

    public CourseInfoPage() {
        super();
        try {
            URL url = new File("src/main/java/UI/Course/InnerPane/CourseInfo/CourseInfo.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Course/InnerPane/CourseInfo/CourseInfo.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CourseInfoPage(CourseInfoController controller, Course course) {
        this();
        this.controller = controller;
        this.setCourse(course);
    }

    void setCourse(Course course) {
        this.idLabel.setText(course.getCodenumber() != null ? course.getCodenumber() : "-");
        this.thaiNameLabel.setText(course.getName() != null ? course.getName() : "-");
        this.englishNameLabel.setText(course.getName() != null ? course.getName() : "-");
        this.descriptionText.setText(course.getName() != null ? course.getDescription() : "-");
    }
}