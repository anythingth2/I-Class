package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static ApplicationController applicationController;
    private static Stage globalStage;
    private static Scene scene;

    public static ApplicationController getApplicationController() {
        return applicationController;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        globalStage = primaryStage;
        applicationController = new ApplicationController(primaryStage);


    }

    public static void main(String[] args) {
        launch(args);
    }
}
