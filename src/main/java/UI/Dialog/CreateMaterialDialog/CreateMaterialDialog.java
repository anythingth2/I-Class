package UI.Dialog.CreateMaterialDialog;

import UI.Dialog.CreateDialog;
import javafx.fxml.FXMLLoader;

import java.io.File;
import java.net.URL;

public class CreateMaterialDialog extends CreateDialog {


    public CreateMaterialDialog() {
        super();
        try {
            URL url = new File("src/main/java/UI/Dialog/CreateMaterialDialog/fileDialog.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/java/UI/Dialog/CreateMaterialDialog/fileDialog.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.initialise();
    }
}
