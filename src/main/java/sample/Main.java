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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

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

    private void input(Stage primaryStage) throws IOException {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        reader.close();
        if (n == 1) {
            URL url = new File("src/main/java/sample/subject.fxml").toURL();
            Parent root = FXMLLoader.load(url);
            primaryStage.setScene(new Scene(root));
        }
        System.out.printf("%d", n);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        globalStage = primaryStage;
        showPage("src/main/java/sample/login.fxml");
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
