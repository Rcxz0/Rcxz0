
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private MenuBar menu;
    @FXML
    private MenuItem add;
    @FXML
    private MenuItem search;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void adding(ActionEvent event) throws IOException {
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("InformationMissing.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Add Missing");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void searching(ActionEvent event) throws IOException {
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("SearchForMissing.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Search For Missing");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }


    
}
