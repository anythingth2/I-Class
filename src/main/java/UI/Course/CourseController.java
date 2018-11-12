package UI.Course;

import Main.Main;
import Model.Course;
import Model.Teacher;
import Model.TeachingClass;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseController extends AnchorPane {

    @FXML
    Label courseNameTextView;
    @FXML
    Button editAnnouncementButton;
    @FXML
    Label announcementLabel;
    @FXML
    Label titleLabel;
    @FXML
    private VBox classVBox;
    private List<ClassItemPane> classItemPanes = new ArrayList<ClassItemPane>();
    @FXML
    private ScrollPane scrollPane;

    @FXML
    Pane teachingClassPane;

    private Course course;
    private List<TeachingClass> teachingClasses;


    public CourseController() {
        super();
        try {
            URL url = new File("src/main/java/UI/Course/Course.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Course/Course.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CourseController(Course course) {
        this();
        this.course = course;
        this.teachingClasses = course.getTeachingClasses();
        this.announcementLabel.setText(course.getAnnouncement());
        this.courseNameTextView.setText(this.course.getName());
        this.titleLabel.setText(this.course.getName());

        for (final TeachingClass teachingClass : this.teachingClasses) {
            ClassItemPane classItemPane = new ClassItemPane(teachingClass);
            classItemPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    setTeachingClassPane(teachingClass);
                }
            });
            classItemPanes.add(classItemPane);
        }

        boolean isTeacher = Main.getApplicationController().getUser() instanceof Teacher;
        editAnnouncementButton.setVisible(isTeacher);
        refresh();
    }

    private void refresh() {
        this.classVBox.getChildren().clear();
        for (ClassItemPane classItemPane : this.classItemPanes) {
            this.classVBox.getChildren().add(classItemPane);
        }
    }


    private void setTeachingClassPane(TeachingClass teachingClass) {

        if (this.teachingClassPane.getChildren().size() > 1) {

        }else{

        }
    }
}