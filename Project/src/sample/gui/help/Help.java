package sample.gui.help;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Help extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
        Scene sc = new Scene(root);
        
        primaryStage.setTitle("Hello World");
        
        primaryStage.setScene(sc);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        primaryStage.show();
        
    }


//    public static void main(String[] args) {
//        launch(args);
//    }
}
