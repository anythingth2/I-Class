package Model;

import javax.persistence.*;
import java.io.File;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Material extends Model {
    @Id
    @GeneratedValue
    private int id;

    private String description;
    private String fileLink;
    private String videoLink;
    @OneToOne
    private TeachingClass teachingClass;





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

    public String getFileName() {
        if (this.fileLink == null) return null;
        return new File(this.fileLink).getName();
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


    public Material(TeachingClass teachingClass) {
        this.teachingClass = teachingClass;
    }


}

