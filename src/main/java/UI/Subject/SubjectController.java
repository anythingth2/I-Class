package UI.Subject;

import Main.Main;
import Model.Course;
import UI.Controller;
import UI.Course.CourseController;
import UI.Login.LoginController;
import javafx.scene.Node;

import java.util.List;

public class SubjectController implements Controller {

    SubjectPage subjectPage;
    List<Course> courses;

    @Override
    public Node getRoot() {
        return this.subjectPage;
    }

    public SubjectController(List<Course> courses) {
        super();
        this.courses = courses;

        this.subjectPage = new SubjectPage(this, this.courses);
    }

    public void selectCourse(Course course) {
        Main.getApplicationController().navigateTo(new CourseController(course));
    }

    public void logout() {
        Main.getApplicationController().navigateTo(new LoginController());
    }
}
