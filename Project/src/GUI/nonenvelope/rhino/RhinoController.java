package GUI.nonenvelope.rhino;

import Main.Main;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import GUI.GeneralVirusController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class RhinoController extends GeneralVirusController implements Initializable {
    private MediaPlayer mediaPlayer;
    private String path = "src/GUI/nonenvelope/rhino/media/rhinovideo.mp4";
    @FXML
    private ImageView image,rhino1,rhino2,rhino3,rhino4,cell1,cell2,ARN;
    @FXML
    private Slider volumnBar;
    @FXML
    private Slider progress;
    @FXML
    private Label setData;
    @FXML                  
    private Button replay; 
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
    public void animation(ActionEvent e){
        super.animation(e);
        replay.setVisible(true);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
        rhino1.setOpacity(1);
        rhino1.setTranslateX(0);
        rhino1.setTranslateY(0);
        rhino2.setOpacity(0);
        rhino2.setTranslateX(0);
        rhino2.setTranslateY(0);
        rhino3.setOpacity(0);
        rhino3.setTranslateX(0);
        rhino3.setTranslateY(0);
        rhino4.setOpacity(0);
        rhino4.setTranslateX(0);
        rhino4.setTranslateY(0);
        ARN.setOpacity(0);
        ARN.setTranslateX(0);
        ARN.setTranslateY(0);
        ARN.setOpacity(0);
        ARN.setTranslateX(0);
        cell1.setOpacity(1);
        cell2.setOpacity(0);
    }
    @FXML
    public void runAnimation() {
    	replay.setVisible(false);
    	replay.setText("Replay");
        rhino1.setOpacity(1);
        rhino1.setTranslateX(0);
        rhino1.setTranslateY(0);
        rhino2.setOpacity(0);
        rhino2.setTranslateX(0);
        rhino2.setTranslateY(0);
        rhino3.setOpacity(0);
        rhino3.setTranslateX(0);
        rhino3.setTranslateY(0);
        rhino4.setOpacity(0);
        rhino4.setTranslateX(0);
        rhino4.setTranslateY(0);
        ARN.setOpacity(0);
        ARN.setTranslateX(0);
        ARN.setTranslateY(0);
        ARN.setOpacity(0);
        ARN.setTranslateX(0);
        cell1.setOpacity(1);
        cell2.setOpacity(0);
        
        Timeline tm10 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(cell1.opacityProperty(),  0.0)));
        Timeline tm11 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(cell1.opacityProperty(),  1.0)));
        
        Timeline tm20 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(cell2.opacityProperty(),  0.0)));
        Timeline tm21 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(cell2.opacityProperty(),  1.0)));
        
        Timeline tmVirus10 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(rhino1.opacityProperty(),  0.0)));
        Timeline tmVirus11 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(rhino1.opacityProperty(),  1.0)));
        
        Timeline tmVirus20 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(rhino2.opacityProperty(),  0.0)));
        Timeline tmVirus21 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(rhino2.opacityProperty(),  1.0)));
        
        Timeline tmVirus30 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(rhino3.opacityProperty(),  0.0)));
        Timeline tmVirus31 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(rhino3.opacityProperty(),  1.0)));
        
        Timeline tmVirus40 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(rhino4.opacityProperty(),  0.0)));
        Timeline tmVirus41 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(rhino4.opacityProperty(),  1.0)));
        
        Timeline tmARN10 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(ARN.opacityProperty(),  0.0)));
        Timeline tmARN11 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(ARN.opacityProperty(),  1.0)));
        
        
        TranslateTransition phase1 = new TranslateTransition();
        phase1.setDuration(Duration.millis(2000));
        phase1.setNode(rhino1);
        phase1.setToX(596-163);
        phase1.setToY(28-75);
        phase1.play();
        phase1.setOnFinished(event -> {
        	tm10.play();
        	tm21.play();
            
            TranslateTransition phase2 = new TranslateTransition();
            phase2.setDuration(Duration.millis(1000));
            phase2.setDelay(Duration.millis(1000));
            phase2.setNode(rhino1);
            phase2.setToX(692-163);
            phase2.setToY(14-75);
            phase2.setOnFinished(event2 ->{
                tmVirus10.play();
                tmVirus21.play();
                
                
                tmVirus21.setOnFinished(event3 -> {
                	tmVirus20.setDelay(Duration.millis(1000));
                	tmVirus20.play();
                	tmVirus31.setDelay(Duration.millis(1000));
                  	tmVirus31.play();
                  	
                  	tmVirus31.setOnFinished(event4 -> {
	                  	tmVirus30.setDelay(Duration.millis(1000));
	                  	tmVirus30.play();
	         
	                  	tmVirus41.setDelay(Duration.millis(1000));
	                  	tmVirus41.play();
	                  	tmARN11.play();
	                  	tmVirus41.setOnFinished(event5 -> {
	                    		replay.setVisible(true);
	                  	});
                  	});
                });
                
            });
            phase2.play();
            
        });
        
        phase1.play();
    }

//IMPLEMENT VIDEO 
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
    
 //SET STRUCTURE FOR RHINO VIRUS
    @Override
    public void virusStructure(ActionEvent e) {
        super.virusStructure(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }
    @FXML
    public void getRNAg() {
    	setData.setText(Main.rhino.getSsRNAgen());
    	setData.setMaxWidth(260);
    	setData.setWrapText(true);
    	}
    @FXML
    public void getIV() {
    	setData.setText(Main.rhino.getTypeOfNucleocapsid().getTypeOfStructureOfCapsid());
    	setData.setMaxWidth(260);
    	setData.setWrapText(true);
    }
}
