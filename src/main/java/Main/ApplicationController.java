package Main;

import UI.Login.LoginController;
import UI.Subject.SubjectController;
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
        Teacher("/UI/Course/Course.fxml"),
        Dialog("/UI/Dialog/callDialog.fxml");
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

    public ApplicationController(Stage stage) {
        this.stage = stage;

        initialize();
    }

    private void initialize() {
        Parent root = new SubjectController();
        this.scene = new Scene(root);
        this.stage.setScene(scene);
        //this.stage.setFullScreen(true);
        this.stage.show();
    }

    public void navigateTo(Parent root) {
//        Parent root = resource.getRoot();
        if (scene == null)
            scene = new Scene(root);
        else
            scene.setRoot(root);
    }
}
