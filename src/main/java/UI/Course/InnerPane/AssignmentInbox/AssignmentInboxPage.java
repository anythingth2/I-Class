package UI.Course.InnerPane.AssignmentInbox;

import Model.AssignmentMaterial;
import Model.Homework;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AssignmentInboxPage extends Pane {
    AssignmentInboxController controller;

    @FXML
    private TableView<Homework> tableView;

    @FXML
    private TableColumn<Homework, String> idColumn;
    @FXML
    private TableColumn<Homework, String> nameColumn;
    @FXML
    private TableColumn<Homework, String> dateColumn;
    @FXML
    private TableColumn<Homework, String> fileNameColumn;

    @FXML
    private ChoiceBox<String> selectAssignmentChoiceBox;


    private AssignmentInboxPage() {
        super();
        try {
            URL url = new File("src/main/java/UI/Course/InnerPane/AssignmentInbox/Teacher_table.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Course/InnerPane/AssignmentInbox/Teacher_table.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AssignmentInboxPage(AssignmentInboxController controller, List<AssignmentMaterial> assignmentMaterials) {
        this();
        this.controller = controller;
        this.initialise(assignmentMaterials);
    }

    private void initialise(List<AssignmentMaterial> assignmentMaterials) {
        this.idColumn.setCellValueFactory(param -> new SimpleStringProperty("" + param.getValue().getOwner().getId()));
        this.nameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getOwner().getFullName()));
        this.dateColumn.setCellValueFactory(param -> {
            Date date = param.getValue().getSubmitDate();
            String text;
            text = new SimpleDateFormat("dd/MM/yyyy").format(date);
            return new SimpleStringProperty(text);
        });
        this.fileNameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getFilePath()));

        this.tableView.setRowFactory(param -> {
            TableRow<Homework> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (row.getItem() != null)
                    this.download(row.getItem().getFilePath());
            });
            return row;
        });

        for (AssignmentMaterial assigmentMaterial : assignmentMaterials) {
            if (assigmentMaterial.getTeachingClass() != null)
                this.selectAssignmentChoiceBox.getItems().add(assigmentMaterial.getTeachingClass().getTitle());
            else this.selectAssignmentChoiceBox.getItems().add("-");
        }
        this.selectAssignmentChoiceBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            this.displayHomeworkTable(assignmentMaterials.get(newValue.intValue()).getHomework());
        });
//        this.selectAssignmentChoiceBox.setOnAction(event -> {
//            System.out.println("select");
//        });

        this.selectAssignmentChoiceBox.getSelectionModel().select(0);
    }

    public void displayHomeworkTable(List<Homework> homeworks) {
        this.tableView.getItems().clear();
        for (Homework homework : homeworks) {
            this.tableView.getItems().add(homework);
        }
    }

    private void download(String link) {
        System.out.println("navigate to " + link);
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
