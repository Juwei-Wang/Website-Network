package client;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new TodoScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
