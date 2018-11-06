package Main;

import Model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    private static Stage globalStage;

    public static Stage getGlobalStage(){
        return globalStage;
    }

    public static void showPage(String pathname) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource(pathname));
        URL url = new File(pathname).toURL();
        Parent root = FXMLLoader.load(url);
        globalStage.setTitle("I-ClassRoom");
        globalStage.setScene(new Scene(root));
        globalStage.setFullScreen(true);
        globalStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        globalStage = primaryStage;
        showPage("src/main/java/UI/Login/login.fxml");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
