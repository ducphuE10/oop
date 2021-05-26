package GUI.envelope.covid;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.Main;
import GUI.GeneralVirusController;
//import Virus.envelope.CoronaVirus;
import javafx.animation.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class CovidController extends GeneralVirusController implements Initializable {
    private MediaPlayer mediaPlayer;
    private String path = "src/GUI/envelope/covid/media/covidvideo.mp4";
    @FXML
    private ImageView image, hostCell1, hostCell2, virus1, virus2;
    @FXML
    private Slider volumnBar;
    @FXML
    private Slider progress;
    @FXML
    private Label moment;
    @FXML
    private Label setData;
    @FXML
    private Button replay;


    @Override
    public void initialize(URL agr0, ResourceBundle agr1) {
    }

    @Override
    public void video(ActionEvent e) {
        super.video(e);
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

    @Override
    public void virusStructure(ActionEvent e) {
        super.virusStructure(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }

    @Override
    public void animation(ActionEvent e) {
        replay.setText("PLAY");
        super.animation(e);
        try {
            virus1.setTranslateX(0);
            virus1.setRotate(0);
            virus1.setTranslateY(0);
            virus1.setOpacity(1);
            virus2.setOpacity(0);
            hostCell1.setOpacity(1);
            hostCell2.setOpacity(0);
            mediaPlayer.stop();
        } catch (Exception e1) {
        }




    }
    public void runAnimation(){
        replay.setVisible(false);
        replay.setText("Replay");
        virus1.setTranslateX(0);
        virus1.setRotate(0);
        virus1.setTranslateY(0);
        virus1.setOpacity(1);
        virus2.setOpacity(0);
        hostCell1.setOpacity(1);
        hostCell2.setOpacity(0);
        Timeline tm10 = new Timeline(new KeyFrame(Duration.millis(500),new KeyValue(hostCell1.opacityProperty(),  0.0)));
        Timeline tm11 = new Timeline(new KeyFrame(Duration.millis(500),new KeyValue(hostCell1.opacityProperty(),  1.0)));
        Timeline tm20 = new Timeline(new KeyFrame(Duration.millis(500),new KeyValue(hostCell2.opacityProperty(),  0.0)));
        Timeline tm21 = new Timeline(new KeyFrame(Duration.millis(500),new KeyValue(hostCell2.opacityProperty(),  1.0)));
        Timeline tmVirus10 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(virus1.opacityProperty(),  0)));
        Timeline tmVirus21 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(virus2.opacityProperty(),  1.0)));

        tm10.setDelay(Duration.millis(500));tm11.setDelay(Duration.millis(550));tm20.setDelay(Duration.millis(500));tm21.setDelay(Duration.millis(500));

        RotateTransition rotation = new RotateTransition();
        PauseTransition pause = new PauseTransition();
        pause.setDuration(Duration.millis(4000));
        pause.setOnFinished(event -> {
            tmVirus10.setOnFinished(event1 -> {
                replay.setVisible(true);
            });

            tmVirus10.play();
            tmVirus21.play();


        });

        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.millis(2000));
        slider.setNode(virus1);
        slider.setToX(-180);
        slider.setToY(136);


        TranslateTransition slider1 = new TranslateTransition();
        slider1.setDuration(Duration.millis(1000));
        slider1.setNode(virus1);
        slider1.setToX(-195);
        slider1.setToY(202);

        TranslateTransition slider2 = new TranslateTransition();
        slider2.setDuration(Duration.millis(2000));
        slider2.setNode(virus1);
        slider2.setToX(-301);
        slider2.setToY(391);

        Timeline tm3 = new Timeline(new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                slider2.play();
                tm11.play();
                tm20.play();
                pause.play();

            }
        }));


        rotation.setNode(virus1);
        rotation.setByAngle(8.1);
        rotation.setDuration(Duration.millis(500));

        slider.setOnFinished(event -> {
            replay.setVisible(false);
            tm10.play();
            tm21.play();
            slider1.play();
            rotation.play();
            tm3.play();


        });
        slider.play();


    }


    @Override
    public void home(ActionEvent e) throws IOException {
        super.home(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }

    @FXML
    public void play(ActionEvent e) {
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
        mediaPlayer.setRate(2);

    }

    @FXML
    public void fast(ActionEvent e) {
        mediaPlayer.setRate(2);

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

    @FXML
    public void setEP(ActionEvent e) {
        setData.setText(Main.corona.evenlopeProtein);
        setData.setMaxWidth(260);
        setData.setWrapText(true);
    }

    @FXML
    public void setMP(ActionEvent e) {
        setData.setText(Main.corona.mprotein);
        setData.setMaxWidth(260);
        setData.setWrapText(true);
    }

    @FXML
    public void setSG(ActionEvent e) {
        setData.setText(Main.corona.spike);
        setData.setMaxWidth(260);
        setData.setWrapText(true);
    }

    @FXML
    public void setNP(ActionEvent e) {
        setData.setText(Main.corona.typeOfNucleocapsid.getTypeOfStructureOfCapsid());
        setData.setMaxWidth(260);
        setData.setWrapText(true);
    }

    @FXML
    public void setLM(ActionEvent e) {
        setData.setText(Main.corona.envelopeOfVirus.getEnvelopeOfVirus());
        setData.setMaxWidth(260);
        setData.setWrapText(true);
    }

}

