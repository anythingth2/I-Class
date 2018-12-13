package UI.Dialog.TypeDialog;

import UI.Controller;
import UI.Dialog.DialogController;
import javafx.scene.Node;

public abstract class TypeDialogController implements DialogController {
    public enum TypeRadio {
        Material, Homework
    }

    TypeDialog typeDialog;

    @Override
    public Node getRoot() {
        return this.typeDialog;
    }

    public TypeDialogController() {
        super();
        this.typeDialog = new TypeDialog(this);
    }

    abstract public void onAccept(TypeRadio typeRadio);

    @Override
    public void show() {
        this.typeDialog.show();
    }

    @Override
    public void dismiss() {
        this.typeDialog.dismiss();
    }
}
