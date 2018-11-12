package Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "classes")
public class TeachingClass {
    private String title;
    private Date date;

    private Course course;
    private Material material;
    private Homework homework;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public TeachingClass() {
    }

    public TeachingClass(Date date) {
        this.date = date;
    }

    public TeachingClass(Material material) {
        this.material = material;
    }

    public TeachingClass(Material material, Homework homework) {
        this(material);
        this.homework = homework;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
