package UI.Teacher;

import Model.Material;
import Model.TeachingClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.Date;

public class TeacherHomeController {
    @FXML
    VBox classVBox;
    @FXML
    ScrollPane scrollPane;
    @FXML
    Button button;

    public TeacherHomeController() {
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