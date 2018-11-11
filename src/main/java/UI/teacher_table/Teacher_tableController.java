package UI.teacher_table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;


public class Teacher_tableController {
    ObservableList<String> list = FXCollections.observableArrayList("Assigned 1","Assigned 2");
    ObservableList<homework> data = FXCollections.observableArrayList(
            new homework(59011300,"aaa","11 Nov 2018","sawatdee","555"),
            new homework(59011300,"aaa","12 Nov 2018","sawatdee","555"),
            new homework(59011300,"aaa","13 Nov 2018","sawatdee","555"),
            new homework(59011300,"aaa","14 Nov 2018","sawatdee","555"),
            new homework(59011300,"aaa","15 Nov 2018","sawatdee","555")
            );

    @FXML
    private ChoiceBox select_work;

    @FXML
    private Button button;

    @FXML
    private TableView<homework> table;

    @FXML
    private TableColumn<homework,Integer> id;

    @FXML
    private TableColumn<homework,String> name;

    @FXML
    private TableColumn<homework,String> date;

    @FXML
    private TableColumn<homework,String> file_name;

    @FXML
    private TableColumn<homework,String> description;

    @FXML
    private void onAddClick(MouseEvent event) {
        select_work.setItems(list);
    }

    @FXML
    void onclickbtn(MouseEvent event) {
        id.setCellValueFactory(new PropertyValueFactory<homework, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<homework, String>("name"));
        date.setCellValueFactory(new PropertyValueFactory<homework, String>("date"));
        file_name.setCellValueFactory(new PropertyValueFactory<homework, String>("filename"));
        description.setCellValueFactory(new PropertyValueFactory<homework, String>("description"));
        table.setItems(data);

    }

}
