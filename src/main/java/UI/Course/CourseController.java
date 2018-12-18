package UI.Course;


import Main.Main;
import Main.MockData;
import Model.*;
import UI.Controller;
import UI.Course.InnerPane.AssignmentInbox.AssignmentInboxController;
import UI.Course.InnerPane.AssignmentMaterial.AssignmentMaterialController;
import UI.Course.InnerPane.CourseInfo.CourseInfoController;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialController;
import UI.Dialog.AnnouncementDialog.AnnouncementDialogController;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkController;
import UI.Dialog.CreateMaterialDialog.CreateMaterialController;
import UI.Dialog.TypeDialog.TypeDialogController;
import UI.Login.LoginController;
import UI.Subject.SubjectController;
import javafx.scene.Node;

import java.util.ArrayList;
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
        this.coursePage = new CoursePage(this, course, Main.getApplication().getUser());
    }

    public void onClickAddTeachingClass() {
        final CreateMaterialController createMaterialController = new CreateMaterialController() {
            @Override
            public void onSuccess(TeachingClass teachingClass) {
                teachingClass.setCourse(course);
                teachingClass.save();
                course.getTeachingClasses().add(teachingClass);
                course.saveOrUpdate();
                coursePage.setTeachingClasses(course.getTeachingClasses());
            }
        };
        final CreateHomeworkController createHomeworkController = new CreateHomeworkController() {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {
                teachingClass.setCourse(course);
                teachingClass.save();
                course.getTeachingClasses().add(teachingClass);
                course.saveOrUpdate();
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
                course.update();
                coursePage.getAnnouncementLabel().setText(text);
            }
        };
        announcementDialog.show();
    }

    void onClickAssignmentInbox() {
        List<AssignmentMaterial> assignmentMaterials;
        assignmentMaterials = MockData.mockAssignment();
//        assignmentMaterials = new ArrayList<AssignmentMaterial>();
//        for (TeachingClass teachingClass : this.course.getTeachingClasses()) {
//            Material material = teachingClass.getMaterial();
//            if (material instanceof AssignmentMaterial) {
//                assignmentMaterials.add((AssignmentMaterial) material);
//            }
//        }
        AssignmentInboxController assignmentInboxController = new AssignmentInboxController(assignmentMaterials);

        this.coursePage.displayContent(assignmentInboxController);
    }

    public void refresh() {
        this.coursePage.setUser(Main.getApplication().getUser());
        this.coursePage.setTeachingClasses(this.course.getTeachingClasses());
        this.coursePage.displayContent(new CourseInfoController(this.course));
    }

    public void logout() {
        Main.getApplication().navigateTo(new LoginController());
    }

    public void goToSubject() {
        User user = Main.getApplication().getUser();
        List<Course> courses = null;
        if (user instanceof Student)
            courses = ((Student) user).getEnrolledCourses();
        else if (user instanceof Teacher)
            courses = ((Teacher) user).getOwnCourses();

        Main.getApplication().navigateTo(new SubjectController(courses));

    }
}