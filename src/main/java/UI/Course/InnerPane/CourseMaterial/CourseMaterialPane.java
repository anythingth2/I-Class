package UI.Course.InnerPane.CourseMaterial;

import Model.TeachingClass;
import UI.Dialog.CreateMaterialDialog.CreateMaterialDialog;
import UI.Dialog.comfirmDialog.comfirmDialogController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;

public class CourseMaterialPane extends ScrollPane {
    private TeachingClass teachingClass;

    public CourseMaterialPane() {
        super();
        try {
            URL url = new File("src/main/java/UI/Course/InnerPane/CourseMaterial/CourseMaterial.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Course/InnerPane/CourseMaterial/CourseMaterial.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CourseMaterialPane(TeachingClass teachingClass) {
        this();
        this.teachingClass = teachingClass;
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
        final CreateMaterialDialog materialDialog = new CreateMaterialDialog() {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {

            }
        };
        materialDialog.show();
    }

}
