package com.school.satelliteview;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.school.satelliteview.apiClasses.ApiConnector;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.ArrayList;

public class MainController {
    @FXML
    public TextField searchInput;

    @FXML
    public Button searchButton;

    @FXML
    public TabPane tabs;

    @FXML
    public VBox satellitesContainer;

    @FXML
    public WebView webView;

    private void show(String id) {
        Calculator calc = new Calculator();

        try {
            String[] c = calc.getCoordinates(id);
            System.out.println("Latitude: " + c[0] + ", Longitude: " + c[1]);

            webView.getEngine().load("https://maps.google.com?q=" + c[0] + "," + c[1]);
        } catch (JsonProcessingException e) {
            System.out.println(e.toString());
        }
    }

    public void handleSearch() {
        String id = searchInput.getText();

        show(id);
    }

    public void showISS() {
        show("25544");
    }


    public void showITASAT() {
        show("43786");
    }

}

