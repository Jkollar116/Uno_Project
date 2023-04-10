/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.uno_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Jkoll
 */
public class endScreen extends aiController {

    @FXML
    private Button secondaryButton;
    @FXML
    private TextArea statsTxt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            File file = new File("cardScores.txt");
            Scanner scanner = new Scanner(file);
            String cardScores = scanner.nextLine();
            scanner.close();

            statsTxt.setText(cardScores);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }    

    @FXML
    private void switchToSecondary(ActionEvent event)throws IOException {
        App.setRoot("home");
    }
    
}
