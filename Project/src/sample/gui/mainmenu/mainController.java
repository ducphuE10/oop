package sample.gui.mainmenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    private Parent root;
    private double x = 0;
    private double y = 0;
    private Stage stage;
    private Scene scene;
    private MediaPlayer music;
    private File file;
    private boolean helpStatus = false;
    private boolean envelopeVirusStatus = false;
    private boolean nonEnvelopeVirusStatus = false;
    @FXML
    private MediaView mediaView;
    @FXML
    private Button helpButton;
    @FXML
    private TextArea helpView;
    @FXML
    private Button ebolaButton;
    @FXML
    private VBox envelopeVirusView;
    @FXML
    private VBox nonEnvelopeVirusView;



    public void initialize(URL arg0, ResourceBundle arg1) {
        file = new File("src/sample/gui/mainmenu/media/background_music.mp3");
        Media media = new Media(file.toURI().toString());
        music = new MediaPlayer(media);
        music.setCycleCount(1000);
        music.play();
    }


    @FXML
    void ebolaScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/sample/gui/ebola/ebolaFxml.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void nonEnvelopeVirus(ActionEvent e) {
        if (!nonEnvelopeVirusStatus) {
            nonEnvelopeVirusView.setVisible(true);
            nonEnvelopeVirusStatus = true;
            helpView.setVisible(false);
            helpStatus = false;
            envelopeVirusView.setVisible(false);
            envelopeVirusStatus = false;

        } else {
            nonEnvelopeVirusView.setVisible(false);
            nonEnvelopeVirusStatus = false;
        }
    }

    @FXML
    void envelopeVirus(ActionEvent e) {

        if (!envelopeVirusStatus) {
            envelopeVirusView.setVisible(true);
            envelopeVirusStatus = true;
            helpView.setVisible(false);
            helpStatus = false;
            nonEnvelopeVirusView.setVisible(false);
            nonEnvelopeVirusStatus = false;

        } else {
            envelopeVirusView.setVisible(false);
            envelopeVirusStatus = false;
        }

    }

    @FXML
    void help(ActionEvent e) {
        envelopeVirusView.setVisible(false);
        if (!helpStatus) {
            helpView.setVisible(true);
            helpStatus = true;
            envelopeVirusView.setVisible(false);
            envelopeVirusStatus = false;
            nonEnvelopeVirusView.setVisible(false);
            nonEnvelopeVirusStatus = false;
        } else {
            helpView.setVisible(false);
            helpStatus = false;
        }
    }

    @FXML
    void exit(ActionEvent e) {


//        UIManager UI = new UIManager();
//        UI.put("OptionPane.background", new ColorUIResource(123, 8, 8));
//        UI.put("Panel.background", new ColorUIResource(123, 8, 8));
        int option = JOptionPane.showConfirmDialog(new JFrame(), "Do you sure to exit?", "Exit",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            ((Stage) (((Button) e.getSource()).getScene().getWindow())).close();

        }
    }
    @FXML
    void minimize(ActionEvent e){
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


}
