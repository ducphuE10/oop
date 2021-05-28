package GUI.envelope.ebola;

import Main.Main;
import GUI.GeneralVirusController;
import javafx.animation.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EbolaController extends GeneralVirusController implements Initializable {
    private MediaPlayer mediaPlayer;
    private double speed = 1;
    private String path = "src/GUI/envelope/ebola/media/animation.mp4";
    @FXML
    private ImageView image,virus1, virus2, virus3,cell1,cell2,ARN;
    @FXML
    private Slider volumnBar;
    @FXML
    private Slider progress;
    @FXML
    private Label textExplain;
    @FXML
    private Button replay,animationButton;


    @Override
    public void initialize(URL agr0, ResourceBundle agr1) {
    }


//BACK TO MAIN MENU
    @Override
    public void home(ActionEvent e) throws IOException {
        super.home(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        	}
    }

    
//RUN ANIMATION
// IMPLEMENT RUN ANIMATION
    @Override
    public void animation(ActionEvent e) {
        super.animation(e);
        replay.setVisible(true);
        replay.setText("PLAY");
        try {
            mediaPlayer.stop();
            virus1.setOpacity(1);
            virus1.setTranslateX(0);
            virus1.setTranslateY(0);
            virus2.setOpacity(0);
            virus2.setTranslateX(0);
            virus2.setTranslateY(0);
            virus2.setRotate(0);
            virus3.setOpacity(0);
            virus3.setTranslateX(0);
            virus3.setTranslateY(0);
            ARN.setOpacity(0);
            ARN.setTranslateX(0);
            ARN.setTranslateY(0);
            cell1.setOpacity(1);
            cell2.setOpacity(0);
        } catch (Exception e1) {
        	}
    }
    @FXML

    public void runAnimation(){
        animationButton.setDisable(true);
        virus1.setOpacity(1);
        virus1.setTranslateX(0);
        virus1.setTranslateY(0);
        virus2.setOpacity(0);
        virus2.setTranslateX(0);
        virus2.setTranslateY(0);
        virus2.setRotate(0);
        virus3.setOpacity(0);
        virus3.setTranslateX(0);
        virus3.setTranslateY(0);
        ARN.setOpacity(0);
        ARN.setTranslateX(0);
        ARN.setTranslateY(0);
        ARN.setRotate(110);
        cell1.setOpacity(1);
        cell2.setOpacity(0);
        replay.setVisible(false);
        replay.setText("Replay");
        Timeline tm10 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(cell1.opacityProperty(),  0.0)));
        Timeline tm11 = new Timeline(new KeyFrame(Duration.millis(2000),new KeyValue(cell1.opacityProperty(),  1.0)));
        Timeline tm20 = new Timeline(new KeyFrame(Duration.millis(2000),new KeyValue(cell2.opacityProperty(),  0.0)));
        Timeline tm21 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(cell2.opacityProperty(),  1.0)));
        Timeline tmVirus10 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(virus1.opacityProperty(),  0)));
        Timeline tmVirus21 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(virus2.opacityProperty(),  1.0)));
        Timeline tmVirus20 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(virus2.opacityProperty(),  0.0)));
        Timeline tmVirus31 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(virus3.opacityProperty(),  1.0)));
        Timeline tmVirus30 = new Timeline(new KeyFrame(Duration.millis(2000),new KeyValue(virus3.opacityProperty(),  0.0)));
        Timeline tmARN1 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(ARN.opacityProperty(),  1.0)));
        TranslateTransition phase1 = new TranslateTransition();
        phase1.setNode(virus1);
        phase1.setDuration(Duration.millis(2000));
        phase1.setToX(385);
        phase1.setToY(139);
        phase1.setOnFinished(event ->{
            TranslateTransition phase2 = new TranslateTransition();
            phase2.setDuration(Duration.millis(1000));
            phase2.setNode(virus1);
            phase2.setToX(437);
            phase2.setToY(145);
            phase2.setOnFinished(event1->{
                TranslateTransition phase3 = new TranslateTransition();
                phase3.setDuration(Duration.millis(3000));
                phase3.setNode(virus2);
                phase3.setToX(158);
                phase3.setToY(-150);
                phase3.setOnFinished(event2 -> {
                    tmARN1.setDelay(Duration.millis(2000));
                    tmARN1.play();
                    tmVirus31.setDelay(Duration.millis(2000));
                    tmVirus31.play();
                    tmVirus20.setDelay(Duration.millis(2000));
                    tmVirus20.play();
                    TranslateTransition phase4 = new TranslateTransition();
                    phase4.setDelay(Duration.millis(3000));
                    phase4.setDuration(Duration.millis(2500));
                    phase4.setNode(ARN);
                    phase4.setToX(-34);
                    phase4.setToY(178);
                    phase4.setOnFinished(event3 -> {
                        tmVirus30.play();
                        replay.setVisible(true);
                        animationButton.setDisable(false);
                    });
                    RotateTransition rotate2 = new RotateTransition();
                    rotate2.setDelay(Duration.millis(3000));
                    rotate2.setNode(ARN);
                    rotate2.setDuration(Duration.millis(2000));
                    rotate2.setToAngle(70);
                    rotate2.play();
                    phase4.play();

                });
                RotateTransition rotate = new RotateTransition();
                rotate.setDuration(Duration.millis(1500));
                rotate.setNode(virus2);
                rotate.setByAngle(110);

                rotate.play();
                tmVirus21.play();
                tmVirus10.play();
                phase3.play();
                tm11.play();
                tm20.play();

            });
            tm10.play();
            tm21.play();
            phase2.play();
        });
        phase1.play();

    }

