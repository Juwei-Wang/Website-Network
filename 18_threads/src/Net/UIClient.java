package Net;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import srrp.Request;
import srrp.Response;
import srrp.SRRPClient;

public class UIClient extends Application {

    private Label label;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 400, 100);

        // textField
        TextField textField = new TextField();
        textField.setLayoutX(10);
        textField.setLayoutY(10);
        textField.setPrefWidth(100);
        textField.setPrefHeight(30);
        pane.getChildren().add(textField);

        // button
        Button button = new Button("申请");
        button.setLayoutX(120);
        button.setLayoutY(10);
        button.setPrefWidth(80);
        button.setPrefHeight(30);
        pane.getChildren().add(button);

        // label
        label = new Label("hello");
        label.setLayoutX(210);
        label.setLayoutY(10);
        label.setPrefWidth(100);
        label.setPrefHeight(30);
        pane.getChildren().add(label);

//
 //       button.setOnAction(new EventHandler<ActionEvent>() {
 //           @Override
 //           public void handle(ActionEvent event) {
//                Response response = new SRRPClient().send(new Request("wait", ""));
//                System.out.println(response.getData());
//
//               label.setText(response.getData());

//            }
 //       });
//
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Response response = new SRRPClient().send(new Request("wait", ""));
                        System.out.println(response.getData());

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                label.setText(response.getData());
                            }
                        });
                    }
                }).start();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
