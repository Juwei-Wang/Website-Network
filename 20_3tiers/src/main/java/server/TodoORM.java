package server;

import common.Todo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoORM {
    public static Todo toObject(ResultSet resultSet) {
        Todo todo = new Todo();
        try {
            todo.setText(resultSet.getString("text"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }
}
