package Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class VideoMaterial extends Material {
    VideoMaterial(TeachingClass teachingClass) {
        super(teachingClass);
    }
}
