package com.sceneBased;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MainView extends Pane {
    public MainView() {
        Label hello = new Label("hello");
        getChildren().add(hello);
    }
}
