package com;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.io.IOUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class SimpleHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        byte[] result = responseString(httpExchange).getBytes("UTF-8");

        // code, data length = byte?
        httpExchange.sendResponseHeaders(200, result.length);

        httpExchange.getResponseBody().write(result);
        httpExchange.close();
    }

    private String responseString(HttpExchange httpExchange) {
        StringBuilder builder = new StringBuilder();

        // method
        String method = httpExchange.getRequestMethod();
        builder.append("method");
        builder.append("\n");
        builder.append(method);
        builder.append("\n\n");

        URI uri = httpExchange.getRequestURI();
        UriComponents uriComponents = UriComponentsBuilder.fromUri(uri).build();

        // path
        String path = uri.getPath();
        builder.append("path");
        builder.append("\n");
        builder.append(path);
        builder.append("\n\n");

        // query
        builder.append("query");
        builder.append("\n");

        MultiValueMap<String, String> queryParams = uriComponents.getQueryParams();
        for (Map.Entry<String, List<String>> queryEntry : queryParams.entrySet()) {
            builder.append(queryEntry.getKey());
            builder.append(" -> ");
            builder.append(String.join(", ", queryEntry.getValue()));
            builder.append("\n");
        }

        builder.append("\n");

        // headers
        builder.append("headers");
        builder.append("\n");
        Headers headers = httpExchange.getRequestHeaders();
        for (Map.Entry<String, List<String>> headerEntry : headers.entrySet()) {
            builder.append(headerEntry.getKey());
            builder.append(" -> ");
            builder.append(String.join(", ", headerEntry.getValue()));
            builder.append("\n");
        }
        builder.append("\n");

        // body
        builder.append("body");
        builder.append("\n");
        try {
            InputStream bodyStream = httpExchange.getRequestBody();
            String body = IOUtils.toString(bodyStream, "UTF-8");
            builder.append(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        builder.append("\n\n");



        return builder.toString();
    }
}
