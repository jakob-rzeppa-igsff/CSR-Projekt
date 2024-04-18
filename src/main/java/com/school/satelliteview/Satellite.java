package com.school.satelliteview;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import lombok.Getter;

import java.awt.*;

public class Satellite {

    @FXML
    private Label label;

    private String name;
    private int id;

    public Satellite(String name, int id) {
        this.name = name;
        this.id = id;
        initLabel();
    }

    private void initLabel() {
        label = new Label(name + " (" + id + ")");
    }

    public Label getLabel() {
        return label;
    }
}
