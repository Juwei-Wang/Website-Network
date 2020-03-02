package common;

import java.util.LinkedList;

public class Todos {
    private LinkedList<Todo> todos;

    public Todos() {
    }

    public Todos(LinkedList<Todo> todos) {
        this.todos = todos;
    }

    public LinkedList<Todo> getTodos() {
        return todos;
    }

    public void setTodos(LinkedList<Todo> todos) {
        this.todos = todos;
    }
}
