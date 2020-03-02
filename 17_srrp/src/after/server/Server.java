package after.server;

import srrp.SRRPServer;

public class Server {
    public static void main(String[] args) {
        SRRPServer srrpServer = new SRRPServer();
        srrpServer.registerHandler("add", new AddHandler());
        srrpServer.start();
    }
}
