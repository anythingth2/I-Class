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
    private String fileLink;
    private String videoLink;

    private TeachingClass teachingClass;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileLink() {
        return this.fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public String getVideoLink() {
        return this.videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public TeachingClass getTeachingClass() {
        return this.teachingClass;
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

