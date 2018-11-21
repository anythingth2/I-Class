package UI.Course;


import Main.Main;
import Model.*;
import UI.Controller;
import UI.Course.InnerPane.AssignmentMaterial.AssignmentMaterialController;
import UI.Course.InnerPane.CourseInfo.CourseInfoController;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialController;
import UI.Dialog.AnnouncementDialog.AnnouncementDialogController;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkController;
import UI.Dialog.CreateMaterialDialog.CreateMaterialController;
import UI.Dialog.TypeDialog.TypeDialog;
import UI.Dialog.TypeDialog.TypeDialogController;
import UI.Login.LoginController;
import UI.Subject.SubjectController;
import javafx.scene.Node;

import java.util.List;


public class CourseController implements Controller {
    private Course course;
    //    private List<TeachingClass> teachingClasses;
    private CoursePage coursePage;

    @Override
    public Node getRoot() {
        return this.coursePage;
    }

    public CourseController(Course course) {
        super();
        this.course = course;
        this.coursePage = new CoursePage(this, course, Main.getApplicationController().getUser());
    }

    public void onClickAddTeachingClass() {
        final CreateMaterialController createMaterialController = new CreateMaterialController() {
            @Override
            public void onSuccess(TeachingClass teachingClass) {
                course.getTeachingClasses().add(teachingClass);
                coursePage.setTeachingClasses(course.getTeachingClasses());
            }
        };
        final CreateHomeworkController createHomeworkController = new CreateHomeworkController() {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {
                course.getTeachingClasses().add(teachingClass);
                coursePage.setTeachingClasses(course.getTeachingClasses());
            }
        };
        TypeDialogController typeDialogController = new TypeDialogController() {
            @Override
            public void onAccept(TypeRadio typeRadio) {
                if (typeRadio == TypeRadio.Material)
                    createMaterialController.show();
                else if (typeRadio == TypeRadio.Homework)
                    createHomeworkController.show();
            }
        };
        typeDialogController.show();
    }

    void onClickTeachingClassTab(TeachingClass teachingClass) {
        Material material = teachingClass.getMaterial();
        Controller controller = material instanceof AssignmentMaterial ?
                new AssignmentMaterialController(this, course, teachingClass)
                : new CourseMaterialController(this, course, teachingClass);
        this.coursePage.displayContent(controller);
    }

    void onClickAnnouncementEdit() {
        AnnouncementDialogController announcementDialog = new AnnouncementDialogController() {
            @Override
            protected void onEditSuccess(String text) {
                course.setAnnouncement(text);
                course.save();
                coursePage.getAnnouncementLabel().setText(text);
            }
        };
        announcementDialog.show();
    }

    public void refresh() {
        this.coursePage.setUser(Main.getApplicationController().getUser());
        this.coursePage.setTeachingClasses(this.course.getTeachingClasses());
        this.coursePage.displayContent(new CourseInfoController(this.course));
    }

    public void logout() {
        Main.getApplicationController().navigateTo(new LoginController());
    }

    public void goToSubject() {
        User user = Main.getApplicationController().getUser();
        List<Course> courses = null;
        if (user instanceof Student)
            courses = ((Student) user).getEnrolledCourses();
        else if (user instanceof Teacher)
            courses = ((Teacher) user).getOwnCourses();

        Main.getApplicationController().navigateTo(new SubjectController(courses));

    }
}