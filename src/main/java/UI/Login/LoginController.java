package UI.Login;

import Main.Main;
import Model.Teacher;
import Model.User;
import UI.Controller;
import UI.Subject.SubjectController;
import javafx.scene.Node;

public class LoginController implements Controller {

    LoginPage loginPage;

    @Override
    public Node getRoot() {
        return this.loginPage;

    }

    public LoginController() {
        super();
        this.loginPage = new LoginPage(this);
    }

    public boolean validateUserLogin(String userIdText, String pin) {
        User login_user = User.findByUserID(userIdText);
        boolean result = false;
        try {
            System.out.println(login_user.getFullName() + " isTeacher: " + (login_user instanceof Teacher));
            if (login_user.getPin().equals(pin)) {
                Main.getApplicationController().setUser(login_user);
                System.out.println(login_user.getId());
                System.out.println(login_user.getUserCourse());
//                Parent root = new SubjectPage(login_user.getUserCourse()); // Change page

                Main.getApplicationController().navigateTo(new SubjectController(login_user.getUserCourse()));
                result = true;
            } else {

                result = false;
            }

        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                //Show user not found msg
                System.out.println("User not found!");

                result = false;
            }

        }
        return result;
    }
}
