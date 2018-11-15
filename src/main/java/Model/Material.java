package Model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Material {
    String title;
    String description;
    String link;

    TeachingClass teachingClass;

    public Material() {
    }

    public Material(TeachingClass teachingClass) {
        this.teachingClass = teachingClass;
    }
}

