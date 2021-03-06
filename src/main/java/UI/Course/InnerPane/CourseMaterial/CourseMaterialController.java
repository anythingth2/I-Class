package UI.Course.InnerPane.CourseMaterial;

import Model.Course;
import Model.Model;
import Model.TeachingClass;
import UI.Controller;
import UI.Course.CourseController;
import UI.Dialog.ConfirmDialog.ConfirmDialogController;
import UI.Dialog.CreateMaterialDialog.CreateMaterialController;
import javafx.scene.Node;
import org.hibernate.SQLQuery;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CourseMaterialController implements Controller {
    private CourseController parentController;
    private CourseMaterialPage courseMaterialPage;
    protected Course course;
    protected TeachingClass teachingClass;

    @Override
    public Node getRoot() {
        return this.courseMaterialPage;
    }

    public CourseMaterialController() {
        super();

    }

    public CourseMaterialController(CourseController parentController, Course course, TeachingClass teachingClass) {
        super();
        this.parentController = parentController;
        this.course = course;
        this.teachingClass = teachingClass;
        this.courseMaterialPage = new CourseMaterialPage(this, this.teachingClass);

    }

    public void onClickDelete() {
        final ConfirmDialogController confirmDialog = new ConfirmDialogController(course) {
            @Override
            public void onConfirm() {
                course.getTeachingClasses().remove(teachingClass);
                System.out.println("TC:" + teachingClass.getId());
                SQLQuery query = Model.getSession().createSQLQuery("DELETE FROM TeachingClass WHERE id = :tid");
                query.setParameter("tid", teachingClass.getId());
                query.executeUpdate();
                Model.commit();
                parentController.refresh();
            }
        };
        confirmDialog.show();
    }

    public void onEditMaterial() {
        CreateMaterialController createMaterialController = new CreateMaterialController(this.course, this.teachingClass) {
            @Override
            public void onSuccess(TeachingClass teachingClass) {
                parentController.refresh();
            }
        };
        createMaterialController.show();
    }

    public void navigate(String link) {
        System.out.println("navigate to " + link);
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void onDownload() {
        String link = this.teachingClass.getMaterial().getFileLink();
        this.navigate(link);
    }

    public void onViewVideo() {
        String link = this.teachingClass.getMaterial().getVideoLink();
        this.navigate(link);
    }
}
