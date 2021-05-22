package GUI;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class GeneralVirusController {
    public Stage stage;
    public Scene scene;
    double x = 0, y = 0;

    public MediaPlayer mediaPlayer;
    @FXML
    public Slider progress, volumnBar;
    @FXML
    public Label moment;
    @FXML
    public Button collapseButton;
    @FXML
    public Button expandButton;
    @FXML
    public MediaView media;
    @FXML
    public ImageView image, volumn, muted;
    @FXML
    public AnchorPane viewField, playingBar,animationView,menuBar;

    @FXML
    void collapse(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.millis(400));
        slider.setNode(menuBar);
        slider.setToX(-200);
        slider.play();
        slider.setOnFinished((ActionEvent e) -> expandButton.setVisible(true));
        menuBar.setTranslateX(0);
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

    }

    @FXML
    void mouseEntered() {
        expandButton.setText("》");
        expand(new ActionEvent());

    }

    @FXML
    void mouseExited() {
        expandButton.setText("〉");
    }

    @FXML
    void mouseEnteredCollapse() {
        collapseButton.setText("《");

    }

    @FXML
    void mouseExitedCollapse() {
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
    public void virusStructure(ActionEvent e) {
        media.setVisible(false);
        animationView.setVisible(false);
        image.setVisible(true);
        playingBar.setVisible(false);
        collapse(e);

    }
    @FXML
    public void animation(ActionEvent e){

        media.setVisible(false);
        image.setVisible(false);
        playingBar.setVisible(false);
        animationView.setVisible(true);
        collapse(e);
   }

    @FXML
    public void video(ActionEvent e) {

        image.setVisible(false);
        animationView.setVisible(false);
        media.setVisible(true);
        playingBar.setVisible(true);
        collapse(e);

    }

    @FXML
    public void home(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/mainmenu/FXML/mainFxml.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void showPlayingBar(){
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.millis(400));
        slider.setNode(playingBar);
        slider.setToY(0);
        slider.play();
        playingBar.setTranslateY(55);
    }
    @FXML
    public void hidePlayingBar(){
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.millis(400));
        slider.setNode(playingBar);
        slider.setToY(55);
        slider.play();
        playingBar.setTranslateY(0);
    }

}






