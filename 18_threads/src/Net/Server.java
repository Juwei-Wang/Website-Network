package Net;

import srrp.SRRPServer;

public class Server {
    public static void main(String[] args) {
        SRRPServer srrpServer = new SRRPServer();
        srrpServer.registerHandler("wait", new BlockingHandler());
        srrpServer.start();
    }
}
