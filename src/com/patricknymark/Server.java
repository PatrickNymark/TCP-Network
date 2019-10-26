package com.patricknymark;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        System.out.println("Server: Starting on port 5000...");

        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket = serverSocket.accept();
            System.out.println("Server: Connection to client established...");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
