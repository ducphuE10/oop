package GUI.nonenvelope.noro;


import GUI.GeneralVirusController;
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

public class noroController extends GeneralVirusController implements Initializable {
    private MediaPlayer mediaPlayer;
    private String path = "src/GUI/nonenvelope/noro/media/animation.mp4";
    @FXML
    private AnchorPane stucture;
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
    void showConstant(ActionEvent event) {
        textExplain.setText("Constant Domain:\n" +
                "the constant domain is blue. Note the large gap between the shell and P " +
                "domain and that the Fab binds to the very top of the P domain." +
                " Panel C is a stereo diagram of the pseudo atomic model of the 2D3/MNV complex. " +
                "The open and closed conformations of the P domain is shown in red and blue, respectively." +
                " The heavy chain variable and the light variable domains are shown in yellow and brown, respectively." +
                "Note that the CDR3 loop of the heavy chain fits into the cleft between the A’-B’ and E’-F’ loops in " +
                "the open conformation but completely overlaps the E’-F’ loop in the closed conformation," +
                " making it unlikely that 2D3 can bind to the closed conformation.\n");

    }

    @FXML
    void showPDomain(ActionEvent event) {
        textExplain.setText("P Domain:\n" +
                "The P domains dimerize to form protrusions on the capsid surface." +
                " The P domain is subdivided into P1 and P2 subdomains, with the latter containing the binding" +
                " sites for cellular receptors and neutralizing antibodies. There is increasing evidence " +
                "that these viruses are extremely dynamic and this flexibility is critical for viral replication. " +
                "There are at least two modes of flexibility; the entire P domain relative to the shell and within the P domain itself\n");

    }

    @FXML
    void showRNA(ActionEvent event) {
        textExplain.setText("RNA:\n" +
                " RNA as its genetic material of Virus,\n");

    }

    @FXML
    void showSDomain(ActionEvent event) {
        textExplain.setText("S domain:\n" +
                " The S domain forms a shell around the viral RNA genome.\n");

    }

    @FXML
    void showVariable(ActionEvent event) {
        textExplain.setText("Varibale Domainn:\n" +
                "the Fab variable domain is cyan\n");

    }

    @FXML
    void introVirus() {
        textExplain.setText("Viruses in Norovirus are non-enveloped, with icosahedral geometries." +
                " Capsid diameters vary widely, from 23 to 40 nm in diameter." +
                " The larger capsids (38–40 nm) exhibit T=3 symmetry and are composed of 180 VP1 proteins." +
                " Small capsids (23 nm) show T=1 symmetry, and are composed of 60 VP1 proteins." +
                " The virus particles demonstrate an amorphous surface structure when visualized using electron microscopy.");
    }


}
