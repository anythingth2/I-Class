package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    private static ApplicationController applicationController;
    private static Stage globalStage;
    private static Scene scene;

    //    public static Stage getGlobalStage() {
//        return globalStage;
//    }
    public static ApplicationController getApplicationController() {
        return applicationController;
    }

//    public static void showPage(String pathname) throws IOException {
////        Parent root = FXMLLoader.load(getClass().getResource(pathname));
//        URL url = new File(pathname).toURL();
//        Parent root = FXMLLoader.load(url);
//        if (scene == null)
//            scene = new Scene(root);
//        else
//            scene.setRoot(root);
//        globalStage.setTitle("I-ClassRoom");
//        globalStage.setScene(scene);
////        globalStage.setFullScreen(true);
////        globalStage.show();
//    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        globalStage = primaryStage;
        applicationController = new ApplicationController(primaryStage, ApplicationController.Resource.Teacher);


    }

    public static void main(String[] args) {
        launch(args);
    }
}
