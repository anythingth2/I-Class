package UI.Course;

import Main.Main;
import Model.Course;
import Model.Student;
import Model.Teacher;
import Model.TeachingClass;
import UI.Controller;
import UI.Course.InnerPane.AssignmentMaterial.AssignmentMaterialController;
import UI.Course.InnerPane.AssignmentMaterial.AssignmentMaterialPane;
import UI.Course.InnerPane.CourseInfo.CourseInfoPane;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialController;
import UI.Course.InnerPane.CourseMaterial.CourseMaterialPane;
import UI.Course.InnerPane.StudentTodoPane.StudentTodoPane;

import UI.Dialog.AnnouncementDialog.announcementDialogController;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkController;
import UI.Dialog.CreateHomeworkDialog.CreateHomeworkDialog;
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
    private Pane teachingClassPane;

    private Course course;
    private List<TeachingClass> teachingClasses;


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

    public CourseUI(Course course) {
        this();

        this.course = course;
        this.teachingClasses = course.getTeachingClasses();
        this.initialise();
    }

    private void initialise() {
        this.announcementLabel.setText(this.course.getAnnouncement());
        this.accountIdTextView.setText(Main.getApplicationController().getUser().getUserid());
        this.titleLabel.setText(this.course.getName());
        this.courseInfoButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setTeachingClassPane(new CourseInfoPane(course));
            }
        });
        this.todoButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Pane pane = new StudentTodoPane();
                setTeachingClassPane(pane);
            }
        });


        boolean isTeacher = Main.getApplicationController().getUser() instanceof Teacher;
        this.editAnnouncementButton.setVisible(isTeacher);

        this.setTeachingClassPane(new CourseInfoPane(this.course));
        this.refresh();
    }

    private void refresh() {
        this.classVBox.getChildren().clear();
        this.classItemPanes.clear();
        for (final TeachingClass teachingClass : this.teachingClasses) {
            if (teachingClass.getMaterial() != null) {

                ClassItemPane classItemPane = new ClassItemPane(teachingClass,
                        teachingClass.getMaterial());
                if (teachingClass.getMaterial() instanceof Model.AssignmentMaterial)
                    classItemPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            AssignmentMaterialController assignmentMaterialController = new AssignmentMaterialController(teachingClass);
                            setTeachingClassPane(assignmentMaterialController);
                        }
                    });
                else
                    classItemPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            CourseMaterialController courseMaterialController = new CourseMaterialController(teachingClass);
                            setTeachingClassPane(courseMaterialController);
                        }
                    });
                this.classItemPanes.add(classItemPane);
            }
        }
        for (ClassItemPane classItemPane : this.classItemPanes) {
            this.classVBox.getChildren().add(classItemPane);
        }
    }

    private void setTeachingClassPane(Node pane) {
        if (this.teachingClassPane.getChildren().size() > 0) {
            this.teachingClassPane.getChildren().set(0, pane);
        } else {
            this.teachingClassPane.getChildren().add(pane);
        }
    }

    private void setTeachingClassPane(Controller controller) {
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
    void openTypeDialog(MouseEvent event) {
//        try {
//            URL url = new File("src/main/java/UI/Dialog/TypeDialog/typeDialog.fxml").toURL();
//            Parent root1 = FXMLLoader.load(url);
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root1));
//            stage.show();
//        } catch (Exception e) {
//            System.out.println("Can't load");
//            e.printStackTrace();
//        }
        final CreateMaterialController createMaterialController = new CreateMaterialController() {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {
                teachingClasses.add(teachingClass);
                refresh();
            }
        };
        final CreateHomeworkController createHomeworkController = new CreateHomeworkController() {
            @Override
            public void onCreateSuccess(TeachingClass teachingClass) {
                teachingClasses.add(teachingClass);
                refresh();
            }
        };
        TypeDialog typeDialog = new TypeDialog() {
            @Override
            public void onAccept(TypeRadio typeRadio) {
                if (typeRadio == TypeRadio.Material)
                    createMaterialController.show();
                else if (typeRadio == TypeRadio.Homework)
                    createHomeworkController.show();

            }
        };
        typeDialog.show();
    }

    @FXML
    void openEditAnnouncement(ActionEvent event) {

        final announcementDialogController announcementDialog = new announcementDialogController();
        announcementDialog.show();

    }

}
