package Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "homeworks")
public class Homework {
    String title;
    String description;

    Date startDate;
    Date dueDate;

    Material material;
    List<WorkFile> workFiles;

    TeachingClass teachingClass;

    Homework(TeachingClass teachingClass) {
        this.teachingClass = teachingClass;
    }
}
