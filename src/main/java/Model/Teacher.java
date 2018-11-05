package Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "teachers")
public class Teacher extends User {
    List<Course> ownCourses;
}
