package srrp;

import io.zzax.jadeite.net.Connector;

import java.io.IOException;
import java.net.Socket;

public class SRRPClient {
    public Response send(Request request) {

        Socket socket = null;
        try {
            socket = new Socket("localhost", 2440);
        } catch (IOException e) {
            return new Response("io error");
        }

        Connector connector = new Connector(socket);

        connector.writeLine(request.getAction());
        connector.writeLine(request.getData());

        String status = connector.readLine();
        String data = connector.readLine();

        return new Response(status, data);
    }
}
