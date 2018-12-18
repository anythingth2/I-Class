package UI.Dialog.TypeDialog;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TypeDialog extends AnchorPane {


    private TypeDialogController controller;
    @FXML
    private RadioButton slideRadio;

    @FXML
    private RadioButton homeworkRadio;

    @FXML
    private ToggleGroup typeRadioGroup;

    @FXML
    private Label cancelButton;

    @FXML
    private Label okButton;

    public TypeDialog() {
        super();
        try {
            URL url = new File("src/main/java/UI/Dialog/TypeDialog/typeDialog.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/java/UI/Dialog/TypeDialog/typeDialog.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TypeDialog(TypeDialogController controller) {
        this();
        this.controller = controller;
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

    @FXML
    void clickCancel(MouseEvent event) {
        this.dismiss();
    }

    @FXML
    void clickOk(MouseEvent event) {
        TypeDialogController.TypeRadio typeRadio = this.typeRadioGroup.getSelectedToggle() == this.slideRadio ?
                TypeDialogController.TypeRadio.Material : TypeDialogController.TypeRadio.Homework;
        this.controller.onAccept(typeRadio);
        this.dismiss();

    }

    @FXML
    private void onConfirmEntered() throws IOException {
        this.okButton.setStyle("-fx-background-color : #010101; -fx-background-radius: 7;");
    }

    @FXML
    private void onConfirmExited() throws IOException {
        this.okButton.setStyle("-fx-background-color : #424242; -fx-background-radius: 7;");
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
