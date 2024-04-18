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

    private ArrayList<Satellite> satellites = new ArrayList<>();

    @FXML
    private void initialize() {
        createSatellites();

    }

    public void handleSearch() {
        String id = searchInput.getText();

        Calculator calc = new Calculator();

        try {
            String[] c = calc.getCoordinates(id);
            System.out.println("Latitude: " + c[0] + ", Longitude: " + c[1]);

            webView.getEngine().load("https://maps.google.com?q=" + c[0] + "," + c[1]);
        } catch (JsonProcessingException e) {
            System.out.println(e.toString());
        }

    }


    private void createSatellites() {
        satellites.add(new Satellite("ISS", 25544));




        //satellitesContainer.getChildren().add(new Label(""));

        for (Satellite satellite : satellites) {
            //satellitesContainer.getChildren().add(satellite.getLabel());
        }
    }
}

