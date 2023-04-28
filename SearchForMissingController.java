
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import university.missing.images.TheLost;

import javax.swing.*;

public class SearchForMissingController implements Initializable {

    @FXML
    private ListView<String> CollegeList;
    @FXML
    private TextField College;
    @FXML
    private ListView<String> itemsList;
    @FXML
    private TextField items;
    @FXML
    private Button details;
    @FXML
    private Button cancel;
    private String itemSelected;
    String collegeSelected;
    ArrayList<TheLost> lost = new ArrayList<TheLost>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String[] college = {"College of Engineering", "College of Science", "College of Business", "College of Arts and Sciences", "College of Education", "College of Law", "College of Pharmacy", "College of Nursing"};
        CollegeList.getItems().addAll(college);
        // get the selected item from the list and display it in the text field
        CollegeList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            College.setText(newValue);
            collegeSelected = newValue;
        });
        // if the user select college call getItems method
        CollegeList.setOnMouseClicked(event -> {
            getItems();
        });


        itemsList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            items.setText(newValue);
            itemSelected = newValue;
        });


    }



    @FXML
    private void getdetails(ActionEvent event) throws IOException {
        if(writeToFile()){
            Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("ItemInformation.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Item Information");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void cancelbt(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("University Missing");
        stage.setScene(scene);
        stage.show();
    }
    private void getItems() {
        lost.clear();
        itemsList.getItems().clear();
        items.setText("items");
        File file=new File("src\\university\\missing\\"+collegeSelected+".txt");
        if(file.exists()){
            try {
                Scanner input=new Scanner(file);
                while(input.hasNext()){
                    String line=input.nextLine();
                    String[] item=line.split(",");
                    itemsList.getItems().add(item[0]);
                    lost.add(new TheLost(item[0],item[1],item[2],item[3]));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "No items found in "+collegeSelected);
            itemsList.getItems().clear();
            lost.clear();
            items.setText("items");
        }
    }
    private boolean writeToFile() {
        try {
            PrintWriter output = new PrintWriter("src\\university\\missing\\selectedItem.txt");
            for (TheLost item : lost) {
                if (item.getName().equals(itemSelected)) {
                    output.println(item.getName());
                    output.println(item.getCollege());
                    output.println(item.getDetails());
                    output.println(item.getImage());
                    output.close();
                    return true;
                }

                }
            } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        JOptionPane.showMessageDialog(null, "Item not found");
        return false;

    }
}
