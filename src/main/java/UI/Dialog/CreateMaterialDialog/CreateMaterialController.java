package UI.Dialog.CreateMaterialDialog;

import Main.FileStorage;
import Main.Main;
import Model.Course;
import Model.Material;
import Model.TeachingClass;
import UI.Dialog.DialogController;
import javafx.scene.Node;

import java.time.ZoneId;
import java.util.Date;

abstract public class CreateMaterialController implements DialogController {
    protected CreateMaterialDialog createMaterialDialog;
    protected TeachingClass teachingClass;
    protected Course course;

    @Override
    public Node getRoot() {
        return this.createMaterialDialog;
    }

    public CreateMaterialController(Course course) {
        this.course = course;
        this.createMaterialDialog = new CreateMaterialDialog(this);
    }

    public CreateMaterialController(Course course, TeachingClass teachingClass) {
        this.course = course;
        this.teachingClass = teachingClass;
        this.createMaterialDialog = new CreateMaterialDialog(this, teachingClass);
    }

    private void createTeachingClass() {
        if (this.teachingClass == null) {
            this.teachingClass = new TeachingClass();
        }


        Date date = Date.from(this.createMaterialDialog.getDatePicker().getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        if (this.createMaterialDialog.getHourChoiceBox().getValue() != null)
            date.setHours(this.createMaterialDialog.getHourChoiceBox().getValue());
        if (this.createMaterialDialog.getMinuteChoiceBox().getValue() != null)
            date.setMinutes(this.createMaterialDialog.getMinuteChoiceBox().getValue());
        this.teachingClass.setDate(date);
        this.teachingClass.setTitle(this.createMaterialDialog.getTitleNameTextField().getText());

        Material material = this.teachingClass.getMaterial();

        if (material == null)
            material = new Material();
        material.setTeachingClass(this.teachingClass);
        material.setDescription(this.createMaterialDialog.getDescriptionTextArea().getText());
        if (this.createMaterialDialog.uploadFile != null) {
            String fileLink = FileStorage.upload(this.createMaterialDialog.uploadFile, this.course.getId(), Main.getApplication().getUser().getUserid());
            System.out.println("upload " + fileLink);
            material.setFileLink(fileLink);
        }
        material.setTeachingClass(this.teachingClass);
        material.setVideoLink(this.createMaterialDialog.getVideoLinkTextField().getText());
//        material.save();

        this.teachingClass.setMaterial(material);
        this.teachingClass.persist();

        this.onSuccess(this.teachingClass);
        this.dismiss();
    }

    void onConfirm() {
        createTeachingClass();
    }

    abstract public void onSuccess(TeachingClass teachingClass);

    @Override
    public void show() {
        this.createMaterialDialog.show();
    }

    @Override
    public void dismiss() {
        this.createMaterialDialog.dismiss();
    }
}
