package Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "students")
public class Student extends User {
    private List<Course> enrolledCourses;

    public Student(String fullName) {
        super(fullName);
    }

    public Student(String fullName, List<Course> enrolledCourses) {
        super(fullName);
        this.enrolledCourses = enrolledCourses;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
