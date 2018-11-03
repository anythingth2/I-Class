package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;

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
        Session session;

        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        User user = new User("Hello Chai");
        session.save(user);
        session.getTransaction().commit();
        factory.close();
        System.out.println("Started");


    }
}
