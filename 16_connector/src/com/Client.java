package com;

import io.zzax.jadeite.net.Connector;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8080);
        Connector connector = new Connector(socket);

        connector.writeLine("hello zzax");
    }
}
