package UI.Dialog.ConfirmDialog;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class ConfirmDialog extends AnchorPane {
    @FXML
    private Label noButton;

    @FXML
    private Label yesButton;

    ConfirmDialogController controller;

    public ConfirmDialog(ConfirmDialogController controller) {
        super();
        try {
            URL url = new File("src/main/java/UI/Dialog/ConfirmDialog/ConfirmDialog.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/java/UI/Dialog/ConfirmDialog/ConfirmDialog.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    void clickNo(MouseEvent event) {
        this.dismiss();

    }

    @FXML
    void clickYes(MouseEvent event) {
        this.controller.onConfirm();
        this.dismiss();
    }
}
