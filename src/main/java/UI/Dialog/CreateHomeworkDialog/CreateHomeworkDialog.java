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
        for (int i = 8; i < 20; tempHourValues.add(i), i++) ;
        hourValues.addAll(tempHourValues);
        this.hourDueChoiceBox.setItems(hourValues);

        ObservableList<Integer> minuteValues = FXCollections.observableArrayList();
        List<Integer> tempMinuteValues = new ArrayList<Integer>();
        for (int i = 0; i < 60; tempMinuteValues.add(i), i += 30) ;
        minuteValues.addAll(tempMinuteValues);
        this.minuteDueChoiceBox.setItems(minuteValues);

        this.confirmButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onConfirm();
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
        boolean validated = super.validateInput();
        if (!validated) return validated;
        this.dueDateAlertLabel.setVisible(this.dueDatePicker.getValue() == null);
        if (this.dueDatePicker.getValue() == null) {
            this.dueDateAlertLabel.setText("กรุณากรอกวันสิ้นสุด");
            this.dueDateAlertLabel.setVisible(true);
            return false;
        }
        if (this.dueDatePicker.getValue().isBefore(this.getDatePicker().getValue())) {
            this.dueDateAlertLabel.setText("วันที่ไม่ถูกต้อง");
            this.dueDateAlertLabel.setVisible(true);
            return false;
        }
        this.dueDateAlertLabel.setVisible(false);

        return true;
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
}
