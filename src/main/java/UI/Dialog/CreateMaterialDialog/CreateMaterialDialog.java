package UI.Dialog.CreateMaterialDialog;

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
import javafx.util.Callback;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateMaterialDialog extends AnchorPane {
    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<Integer> hourChoiceBox;
    @FXML
    private ChoiceBox<Integer> minuteChoiceBox;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextField videoLinkTextField;

    @FXML
    private Label confirmButton;
    @FXML
    private Label cancelButton;
    @FXML
    private Button uploadButton;
    @FXML
    private Label pathLabel;

    @FXML
    private Label dateAlertLabel;
    @FXML
    private Label timeAlertLabel;

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

    private void initialise() {


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
                System.out.println("" + validateInput());
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
//                System.out.println(browseFile());
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
