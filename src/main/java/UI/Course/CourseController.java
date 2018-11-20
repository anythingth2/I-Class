package UI.Course;


import Main.Main;
import Model.AssignmentMaterial;
import Model.Course;
import Model.Material;
import Model.TeachingClass;
import UI.Controller;
import UI.Course.InnerPane.AssignmentMaterial.AssignmentMaterialController;
import UI.Course.InnerPane.CourseInfo.CourseInfoController;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialController;
import UI.Dialog.AnnouncementDialog.AnnouncementDialogController;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkController;
import UI.Dialog.CreateMaterialDialog.CreateMaterialController;
import UI.Dialog.TypeDialog.TypeDialog;
import javafx.scene.Node;



public class CourseController implements Controller {
    private Course course;
    //    private List<TeachingClass> teachingClasses;
    private CourseUI courseUI;

    @Override
    public Node getRoot() {
        return this.courseUI;
    }

    public CourseController(Course course) {
        super();
        this.course = course;
        this.courseUI = new CourseUI(this, course, Main.getApplicationController().getUser());
    }

    public void onClickAddTeachingClass() {
        final CreateMaterialController createMaterialController = new CreateMaterialController() {
            @Override
            public void onSuccess(TeachingClass teachingClass) {
                course.getTeachingClasses().add(teachingClass);
                courseUI.setTeachingClasses(course.getTeachingClasses());
            }
        };
        final CreateHomeworkController createHomeworkController = new CreateHomeworkController() {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {
                course.getTeachingClasses().add(teachingClass);
                courseUI.setTeachingClasses(course.getTeachingClasses());
            }
        };
        TypeDialog typeDialog = new TypeDialog() {
            @Override
            public void onAccept(TypeRadio typeRadio) {
                if (typeRadio == TypeRadio.Material)
                    createMaterialController.show();
                else if (typeRadio == TypeRadio.Homework)
                    createHomeworkController.show();

            }
        };
        typeDialog.show();
    }

    void onClickTeachingClassTab(TeachingClass teachingClass) {
        Material material = teachingClass.getMaterial();
        Controller controller = material instanceof AssignmentMaterial ?
                new AssignmentMaterialController(this, course, teachingClass)
                : new CourseMaterialController(this, course, teachingClass);
        this.courseUI.displayContent(controller);
    }

    void onClickAnnouncementEdit() {
        AnnouncementDialogController announcementDialog = new AnnouncementDialogController(course) {
            @Override
            protected void onEditSuccess(String text) {
                courseUI.getAnnouncementLabel().setText(text);
            }
        };
        announcementDialog.show();
    }

    public void refresh() {
        this.courseUI.setUser(Main.getApplicationController().getUser());
        this.courseUI.setTeachingClasses(this.course.getTeachingClasses());
        this.courseUI.displayContent(new CourseInfoController(this.course));
    }
}