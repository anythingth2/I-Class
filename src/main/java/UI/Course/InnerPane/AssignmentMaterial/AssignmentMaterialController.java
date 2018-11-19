package UI.Course.InnerPane.AssignmentMaterial;

import Model.Course;
import Model.TeachingClass;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialController;
import UI.Dialog.ConfirmDialog.ConfirmDialogController;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkController;
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

    public AssignmentMaterialController(Course course,TeachingClass teachingClass) {
        super();
        this.teachingClass = teachingClass;
        this.assignmentMaterialPane = new AssignmentMaterialPane(this, this.teachingClass);
    }

    void onClickDelete(){
        final ConfirmDialogController confirmDialog = new ConfirmDialogController(course);
        confirmDialog.show();
    }

    public void onEditAssignmentMaterial() {
        CreateHomeworkController createHomeworkController = new CreateHomeworkController(this.teachingClass) {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {

            }
        };
        createHomeworkController.show();
    }
}
