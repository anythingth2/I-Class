package UI.Course.InnerPane.AssignmentMaterial;

import Model.TeachingClass;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialController;
import javafx.scene.Node;

public class AssignmentMaterialController extends CourseMaterialController {
    AssignmentMaterialPane assignmentMaterialPane;

    @Override
    public Node getRoot() {
        return this.assignmentMaterialPane;
    }

    public AssignmentMaterialController() {
        super();
    }

    public AssignmentMaterialController(TeachingClass teachingClass) {
        super();
        this.teachingClass = teachingClass;
        this.assignmentMaterialPane = new AssignmentMaterialPane(this,this.teachingClass);
    }
}
