package server;

import com.google.gson.Gson;
import common.Todo;
import common.Todos;
import srrp.Handler;
import srrp.Request;
import srrp.Response;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class TodoGetAllHandler implements Handler {
    @Override
    public void handle(Request request, Response response) {
        String query = "SELECT * FROM todos";

        Connection connection = Database.newConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            LinkedList<Todo> todoList = new LinkedList<>();
            while (resultSet.next()) {
                Todo todo = TodoORM.toObject(resultSet);
                todoList.add(todo);
            }
            Todos todos = new Todos(todoList);

            String json = new Gson().toJson(todos);
            response.setStatus(Response.ok);
            response.setData(json);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
