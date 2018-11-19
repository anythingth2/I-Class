package UI.Dialog.AnnouncementDialog;

import Model.Course;
import UI.Dialog.DialogController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

abstract public class AnnouncementDialogController implements DialogController {

    AnnouncementDialog announcementDialog;
    Course course;
    @Override
    public Node getRoot() {
        return this.announcementDialog;
    }

    public AnnouncementDialogController(Course course) {
        super();
        this.course = course;
        this.announcementDialog = new AnnouncementDialog(this);
    }

    @FXML
    private Label cancelButton;

    @FXML
    private Label editButton;

    @FXML
    private TextField dataField;

    @Override
    public void show() {
        this.announcementDialog.show();
    }

    @Override
    public void dismiss() {
        this.announcementDialog.dismiss();
    }

    void editAnnouncement(String text){
        course.setAnnouncement(text);this.onEditSucess(text);
    }
   protected abstract void onEditSucess(String text);

}
