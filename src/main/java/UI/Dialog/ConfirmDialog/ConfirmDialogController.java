package UI.Dialog.ConfirmDialog;

import Model.Course;
import UI.Dialog.DialogController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

abstract public class ConfirmDialogController implements DialogController {

    ConfirmDialog confirmDialog;
    Course course;

    @FXML
    private Label noButton;

    @FXML
    private Label yesButton;

    public ConfirmDialogController(Course course) {
        super();
        this.confirmDialog = new ConfirmDialog(this);
        this.course = course;
    }


    @Override
    public void show() {
        confirmDialog.show();
    }

    @Override
    public void dismiss() {
        confirmDialog.dismiss();
    }

    @Override
    public Node getRoot() {
        return this.confirmDialog;
    }

   public abstract void onConfirm();
}

