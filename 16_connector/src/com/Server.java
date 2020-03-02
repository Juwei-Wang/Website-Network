package com;

import io.zzax.jadeite.net.Connector;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        Connector connector = new Connector(socket);

        String line = connector.readLine();
        System.out.println(line);
    }
}
