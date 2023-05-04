package com.mycompany.uno_project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class homeController {

    @FXML
    private Button secondaryButton;
    @FXML
    private Button PVP1btn;
    @FXML
    private Button PVP2btn;

    @FXML
    private void switchToAi() throws IOException {
        App.setRoot("ai");
    }

    @FXML
    private void PVP1btn_Click(ActionEvent event) throws IOException {
        App.setRoot("ai");
    }

//    @FXML
//    private void PVP2btn_Click(ActionEvent event) throws IOException {
//        App.setRoot("ai");
//
//    }


}