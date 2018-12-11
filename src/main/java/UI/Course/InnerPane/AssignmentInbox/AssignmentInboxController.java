package UI.Course.InnerPane.AssignmentInbox;

import Model.AssignmentMaterial;
import Model.Homework;
import UI.Controller;
import javafx.scene.Node;

import java.util.List;


public class AssignmentInboxController implements Controller {
    AssignmentInboxPage root;
    List<AssignmentMaterial> assignmentMaterials;

    @Override

    public Node getRoot() {
        return this.root;
    }


    public AssignmentInboxController(List<AssignmentMaterial> assignmentMaterials) {
        this.assignmentMaterials = assignmentMaterials;
        this.root = new AssignmentInboxPage(this);
        this.root.displayHomeworkTable(assignmentMaterials.get(0).getHomework());
    }
}
