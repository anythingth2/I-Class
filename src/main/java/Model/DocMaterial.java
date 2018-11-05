package Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "doc_materials")
public class DocMaterial extends Material {
    DocMaterial(TeachingClass _class) {
        super(_class);
    }
}
