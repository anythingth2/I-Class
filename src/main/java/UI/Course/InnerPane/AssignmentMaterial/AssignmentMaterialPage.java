package UI.Course.InnerPane.AssignmentMaterial;


import Model.AssignmentMaterial;
import Model.Teacher;
import Model.TeachingClass;
import Model.User;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AssignmentMaterialPage extends CourseMaterialPage {
    private AssignmentMaterialController controller;
    @FXML
    private Label dueDateLabel;
    @FXML
    private Label dueTimeLabel;
    @FXML
    private Button submitButton;
    @FXML
    private Label submitFileNameLabel;
    @FXML
    private Button fileButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button editButton;


    public AssignmentMaterialPage() {
        super("/UI/Course/InnerPane/AssignmentMaterial/AssignmentMaterial.fxml");
    }

    public AssignmentMaterialPage(AssignmentMaterialController controller) {
        super("/UI/Course/InnerPane/AssignmentMaterial/AssignmentMaterial.fxml");
        this.controller = controller;

    }

    public AssignmentMaterialPage(AssignmentMaterialController controller, TeachingClass teachingClass) {
        super("/UI/Course/InnerPane/AssignmentMaterial/AssignmentMaterial.fxml");
        this.controller = controller;
        this.setTeachingClass(teachingClass);
    }


    @FXML
    private void clickDelete(ActionEvent event) {
        this.controller.onClickDelete();
    }

    @FXML
    public void onClickVideo(){
        this.controller.onViewVideo();
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
        Date date = ((AssignmentMaterial) teachingClass.getMaterial()).getDueDate();
        this.dueDateLabel.setText(dateFormat.format(date));
        this.dueTimeLabel.setText(timeFormat.format(date) + " น.");
    }

    @FXML
    void clickEdit(ActionEvent event) {
        controller.onEditAssignmentMaterial();
    }

    @FXML
    void onSubmit() {
        FileChooser fileChooser = new FileChooser();
        controller.onSubmit(fileChooser.showOpenDialog(getScene().getWindow()));
    }

    @FXML
    void onClickDownload() {
        controller.onDownload();
    }

    @FXML
    private void onSubmitEntered() throws IOException {
        this.submitButton.setStyle("-fx-background-color : #16eedb;");
    }

    @FXML
    private void onSubmitExited() throws IOException {
        this.submitButton.setStyle("-fx-background-color : #B1DFDB;");
    }

    @FXML
    private void onDownloadEntered() throws IOException {
        this.fileButton.setStyle("-fx-background-color : #016f9e;");
    }

    @FXML
    private void onDownloadExited() throws IOException {
        this.fileButton.setStyle("-fx-background-color :  #0399D8;");
    }

    @FXML
    private void onEditEntered() throws IOException {
        this.editButton.setStyle("-fx-background-color : #16eedb;");
    }

    @FXML
    private void onEditExited() throws IOException {
        this.editButton.setStyle("-fx-background-color : #B1DFDB;");
    }

    @FXML
    private void onDeleteEntered() throws IOException {
        this.deleteButton.setStyle("-fx-background-color : #f50b0b;");
    }

    @FXML
    private void onDeleteExited() throws IOException {
        this.deleteButton.setStyle("-fx-background-color :  #f99393;");
    }

}