package UI.Dialog.CreateHomeworkDialog;

import Main.FileStorage;
import Main.Main;
import Model.AssignmentMaterial;
import Model.Course;
import Model.Material;
import Model.TeachingClass;
import UI.Dialog.DialogController;
import javafx.scene.Node;

import java.time.ZoneId;
import java.util.Date;

abstract public class CreateHomeworkController implements DialogController {
    TeachingClass teachingClass;
    CreateHomeworkDialog homeworkDialog;
Course course;
    @Override
    public Node getRoot() {
        return this.homeworkDialog;
    }

    public CreateHomeworkController(Course course) {
        super();
        this.course = course;
        this.homeworkDialog = new CreateHomeworkDialog(this);
    }

    public CreateHomeworkController(Course course, TeachingClass teachingClass) {
        super();
        this.course = course;
        this.teachingClass = teachingClass;
        this.homeworkDialog = new CreateHomeworkDialog(this, teachingClass);
    }

    private void createTeachingClass() {
        if (this.teachingClass == null) {
            this.teachingClass = new TeachingClass();
        }

        AssignmentMaterial assignmentMaterial = (AssignmentMaterial) teachingClass.getMaterial();
        if (assignmentMaterial == null)
            assignmentMaterial = new AssignmentMaterial();
        assignmentMaterial.setTeachingClass(this.teachingClass);

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
        String fileLink = FileStorage.upload(this.homeworkDialog.uploadFile, this.course.getId(), Main.getApplication().getUser().getUserid());
        System.out.println("upload " + fileLink);
        assignmentMaterial.setFileLink(fileLink);

        this.teachingClass.setTitle(this.homeworkDialog.getTitleNameTextField().getText());
        this.teachingClass.setDate(startDate);
        this.teachingClass.setMaterial(assignmentMaterial);
        this.teachingClass.persist();
        this.onCreateSuccess(this.teachingClass);
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
