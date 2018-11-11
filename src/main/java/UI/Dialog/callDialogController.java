package UI.Dialog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class mainScreenController {

    @FXML
    private Button buttonTest;

    @FXML
    private Label text;

    @FXML
    private Button openDialog;

    @FXML
    void createDialog(ActionEvent event) {



    }

    @FXML
    void openDialog(ActionEvent event) {

        try{
            URL url = new File("src/main/java/UI/Dialog/Dialog.fxml").toURL();
            Parent root1 = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setScene(new Scene(root1, 316, 202));
            stage.show();
        }catch (Exception e){
            System.out.println("Can't load");
        }
    }

}
