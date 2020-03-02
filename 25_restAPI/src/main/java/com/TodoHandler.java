package com;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URI;
import java.util.LinkedList;

public class TodoHandler implements HttpHandler {

    LinkedList<Todo> todos = new LinkedList<>();
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String method = httpExchange.getRequestMethod();
        if (method.equals("GET")) {
            System.out.println("do get");
            doGet(httpExchange);
        } else if(method.equals("POST")) {
            System.out.println("do post");
            doPost(httpExchange);
        }
    }

    public void doGet(HttpExchange httpExchange) throws IOException {
        String bodyJson = new Gson().toJson(todos);
        byte[] bodyBytes = bodyJson.getBytes();
        httpExchange.sendResponseHeaders(200,bodyBytes.length);
        httpExchange.getResponseBody().write(bodyBytes);
        httpExchange.getResponseBody().close();


    }

    public void doPost(HttpExchange httpExchange) throws IOException {
        InputStream inputStream = httpExchange.getRequestBody();
        String body = IOUtils.toString(inputStream,"UTF-8");
        Todo todo = new Gson().fromJson(body,Todo.class);
        System.out.println(todo);
        todos.add(todo);

        httpExchange.sendResponseHeaders(200,0);
        httpExchange.getResponseBody().close();
    }
}