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

public abstract class CreateMaterialDialog extends AnchorPane {
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
//                    createTeachingClass();
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

    private boolean validateInput() {
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
        if (this.hourChoiceBox.getValue() == null || this.minuteChoiceBox.getValue() == null) {
            this.timeAlertLabel.setVisible(true);
            return false;
        }
        this.titleNameAlertLabel.setVisible(false);
        return true;
    }


    abstract void onConfirm();


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


    public CreateMaterialDialog() {
        super();
        try {
            URL url = new File("src/main/java/UI/Dialog/CreateMaterialDialog/fileDialog.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/java/UI/Dialog/CreateMaterialDialog/fileDialog.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.initialise();
    }
}
