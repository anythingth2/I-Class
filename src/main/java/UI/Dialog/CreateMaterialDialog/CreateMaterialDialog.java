package UI.Dialog.CreateMaterialDialog;

import Model.Material;
import Model.TeachingClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateMaterialDialog extends AnchorPane {
    @FXML
    protected TextField titleNameTextField;
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
    protected Label titleNameAlertLabel;
    @FXML
    protected Label dateAlertLabel;
    @FXML
    protected Label timeAlertLabel;

    public TextField getTitleNameTextField() {
        return titleNameTextField;
    }

    public Label getTitleNameAlertLabel() {
        return titleNameAlertLabel;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public ChoiceBox<Integer> getHourChoiceBox() {
        return hourChoiceBox;
    }

    public ChoiceBox<Integer> getMinuteChoiceBox() {
        return minuteChoiceBox;
    }

    public TextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public TextField getVideoLinkTextField() {
        return videoLinkTextField;
    }

    public Label getConfirmButton() {
        return confirmButton;
    }

    public Label getCancelButton() {
        return cancelButton;
    }

    public Button getUploadButton() {
        return uploadButton;
    }

    public Label getPathLabel() {
        return pathLabel;
    }

    public Label getDateAlertLabel() {
        return dateAlertLabel;
    }

    public Label getTimeAlertLabel() {
        return timeAlertLabel;
    }

    CreateMaterialController controller;

    public CreateMaterialDialog() {
        this("/UI/Dialog/CreateMaterialDialog/fileDialog.fxml");
    }

    protected CreateMaterialDialog(String path) {
        super();
        try {
            URL url = new File("src/main/java" + path).toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.initialise();
    }

    public CreateMaterialDialog(CreateMaterialController controller) {
        this();
        this.controller = controller;
    }

    public CreateMaterialDialog(CreateMaterialController controller, TeachingClass teachingClass) {
        this(controller);

        this.fillInput(teachingClass);
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
                    onConfirm();
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

    protected void fillInput(TeachingClass teachingClass) {
        this.titleNameTextField.setText(teachingClass.getTitle());
        this.datePicker.setValue(teachingClass.getDate() != null ?
                teachingClass.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                : null);
        this.hourChoiceBox.setValue(teachingClass.getDate().getHours());
        this.minuteChoiceBox.setValue(teachingClass.getDate().getMinutes());
        this.descriptionTextArea.setText(teachingClass.getMaterial().getDescription());
        this.pathLabel.setText(teachingClass.getMaterial().getFileName());
        this.pathLabel.setVisible(true);
        this.videoLinkTextField.setText(teachingClass.getMaterial().getVideoLink());


    }

    protected boolean validateInput() {
        this.titleNameAlertLabel.setVisible(this.titleNameTextField.getText() == null || this.titleNameTextField.getText().equals(""));
        if (this.titleNameTextField.getText() == null || this.titleNameTextField.getText().equals("")) {
            return false;
        }
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
        this.dateAlertLabel.setVisible(false);

        this.titleNameAlertLabel.setVisible(false);
        return true;
    }


    private void onConfirm() {
        controller.onConfirm();

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
