package srrp;

import io.zzax.jadeite.net.Connector;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SRRPServer {
    private Map<String, Handler> handlers = new HashMap<>();

    public void registerHandler(String action, Handler handler) {
        handlers.put(action, handler);
    }

    public void start() {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(2440);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                break;
            }

            Reception reception = new Reception(socket);
            new Thread(reception).start();
        }
    }
    private class Reception implements Runnable {
        private Socket socket;
        public Reception(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            Connector connector = new Connector(socket);

            String action = connector.readLine();
            String data = connector.readLine();

            Request request = new Request(action, data);
            Response response = new Response();

            if (handlers.containsKey(action)) {
                Handler handler = handlers.get(action);
                handler.handle(request, response);
            } else {
                response.setStatus("action not supported");
            }

            connector.writeLine(response.getStatus());
            connector.writeLine(response.getData());
        }
    }
}
