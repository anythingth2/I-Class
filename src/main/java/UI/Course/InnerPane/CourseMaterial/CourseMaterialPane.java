package UI.Course.InnerPane.CourseMaterial;

import Model.TeachingClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;

public class CourseMaterialPane extends Pane {
    private TeachingClass teachingClass;

    public CourseMaterialPane() {
        super();
        try {
            URL url = new File("src/main/java/UI/Course/InnerPane/CourseMaterial/CourseMaterial.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Course/InnerPane/CourseMaterial/CourseMaterial.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CourseMaterialPane(TeachingClass teachingClass) {
        this();
        this.teachingClass = teachingClass;
    }
}
