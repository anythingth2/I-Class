package UI.Dialog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class CallDialogController extends AnchorPane {

    @FXML
    private Button buttonTest;

    @FXML
    private Label text;

    @FXML
    private Button announce;

    @FXML
    private Button type;

    @FXML
    private Button comfirm;

    @FXML
    private Button file;

    @FXML
    private Button homework;

    public CallDialogController() {
        super();
        try {
            URL url = new File("src/main/java/UI/Dialog/callDialog.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Dialog/callDialog.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            System.out.println("Can't load");
            e.printStackTrace();
        }
    }

    @FXML
    void openDialog(ActionEvent event) {
        try{
            URL url = new File("src/main/java/UI/Dialog/dialog.fxml").toURL();
            Parent root1 = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Can't load");
        }
    }

    @FXML
    void openComfirm(ActionEvent event) {
        try{
            URL url = new File("src/main/java/UI/Dialog/ComfirmDialog/comfirmDialog.fxml").toURL();
            Parent root1 = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Can't load");
            e.printStackTrace();

        }
    }

    @FXML
    void openAnnouncement(ActionEvent event) {
        try{
            URL url = new File("src/main/java/UI/Dialog/AnnouncementDialog/AnnouncementDialog.fxml").toURL();
            Parent root1 = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Can't load");
            e.printStackTrace();
        }
    }

    @FXML
    void openFile(ActionEvent event) {
        try{
            URL url = new File("src/main/java/UI/Dialog/CreateMaterialDialog/fileDialog.fxml").toURL();
            Parent root1 = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Can't load");
            e.printStackTrace();
        }
    }

    @FXML
    void openHomework(ActionEvent event) {
        try{
            URL url = new File("src/main/java/UI/Dialog/CreateHomeworkDialog/homeworkDialog.fxml").toURL();
            Parent root1 = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Can't load");
            e.printStackTrace();
        }
    }

    @FXML
    void openType(ActionEvent event) {
        try{
            URL url = new File("src/main/java/UI/Dialog/TypeDialog/typeDialog.fxml").toURL();
            Parent root1 = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Can't load");
            e.printStackTrace();
        }
    }


}
