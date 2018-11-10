package Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ApplicationController {

    public enum Resource {
        Login("/UI/Login/login.fxml"),
        Subject("/UI/Subject/subject.fxml"),
        Course("/UI/Course/course.fxml"),
        Teacher("/UI/Teacher/TeacherHome.fxml");
        String source = "src/main/java";
        String path;

        Resource(String path) {
            this.path = path;
        }

        public String getResourcePath() {
            return source + path;
        }

        public Parent getRoot() {

            File file = new File(this.getResourcePath());
            Parent root;
            try {

                root = FXMLLoader.load(file.toURL());
            } catch (IOException e) {
                root = null;
                e.printStackTrace();
            }
            return root;
        }

        @Override
        public String toString() {
            return this.getResourcePath();
        }
    }

    private Stage stage;
    private Scene scene;


    public ApplicationController(Stage stage, Resource resource) {
        this.stage = stage;
        initialize(resource);
    }

    private void initialize(Resource resource) {
        this.scene = new Scene(resource.getRoot());
        this.stage.setScene(scene);
        this.stage.setFullScreen(true);
        this.stage.show();
    }

    public void navigateTo(Resource resource) {
        Parent root = resource.getRoot();
        if (scene == null)
            scene = new Scene(root);
        else
            scene.setRoot(root);
    }
}
