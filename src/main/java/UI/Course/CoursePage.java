package UI.Course;

import Main.Main;
import Model.*;
import UI.Controller;
import UI.Course.InnerPane.CourseInfo.CourseInfoController;
import UI.Course.InnerPane.StudentTodoPane.StudentTodoPage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CoursePage extends AnchorPane {
    @FXML
    private Label accountIdTextView;
    @FXML
    private Button editAnnouncementButton;
    @FXML
    private Label announcementLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Button courseInfoButton;
    @FXML
    private Button todoButton;
    @FXML
    private VBox classVBox;
    private List<ClassItemPane> classItemPanes = new ArrayList<ClassItemPane>();
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button logout;
    @FXML
    private Button subject;

    @FXML
    private ImageView addTeachingClassImageView;
    @FXML
    private ImageView chatImageView;
    @FXML
    private ImageView assignmentImageView;

    @FXML
    private Pane teachingClassPane;

    public Label getAnnouncementLabel() {
        return announcementLabel;
    }

    CourseController controller;


    public CoursePage() {
        super();
        try {
            URL url = new File("src/main/java/UI/Course/Course.fxml").toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Course/Course.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(url);
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CoursePage(CourseController controller, Course course, User user) {
        this();

        this.controller = controller;
        this.setCourse(course);
        this.setUser(user);
    }

    private void setCourse(Course course) {
        this.announcementLabel.setText(course.getAnnouncement());
        this.accountIdTextView.setText(Main.getApplication().getUser().getUserid());
        this.titleLabel.setText(course.getName());
        this.courseInfoButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                displayContent(new CourseInfoController(course));
            }
        });
        this.todoButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Pane pane = new StudentTodoPage();
                displayContent(pane);
            }
        });


        this.displayContent(new CourseInfoController(course));
        this.setTeachingClasses(course.getTeachingClasses());
    }

    public void setUser(User user) {
        boolean isTeacher = user instanceof Teacher;
        this.editAnnouncementButton.setVisible(isTeacher);
        this.todoButton.setVisible(!isTeacher);
//        this.courseInfoButton.setVisible(!isTeacher);
        this.addTeachingClassImageView.setVisible(isTeacher);
        this.assignmentImageView.setVisible(isTeacher);
    }

    public void setTeachingClasses(List<TeachingClass> teachingClasses) {
        this.classVBox.getChildren().clear();
        this.classItemPanes.clear();
        for (final TeachingClass teachingClass : teachingClasses) {
            if (teachingClass.getMaterial() != null) {

                ClassItemPane classItemPane = new ClassItemPane(teachingClass,
                        teachingClass.getMaterial());

                classItemPane.setOnMouseClicked(event -> this.controller.onClickTeachingClassTab(teachingClass));

                this.classItemPanes.add(classItemPane);
            }
        }
        for (ClassItemPane classItemPane : this.classItemPanes) {
            this.classVBox.getChildren().add(classItemPane);
        }
    }


    public void displayContent(Node pane) {
        if (this.teachingClassPane.getChildren().size() > 0) {
            this.teachingClassPane.getChildren().set(0, pane);
        } else {
            this.teachingClassPane.getChildren().add(pane);
        }
    }

    public void displayContent(Controller controller) {
        if (this.teachingClassPane.getChildren().size() > 0) {
            this.teachingClassPane.getChildren().set(0, controller.getRoot());
        } else {
            this.teachingClassPane.getChildren().add(controller.getRoot());
        }
    }


    @FXML
    private void onLogoutAction() {
        this.controller.logout();
    }

    @FXML
    private void onSubjectAction() throws IOException {
        this.controller.goToSubject();
    }

    @FXML
    private void onLogoutEntered() throws IOException {
        this.logout.setTextFill(Color.valueOf("#f50b0b"));
    }

    @FXML
    private void onLogoutExited() throws IOException {
        this.logout.setTextFill(Color.WHITE);
    }

    @FXML
    private void onSubjectEntered() throws IOException {
        this.subject.setTextFill(Color.valueOf("#16eedb"));
    }

    @FXML
    private void onSubjectExited() throws IOException {
        this.subject.setTextFill(Color.WHITE);
    }


    @FXML
    void onAddTeachingClassClick(MouseEvent event) {
        this.controller.onClickAddTeachingClass();
    }

    @FXML
    void onEditAnnouncementAction(ActionEvent event) {
        this.controller.onClickAnnouncementEdit();
    }

    @FXML
    private void onEditAnnouncementEntered() throws IOException {
        this.editAnnouncementButton.setStyle("-fx-background-color : #6aede1");
    }

    @FXML
    private void onEditAnnouncementExited() throws IOException {
        this.editAnnouncementButton.setStyle("-fx-background-color : #B1DFDB");
    }

    @FXML
    private void onTodoEntered() throws IOException {
        this.todoButton.setStyle("-fx-background-color : #6aede1");
    }

    @FXML
    private void onTodoExited() throws IOException {
        this.todoButton.setStyle("-fx-background-color : #B1DFDB");
    }

    @FXML
    private void onCourseInfoEntered() throws IOException {
        this.courseInfoButton.setStyle("-fx-background-color : white");
    }

    @FXML
    private void onCourseInfoExited() throws IOException {
        this.courseInfoButton.setStyle("-fx-background-color : #d6d3d3");
    }

}
