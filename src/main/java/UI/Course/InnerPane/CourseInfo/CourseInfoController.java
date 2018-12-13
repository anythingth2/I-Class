package UI.Course.InnerPane.CourseInfo;

import Model.Course;
import UI.Controller;
import javafx.scene.Node;

public class CourseInfoController implements Controller {
    CourseInfoPage courseInfoPage;
    Course course;

    @Override
    public Node getRoot() {
        return courseInfoPage;
    }

    public CourseInfoController(Course course) {
        super();
        this.course = course;
        this.courseInfoPage = new CourseInfoPage(this, course);
    }
}
