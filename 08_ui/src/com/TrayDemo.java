package com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TrayDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        int width = 400;
        int height = 600;
        Pane pane = new Pane();
        Scene scene = new Scene(pane, width, height);


        Pane bottomBar = new Pane();
        bottomBar.setPrefWidth(width);
        bottomBar.setPrefHeight(60);
        bottomBar.setLayoutY(height - bottomBar.getPrefHeight());
        pane.getChildren().add(bottomBar);

        bottomBar.setBackground(new Background(new BackgroundFill(Color.valueOf("FFFFFF"), null, null)));

        int margin = 10;
        TextField textField = new TextField();
        textField.setLayoutX(margin);
        textField.setLayoutY(margin);
        textField.setPrefWidth(bottomBar.getPrefWidth() - margin * 2);
        textField.setPrefHeight(40);
        bottomBar.getChildren().add(textField);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        TrayDemo.launch(args);
    }
}
