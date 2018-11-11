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
    String fullName;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TeachingClass> getTeachingClasses() {
        return teachingClasses;
    }

    public void setTeachingClasses(List<TeachingClass> teachingClasses) {
        this.teachingClasses = teachingClasses;
    }

    List<TeachingClass> teachingClasses;

    public Course() {
    }

    public Course(String name) {

    }

    public Course(List<TeachingClass> teachingClasses) {
        this.teachingClasses = teachingClasses;
    }

}
