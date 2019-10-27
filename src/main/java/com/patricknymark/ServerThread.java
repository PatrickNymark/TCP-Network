package com.patricknymark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ServerThread extends Thread {
    private Socket socket;
    private Server server;
    private BufferedReader inputStream;
    private int ID;

    public ServerThread(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        ID = socket.getPort();
    }

    public void run() {
        System.out.println(ConsoleColor.ANSI_GREEN + "Server Thread " + ID + " running.");
        System.out.print(ConsoleColor.ANSI_RESET);
        try {
            String input;
            while((input = inputStream.readLine()) != null) {
                if(input.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println(input);
            }

            System.out.println("Server Thread " + ID + " closed");
            close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void open() throws IOException {
        inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void close() throws IOException {
        if (socket != null)    socket.close();
    }
}

