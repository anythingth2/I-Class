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
import java.net.URL;

abstract public class TypeDialog extends AnchorPane {
    public enum TypeRadio {
        Material, Homework
    }

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

    abstract public void onAccept(TypeRadio typeRadio);

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
        TypeRadio typeRadio = this.typeRadioGroup.getSelectedToggle() == this.slideRadio ?
                TypeRadio.Material : TypeRadio.Homework;
        this.onAccept(typeRadio);
        this.dismiss();

    }

}
