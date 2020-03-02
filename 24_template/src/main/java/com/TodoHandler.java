package com;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.*;
import java.net.URI;
import java.util.LinkedList;

public class TodoHandler implements HttpHandler {

    LinkedList<Todo> todos = new LinkedList<>();
    // meth  path       descript             action                     return
    // GET  /todo       view todo list       read data -> render        html ...
    // POST /todo       add todo             append data                redirect -
    //      html body[text=zzax]

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
        parseHttpRequestQuery(httpExchange);

        byte[] data = render().getBytes();

        httpExchange.sendResponseHeaders(200, data.length);
        httpExchange.getResponseBody().write(data);
        httpExchange.getResponseBody().close();
    }

    public void doPost(HttpExchange httpExchange) throws IOException {
        parseHttpRequestBody(httpExchange);

        httpExchange.getResponseHeaders().set("Location", "/todo");
        httpExchange.sendResponseHeaders(301, 0);
        httpExchange.getResponseBody().close();
    }

    public void parseHttpRequestQuery(HttpExchange httpExchange) {
        URI uri = httpExchange.getRequestURI();
        UriComponents uriComponents = UriComponentsBuilder.fromUri(uri).build();
        String text = uriComponents.getQueryParams().getFirst("text");
        if (text == null) {
            return;
        }
        todos.add(new Todo(text));
    }


    public void parseHttpRequestBody(HttpExchange httpExchange) throws IOException {
        InputStream bodyStream = httpExchange.getRequestBody();
        String body = IOUtils.toString(bodyStream, "UTF-8");
        System.out.println(body);

        UriComponents uriComponents = UriComponentsBuilder.fromUriString("/path?" + body).build();
        String text = uriComponents.getQueryParams().getFirst("text");
        System.out.println(text);

        if (text == null) {
            return;
        }
        todos.add(new Todo(text));
    }


    public String render() {

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        Template template = velocityEngine.getTemplate("static/template.html");

        VelocityContext context = new VelocityContext();

        context.put("name", "ZZAX");
        context.put("point", new Point(3, 4));
        context.put("circle", new Circle(new Point(3, 4), 5));
        context.put("todos", todos);


        StringWriter writer = new StringWriter();
        template.merge( context, writer );

        return writer.toString();
    }
}
