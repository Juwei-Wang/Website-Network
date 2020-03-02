package com;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        // 占用 8080 端口
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("server 1");

        while (true) {
            // 等待一个客户端的连接
            Socket socket = serverSocket.accept();
            System.out.println("server 2");

            int data = socket.getInputStream().read();

            System.out.println("server 3");
            System.out.println(data);

            socket.getOutputStream().write(data + 1);

            System.out.println(socket.getPort());
            System.out.println(socket.getLocalPort());
        }
    }
}
