package Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="video_material")
public class VideoMaterial extends Material {
    VideoMaterial(TeachingClass teachingClass) {
        super(teachingClass);
    }
}
