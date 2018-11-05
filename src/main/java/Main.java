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
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File("src/main/java/UI/Login/login.fxml").toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("I-ClassRoom");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
        SessionFactory factory;
        Session session;

        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        User user = new User("ChiChaCdadhai");
        session.save(user);
        session.getTransaction().commit();
        factory.close();
        System.out.println("Started");
    }
}
