package com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LayoutDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        int width = 400;
        int height = 600;
        Pane pane = new Pane();
        Scene scene = new Scene(pane, width, height);

        int margin = 20;
        TextField textField = new TextField();
        textField.setLayoutX(margin);
        textField.setLayoutY(margin);
        textField.setPrefWidth(width - margin * 2);
        textField.setPrefHeight(40);
        pane.getChildren().add(textField);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}