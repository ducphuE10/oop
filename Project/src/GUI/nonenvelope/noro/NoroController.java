package GUI.nonenvelope.noro;

import Main.Main;
import GUI.GeneralVirusController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NoroController extends GeneralVirusController implements Initializable {
	private MediaPlayer mediaPlayer;
	private double speed = 1;
    private String path = "src/GUI/nonenvelope/noro/media/animation.mp4";
    @FXML
    private AnchorPane stucture;
    @FXML
    private Slider volumnBar;
    @FXML
    private Slider progress;
    @FXML
    private Label textExplain;
    @FXML
    private ImageView cell1, cell2, virus1, virus2;
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
    @Override
    public void animation(ActionEvent e) {
        super.animation(e);
        try {
            replay.setText("PLAY");
            replay.setVisible(true);
            cell1.setOpacity(1);
            cell2.setOpacity(0);
            virus1.setOpacity(1);
            virus1.setTranslateX(0);
            virus1.setTranslateY(0);
            virus2.setOpacity(0);
            mediaPlayer.stop();
        } catch (Exception e1) {
        }

    }

    @FXML
    public void runAnimation(ActionEvent e) {
        animationButton.setDisable(true);
        replay.setText("REPLAY");
        replay.setVisible(false);
        cell1.setOpacity(1);
        cell2.setOpacity(0);
        virus1.setOpacity(1);
        virus1.setTranslateX(0);
        virus1.setTranslateY(0);
        virus2.setOpacity(0);

        Timeline tm10 = new Timeline(new KeyFrame(Duration.millis(1500), new KeyValue(cell1.opacityProperty(), 0.0)));
        Timeline tm11 = new Timeline(new KeyFrame(Duration.millis(1000), new KeyValue(cell1.opacityProperty(), 1.0)));
        Timeline tm20 = new Timeline(new KeyFrame(Duration.millis(1000), new KeyValue(cell2.opacityProperty(), 0.0)));
        Timeline tm21 = new Timeline(new KeyFrame(Duration.millis(1500), new KeyValue(cell2.opacityProperty(), 1.0)));
        Timeline tmVirus10 = new Timeline(new KeyFrame(Duration.millis(1000), new KeyValue(virus1.opacityProperty(), 0)));
        Timeline tmVirus21 = new Timeline(new KeyFrame(Duration.millis(1000), new KeyValue(virus2.opacityProperty(), 1.0)));

        TranslateTransition phase1 = new TranslateTransition();
        phase1.setNode(virus1);
        phase1.setDuration(Duration.millis(2500));
        phase1.setToX(-268);
        phase1.setToY(182);
        phase1.setOnFinished(event -> {
            tm10.setDelay(Duration.millis(1500));
            tm21.setDelay(Duration.millis(1500));
            TranslateTransition phase2 = new TranslateTransition();
            phase2.setNode(virus1);
            phase2.setDuration(Duration.millis(2000));
            phase2.setToX(-287);
            phase2.setToY(205);
            phase2.setDelay(Duration.millis(1500));
            phase2.setOnFinished(event1 -> {
                TranslateTransition phase3 = new TranslateTransition();
                phase3.setDuration(Duration.millis(3000));
                phase3.setNode(virus1);
                phase3.setToX(-319);
                phase3.setToY(398);
                phase3.setOnFinished(event2 -> {
                    tmVirus10.setDelay(Duration.millis(2000));
                    tmVirus21.setDelay(Duration.millis(2000));
                    tmVirus10.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            replay.setVisible(true);
                            animationButton.setDisable(false);
                        }
                    });
                    tmVirus21.play();
                    tmVirus10.play();

                });

                tm11.setDelay(Duration.millis(500));
                tm20.setDelay(Duration.millis(500));
                tm11.play();
                tm20.play();
                phase3.play();
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
   

//SET STRUCTURE FOR NORO VIRUS  
    @Override
    public void virusStructure(ActionEvent e) {
        super.virusStructure(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }
 
    @FXML
    void showConstant(ActionEvent event) {
        textExplain.setText(Main.noro.getConstantDomain());
    }
    @FXML
    void showPDomain(ActionEvent event) {
        textExplain.setText(Main.noro.getPDomain());
    }
    @FXML
    void showRNA(ActionEvent event) {
        textExplain.setText(Main.noro.getRNA());
    }
    @FXML
    void showSDomain(ActionEvent event) {
        textExplain.setText(Main.noro.getSDomain());
    }
    @FXML
    void showVariable(ActionEvent event) {
        textExplain.setText(Main.noro.getVariableDomain());
    }
    @FXML
    void introVirus() {
        textExplain.setText(Main.noro.getIntroVirus());
    }
}
