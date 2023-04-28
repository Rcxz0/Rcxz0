
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;


public class InformationMissingController implements Initializable {

    @FXML
    private Button image;
    @FXML
    private Button add;
    @FXML
    private Button cancel;
    @FXML
    private ComboBox<String> college;
    @FXML
    private TextField name;
    @FXML
    private TextArea details;
    private File selectedFile;

    private ArrayList<String> addCollege() {
        ArrayList<String> colleges = new ArrayList<String>();
        colleges.add("College of Engineering");
        colleges.add("College of Science");
        colleges.add("College of Business");
        colleges.add("College of Arts and Sciences");
        colleges.add("College of Education");
        colleges.add("College of Law");
        colleges.add("College of Pharmacy");
        colleges.add("College of Nursing");
        return colleges;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        college.getItems().addAll(addCollege());

    }

    @FXML
    private void addImage(ActionEvent event) {
        if (name.getText().isEmpty() || details.getText().isEmpty() || college.getValue().isEmpty()) {
            Stage stage = (Stage) image.getScene().getWindow();
            stage.hide();
            JOptionPane.showMessageDialog(null, "Please fill all the fields before adding an image");
            stage.show();
        } else {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            selectedFile = fileChooser.showOpenDialog(null);

        }
    }

    @FXML
    private void added(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.hide();
        if (selectedFile != null) {
            try {
                stage.close();
                String extension = selectedFile.getName().substring(selectedFile.getName().lastIndexOf("."));
                String imageNamee= name.getText()+details.getText() + extension;
                Files.copy(selectedFile.toPath(), new File("src\\university\\missing\\images\\" + imageNamee).toPath());
                JOptionPane.showMessageDialog(null, "You have added this item");
                saveItem(imageNamee);
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("University Missing");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } else if (name.getText().isEmpty() || details.getText().isEmpty() || college.getValue().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
            stage.show();
        }

    }

    @FXML
    private void cancelAdd(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("University Missing");
        stage.setScene(scene);
        stage.show();
    }

    private void saveItem(String imageNamee) {
        try {
            String fileName="src\\university\\missing\\"+college.getValue()+".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(name.getText() + "," + details.getText() + "," + college.getValue()+","+imageNamee+'\n');
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }
}
