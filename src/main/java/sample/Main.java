package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
//        primaryStage.setTitle("I-ClassRoom");
//        primaryStage.setScene(new Scene(root, 1920, 1080));
//        primaryStage.show();
    }


    public static void main(String[] args) {
//        launch(args);
        SessionFactory factory;
        try {
            factory=  new Configuration().configure().buildSessionFactory();
            factory.close();
        } catch (Throwable ex) {
            System.out.println("failed");
        }

    }
}
