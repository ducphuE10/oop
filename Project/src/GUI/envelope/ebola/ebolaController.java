package GUI.envelope.ebola;

import Main.Main;
import GUI.GeneralVirusController;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class ebolaController extends GeneralVirusController implements Initializable {
    private MediaPlayer mediaPlayer;
    private String path = "src/GUI/envelope/ebola/media/animation.mp4";
    @FXML
    private ImageView image;
    @FXML
    private Slider volumnBar;
    @FXML
    private Slider progress;
    @FXML
    private TextArea textExplain;


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
    public void home(ActionEvent e) throws IOException {
        super.home(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }

    @Override
    public void animation(ActionEvent e) {
        super.animation(e);
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
    void showEnvelope(ActionEvent event) {
        textExplain.setText(Main.ebola.envelopeOfVirus.getEnvelopeOfVirus());

    }

    @FXML
    void showGlyPortein(ActionEvent event) {
        textExplain.setText(Main.ebola.GlyProtein);

    }

    @FXML
    void showNucleprotein(ActionEvent event) {
        textExplain.setText(Main.ebola.Nucleprotein);

    }

    @FXML
    void showRNA(ActionEvent event) {
        textExplain.setText(Main.ebola.RNA);
    }

    @FXML
    void showVP(ActionEvent event) {
        textExplain.setText(Main.ebola.VP);

    }


}
