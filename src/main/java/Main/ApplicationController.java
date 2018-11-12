package Main;

import Model.User;
import UI.Subject.SubjectController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationController {

    private Stage stage;
    private Scene scene;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ApplicationController(Stage stage) {
        this.stage = stage;

        initialize();
    }

    private void initialize() {
        Parent root = new SubjectController();
        this.scene = new Scene(root);
        this.stage.setScene(scene);
//        this.stage.setFullScreen(true);
        this.stage.setResizable(false);
        this.stage.show();
    }

    public void navigateTo(Parent root) {
        if (scene == null)
            scene = new Scene(root);
        else
            scene.setRoot(root);
    }
}
