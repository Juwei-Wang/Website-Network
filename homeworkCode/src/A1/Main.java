package A1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        int x = 400;
        int y = 250;
        Pane pane = new Pane();
        Scene scene = new Scene(pane,x,y);

        int margin = 10;
        int margin2 = 20;
        Pane colorpane = new Pane();
        colorpane.setPrefWidth(100);
        colorpane.setPrefHeight(50);
        colorpane.setLayoutX(margin);
        colorpane.setLayoutY(margin2);
        pane.getChildren().add(colorpane);
        colorpane.setBackground(new Background(new BackgroundFill(Color.valueOf("#97FFFF"),null,null)));

        TextField textFieldMain = new TextField();
        textFieldMain.setPrefWidth(100);
        textFieldMain.setPrefHeight(25);
        textFieldMain.setLayoutX(margin);
        textFieldMain.setLayoutY(2 * margin2 + 50);
        pane.getChildren().add(textFieldMain);

        for (int i = 0; i < 3 ; i++) {
            TextField a = new TextField();
            a.setPrefWidth(50);
            a.setPrefHeight(25);
            a.setLayoutX(((2 + i) * margin) + 100 + (50 * i));
            a.setLayoutY(2 * margin2 + 50);
            pane.getChildren().add(a);
        }

        Label hex = new Label("HEX");
        hex.setPrefWidth(100);
        hex.setPrefHeight(25);
        hex.setLayoutX(margin);
        hex.setLayoutY(2 * margin2 + 50 + 25);
        pane.getChildren().add(hex);


        for (int i = 0; i < 3 ; i++) {
            Label b = new Label("R");;
            if (i == 0) {
                b = new Label("R");
            }else if(i == 1){
                b = new Label("G");
            }else if(i == 2){
                b = new Label("B");
            }
            b.setPrefWidth(50);
            b.setPrefHeight(25);
            b.setLayoutX(((2 + i) * margin) + 100 + (50 * i));
            b.setLayoutY(2 * margin2 + 50 + 25);
            pane.getChildren().add(b);

        }

        Button button1 = new Button("Random");
        button1.setPrefWidth(100);
        button1.setPrefHeight(25);
        button1.setLayoutX(margin);
        button1.setLayoutY(3 * margin2 + 50 + 25 + 25);
        pane.getChildren().add(button1);

        Button button2 = new Button("Save");
        button2.setPrefWidth(100);
        button2.setPrefHeight(25);
        button2.setLayoutX(margin + 200);
        button2.setLayoutY(3 * margin2 + 50 + 25 + 25);
        pane.getChildren().add(button2);





        primaryStage.setScene(scene);
        primaryStage.show();




    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}
