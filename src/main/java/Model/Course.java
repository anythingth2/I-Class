package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue
    int id;
    String name;
    String description;

    List<TeachingClass> teachingClasses;

    Course(List<TeachingClass> teachingClasses) {
        this.teachingClasses = teachingClasses;
    }

}
