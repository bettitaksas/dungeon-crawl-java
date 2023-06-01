package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label wandTextLabel;
    private Label wandValueLabel;
    private Label keyTextLabel;
    private Label keyValueLabel;
    private Label scubaTextLabel;
    private Label scubaValueLabel;
    private Label eggTextLabel;
    private Label eggValueLabel;


    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("Health: ");
        healthValueLabel = new Label();

        wandTextLabel = new Label("Wand: ");
        wandValueLabel = new Label();

        keyTextLabel = new Label("Key: ");
        keyValueLabel = new Label();

        scubaTextLabel = new Label("Scuba: ");
        scubaValueLabel = new Label();

        eggTextLabel = new Label("Egg: ");
        eggValueLabel = new Label();

    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 1, 0);
        ui.add(wandTextLabel, 0, 5);
        ui.add(wandValueLabel, 1, 5);
        ui.add(keyTextLabel, 0, 10);
        ui.add(keyValueLabel, 1, 10);
        ui.add(scubaTextLabel, 0, 15);
        ui.add(scubaValueLabel, 1, 15);
        ui.add(eggTextLabel, 0, 20);
        ui.add(eggValueLabel, 1, 20);


        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }
    public void setWandValue(String text) {
        wandValueLabel.setText(text);
    }
    public void setKeyValue(String text) {
        keyValueLabel.setText(text);
    }

    public void setScubaValue(String text) {
        scubaValueLabel.setText(text);
    }

    public void setEggValue(String text) {
        eggValueLabel.setText(text);
    }
}