package com;

import io.zzax.jadeite.net.Connector;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 2440);
        Connector connector = new Connector(socket);

        String action = "add";
        int value1 = 4;
        int value2 = 6;
        String data = value1 + "," + value2;
        connector.writeLine(action);
        connector.writeLine(data);

        String status = connector.readLine();
        String result = connector.readLine();
        System.out.println(status);
        System.out.println(result);

        if (status.equals("ok")){
            System.out.println(result);
        }else {
            System.out.println(status);
        }

    }
}
