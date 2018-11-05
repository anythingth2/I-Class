package Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "classes")
public class TeachingClass {
    String title;
    Date date;

    Course course;
    Material material;
    Homework homework;

    TeachingClass(Material material) {
        this.material = material;
    }

}
