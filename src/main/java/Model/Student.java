package Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends User {


    List<Course> enrolledCourses;

}
