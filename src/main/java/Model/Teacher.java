package Model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Teacher extends User {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> ownCourses;

    public Teacher() {
    }

    public Teacher(String fullName) {
        super(fullName);
    }

    public Teacher(String fullName, List<Course> ownCourses) {
        super(fullName);
        this.ownCourses = ownCourses;
    }

    public Teacher(String fullName, String userid, String pin, List<Course> ownCourses) {
        super(fullName, userid, pin);
        this.ownCourses = ownCourses;
    }


    @Override
    public List<Course> getUserCourse() {
        return this.ownCourses;
    }

    public List<Course> getOwnCourses() {
        return this.ownCourses;
    }

    public void setOwnCourses(List<Course> ownCourses) {
        this.ownCourses = ownCourses;
    }
}
