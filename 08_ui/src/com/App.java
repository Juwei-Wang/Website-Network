package com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 1000, 100);
        pane.setBackground(new Background(new BackgroundFill(Color.valueOf("333"), null, null)));
        // 1. new
        // 2. set
        // 3. add to container

        // label
        Label label = new Label("LABEL");

        label.setLayoutX(100);
        label.setLayoutY(20);

        pane.getChildren().add(label);

        // textField
        TextField textField = new TextField();
        textField.setLayoutX(100);
        textField.setLayoutY(50);
        textField.setPrefWidth(100);
        pane.getChildren().add(textField);


        // button
        Button button = new Button("点我啊");
        button.setLayoutX(100);
        button.setLayoutY(80);
        button.setPrefWidth(100);
        pane.getChildren().add(button);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText(textField.getText());
            }
        });


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}
