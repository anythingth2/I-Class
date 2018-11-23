package Main;

import Model.Model;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

public class Main extends javafx.application.Application {

    private static Application application;
    private static Stage globalStage;
    private static Scene scene;
    private static Session session;

    public static Application getApplication() {
        return application;
    }

    @Override
    public void start(Stage primaryStage) {
        globalStage = primaryStage;
        application = new Application(primaryStage);
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
