package sample;

import com.sun.deploy.util.SessionState;
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
import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        URL url = new File("src/main/java/sample/login.fxml").toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("I-ClassRoom");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

//        Scanner reader = new Scanner(System.in);
//        int n = reader.nextInt();
//        reader.close();
//        if(n == 1){
//            url = new File("src/main/java/sample/subject.fxml").toURL();
//            root = FXMLLoader.load(url);
//            primaryStage.setScene(new Scene(root));
//        }
//        System.out.printf("%d", n);
        //LoginController login = new LoginController(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
//        SessionFactory factory;
//        Session session;
//
//        factory = new Configuration().configure().buildSessionFactory();
//        session = factory.openSession();
//        session.beginTransaction();
//        User user = new User("Hello Chai");
//        session.save(user);
//        session.getTransaction().commit();
//        factory.close();
//        System.out.println("Started");


    }
}
