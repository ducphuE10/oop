package GUI.envelope.ebola;


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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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
                if (volumnBar.getValue() == 0){
                    muted.setVisible(true);
                    volumn.setVisible(false);
                }else{volumn.setVisible(true);muted.setVisible(false);}
            }
        });

        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                                                          @Override
                                                          public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                                                              progress.setValue(newValue.toSeconds());
                                                              moment.setText(""+ String.format("%02d", (int) newValue.toSeconds()/60) +":" + String.format("%02d",(int)newValue.toSeconds()%60));
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
    public void animation(ActionEvent e){
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
        textExplain.setText("Viral envelope:\n" +
                "A viral envelope is the outermost layer of many types of viruses." +
                " It protects the genetic material in their life-cycle when traveling between host cells.\n");

    }

    @FXML
    void showGlyPortein(ActionEvent event) {
        textExplain.setText("Glycoprotein:\n" +
                "The EBOV glycoprotein (GP) is the only virally expressed protein on the virion surface" +
                " and is critical for attachment to host cells and catalysis of membrane fusion. " +
                "Hence, the EBOV GP is a critical component of vaccines as well as a target of neutralizing" +
                "antibodies and inhibitors of attachment and fusion. The crystal structure of the Zaire ebolavirus" +
                " GP in its trimeric, prefusion conformation (3 GP1 plus 3 GP2) in complex with a neutralizing antibody" +
                " fragment, derived from a human survivor of the 1995 Kikwit outbreak, was recently determined. " +
                "This is the first near-complete structure of any filovirus glycoprotein. " +
                "The overall molecular architecture of the Zaire ebolavirus GP" +
                " and its role in viral entry and membrane fusion are discussed in this article.\n");

    }

    @FXML
    void showNucleprotein(ActionEvent event) {
        textExplain.setText("Nucleoprotein:\n" +
                "At 739 amino acids, the nucleoprotein (NP) of Ebola virus is the largest nucleoprotein of " +
                "the nonsegmented negative-stranded RNA viruses, and like the NPs of other viruses," +
                " it plays a central role in virus replication. Huang et al. (Y. Huang, L. Xu, Y. Sun, and G. J. Nabel, Mol. Cell)" +
                " previously demonstrated that NP, together with the minor matrix protein VP24 and polymerase cofactor VP35, " +
                "is necessary and sufficient for the formation of nucleocapsid-like structures that are morphologically" +
                " indistinguishable from those seen in Ebola virus-infected cells. T" +
                "hey further showed that NP is O glycosylated and sialylated and that these modifications are " +
                "important for interaction between NP and VP35. However, little is known about the structure-function relationship " +
                "of Ebola virus NP. Here, we examined the glycosylation of Ebola virus NP and further investigated its properties by " +
                "generating deletion mutants to define the region(s) involved in NP-NP interaction (self-assembly), " +
                "in the formation of nucleocapsid-like structures, and in the replication of the viral genome." +
                " We were unable to identify the types of glycosylation and sialylation, " +
                "although we did confirm that Ebola virus NP was glycosylated. \n");

    }


    @FXML
    void showRNA(ActionEvent event) {
        textExplain.setText("RNA genoma:\n" +
                "The EBOV genome is a single-stranded RNA, approximately 19,000 nucleotides long." +
                " It encodes seven structural proteins: nucleoprotein (NP), polymerase cofactor (VP35), (VP40), GP, transcription activator" +
                " (VP30), VP24, and RNA-dependent RNA polymerase.\n");

    }

    @FXML
    void showVP(ActionEvent event) {
        textExplain.setText("VP40,VP24:\n" +
                "the VP24 is a structural protein, that has the ability to internalize the cell nucleus," +
                " and known as a minor matrix protein and membrane‐associated protein. " +
                "Then, the latest protein “VP40” is known as a viral matrix protein," +
                " and it is the most abundant protein in Ebola's viral structure.\n");

    }


}
