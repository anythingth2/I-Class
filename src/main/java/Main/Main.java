package Main;

import Model.Course;
import Model.Model;
import Model.Student;
import Model.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

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
//        Transaction tx = session.beginTransaction();
        Model.createSession();
//        User test = new Student("มยูวววว","3333","1234");
//        test.save();
//        List<Course> courses = new ArrayList<Course>();
//        courses.add(new Course("Object Oriented A & D", "OOAD", "0000000000", "This subject ...", "annaaaaa!!!"));
//        ((Student) test).setEnrolledCourses(courses);
//        session.saveOrUpdate(test);
//        tx.commit();

        launch(args);
    }
}
