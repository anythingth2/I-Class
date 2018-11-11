package UI.Dialog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class dialogController {

    @FXML
    private Button button;

    @FXML
    void clickOK(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) button.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
