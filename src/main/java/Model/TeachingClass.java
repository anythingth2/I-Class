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


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }


    public TeachingClass() {
    }

    public TeachingClass(Date date) {
        this.date = date;
    }

    public TeachingClass(Date date, String title) {
        this(date);
        this.title = title;
    }

    public TeachingClass(Date date, Material material) {
        this(date);
        this.material = material;
    }
public TeachingClass(Date date,String title,Material material){
        this(date,title);
        this.material = material;
}
    @Override
    public String toString() {
        return super.toString();
    }
}
