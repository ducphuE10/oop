package GUI.nonenvelope.polio;

import Main.Main;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import GUI.GeneralVirusController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
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

public class PolioController extends GeneralVirusController implements Initializable {
    private double speed =1 ;
    private MediaPlayer mediaPlayer;
    private String path = "src/GUI/nonenvelope/polio/media/poliocycle.mp4";
    @FXML
    private ImageView image;
    @FXML
    private ImageView polio1, polio2, polio3,polio4,cell1,cell2,ARN1,ARN2;
    @FXML
    private Slider volumnBar;
    @FXML
    private Slider progress;
    @FXML                  
    private Button replay;
    @FXML 
    private Label setData;

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
    public void animation(ActionEvent e) throws IOException {
    	super.animation(e);
        replay.setText("PLAY");
        try {
        mediaPlayer.stop();
        } catch (Exception e1) {
        };

    }
    @FXML
    public void runAnimation(){
        polio1.setOpacity(1);
        polio1.setTranslateX(0);
        polio1.setTranslateY(0);

        polio2.setOpacity(0);
        polio2.setTranslateX(0);
        polio2.setTranslateY(0);
        
        polio3.setOpacity(0);
        polio3.setTranslateX(0);
        polio3.setTranslateY(0);
 
        polio4.setOpacity(0);
        polio4.setTranslateX(0);
        polio4.setTranslateY(0);
        
        ARN1.setOpacity(0);
        ARN1.setTranslateX(0);
        ARN1.setTranslateY(0);
        
        ARN2.setOpacity(0);
        ARN2.setTranslateX(0);
        ARN2.setTranslateY(0);
              
        cell1.setOpacity(1);
        cell2.setOpacity(0);
        
        replay.setVisible(false);
        replay.setText("Replay");
        
        Timeline tm10 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(cell1.opacityProperty(),  0.0)));
        Timeline tm11 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(cell1.opacityProperty(),  1.0)));
        Timeline tm20 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(cell2.opacityProperty(),  0.0)));
        Timeline tm21 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(cell2.opacityProperty(),  1.0)));
        
        Timeline tmVirus10 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(polio1.opacityProperty(),  0.0)));
        Timeline tmVirus11 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(polio1.opacityProperty(),  1.0)));
        
        Timeline tmVirus20 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(polio2.opacityProperty(),  0.0)));
        Timeline tmVirus21 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(polio2.opacityProperty(),  1.0)));
        
        Timeline tmVirus30 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(polio3.opacityProperty(),  0.0)));
        Timeline tmVirus31 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(polio3.opacityProperty(),  1.0)));
        
        Timeline tmVirus41 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(polio4.opacityProperty(),  1.0)));
        
        Timeline tmARN11 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(ARN1.opacityProperty(),  1.0)));
        Timeline tmARN10 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(ARN1.opacityProperty(),  0.0)));
        
        Timeline tmARN21 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(ARN2.opacityProperty(),  1.0)));
        Timeline tmARN20 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(ARN2.opacityProperty(),  0.0)));

        TranslateTransition phase1 = new TranslateTransition();
        
        phase1.setNode(polio1);
        phase1.setDuration(Duration.millis(2000));
        phase1.setToX(114);
        phase1.setToY(184);
        
        phase1.setOnFinished(event ->{
        	tm21.play();
        	tmVirus10.play();
        	tmVirus21.play();
        	tmVirus21.setOnFinished(event1 -> {
        		tmVirus20.setDelay(Duration.millis(1000));
            	tmVirus20.play();
            	tmVirus31.setDelay(Duration.millis(1000));
            	tmVirus31.play();
            	tmARN11.setDelay(Duration.millis(1000));
            	tmARN11.play();
            	tmARN11.setOnFinished(event2->{
                	tmVirus30.setDelay(Duration.millis(500));
                	tmVirus30.play();
              	
                	tmARN10.setDelay(Duration.millis(1000));
                	tmARN10.play();
          	
                	tmARN21.setDelay(Duration.millis(1500));
                	tmARN21.play();
          	
                	tmARN21.setOnFinished(event3->{
                    	tmARN20.setDelay(Duration.millis(1000));
                    	tmARN20.play();
                    	tmVirus41.setDelay(Duration.millis(1000));
                    	tmVirus41.play();
                    	tmVirus41.setOnFinished(event4->{
                    		replay.setVisible(true);
                    	});
                	});
            	});
        	});
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
    
    
//SET STRUCTURE FOR POLIO VIRUS
    @Override
    public void virusStructure(ActionEvent e) {
        super.virusStructure(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }
    @FXML
    public void setCapsid() {
    	setData.setText(Main.polio.getTypeOfNucleocapsid().getTypeOfStructureOfCapsid());
    	setData.setMaxWidth(260);
    	setData.setWrapText(true);
    }
    @FXML
    public void setRNA() {
    	setData.setText(Main.polio.getSsRNA());
    	setData.setMaxWidth(260);
    	setData.setWrapText(true);
    }
    @FXML 
    public void setVPg() {
    	setData.setText(Main.polio.getVPg());
    	setData.setMaxWidth(260);
    	setData.setWrapText(true);
    }


}