package UI.Dialog.CreateHomeworkDialog;

import Model.AssignmentMaterial;
import Model.Material;
import Model.TeachingClass;
import UI.Dialog.DialogController;
import javafx.scene.Node;

import java.time.ZoneId;
import java.util.Date;

abstract public class CreateHomeworkController implements DialogController {

    CreateHomeworkDialog homeworkDialog;

    @Override
    public Node getRoot() {
        return this.homeworkDialog;
    }

    public CreateHomeworkController() {
        super();
        this.homeworkDialog = new CreateHomeworkDialog(this);
    }

    public CreateHomeworkController(TeachingClass teachingClass) {
        super();
        this.homeworkDialog = new CreateHomeworkDialog(this, teachingClass);
    }

    private void createTeachingClass() {
        TeachingClass teachingClass = new TeachingClass();
        AssignmentMaterial assignmentMaterial = new AssignmentMaterial();

        Date startDate = Date.from(this.homeworkDialog.getDatePicker().getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        if (this.homeworkDialog.getHourChoiceBox().getValue() != null)
            startDate.setHours(this.homeworkDialog.getHourChoiceBox().getValue());
        if (this.homeworkDialog.getMinuteChoiceBox().getValue() != null)
            startDate.setMinutes(this.homeworkDialog.getMinuteChoiceBox().getValue());


        Date dueDate = Date.from(this.homeworkDialog.getDueDatePicker().getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        if (this.homeworkDialog.getHourDueChoiceBox().getValue() != null)
            dueDate.setHours(this.homeworkDialog.getHourDueChoiceBox().getValue());
        if (this.homeworkDialog.getMinuteDueChoiceBox().getValue() != null)
            dueDate.setMinutes(this.homeworkDialog.getMinuteDueChoiceBox().getValue());

        assignmentMaterial.setStartDate(startDate);
        assignmentMaterial.setDueDate(dueDate);
        assignmentMaterial.setVideoLink(this.homeworkDialog.getVideoLinkTextField().getText());
        assignmentMaterial.setDescription(this.homeworkDialog.getDescriptionTextArea().getText());
        //todo: file link

        teachingClass.setTitle(this.homeworkDialog.getTitleNameTextField().getText());
        teachingClass.setDate(startDate);
        teachingClass.setMaterial(assignmentMaterial);
        this.onCreateSuccess(teachingClass);
    }

    void onConfirm() {
        createTeachingClass();
        this.dismiss();
    }

    abstract public void onCreateSuccess(TeachingClass teachingClass);


    @Override
    public void show() {
        this.homeworkDialog.show();
    }

    @Override
    public void dismiss() {
        this.homeworkDialog.dismiss();
    }


}
