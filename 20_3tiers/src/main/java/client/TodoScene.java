package client;

import com.google.gson.Gson;
import common.Todo;
import common.Todos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import srrp.Request;
import srrp.Response;
import srrp.SRRPClient;

import java.util.LinkedList;
import java.util.Random;

public class TodoScene extends Scene {
    private Pane root;

    // 内存
    private LinkedList<Todo> todos = new LinkedList<Todo>();

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

                Todo todoObj = new Todo(todo);

                // 用户意识 -> 内存
                // 实时同步 + 局部更新
                todos.add(todoObj);

                // 内存 -> 界面
                // 实时同步 + 局部更新
                updateViewsByDelta(todoObj.getText());

                // 内存 -> 数据库
                // 实时同步 + 局部更新
                {
                    // Obj -> JSON String
                    String json = new Gson().toJson(todoObj);

                    // JSON String -> Request
                    Request request = new Request();
                    request.setAction("todo add");
                    request.setData(json);

                    // send
                    new SRRPClient().send(request);
                }
            }
        });

        // 内存 -> 文件
        // 未来同步 + 整体更新
        // timer.tick({
        //      Persistence.save(todos);
        // });


        maxY = addButton.getLayoutY() + addButton.getPrefHeight() + margin;

        // init get all messages
        Request request = new Request();
        request.setAction("todo get all");

        Response response = new SRRPClient().send(request);
        String json = response.getData();

        Todos todos = new Gson().fromJson(json, Todos.class);
        LinkedList<Todo> todoList = todos.getTodos();
        for (Todo todo : todoList) {
            updateViewsByDelta(todo.getText());
        }
    }

    private double maxY;

    private void updateViewsByDelta(String newMessage) {
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
