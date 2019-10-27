package com.patricknymark;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private ServerSocket server;
    private Thread thread;
    private ServerThread client;

    public Server(int port) {
        System.out.println(ConsoleColor.ANSI_BLUE + "Server starting on port: " + port + " ...");

        try {
            server = new ServerSocket(port);
            System.out.println(ConsoleColor.ANSI_GREEN + "Server started: " + server);
            start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() {
        while(thread != null) {
            try {
                System.out.println(ConsoleColor.ANSI_BLUE + "Waiting for a client ...");
                addThread(server.accept());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addThread(Socket socket) {
        System.out.println(ConsoleColor.ANSI_GREEN + "Client accepted: " + socket);
        client = new ServerThread(this, socket);
        try {
            client.open();
            client.start();
        } catch(IOException ioe) {
            System.out.println("Error opening thread: " + ioe);
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }


    public static void main(String[] args) {
        Server server = new Server(5000);
    }
}