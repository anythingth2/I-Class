package UI.Dialog;

import Model.Material;
import Model.TeachingClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract public class CreateDialog extends AnchorPane {
    @FXML
    protected DatePicker datePicker;
    @FXML
    protected ChoiceBox<Integer> hourChoiceBox;
    @FXML
    protected ChoiceBox<Integer> minuteChoiceBox;
    @FXML
    protected TextArea descriptionTextArea;
    @FXML
    protected TextField videoLinkTextField;

    @FXML
    protected Label confirmButton;
    @FXML
    protected Label cancelButton;
    @FXML
    protected Button uploadButton;
    @FXML
    protected Label pathLabel;

    @FXML
    protected Label dateAlertLabel;
    @FXML
    protected Label timeAlertLabel;

    public CreateDialog() {
        super();
    }

    protected void initialise() {
        ObservableList<Integer> hourValues = FXCollections.observableArrayList();
        List<Integer> tempHourValues = new ArrayList<Integer>();
        for (int i = 8; i < 20; tempHourValues.add(i), i++) ;
        hourValues.addAll(tempHourValues);
        this.hourChoiceBox.setItems(hourValues);


        ObservableList<Integer> minuteValues = FXCollections.observableArrayList();
        List<Integer> tempMinuteValues = new ArrayList<Integer>();
        for (int i = 0; i < 60; tempMinuteValues.add(i), i += 30) ;
        minuteValues.addAll(tempMinuteValues);
        this.minuteChoiceBox.setItems(minuteValues);

        this.confirmButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (validateInput()) {
                    createTeachingClass();
                }
            }
        });
        this.cancelButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dismiss();
            }
        });
        this.uploadButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                File file = browseFile();
                if (file == null) {
                    return;
                }
                pathLabel.setText(file.getName());
                pathLabel.setVisible(true);
            }
        });
    }

    private boolean validateInput() {
        if (this.datePicker.getValue() == null) {
            this.dateAlertLabel.setText("กรุณาเเลือกวัน");
            this.dateAlertLabel.setVisible(true);
            return false;
        }
        if (this.datePicker.getValue().isBefore(LocalDate.now())) {
            this.dateAlertLabel.setText("ไม่สามารถเลือกวันในอดีตได้");
            this.dateAlertLabel.setVisible(true);
            return false;
        }
        if (this.hourChoiceBox.getValue() == null || this.minuteChoiceBox.getValue() == null) {
            this.timeAlertLabel.setVisible(true);
            return false;
        }

        return true;
    }

    abstract public void onCreateSuccess(TeachingClass teachingClass);

    private void createTeachingClass() {
        TeachingClass teachingClass = new TeachingClass();
        Date date = Date.from(this.datePicker.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        date.setHours(this.hourChoiceBox.getValue());
        date.setMinutes(this.minuteChoiceBox.getValue());
        teachingClass.setDate(date);
        teachingClass.setTitle("FIX ME!");
        Material material = new Material();
        //todo: set Material
        //todo: set teaching class name
        teachingClass.setMaterial(material);
        this.onCreateSuccess(teachingClass);
    }

    private File browseFile() {
        FileChooser fileChooser = new FileChooser();

        return fileChooser.showOpenDialog(getScene().getWindow());
    }

    public void show() {
        Stage stage = new Stage();
        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.show();
    }

    public void dismiss() {
        ((Stage) this.getScene().getWindow()).close();
    }


}
