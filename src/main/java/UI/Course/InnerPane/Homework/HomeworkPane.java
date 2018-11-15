package UI.Course.InnerPane.Homework;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;

public class HomeworkPane extends ScrollPane {
    public HomeworkPane() {
        super();
        try {
            URL url = new File("src/main/java/UI/Course/InnerPane/Homework/Homework.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Course/InnerPane/Homework/Homework.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
