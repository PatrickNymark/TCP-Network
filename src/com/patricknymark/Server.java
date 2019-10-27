package com.patricknymark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket;
    private ServerSocket server;
    private BufferedReader inputStream;

    public Server(int port) {
        System.out.println("Server starting on port: " + port);

        try {
            server = new ServerSocket(port);
            System.out.println("Server started: " + server);

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client connection established: " + socket);

            open();
            boolean done = false;
            while (!done) {
                try {
                    String input = inputStream.readLine();
                    System.out.println(input);
                    done = input.equalsIgnoreCase("exit");
                } catch (IOException e) {
                    done = true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void open() throws IOException {
        inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public static void main(String[] args) {
        Server server = new Server(5000);
    }
}
