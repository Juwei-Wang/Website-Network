package server;

import srrp.SRRPServer;

public class Driver {
    public static void main(String[] args) {
        SRRPServer server = new SRRPServer();
        server.registerHandler("todo add", new TodoAddHandler());
        server.registerHandler("todo get all", new TodoGetAllHandler());
        server.start();
    }
}
