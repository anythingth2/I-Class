package UI.Dialog.CreateMaterialDialog;

import Main.Main;
import Model.Material;
import Model.TeachingClass;
import UI.Controller;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkController;
import UI.Dialog.DialogController;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.time.ZoneId;
import java.util.Date;

abstract public class CreateMaterialController implements DialogController {
    protected CreateMaterialDialog root;

    @Override
    public Node getRoot() {
        return this.root;
    }

    public CreateMaterialController() {
        this.root = new CreateMaterialDialog() {
            @Override
            protected void onConfirm() {
                createTeachingClass();
            }
        };
    }
    public CreateMaterialController(TeachingClass teachingClass){
        this.root = new CreateMaterialDialog(teachingClass) {
            @Override
            protected void onConfirm() {
                createTeachingClass();
            }
        };
    }

    private void createTeachingClass() {
        TeachingClass teachingClass = new TeachingClass();
        Date date = Date.from(this.root.getDatePicker().getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        if (this.root.getHourChoiceBox().getValue() != null)
            date.setHours(this.root.getHourChoiceBox().getValue());
        if (this.root.getMinuteChoiceBox().getValue() != null)
            date.setMinutes(this.root.getMinuteChoiceBox().getValue());
        teachingClass.setDate(date);
        teachingClass.setTitle(this.root.getTitleNameTextField().getText());
        Material material = new Material();
        material.setDescription(this.root.getDescriptionTextArea().getText());
        //todo: file link
        material.setTeachingClass(teachingClass);
        material.setVideoLink(this.root.getVideoLinkTextField().getText());

        teachingClass.setMaterial(material);
        this.onCreateSuccess(teachingClass);
        this.dismiss();

    }

    abstract public void onCreateSuccess(TeachingClass teachingClass);

    @Override
    public void show() {
        this.root.show();
    }

    @Override
    public void dismiss() {
        this.root.dismiss();
    }
}
