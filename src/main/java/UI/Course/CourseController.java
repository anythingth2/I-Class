package UI.Course;

import Model.TeachingClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.util.Date;

public class CourseController {

    @FXML
    VBox classVBox;
    @FXML
    ScrollPane scrollPane;
    @FXML
    Button button;

    public CourseController() {
        super();
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