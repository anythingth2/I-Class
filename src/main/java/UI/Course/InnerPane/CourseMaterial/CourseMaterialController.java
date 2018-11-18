package UI.Course.InnerPane.CourseMaterial;

import Model.Material;
import Model.TeachingClass;
import UI.Controller;
import javafx.scene.Node;

public class CourseMaterialController implements Controller {
   private CourseMaterialPane courseMaterialPane;
   protected TeachingClass teachingClass;

    @Override
    public Node getRoot() {
        return this.courseMaterialPane;
    }

    public CourseMaterialController() {
        super();

    }

    public CourseMaterialController(TeachingClass teachingClass) {
        super();
        this.teachingClass = teachingClass;
        this.courseMaterialPane = new CourseMaterialPane(this, this.teachingClass);
    }

}
