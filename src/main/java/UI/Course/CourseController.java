package UI.Course;

import Model.TeachingClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public class CourseController extends AnchorPane {

    @FXML
    private VBox classVBox;
    private List<ClassItemPane> classItemPanes = new ArrayList<ClassItemPane>();
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button button;

    private List<TeachingClass> teachingClasses;


    public CourseController() {
        super();
        try {
            URL url = new File("src/main/java/UI/Teacher/Course.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Teacher/Course.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CourseController(List<TeachingClass> teachingClasses) {
        this();
        this.teachingClasses = teachingClasses;
        for (TeachingClass teachingClass : this.teachingClasses) {
            ClassItemPane classItemPane = new ClassItemPane(teachingClass);

            classItemPanes.add(classItemPane);
            this.classVBox.getChildren().add(classItemPane);
        }
    }

    private void refresh() {
        this.classVBox.getChildren().clear();
        for (ClassItemPane classItemPane : this.classItemPanes) {
            this.classVBox.getChildren().add(classItemPane);
        }
    }

    @FXML
    void onAddClick() {
        System.out.println("clicked");
        TeachingClass teachingClass = new TeachingClass();
        teachingClass.setDate(new Date(System.currentTimeMillis()));
        ClassItemPane child = new ClassItemPane(teachingClass);

        this.classVBox.getChildren().add(child);

    }
}