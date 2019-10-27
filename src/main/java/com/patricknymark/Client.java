package com.patricknymark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader console;
    private PrintWriter outputStream;

    public Client(String ip, int port) {
        System.out.println("Establishing connection. Please wait ...");

        try {
            socket = new Socket(ip, port);
            System.out.println("Connected: " + socket);
            start();
        } catch (IOException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        String input = "";
        while (!input.equalsIgnoreCase("exit")) {
            try {
                input = console.readLine();
                outputStream.println(input);
            } catch (IOException ioe) {
                System.out.println("Sending error: " + ioe.getMessage());
            }
        }

    }

    public void start() throws IOException {
        console = new BufferedReader(new InputStreamReader(System.in));
        outputStream = new PrintWriter(socket.getOutputStream(), true);
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 5000);
    }
}
