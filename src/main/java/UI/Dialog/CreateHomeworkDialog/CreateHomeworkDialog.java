package UI.Dialog.CreateHomeworkDialog;

import Model.AssignmentMaterial;
import Model.TeachingClass;
import UI.Dialog.CreateMaterialDialog.CreateMaterialDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateHomeworkDialog extends CreateMaterialDialog {
    @FXML
    private DatePicker dueDatePicker;
    @FXML
    private Label dueDateAlertLabel;
    @FXML
    private ChoiceBox<Integer> hourDueChoiceBox;
    @FXML
    private ChoiceBox<Integer> minuteDueChoiceBox;

    public DatePicker getDueDatePicker() {
        return dueDatePicker;
    }

    public Label getDueDateAlertLabel() {
        return dueDateAlertLabel;
    }

    public ChoiceBox<Integer> getHourDueChoiceBox() {
        return hourDueChoiceBox;
    }

    public ChoiceBox<Integer> getMinuteDueChoiceBox() {
        return minuteDueChoiceBox;
    }

    public CreateHomeworkDialog() {
        super("/UI/Dialog/CreateHomeworkDialog/homeworkDialog.fxml");
    }

    CreateHomeworkController controller;

    public CreateHomeworkDialog(CreateHomeworkController controller) {
        this();
        this.controller = controller;
    }

    public CreateHomeworkDialog(CreateHomeworkController controller, TeachingClass teachingClass) {
        this(controller);
        this.fillInput(teachingClass);
    }

    @Override
    protected void initialise() {
        super.initialise();
        ObservableList<Integer> hourValues = FXCollections.observableArrayList();
        List<Integer> tempHourValues = new ArrayList<Integer>();
        for (int i = 0; i < 24; tempHourValues.add(i), i++) ;
        hourValues.addAll(tempHourValues);
        this.hourChoiceBox.setItems(hourValues);
        this.hourDueChoiceBox.setItems(hourValues);

        ObservableList<Integer> minuteValues = FXCollections.observableArrayList();
        List<Integer> tempMinuteValues = new ArrayList<Integer>();
        for (int i = 0; i < 60; tempMinuteValues.add(i), i += 30) ;
        minuteValues.addAll(tempMinuteValues);
        this.minuteChoiceBox.setItems(minuteValues);
        this.minuteDueChoiceBox.setItems(minuteValues);

        this.confirmButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (validateInput()) {
                    onConfirm();
                }
            }
        });
    }

    public void show() {
        Stage stage = new Stage();
        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    protected boolean validateInput() {
        boolean validate = super.validateInput();
        this.dueDateAlertLabel.setVisible(this.dueDatePicker.getValue() == null || this.dueDatePicker.getValue().isBefore(this.getDatePicker().getValue()));
        if (this.dueDatePicker.getValue() == null) {
            this.dueDateAlertLabel.setText("กรุณาเเลือกวันที่");
            validate = false;
        }
        else if (this.dueDatePicker.getValue().isBefore(this.getDatePicker().getValue())) {
            this.dueDateAlertLabel.setText("ไม่สามารถเลือกวันในอดีตได้");
            validate = false;
        }
        return validate;
    }


    private void onConfirm() {
        this.controller.onConfirm();
    }

    @Override
    protected void fillInput(TeachingClass teachingClass) {
        super.fillInput(teachingClass);
        AssignmentMaterial assignmentMaterial = (AssignmentMaterial) teachingClass.getMaterial();
        this.dueDatePicker.setValue(assignmentMaterial.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        this.hourDueChoiceBox.setValue(assignmentMaterial.getDueDate().getHours());
        this.minuteDueChoiceBox.setValue(assignmentMaterial.getDueDate().getMinutes());
    }

    public void dismiss() {
        ((Stage) this.getScene().getWindow()).close();
    }

    @FXML
    private void onUploadEntered() throws IOException {
        this.uploadButton.setStyle("-fx-background-color : #16eedb;");
    }

    @FXML
    private void onUploadExited() throws IOException {
        this.uploadButton.setStyle("-fx-background-color : #92CBC5;");
    }

    @FXML
    private void onConfirmEntered() throws IOException {
        this.confirmButton.setStyle("-fx-background-color : #010101; -fx-background-radius: 7;");
    }

    @FXML
    private void onConfirmExited() throws IOException {
        this.confirmButton.setStyle("-fx-background-color : #424242; -fx-background-radius: 7;");
    }

    @FXML
    private void onCancelEntered() throws IOException {
        this.cancelButton.setStyle("-fx-background-color : #010101; -fx-background-radius: 7;");
    }

    @FXML
    private void onCancelExited() throws IOException {
        this.cancelButton.setStyle("-fx-background-color : #424242; -fx-background-radius: 7;");
    }
}
