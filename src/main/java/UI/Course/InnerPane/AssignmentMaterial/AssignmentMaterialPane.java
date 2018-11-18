package UI.Course.InnerPane.AssignmentMaterial;


import Model.AssignmentMaterial;
import Model.Teacher;
import Model.TeachingClass;
import Model.User;
import UI.Controller;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialPane;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkController;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkDialog;
import UI.Dialog.comfirmDialog.comfirmDialogController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

import java.io.File;
import java.net.URL;

public class AssignmentMaterialPane extends CourseMaterialPane {
    private AssignmentMaterialController controller;

    @FXML
    private Label dueDateLabel;
    @FXML
    private Label dueTimeLabel;
    @FXML
    private Button submitButton;

    public AssignmentMaterialPane() {
        super("/UI/Course/InnerPane/AssignmentMaterial/AssignmentMaterial.fxml");
    }

    public AssignmentMaterialPane(AssignmentMaterialController controller) {
        super("/UI/Course/InnerPane/AssignmentMaterial/AssignmentMaterial.fxml");
        this.controller = controller;

    }

    public AssignmentMaterialPane(AssignmentMaterialController controller, TeachingClass teachingClass) {
        super("/UI/Course/InnerPane/AssignmentMaterial/AssignmentMaterial.fxml");
        this.controller = controller;
        this.setTeachingClass(teachingClass);
    }


    @FXML
    void clickDelete(ActionEvent event) {
        final comfirmDialogController comfirmDialog = new comfirmDialogController();
        comfirmDialog.show();
    }

    @Override
    public void setUser(User user) {
        super.setUser(user);
        boolean isTeacher = user instanceof Teacher;
        this.submitButton.setVisible(!isTeacher);
    }

    @Override
    public void setTeachingClass(TeachingClass teachingClass) {
        super.setTeachingClass(teachingClass);

    }

    @FXML
    void clickEdit(ActionEvent event) {
        final CreateHomeworkController createHomeworkController = new CreateHomeworkController() {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {

            }
        };
        createHomeworkController.show();
    }
}