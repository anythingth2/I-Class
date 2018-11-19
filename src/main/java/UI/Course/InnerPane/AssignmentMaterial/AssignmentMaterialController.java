package UI.Course.InnerPane.AssignmentMaterial;

import Model.Course;
import Model.TeachingClass;
import UI.Course.CourseController;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialController;
import UI.Dialog.ConfirmDialog.ConfirmDialogController;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkController;
import javafx.scene.Node;

public class AssignmentMaterialController extends CourseMaterialController {
    CourseController parentController;
    AssignmentMaterialPane assignmentMaterialPane;

    @Override
    public Node getRoot() {
        return this.assignmentMaterialPane;
    }

    public AssignmentMaterialController() {
        super();
    }

    public AssignmentMaterialController(CourseController parentController, Course course, TeachingClass teachingClass) {
        super();
        this.parentController = parentController;
        this.teachingClass = teachingClass;
        this.assignmentMaterialPane = new AssignmentMaterialPane(this, this.teachingClass);
    }

    void onClickDelete() {
        final ConfirmDialogController confirmDialog = new ConfirmDialogController(course);
        confirmDialog.show();
    }

    public void onEditAssignmentMaterial() {
        CreateHomeworkController createHomeworkController = new CreateHomeworkController(this.teachingClass) {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {
                parentController.refresh();
            }
        };
        createHomeworkController.show();
    }
}
