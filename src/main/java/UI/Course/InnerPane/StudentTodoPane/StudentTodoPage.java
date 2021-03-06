package UI.Course.InnerPane.StudentTodoPane;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;

public class StudentTodoPage extends Pane {
    public StudentTodoPage() {
        super();
        try {
            URL url = new File("src/main/java/UI/Course/InnerPane/StudentTodoPage/StudentTodoPage.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Course/InnerPane/StudentTodoPane/StudentTodoPane.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
