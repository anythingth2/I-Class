package UI.Course.InnerPane.CourseMaterial;

import Model.Course;
import Model.Material;
import Model.TeachingClass;
import UI.Controller;
import UI.Dialog.ConfirmDialog.ConfirmDialogController;
import UI.Dialog.CreateMaterialDialog.CreateMaterialController;
import javafx.scene.Node;

public class CourseMaterialController implements Controller {
   private CourseMaterialPane courseMaterialPane;
   protected TeachingClass teachingClass;
   protected Course course;

    @Override
    public Node getRoot() {
        return this.courseMaterialPane;
    }

    public CourseMaterialController() {
        super();

    }

    public CourseMaterialController(Course course,TeachingClass teachingClass) {
        super();
        this.teachingClass = teachingClass;
        this.courseMaterialPane = new CourseMaterialPane(this, this.teachingClass);
        this.course = course;
    }

    void onClickDelete(){
        final ConfirmDialogController confirmDialog = new ConfirmDialogController(course);
        confirmDialog.show();
    }

    public void onEditCourseMaterial() {
        CreateMaterialController createMaterialController = new CreateMaterialController(teachingClass) {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {

            }
        };
        createMaterialController.show();
    }
}
