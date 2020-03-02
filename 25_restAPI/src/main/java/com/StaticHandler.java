package com;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class StaticHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String path = httpExchange.getRequestURI().getPath();
        path = "static" + path;
        System.out.println(path);

        File file = new File(path);
        // index.html as default for directory
        if (file.isDirectory()) {
            file = new File(path + "/index.html");
        }

        byte[] data = FileUtils.readFileToByteArray(file);

        httpExchange.sendResponseHeaders(200, data.length);
        httpExchange.getResponseBody().write(data);
        httpExchange.getResponseBody().close();
    }
}

//  17, static http , dynamic server
//  18, backend render, jsp / php /
//  19, frontend render, js / rest api / call api
//  20, security, git, Pull Request,