package UI.Course.InnerPane.AssignmentMaterial;


import Model.AssignmentMaterial;
import Model.TeachingClass;
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
    private TeachingClass teachingClass;

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
        super.initialise();
    }

    public AssignmentMaterialPane(AssignmentMaterialController controller, TeachingClass teachingClass) {
        super("/UI/Course/InnerPane/AssignmentMaterial/AssignmentMaterial.fxml");
        this.controller = controller;
        this.teachingClass = teachingClass;
        super.initialise();
    }


    @FXML
    void clickDelete(ActionEvent event) {
        final comfirmDialogController comfirmDialog = new comfirmDialogController();
        comfirmDialog.show();
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