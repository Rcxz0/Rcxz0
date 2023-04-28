
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import university.missing.images.TheLost;

import javax.swing.*;


public class ItemInformationController implements Initializable {

    @FXML
    private ImageView images;
    @FXML
    private TextArea description;
    @FXML
    private Button take;
    private TheLost lost;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showImage();
    }

    @FXML
    private void takeThis(ActionEvent event) throws IOException {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to take this item?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (deleteItem()&&confirm==0) {
            Stage stage = (Stage) take.getScene().getWindow();
            stage.close();
            JOptionPane.showMessageDialog(null, "You have taken this item");
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("University Missing");
            stage.setScene(scene);
            stage.show();
        }
        else if(confirm==1){
            Stage stage = (Stage) take.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("University Missing");
            stage.setScene(scene);
            stage.show();
        }
    }

    private void showImage() {

        File file = new File("src\\university\\missing\\selectedItem.txt");
        try {
            Scanner scanner = new Scanner(file);
            String name = scanner.nextLine();
            String collegeName = scanner.nextLine();
            String desc = scanner.nextLine();
            String imageName = scanner.nextLine();
            String imagePath = "src\\university\\missing\\images\\" + imageName;
            description.setText(desc);
            Image image = new Image(new File(imagePath).toURI().toString());
            images.setImage(image);
            scanner.close();
            Files.deleteIfExists(file.toPath());
            lost = new TheLost(name, desc, collegeName, imageName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean deleteItem() {
        boolean taken = false;
        File file = new File("src\\university\\missing\\" + lost.getCollege() + ".txt");
        PrintWriter output = null;
        try {
            output= new PrintWriter("src\\university\\missing\\selectedItem.txt");
            Scanner in = new Scanner(file);
            int count = 0;
            while (in.hasNextLine()){
                count++;
                String line = in.nextLine();
                String[] item = line.split(",");
                if (!item[0].equals(lost.getName())){
                    output.println(line);
                }
                else {
                    Files.deleteIfExists(Paths.get("src\\university\\missing\\images\\"+lost.getImage()));
                }
            }
            output.close();
            in.close();
            PrintWriter newFile = new PrintWriter("src\\university\\missing\\" + lost.getCollege() + ".txt");
            File oldFile = new File("src\\university\\missing\\selectedItem.txt");
            Scanner scanner = new Scanner(oldFile);
            while (scanner.hasNextLine()){
                newFile.println(scanner.nextLine());

            }
            newFile.close();
            scanner.close();
            Files.deleteIfExists(oldFile.toPath());
            taken = true;
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return taken;

    }
}
