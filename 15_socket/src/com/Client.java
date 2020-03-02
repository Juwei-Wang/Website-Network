package com;

import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        // 尝试和服务器建立连接
        Socket socket = new Socket("localhost", 8080);
        System.out.println("client 1");

        int signal = new Scanner(System.in).nextInt();
        socket.getOutputStream().write(signal);
        System.out.println("client 2");
        int returnedSignal = socket.getInputStream().read();
        System.out.println(returnedSignal);


        System.out.println(socket.getPort());
        System.out.println(socket.getLocalPort());
    }
}
