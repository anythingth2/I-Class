package UI.Dialog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class dialogController {

    @FXML
    private Button closeButton;

    @FXML
    void closeDialog(ActionEvent event) {
            // get a handle to the stage
            Stage stage = (Stage) closeButton.getScene().getWindow();
            // do what you have to do
            stage.close();
        }

    }

