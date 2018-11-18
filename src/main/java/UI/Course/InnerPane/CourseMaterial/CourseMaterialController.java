package UI.Course.InnerPane.CourseMaterial;

import Model.Material;
import Model.TeachingClass;
import UI.Controller;
import javafx.scene.Node;

public class CourseMaterialController implements Controller {
    CourseMaterialPane courseMaterialPane;
    TeachingClass teachingClass;

    @Override
    public Node getRoot() {
        return this.courseMaterialPane;
    }

    public CourseMaterialController() {
        super();
        this.courseMaterialPane = new CourseMaterialPane(this);
    }

    public CourseMaterialController(TeachingClass teachingClass) {
        super();
        this.teachingClass = teachingClass;
        this.courseMaterialPane = new CourseMaterialPane(this, this.teachingClass);
    }

}
