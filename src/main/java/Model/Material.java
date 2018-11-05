package Model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "material")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Material  {
    String title;
    String description;
    String link;

    TeachingClass teachingClass;
    Material(TeachingClass teachingClass){
        this.teachingClass = teachingClass;
    }
}

