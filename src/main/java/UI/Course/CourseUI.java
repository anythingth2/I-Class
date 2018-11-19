package UI.Course;

import Main.Main;
import Model.*;
import UI.Controller;
import UI.Course.InnerPane.AssignmentMaterial.AssignmentMaterialController;
import UI.Course.InnerPane.CourseInfo.CourseInfoController;
import UI.Course.InnerPane.CourseInfo.CourseInfoPane;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialController;
import UI.Course.InnerPane.StudentTodoPane.StudentTodoPane;

import UI.Dialog.AnnouncementDialog.announcementDialogController;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkController;
import UI.Dialog.CreateMaterialDialog.CreateMaterialController;
import UI.Dialog.TypeDialog.TypeDialog;
import UI.Login.LoginController;
import UI.Subject.SubjectController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CourseUI extends AnchorPane {
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
    private Button logout1;

    @FXML
    private ImageView addTeachingClassImageView;
    @FXML
    private ImageView chatImageView;
    @FXML
    private ImageView assignmentImageView;

    @FXML
    private Pane teachingClassPane;

    CourseController controller;


    public CourseUI() {
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

    public CourseUI(CourseController controller, Course course, User user) {
        this();

        this.controller = controller;
        this.setCourse(course);
        this.setUser(user);
    }

    private void setCourse(Course course) {
        this.announcementLabel.setText(course.getAnnouncement());
        this.accountIdTextView.setText(Main.getApplicationController().getUser().getUserid());
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
                Pane pane = new StudentTodoPane();
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

                classItemPane.setOnMouseClicked(event -> controller.onClickTeachingClassTab(teachingClass));

                this.classItemPanes.add(classItemPane);
            }
        }
        for (ClassItemPane classItemPane : this.classItemPanes) {
            this.classVBox.getChildren().add(classItemPane);
        }
    }


    void displayContent(Node pane) {
        if (this.teachingClassPane.getChildren().size() > 0) {
            this.teachingClassPane.getChildren().set(0, pane);
        } else {
            this.teachingClassPane.getChildren().add(pane);
        }
    }

    void displayContent(Controller controller) {
        if (this.teachingClassPane.getChildren().size() > 0) {
            this.teachingClassPane.getChildren().set(0, controller.getRoot());
        } else {
            this.teachingClassPane.getChildren().add(controller.getRoot());
        }
    }


    @FXML
    private void onLogoutAction() {
        Parent root = new LoginController();
        Main.getApplicationController().navigateTo(root);
    }

    @FXML
    private void gotoSubject() throws IOException {
        Parent root = new SubjectController(((Student) Main.getApplicationController().getUser()).getEnrolledCourses());
        Main.getApplicationController().navigateTo(root);
    }

    @FXML
    private void onLogoutEntered() throws IOException {
        logout.setStyle("-fx-text-fill: #71f2e5;");
        logout.setStyle("-fx-background-color: #171C1D");
    }

    @FXML
    private void onLogoutExited() throws IOException {
        logout.setStyle("-fx-text-fill: white;");
        logout.setStyle("-fx-background-color: #171C1D");
    }

    @FXML
    private void onLogout1Entered() throws IOException {
        logout1.setStyle("-fx-text-fill: #71f2e5;");
        logout1.setStyle("-fx-background-color: #171C1D");
    }

    @FXML
    private void onLogout1Exited() throws IOException {
        logout1.setStyle("-fx-text-fill: white;");
        logout1.setStyle("-fx-background-color:#171C1D");
    }


    @FXML
    void onClickAddTeachingClass(MouseEvent event) {

        controller.onClickAddTeachingClass();

    }

    @FXML
    void openEditAnnouncement(ActionEvent event) {

        final announcementDialogController announcementDialog = new announcementDialogController();
        announcementDialog.show();
    }

}
