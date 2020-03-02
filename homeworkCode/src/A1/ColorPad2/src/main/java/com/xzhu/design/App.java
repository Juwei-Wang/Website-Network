package com.xzhu.design;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class App extends Application {
    private TextField[] rgb;
    private TextField hexInput;
    private Pane colorShowArea;

    @Override
    public void start(Stage primaryStage) throws Exception {


        int width = 300;
        int height = 200;
        int margin = 10;

        Pane layout = new Pane();
        Scene scene = new Scene(layout, width, height);

        int curY = margin;
        int curX = margin;
        int inputHeight = 35;
        int inputWidth = 50;
        int rgbWidth = 80;

        colorShowArea = new Pane();
        colorShowArea.setLayoutX(curX);
        colorShowArea.setLayoutY(curY);
        colorShowArea.setPrefWidth(scene.getWidth()-margin*2);
        colorShowArea.setPrefHeight(50);
        layout.getChildren().add(colorShowArea);
        curY += 50 + margin;

        // generate HexInput TextField
        hexInput = new TextField();
        hexInput.setLayoutX(curX);
        hexInput.setLayoutY(curY);
        hexInput.setPrefWidth(rgbWidth);
        hexInput.setPrefHeight(inputHeight);
        hexInput.setAlignment(Pos.CENTER_RIGHT);
        hexInput.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue) {
                    // lose focus

                    String curColor = hexInput.getText().toUpperCase();
                    String newColor = null;
                    int lenColor = curColor.length();

                    if(checkRange(curColor) && (lenColor == 6 || lenColor == 3)) {
                        newColor = curColor;
                        // valid
                        if (lenColor == 6) {
                            newColor = curColor;

                        } else {
                            // 3
                            newColor = "";
                            for (int i = 0; i < 3 ; i++) {
                                newColor += curColor.charAt(i);
                                newColor += curColor.charAt(i);
                            }
                        }
                    } else {
                        newColor = "000000";
                    }


                    // update color
                    hexInput.setText(newColor);

                    // update RGB text field
                    updateRBGField(newColor);

                    updateColor();
                }
            }
        });

        layout.getChildren().add(hexInput);

        Label labelRGB = new Label("RGB");
        labelRGB.setLayoutX(curX);
        labelRGB.setLayoutY(curY+inputHeight);
        labelRGB.setPrefWidth(rgbWidth);
        labelRGB.setPrefHeight(inputHeight);
        labelRGB.setAlignment(Pos.CENTER);
        layout.getChildren().add(labelRGB);
        curX += rgbWidth + margin;

        rgb = new TextField[3];
        String[] labels = new String[] {"R", "G", "B"};

        for (int i = 0; i < 3; i++) {
            // generate HexInput TextField
            TextField input = new TextField("0");
            input.setLayoutX(curX);
            input.setLayoutY(curY);
            input.setPrefWidth(inputWidth);
            input.setPrefHeight(inputHeight);
            input.setAlignment(Pos.CENTER_RIGHT);

            layout.getChildren().add(input);
            rgb[i] = input;

            Label label = new Label(labels[i]);
            label.setLayoutX(curX);
            label.setLayoutY(curY+inputHeight);
            label.setPrefWidth(inputWidth);
            label.setPrefHeight(inputHeight);
            label.setAlignment(Pos.CENTER);
            layout.getChildren().add(label);

            curX += inputWidth + margin;

            input.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if(!newValue) {
                        // lost focus
                        System.out.format("%s lost focus\n", label.getText());
                        hexInput.setText(updateColor());
                    }
                }
            });
        }


        // Random button
        curX = margin;
        curY += inputHeight * 2;
        Button randBtn = new Button("Random");
        randBtn.setLayoutX(curX);
        randBtn.setLayoutY(curY);
        randBtn.setPrefWidth(rgbWidth);
        randBtn.setPrefHeight(inputHeight);
        randBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Random rand=new Random();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    String curColor = String.format("%H%H", rand.nextInt(15),rand.nextInt(15));
                    sb.append(curColor);
                }

                updateRBGField(sb.toString());
                hexInput.setText(updateColor());
            }
        });
        layout.getChildren().add(randBtn);


        // save btn
        curX += margin + 170;
        Button saveBtn = new Button("Save");
        saveBtn.setLayoutX(curX);
        saveBtn.setLayoutY(curY);
        saveBtn.setPrefWidth(rgbWidth);
        saveBtn.setPrefHeight(inputHeight);
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String color = hexInput.getText();
                File file = new File("savedColor.txt");
                try {
                    FileUtils.writeStringToFile(file, color, "UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        layout.getChildren().add(saveBtn);


        File file = new File("savedColor.txt");
        String prevColor = FileUtils.readFileToString(file,"UTF-8");
        updateRBGField(prevColor);
        hexInput.setText(updateColor());


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String updateColor() {
        StringBuilder sb = new StringBuilder();
        for(TextField text: rgb) {
            String curText = text.getText().toUpperCase();
            String newText = "00";
            int lenText = curText.length();

            if(!checkRange(curText) || lenText > 2 || lenText == 0) {
                sb.append("00");
            }
            else if (lenText == 1) {
                newText = curText + curText;
                sb.append(newText);
            } else {
                newText = curText;
                sb.append(curText);
            }
            text.setText(newText);
        }

        setColor(sb.toString());
        return sb.toString();
    }

    private void updateRBGField(String newColor) {
        System.out.println(newColor);

        // update RGB text field
        for (int i = 0; i < 3; i++) {
            String sub = newColor.substring(i*2, i*2+2);
            rgb[i].setText(sub);
        }
    }

    private boolean checkRange(String color) {
        for (int i = 0; i < color.length(); i++) {
            char c = color.charAt(i);
            if (!('0'<=c && c<='9' || 'a'<=c && c<='f' || 'A'<=c && c <= 'F')) {
                return false;
            }
        }
        return true;
    }
    private void setColor(String color) {
        colorShowArea.setBackground(new Background(new BackgroundFill(Color.valueOf(color), null,null)));
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}
