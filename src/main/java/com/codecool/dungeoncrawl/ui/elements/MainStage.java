package com.codecool.dungeoncrawl.ui.elements;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;

public class MainStage {
    private Canvas canvas;
    private Scene scene;
    private StatusPane statusPane;

    public MainStage(Canvas canvas) {
        this.canvas = canvas;
        statusPane = new StatusPane();
        scene = setUpScene();
    }

    private Scene setUpScene() {
        BorderPane borderPane = statusPane.build();
        borderPane.setCenter(canvas);
        Scene scene = new Scene(borderPane);
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void setHealthLabelText(String text) {
        this.statusPane.setHealthValue(text);
    }

    public void setWandLabelText(String text) {
        this.statusPane.setWandValue(text);
    }

    public void setKeyLabelText(String text) {
        this.statusPane.setKeyValue(text);
    }

    public void setScubaLabelText(String text) { this.statusPane.setScubaValue(text); }

    public void setEggLabelText(String text) { this.statusPane.setEggValue(text); }

}
