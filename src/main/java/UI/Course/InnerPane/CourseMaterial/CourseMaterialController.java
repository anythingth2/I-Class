package UI.Course.InnerPane.CourseMaterial;

import Model.Course;
import Model.Material;
import Model.TeachingClass;
import UI.Controller;
import UI.Course.CourseController;
import UI.Dialog.CreateMaterialDialog.CreateMaterialController;
import javafx.scene.Node;

public class CourseMaterialController implements Controller {
    private CourseController parentController;
    private CourseMaterialPane courseMaterialPane;
    protected Course course;
    protected TeachingClass teachingClass;

    @Override
    public Node getRoot() {
        return this.courseMaterialPane;
    }

    public CourseMaterialController() {
        super();

    }

    public CourseMaterialController(CourseController parentController,Course course, TeachingClass teachingClass) {
        super();
        this.parentController = parentController;
        this.course = course;
        this.teachingClass = teachingClass;
        this.courseMaterialPane = new CourseMaterialPane(this, this.teachingClass);
    }

    public void onEditCourseMaterial() {
        CreateMaterialController createMaterialController = new CreateMaterialController(teachingClass) {
            @Override
            public void onSuccess(TeachingClass teachingClass) {
//                int index = course.getTeachingClasses().indexOf(teachingClass);
//                course.getTeachingClasses().set(index,teachingClass);
                System.out.println(teachingClass.getTitle());
parentController.refresh();
            }
        };
        createMaterialController.show();
    }
}
