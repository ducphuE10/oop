package sample.gui.covid;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;


public class covidController {
    public Stage stage;
    public Scene scene;
    double x=0,y=0;
    @FXML
    private HBox menuBar;

    @FXML
    private Button collapseButton;

    @FXML
    private Button expandButton;
    @FXML
    private MediaView media;
    @FXML
    private ImageView image;
    @FXML
    private AnchorPane viewField;
    @FXML
    void collapse(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.millis(400));
        slider.setNode(menuBar);
        slider.setToX(-200);
        slider.play();
        slider.setOnFinished((ActionEvent e) -> expandButton.setVisible(true));
        menuBar.setTranslateX(0);

        slider = new TranslateTransition();
        slider.setNode(viewField);
        slider.setDuration(Duration.millis(400));
        slider.setToX(0);
        slider.play();
        viewField.setTranslateX(160);
    }
    @FXML
    void expand(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.millis(400));
        slider.setNode(menuBar);
        slider.setToX(0);
        slider.play();
        expandButton.setVisible(false);
        menuBar.setTranslateX(-200);

        slider = new TranslateTransition();
        slider.setNode(viewField);
        slider.setDuration(Duration.millis(400));
        slider.setToX(160);
        slider.play();
        viewField.setTranslateX(0);
    }
    @FXML
    void mouseEntered(){
        expandButton.setText("》");

    }
    @FXML
    void mouseExited(){
        expandButton.setText("〉");
    }
    @FXML
    void mouseEnteredCollapse(){
        collapseButton.setText("《");

    }
    @FXML
    void mouseExitedCollapse(){
        collapseButton.setText("〈");

    }
    @FXML
    void exit(ActionEvent e) {
//        int option = JOptionPane.showConfirmDialog(new JFrame(), "Do you sure to exit?", "Exit",
//                JOptionPane.OK_CANCEL_OPTION);
//        if (option == JOptionPane.YES_OPTION) {
            ((Stage) (((Button) e.getSource()).getScene().getWindow())).close();

//        }
    }

    @FXML
    void minimize(ActionEvent e) {
        ((Stage) (((Button) e.getSource()).getScene().getWindow())).setIconified(true);
    }
    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }
    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();

    }
    @FXML
    void virusStructure(ActionEvent e){
        media.setVisible(false);
        image.setVisible(true);
        collapse(e);

    }
    @FXML
    void animation(ActionEvent e){
        image.setVisible(false);
        media.setVisible(true);
        collapse(e);
    }
    @FXML
    void home(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/sample/gui/mainmenu/FXML/mainFxml.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}






