package Model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "material")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Material {
    private String title;

    private String description;
    private String link;

    private TeachingClass teachingClass;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public TeachingClass getTeachingClass() {
        return teachingClass;
    }

    public void setTeachingClass(TeachingClass teachingClass) {
        this.teachingClass = teachingClass;
    }

    public Material() {
    }

    public Material(String title) {
        this.title = title;
    }

    public Material(TeachingClass teachingClass) {
        this.teachingClass = teachingClass;
    }
}

