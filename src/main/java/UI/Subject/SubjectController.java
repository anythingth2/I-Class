package UI.Subject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import java.io.IOException;

import Main.Main;

public class SubjectController {
    @FXML private Pane sbj1;
    @FXML private Label name1;
    @FXML private Label label1;
    private String path1;

    @FXML private Pane sbj2;
    @FXML private Label name2;
    @FXML private Label label2;
    private String path2;

    @FXML private Pane sbj3;
    @FXML private Label name3;
    @FXML private Label label3;
    private String path3;

    @FXML private ImageView arwl;
    @FXML private ImageView arwr;
    private ColorAdjust color = new ColorAdjust();

    public void initialize(){
        setInitialData();
    }

    private void setSubject1Detail(String name, String label, String path){
        name1.setText(name);
        label1.setText(label);
        path1 = path;
    }

    private void setSubject2Detail(String name, String label, String path){
        name2.setText(name);
        label2.setText(label);
        path2 = path;
    }

    private void setSubject3Detail(String name, String label, String path){
        name3.setText(name);
        label3.setText(label);
        path3 = path;
    }

    private void displayBlueShadow(Pane subject){
        subject.setStyle("-fx-effect: dropshadow(three-pass-box, #0399D8, 30, 0, 0, 0);");
    }

    private void displayBlackShadow(Pane sbj){
        sbj.setStyle("-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
    }

    @FXML private void onSubject1Entered() throws IOException {
        displayBlueShadow(sbj1);
    }
    @FXML private void onSubject1Exited() throws IOException {
        displayBlackShadow(sbj1);
    }
    @FXML private void onSubject1Clicked() throws IOException {
//        Main.showPage(path1);
    }

    @FXML private void onSubject2Entered() throws IOException {
        displayBlueShadow(sbj2);
    }
    @FXML private void onSubject2Exited() throws IOException {
        displayBlackShadow(sbj2);
    }
    @FXML private void onSubject2Clicked() throws IOException {
//        Main.showPage(path2);
    }

    @FXML private void onSubject3Entered() throws IOException {
        displayBlueShadow(sbj3);
    }
    @FXML private void onSubject3Exited() throws IOException {
        displayBlackShadow(sbj3);
    }
    @FXML private void onSubject3Clicked() throws IOException {
//        Main.showPage(path3);
    }

    @FXML private void onLeftAction() throws IOException {
        arwr.setVisible(true);
        arwl.setVisible(false);
        setSubject1Detail("OOAD", "Object Oriented Analysis and Design", "src/main/java/UI/Login/login.fxml");
        setSubject2Detail("OOAD", "Object Oriented Analysis and Design", "src/main/java/UI/Login/login.fxml");
        setSubject3Detail("OOAD", "Object Oriented Analysis and Design", "src/main/java/UI/Login/login.fxml");
    }
    @FXML private void onLeftEntered() throws IOException {
        color.setBrightness(-100.0);
        arwl.setEffect(color);
    }
    @FXML private void onLeftExited() throws IOException {
        color.setBrightness(0.0);
        arwl.setEffect(color);
    }

    @FXML private void onRightAction() throws IOException {
        arwl.setVisible(true);
        arwr.setVisible(false);
        setSubject1Detail("SE", "Software Engineering", "src/main/java/UI/Login/login.fxml");
        setSubject2Detail("ToC", "Theory of Computation", "src/main/java/UI/Login/login.fxml");
        setSubject3Detail("CA", "Computer Architecture", "src/main/java/UI/Login/login.fxml");
    }
    @FXML private void onRightEntered() throws IOException {
        color.setBrightness(-100.0);
        arwr.setEffect(color);
    }
    @FXML private void onRightExited() throws IOException {
        color.setBrightness(0.0);
        arwr.setEffect(color);
    }

    public void setInitialData(){
        setSubject1Detail("OOAD", "Object Oriented Analysis and Design", "src/main/java/UI/Login/login.fxml");
        setSubject2Detail("OOAD", "Object Oriented Analysis and Design", "src/main/java/UI/Login/login.fxml");
        setSubject3Detail("OOAD", "Object Oriented Analysis and Design", "src/main/java/UI/Login/login.fxml");
    }

}