//IMPLEMENT VIDEO
    @Override
    public void video(ActionEvent e) {
        super.video(e);
        try{mediaPlayer.stop();}catch(Exception e1){}
        File file = new File(this.path);
        Media m = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(m);
        media.setMediaPlayer(mediaPlayer);

        volumnBar.setValue(mediaPlayer.getVolume() * 100);
        volumnBar.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaPlayer.setVolume(volumnBar.getValue() / 100);
                if (volumnBar.getValue() == 0) {
                    muted.setVisible(true);
                    volumn.setVisible(false);
                } else {
                    volumn.setVisible(true);
                    muted.setVisible(false);
                }
            }
        });

        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                                                          @Override
                                                          public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                                                              progress.setValue(newValue.toSeconds());
                                                              moment.setText("" + String.format("%02d", (int) newValue.toSeconds() / 60) + ":" + String.format("%02d", (int) newValue.toSeconds() % 60));
                                                          }
                                                      }
        );

        progress.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.seek(Duration.seconds(progress.getValue()));
            }
        });

        progress.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.seek(Duration.seconds(progress.getValue()));
            }
        });

        mediaPlayer.setOnReady(new Runnable() {
            @Override
            public void run() {
                double total = mediaPlayer.getStopTime().toSeconds();
                progress.setMax(total);
            }
        });

        mediaPlayer.play();
    }
//IMPLEMENT VIDEO
    @FXML
    public void play(ActionEvent e) {
        this.speed = 1;
        mediaPlayer.play();
        mediaPlayer.setRate(1);
    }
    @FXML
    public void pause(ActionEvent e) {
        mediaPlayer.pause();
    }
    @FXML
    public void skipUp(ActionEvent e) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(5)));
    }
    @FXML
    public void skipDown(ActionEvent e) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(-5)));
    }
    @FXML
    public void slow(ActionEvent e) {
        this.speed /=2;
        mediaPlayer.setRate(speed);
    }
    @FXML
    public void fast(ActionEvent e) {
        this.speed *=2;
        mediaPlayer.setRate(speed);
    }
    @FXML
    public void mute() {
        if (volumnBar.getValue() > 0) {
            volumnBar.setValue(0);
            muted.setVisible(true);
            volumn.setVisible(false);
        } else {
            volumnBar.setValue(10);
            muted.setVisible(false);
            volumn.setVisible(true);
        }
    }

    
//SET STRUCTURE FOR EBOLA VIRUS
    @Override
    public void virusStructure(ActionEvent e) {
        super.virusStructure(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }
//SET STRUCTURE FOR EBOLA VIRUS
    @FXML
    void showEnvelope(ActionEvent event) {
        textExplain.setText(Main.ebola.getEnvelopeOfVirus().getEnvelopeOfVirus());
    }
    @FXML
    void showGlyPortein(ActionEvent event) {
        textExplain.setText(Main.ebola.getGlyProtein());
    }
    @FXML
    void showNucleprotein(ActionEvent event) {
        textExplain.setText(Main.ebola.getNucleprotein());
    }
    @FXML
    void showRNA(ActionEvent event) {
        textExplain.setText(Main.ebola.getRNA());
    }
    @FXML
    void showVP(ActionEvent event) {
        textExplain.setText(Main.ebola.getVP());
    }

}
