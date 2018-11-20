package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends User {
    @OneToMany(cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<Course> enrolledCourses;

    public Student() {
    }

    public Student(String fullName, String userid, String pin) {
        super(fullName, userid, pin);
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
