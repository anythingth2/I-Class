package UI.Course.InnerPane.CourseInfo;

import Model.Course;
import UI.Controller;
import javafx.scene.Node;

public class CourseInfoController implements Controller {
    CourseInfoPane courseInfoPane;
    Course course;

    @Override
    public Node getRoot() {
        return courseInfoPane;
    }

    public CourseInfoController(Course course) {
        super();
        this.course = course;
        this.courseInfoPane = new CourseInfoPane(this, course);
    }
}
