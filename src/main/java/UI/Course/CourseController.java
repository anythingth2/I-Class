package UI.Course;

import Main.Main;
import Model.Course;
import Model.Teacher;
import Model.TeachingClass;
import UI.Course.InnerPane.CourseInfo.CourseInfoPane;
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
    private Label courseNameTextView;
    @FXML
    private Button editAnnouncementButton;
    @FXML
    private Label announcementLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private VBox classVBox;
    private List<ClassItemPane> classItemPanes = new ArrayList<ClassItemPane>();
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Pane teachingClassPane;

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


            if (teachingClass.getMaterial() != null) {
                ClassItemPane classItemPane = new ClassItemPane(teachingClass,
                        teachingClass.getMaterial());
                classItemPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                    }
                });
                classItemPanes.add(classItemPane);
            }
            if (teachingClass.getHomework() != null) {
                ClassItemPane classItemPane = new ClassItemPane(teachingClass,
                        teachingClass.getHomework());
                classItemPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                    }
                });
                classItemPanes.add(classItemPane);
            }

        }

        boolean isTeacher = Main.getApplicationController().getUser() instanceof Teacher;
        this.editAnnouncementButton.setVisible(isTeacher);

        this.setTeachingClassPane(new CourseInfoPane(this.course));
        this.refresh();
    }

    private void refresh() {
        this.classVBox.getChildren().clear();
        for (ClassItemPane classItemPane : this.classItemPanes) {
            this.classVBox.getChildren().add(classItemPane);
        }
    }


    private void setTeachingClassPane(Pane pane) {
        if (this.teachingClassPane.getChildren().size() > 1) {
            this.teachingClassPane.getChildren().set(0, pane);
        } else {
            this.teachingClassPane.getChildren().add(0, pane);
        }
    }
}