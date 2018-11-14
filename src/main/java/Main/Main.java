package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Main.HibernateUtil;
import org.hibernate.Session;

public class Main extends Application {

    private static ApplicationController applicationController;
    private static Stage globalStage;
    private static Scene scene;
    private static Session session;

    public static ApplicationController getApplicationController() {
        return applicationController;
    }

    @Override
    public void start(Stage primaryStage) {
        globalStage = primaryStage;
        applicationController = new ApplicationController(primaryStage);
    }

    public static void main(String[] args) {
        // Initial and update DB
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
        launch(args);
    }
}
