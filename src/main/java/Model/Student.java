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

    public Student(String fullName, String userid, String pin, List<Course> enrolledCourses) {
        super(fullName, userid, pin);
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public List<Course> getUserCourse() {
        return this.enrolledCourses;
    }

    public List<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
