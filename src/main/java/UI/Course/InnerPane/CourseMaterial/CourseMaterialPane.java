package UI.Course.InnerPane.CourseMaterial;

import Main.Main;
import Model.*;
import UI.Dialog.CreateMaterialDialog.CreateMaterialController;
import UI.Dialog.comfirmDialog.comfirmDialogController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;

public class CourseMaterialPane extends ScrollPane {

    private CourseMaterialController controller;
    @FXML
    private Label titleLabel;
    @FXML
    private Label fileNameLabel;
    @FXML
    private Button fileButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Hyperlink videoHyperlink;
    @FXML
    private Text descriptionText;
    @FXML
    private Button editButton;

    private CourseMaterialPane() {
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

    public CourseMaterialPane(String path) {
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
    }

    public CourseMaterialPane(CourseMaterialController controller) {
        this("/UI/Course/InnerPane/CourseMaterial/CourseMaterial.fxml");
        this.controller = controller;


    }

    public CourseMaterialPane(CourseMaterialController controller, TeachingClass teachingClass) {
        this("/UI/Course/InnerPane/CourseMaterial/CourseMaterial.fxml");
        this.controller = controller;

        this.setTeachingClass(teachingClass);
    }


    public void setTeachingClass(TeachingClass teachingClass) {
        this.titleLabel.setText(teachingClass.getTitle() != null ? teachingClass.getTitle() : "ไม่มีหัวข้อ");
        this.fileNameLabel.setText(teachingClass.getMaterial().getFileName() != null ? teachingClass.getMaterial().getFileName() : "ไม่มีเอกสาร");
        this.videoHyperlink.setText(teachingClass.getMaterial().getFileLink() != null ? teachingClass.getMaterial().getFileLink() : "-");
        this.descriptionText.setText(teachingClass.getMaterial().getDescription() != null ? teachingClass.getMaterial().getDescription() : "-");
        this.setUser(Main.getApplicationController().getUser());

    }

    public void setUser(User user) {
        boolean isTeacher = user instanceof Teacher;
        this.editButton.setVisible(isTeacher);
        this.deleteButton.setVisible(isTeacher);
        this.fileButton.setText(isTeacher ? "อัพโหลด" : "ดาวน์โหลด");
    }

    @FXML
    void clickDelete(ActionEvent event) {
        final comfirmDialogController comfirmDialog = new comfirmDialogController();
        comfirmDialog.show();

    }

    @FXML
    void clickEdit(ActionEvent event) {
        final CreateMaterialController createMaterialController = new CreateMaterialController() {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {

            }
        };
        createMaterialController.show();
    }

}
