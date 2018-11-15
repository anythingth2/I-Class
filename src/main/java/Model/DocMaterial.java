package Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class DocMaterial extends Material {
    DocMaterial(TeachingClass _class) {
        super(_class);
    }
}
