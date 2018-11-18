package UI.Course.InnerPane.CourseMaterial;

import Model.Material;
import Model.TeachingClass;
import UI.Controller;
import javafx.scene.Node;

public class CourseMaterialController implements Controller {
    CourseMaterialPane courseMaterialPane;
    Material material;

    @Override
    public Node getRoot() {
        return null;
    }

    public CourseMaterialController() {
        super();
        this.courseMaterialPane = new CourseMaterialPane(this);
    }

    public CourseMaterialController(Material material) {
        super();
        this.material = material;
        this.courseMaterialPane = new CourseMaterialPane(this, this.material);
    }

}
