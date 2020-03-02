package com;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) {
        new Server().run();
    }

    public void run() {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
            httpServer.createContext("/", new SimpleHandler());
            httpServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
