package Main;

import Model.Model;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

public class Main extends javafx.application.Application {

    private static Application application;

    public static Application getApplication() {
        return application;
    }

    @Override
    public void start(Stage primaryStage) {
        application = new Application(primaryStage);
    }

    public static void main(String[] args) {

        Model.createSession();
        FileStorage.init();
//        FileStorage.upload("555");
//        AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
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
