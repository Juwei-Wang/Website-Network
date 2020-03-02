package server;

import com.google.gson.Gson;
import common.Todo;
import srrp.Handler;
import srrp.Request;
import srrp.Response;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TodoAddHandler implements Handler {
    @Override
    public void handle(Request request, Response response) {
        // Request -> JSON
        String data = request.getData();

        // JSON -> Object
        Todo todo = new Gson().fromJson(data, Todo.class);

        // Object -> SQL
        String query = "INSERT INTO todos(text) VALUES (\"%s\")";
        query = String.format(query, todo.getText());

        // SQL -> send
        Connection connection = Database.newConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
