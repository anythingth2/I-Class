package UI.Teacher;

import Model.TeachingClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ClassItemPane extends Pane {

    public TeachingClass teachingClass;
    @FXML
    ImageView iconImageView;
    @FXML
    Text dateTextView;
    @FXML
    Text timeTextView;

    @FXML
    Text captureTextView;

    public void setTeachingClass(TeachingClass teachingClass) {
        this.teachingClass = teachingClass;

        this.dateTextView.setText(teachingClass.getDate().toString());

    }

    public ClassItemPane() {
        super();
        try {
            URL url = new File("src/main/java/UI/Teacher/ClassItemPane.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Teacher/ClassItemPane.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ClassItemPane(TeachingClass teachingClass) {
        this();
        this.setTeachingClass(teachingClass);
    }

}
