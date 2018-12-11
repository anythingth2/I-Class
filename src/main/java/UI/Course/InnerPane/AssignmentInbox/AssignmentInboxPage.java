package UI.Course.InnerPane.AssignmentInbox;

import Model.Homework;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.io.File;
import java.net.URL;
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

    public AssignmentInboxPage(AssignmentInboxController controller) {
        this();
        this.controller = controller;
        this.initialise();
    }

    private void initialise() {
        this.idColumn.setCellValueFactory(param -> new SimpleStringProperty("" + param.getValue().getOwner().getId()));
        this.nameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getOwner().getFullName()));
    this.dateColumn.setCellValueFactory(param-> new SimpleStringProperty(param.getValue().getSubmitDate().toString()));
    this.fileNameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getFilePath()));


    }

    public void displayHomeworkTable(List<Homework> homeworks) {
        System.out.println(homeworks);
        for (Homework homework : homeworks) {
            this.tableView.getItems().add(homework);
        }
    }
}
