package UI.Course.InnerPane.AssignmentMaterial;

import Main.Main;
import Model.*;
import UI.Course.CourseController;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialController;
import UI.Dialog.ConfirmDialog.ConfirmDialogController;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkController;
import javafx.scene.Node;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AssignmentMaterialController extends CourseMaterialController {
    CourseController parentController;
    Course course;
    AssignmentMaterialPage assignmentMaterialPage;

    @Override
    public Node getRoot() {
        return this.assignmentMaterialPage;
    }

    public AssignmentMaterialController() {
        super();
    }

    public AssignmentMaterialController(CourseController parentController, Course course, TeachingClass teachingClass) {
        super();
        this.parentController = parentController;
        this.course = course;
        this.teachingClass = teachingClass;
        this.assignmentMaterialPage = new AssignmentMaterialPage(this, this.teachingClass);
    }

    public void onClickDelete() {
        final ConfirmDialogController confirmDialog = new ConfirmDialogController(course) {
            @Override
            public void onConfirm() {
                course.getTeachingClasses().remove(teachingClass);
                course.update();
                parentController.refresh();
                System.out.println("assignmentMaterial");
            }
        };
        confirmDialog.show();
    }

    public void onEditAssignmentMaterial() {
        CreateHomeworkController createHomeworkController = new CreateHomeworkController(this.course, this.teachingClass) {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {
                parentController.refresh();
            }
        };
        createHomeworkController.show();
    }

    public void onSubmit(File file) {
        if (file == null) return;
        AssignmentMaterial assignmentMaterial = (AssignmentMaterial) this.teachingClass.getMaterial();
        System.out.printf("material:%d assignmentMaterial:%d ", this.teachingClass.getMaterial().hashCode(), assignmentMaterial.hashCode());
        String path = file.getPath();//todo: use url from aws s3
        Homework homework = new Homework(path, (Student) Main.getApplication().getUser());
        assignmentMaterial.addHomework(homework);
        assignmentMaterial.saveOrUpdate();
    }

    public void onDownload() {
        String link = this.teachingClass.getMaterial().getFileLink();
        System.out.println("navigate to " + link);
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
