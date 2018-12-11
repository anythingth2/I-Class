package UI.Dialog.AnnouncementDialog;

import Model.Course;
import UI.Dialog.DialogController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

abstract public class AnnouncementDialogController implements DialogController {

    AnnouncementDialog announcementDialog;

    @Override
    public Node getRoot() {
        return this.announcementDialog;
    }

    public AnnouncementDialogController() {
        super();

        this.announcementDialog = new AnnouncementDialog(this);
    }


    @Override
    public void show() {
        this.announcementDialog.show();
    }

    @Override
    public void dismiss() {
        this.announcementDialog.dismiss();
    }

    void editAnnouncement(String text) {

        this.onEditSuccess(text);
    }

    protected abstract void onEditSuccess(String text);

}
