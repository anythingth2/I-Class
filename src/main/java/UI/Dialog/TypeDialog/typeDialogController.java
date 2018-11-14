package UI.Dialog.TypeDialog;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class typeDialogController {

    @FXML
    private RadioButton slideRadio;

    @FXML
    private ToggleGroup typeSlide;

    @FXML
    private RadioButton homeworkRadio;

    @FXML
    private Label cancelButton;

    @FXML
    private Label okButton;

    @FXML
    void clickCancel(MouseEvent event) {


        //Close Pane
        // get a handle to the stage
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void clickOk(MouseEvent event) {


        //Close Pane
        // get a handle to the stage
        Stage stage = (Stage) okButton.getScene().getWindow();
        // do what you have to do
        stage.close();

    }

}
