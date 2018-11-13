package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue
    int id;
    String name;
    String alias;
    String codenumber;
    String description;
    String announcement;
    List<TeachingClass> teachingClasses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCodenumber() {
        return codenumber;
    }

    public void setCodenumber(String codenumber) {
        this.codenumber = codenumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TeachingClass> getTeachingClasses() {
        if (this.teachingClasses == null) this.teachingClasses = new ArrayList<TeachingClass>();
        return teachingClasses;
    }

    public void setTeachingClasses(List<TeachingClass> teachingClasses) {

        this.teachingClasses = teachingClasses;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public Course(List<TeachingClass> teachingClasses) {
        this.teachingClasses = teachingClasses;
    }

    public Course(String name, String alias, String codenumber, String description, String announcement, List<TeachingClass> teachingClasses) {
        this.name = name;
        this.alias = alias;
        this.codenumber = codenumber;
        this.description = description;
        this.announcement = announcement;
        this.teachingClasses = teachingClasses;
    }

}
