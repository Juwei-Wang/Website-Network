package com;



import io.zzax.jadeite.net.Connector;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(2440);

        while (true) {
            Socket socket = serverSocket.accept();
            Connector connector = new Connector(socket);

            String action = connector.readLine();
            String data = connector.readLine();

            if (action.equals("add")) {
                String[] parts = data.split(",");
                double value1 = Double.parseDouble(parts[0]);
                double value2 = Double.parseDouble(parts[1]);

                double resultValue = value1 + value2;


                String status = "ok";
                String result = resultValue + "";

                connector.writeLine(status);
                connector.writeLine(result);
            }
        }

    }
}
