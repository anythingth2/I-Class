package UI.Course;

import Model.Homework;
import Model.Material;
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
import java.text.SimpleDateFormat;

public class ClassItemPane extends Pane {

    public TeachingClass teachingClass;

    @FXML
    ImageView iconImageView;
    @FXML
    Text dateTextView;
    @FXML
    Text timeTextView;

    @FXML
    Text chapterTextView;

    private void setTeachingClass(TeachingClass teachingClass) {
        this.teachingClass = teachingClass;

        this.dateTextView.setText(new SimpleDateFormat("dd/mm/yyyy")
                .format(teachingClass.getDate()));
        this.timeTextView.setText(new SimpleDateFormat("hh:mm")
                .format(teachingClass.getDate()));

    }

    public ClassItemPane() {
        super();
        try {
            URL url = new File("src/main/java/UI/Course/ClassItemPane.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Course/ClassItemPane.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClassItemPane(TeachingClass teachingClass, Material material) {
        this();
        this.setTeachingClass(teachingClass);
        this.chapterTextView.setText(material.getTitle());
    }

    public ClassItemPane(TeachingClass teachingClass, Homework homework) {
        this();
        this.setTeachingClass(teachingClass);
        this.chapterTextView.setText(homework.getTitle());
    }
}
