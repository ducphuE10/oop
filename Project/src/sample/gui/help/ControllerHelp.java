package sample.gui.help;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerHelp {
    @FXML
    private AnchorPane parent;

    @FXML
    void minimize_stage(ActionEvent e) {
    	((Stage) (((Button) e.getSource()).getScene().getWindow())).setIconified(true);
    }

    @FXML
    void close_app(ActionEvent e) {
    	((Stage) (((Button) e.getSource()).getScene().getWindow())).close();
    }
}
