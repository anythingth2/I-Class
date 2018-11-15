package UI.Dialog.AnnouncementDialog;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class announcementDialogController extends AnchorPane {

    @FXML
    private Label cancelButton;

    @FXML
    private Label editButton;

    @FXML
    private TextField dataField;

    public announcementDialogController() {
        super();
        try {
            URL url = new File("src/main/java/UI/Dialog/AnnouncementDialog/announcementDialog.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/java/UI/Dialog/AnnouncementDialog/announcementDialog.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    void clickEdit(MouseEvent event) {
        this.dismiss();
    }

}
