package teacher_student_template;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.awt.event.MouseEvent;

public class Controller {
    @FXML private HBox Chap1_tab;

    @FXML private AnchorPane Chap1_Apane;

    @FXML
    private void handleButtonAction(MouseEvent event){
        if(Chap1_tab.getE){
            Chap1_Apane.setVisible(true);
        }
    }
}
