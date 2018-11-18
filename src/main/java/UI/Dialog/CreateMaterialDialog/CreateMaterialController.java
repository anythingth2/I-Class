package UI.Dialog.CreateMaterialDialog;

import Model.Material;
import Model.TeachingClass;
import UI.Controller;
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
            void onConfirm() {
                createTeachingClass();
            }
        };
    }

    private void createTeachingClass() {
        TeachingClass teachingClass = new TeachingClass();
        Date date = Date.from(this.root.getDatePicker().getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        date.setHours(this.root.getHourChoiceBox().getValue());
        date.setMinutes(this.root.getMinuteChoiceBox().getValue());
        teachingClass.setDate(date);
        teachingClass.setTitle("FIX ME!");
        Material material = new Material();
        //todo: set Material
        //todo: set teaching class name
        teachingClass.setMaterial(material);
        this.onCreateSuccess(teachingClass);
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
