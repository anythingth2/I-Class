package UI.Course.InnerPane.AssignmentMaterial;


import Model.AssignmentMaterial;
import Model.Teacher;
import Model.TeachingClass;
import Model.User;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialPane;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkController;
import UI.Dialog.ConfirmDialog.ConfirmDialogController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AssignmentMaterialPane extends CourseMaterialPane {
    private AssignmentMaterialController controller;

    @FXML
    private Label dueDateLabel;
    @FXML
    private Label dueTimeLabel;
    @FXML
    private Button submitButton;
    @FXML
    private Label submitFileNameLabel;

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
    private void clickDelete(ActionEvent event) {
        controller.onClickDelete();
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date date = ((AssignmentMaterial)teachingClass.getMaterial()).getDueDate();
        this.dueDateLabel.setText(dateFormat.format(date));
        this.dueTimeLabel.setText(timeFormat.format(date) + " น.");

    }

    @FXML
    void clickEdit(ActionEvent event) {
        controller.onEditAssignmentMaterial();
    }
}