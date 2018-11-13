package UI.Course.InnerPane.CourseInfo;

import Model.Course;
import Model.TeachingClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;

public class CourseInfoPane extends Pane {
    private Course course;


    public CourseInfoPane() {
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

    public CourseInfoPane(Course course) {
        this();
        this.course = course;
    }
}