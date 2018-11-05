package Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "curriculum")
public class Curriculum {
    List<Course> courses;

    Curriculum(List<Course> courses) {
        this.courses = courses;
    }
}
