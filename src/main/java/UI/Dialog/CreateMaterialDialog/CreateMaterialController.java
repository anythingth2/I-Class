package UI.Dialog.CreateMaterialDialog;

import Model.Material;
import Model.TeachingClass;
import UI.Dialog.DialogController;
import javafx.scene.Node;

import java.time.ZoneId;
import java.util.Date;

abstract public class CreateMaterialController implements DialogController {
    protected CreateMaterialDialog root;
    protected TeachingClass teachingClass;

    @Override
    public Node getRoot() {
        return this.root;
    }

    public CreateMaterialController() {
        this.root = new CreateMaterialDialog(this);
    }

    public CreateMaterialController(TeachingClass teachingClass) {
        this.teachingClass = teachingClass;
        this.root = new CreateMaterialDialog(this, teachingClass);
    }

    private void createTeachingClass() {
//        TeachingClass teachingClass = new TeachingClass();
        if (this.teachingClass == null)
            this.teachingClass = new TeachingClass();
        Date date = Date.from(this.root.getDatePicker().getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        if (this.root.getHourChoiceBox().getValue() != null)
            date.setHours(this.root.getHourChoiceBox().getValue());
        if (this.root.getMinuteChoiceBox().getValue() != null)
            date.setMinutes(this.root.getMinuteChoiceBox().getValue());
        teachingClass.setDate(date);
        teachingClass.setTitle(this.root.getTitleNameTextField().getText());
        Material material = this.teachingClass.getMaterial();
        if (material == null)
            material = new Material();
        material.setDescription(this.root.getDescriptionTextArea().getText());
        //todo: file link
        material.setTeachingClass(teachingClass);
        material.setVideoLink(this.root.getVideoLinkTextField().getText());

        teachingClass.setMaterial(material);
        this.onSuccess(teachingClass);
        this.dismiss();

    }

    void onConfirm() {

        createTeachingClass();

    }

    abstract public void onSuccess(TeachingClass teachingClass);

    @Override
    public void show() {
        this.root.show();
    }

    @Override
    public void dismiss() {
        this.root.dismiss();
    }
}
