package UI.Dialog.AnnouncementDialog;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class AnnouncementDialog extends AnchorPane {
    @FXML
    private Label cancelButton;

    @FXML
    private Label editButton;

    @FXML
    private TextField dataField;

    public static final int maxLength = 20;
    AnnouncementDialogController announcementDialogController;


    public AnnouncementDialog(AnnouncementDialogController announcementDialogController) {
        super();
        try {
            URL url = new File("src/main/java/UI/Dialog/AnnouncementDialog/AnnouncementDialog.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/java/UI/Dialog/AnnouncementDialog/AnnouncementDialog.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        limitCharacterTextField();
        this.announcementDialogController=announcementDialogController;
    }

    void limitCharacterTextField(){
        dataField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (dataField.getText().length() > maxLength) {
                    String s = dataField.getText().substring(0, maxLength);
                    dataField.setText(s);
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

    public void dismiss() {
        ((Stage) this.getScene().getWindow()).close();
    }

    @FXML
    void clickCancel(MouseEvent event) {
        this.dismiss();

    }

    @FXML
    void clickEdit(MouseEvent event) {
        String text=dataField.getText();
        announcementDialogController.editAnnouncement(text);
        this.dismiss();
    }


}
