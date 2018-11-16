package UI.Course.InnerPane.AssignmentMaterial;

import UI.Dialog.CreateHomeworkDialog.CreateHomeworkDialog;
import UI.Dialog.comfirmDialog.comfirmDialogController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

import java.io.File;
import java.net.URL;

public class AssignmentMaterialPane extends ScrollPane {
    public AssignmentMaterialPane() {
        super();
        try {
            URL url = new File("src/main/java/UI/Course/InnerPane/AssignmentMaterial/AssignmentMaterial.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Course/InnerPane/AssignmentMaterial/AssignmentMaterial.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    void clickDelete(ActionEvent event) {
        final comfirmDialogController comfirmDialog = new comfirmDialogController();
        comfirmDialog.show();
    }

    @FXML
    void clickEdit(ActionEvent event) {
        final CreateHomeworkDialog createHomeworkDialog = new CreateHomeworkDialog();
        createHomeworkDialog.show();
    }
}
