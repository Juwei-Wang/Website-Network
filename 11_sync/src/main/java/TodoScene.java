import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.LinkedList;
import java.util.Random;

public class TodoScene extends Scene {
    private Pane root;

    // 内存
    private LinkedList<String> todos = new LinkedList<String>();

    public TodoScene() {
        super(new Pane(), 400, 600);
        root = (Pane) getRoot();
        init();
    }

    private void init() {
        int margin = 10;
        int cellHeight = 40;
        Button addButton = new Button("Add");
        addButton.setPrefWidth(400 - 2 * margin);
        addButton.setPrefHeight(cellHeight);
        addButton.setLayoutX(margin);
        addButton.setLayoutY(margin);
        root.getChildren().add(addButton);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String todo = "";
                int size = 8;
                Random random = new Random();
                for (int i = 0; i < size; i++) {
                    todo += random.nextInt(10);
                }
                // 用户意识 -> 内存
                // 实时同步 + 局部更新
                todos.add(todo);
                System.out.println(todos);

                // 内存 -> 界面
                // 实时同步 + 局部更新
                updateViewsByDelta();

                // 内存 -> 文件
                // 实时同步 + 整体更新
                Persistence.save(todos);


            }
        });

        // 内存 -> 文件
        // 未来同步 + 整体更新
        // timer.tick({
        //      Persistence.save(todos);
        // });


        maxY = addButton.getLayoutY() + addButton.getPrefHeight() + margin;
    }

    private double maxY;

    private void updateViewsByDelta() {
        String newMessage = todos.getLast();

        int margin = 10;
        int cellHeight = 30;
        Label label = new Label(newMessage);
        label.setPrefWidth(400 - 2 * margin);
        label.setPrefHeight(cellHeight);
        label.setLayoutX(margin);
        label.setLayoutY(maxY);
        root.getChildren().add(label);
        maxY += cellHeight + margin;
    }

    private void updateViewsEntirely() {
        // pane > label *
        // remove pane
        // create pane
        // string* -> label *
        // label add -> pane
        // pane add -> root
    }
}