package com.project.lab06;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LabController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}