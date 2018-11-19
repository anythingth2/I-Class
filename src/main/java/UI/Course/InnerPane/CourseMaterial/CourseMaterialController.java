package UI.Course.InnerPane.CourseMaterial;

import Model.Material;
import Model.TeachingClass;
import UI.Controller;
import UI.Dialog.CreateMaterialDialog.CreateMaterialController;
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

    public void onEditCourseMaterial() {
        CreateMaterialController createMaterialController = new CreateMaterialController(teachingClass) {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {

            }
        };
        createMaterialController.show();
    }
}
